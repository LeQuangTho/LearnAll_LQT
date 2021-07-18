using BTL_ASP.NET.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;
using System.Web.Mvc;
using System.Collections;
using System.Security.Cryptography;
using System.Text;

namespace BTL_ASP.NET.Controllers
{
    public class HomeController : Controller
    {
        // 
        private ModelQuanLyKho db = new ModelQuanLyKho();
        public int pageSize = 5;
        int timeLogOut = 30; // thời gian lưu cookies

        // ----------------------------------------- Truyền data đến Home --------------------------------------------------
        public long[] showData()
        {
            long[] data = new long[10];
            //DateTime dateTime = DateTime.Now;
            DateTime dateTime = DateTime.Today;//Convert.ToDateTime("2020-01-01");
            long totalPrice = 0;
            //Lấy tổng hóa đơn xuất trong ngày
            var countID_deliveryBill = db.DeliveryBills.Where(s => s.DateCreate == dateTime).Count();
            //Lấy tổng hóa đơn nhập trong ngày
            var receiptBills = db.ReceiptBills.Where(s => s.DateCreate.Equals(dateTime));
            var countID_receiptBill = receiptBills.ToList().Count;
            var id = from receipt in receiptBills select receipt.IdReceiptBill;
            //Tính tổng giá trị hóa đơn
            foreach (var itemID in id)
            {
                //totalPrice += 10;
                var detailReceipt = db.DetailReceipts.Where(s => s.IdReceiptBill.Equals(itemID));
                if (detailReceipt != null)
                {
                    foreach (var itemDetail in detailReceipt)
                    {
                        totalPrice += (long)(totalPrice + itemDetail.Price);

                    }
                }
                var temptBill = (from b in db.ReceiptBills where b.IdReceiptBill == itemID select b).First();
                temptBill.Total = totalPrice;
            }
            //Lấy tổng sô sản phẩm hết hàng trong kho
            var productList1 = db.ProductLists.Count();
            var productList2 = db.ProductLists.Where(s => s.ProductCount == 0).Count();
            var productList3 = db.ProductLists.Where(s => s.ProductCount <= 10).Count();
            data[0] = countID_deliveryBill;
            data[1] = countID_receiptBill;
            data[2] = totalPrice;
            data[3] = productList1;
            data[4] = productList2;
            data[5] = productList3;
            return data;
        }
        // GET: Home
        public ActionResult Index(string PasswordUser, string IdUser) // Trang chủ
        {
            long[] data = this.showData();
            ViewBag.countID_deliveryBill = data[0];
            ViewBag.countID_receiptBill = data[1];
            ViewBag.totalPrice = data[2];
            ViewBag.productList1 = data[3];
            ViewBag.productList2 = data[4];
            ViewBag.productList3 = data[5];
            ViewBag.day = DateTime.Today.Day.ToString();
            ViewBag.month = DateTime.Today.Month;
            ViewBag.year = DateTime.Today.Year;
            if (CheckLogin()) // Check Login
            {
                return View();
            }
            else
            {
                if (PasswordUser != null && IdUser != null)
                {
                    string pass = Encrypt(PasswordUser);
                    var result = db.Users.SingleOrDefault(x => x.IdUser == IdUser && x.PasswordUser == pass);
                    if (result != null)
                    {
                        Session["User"] = IdUser; // Session Cookies
                        Response.Cookies["IdUser"].Value = IdUser;
                        Response.Cookies["PassWord"].Value = PasswordUser;
                        Response.Cookies["isLogin"].Value = "True";
                        Response.Cookies["isAdmin"].Value = result.IdRoleUser + "";
                        Response.Cookies["IdUser"].Expires = DateTime.Now.AddMinutes(timeLogOut); // Thời hạn lưu cookies : 30p
                        Response.Cookies["PassWord"].Expires = DateTime.Now.AddMinutes(timeLogOut);
                        Response.Cookies["isLogin"].Expires = DateTime.Now.AddMinutes(timeLogOut);
                        Response.Cookies["isAdmin"].Expires = DateTime.Now.AddMinutes(timeLogOut);
                        return View();
                    }
                }
                return View("Login");
            }
        }
        // ----------------------------------------- Đăng ký --------------------------------------------------
        public ActionResult Sign_Up()
        {
            ViewBag.IdRoleUser = new SelectList(db.RoleUsers, "IdRoleUser", "IdRoleUser");
            return View();
        }
        // ----------------------------------------- Đăng ký [HttpPost] --------------------------------------------------
        [HttpPost]
        public ActionResult Sign_Up([Bind(Include = "IdUser,NameUser,Place,PasswordUser,PhoneNumber,Email,Gender,UserStatus,IdRoleUser")] User user)
        {
            // them vao data
            if (ModelState.IsValid)
            {
                var user1 = db.Users.SingleOrDefault(s => s.IdUser == user.IdUser);
                if (user1 == null)
                {
                    user.PasswordUser = Encrypt(user.PasswordUser);
                    db.Users.Add(user);
                    db.SaveChanges();
                    return RedirectToAction("ListUser");
                }
                else
                {
                    ViewBag.Message = "User account already exists";
                    return View();
                }
            }
            return View();
        }
        // ----------------------------------------- Đăng nhập --------------------------------------------------
        public ActionResult Login()
        {
            if (Session["User"] != null)
            {
                if (Request.Cookies["IdUser"] != null && Request.Cookies["PassWord"] != null)
                {
                    return View("Index", new { IdUser = Request.Cookies["IdUser"].Value, PasswordUser = Request.Cookies["PassWord"].Value });
                }
            }
            return View();
        }
        // ----------------------------------------- Đăng xuất --------------------------------------------------
        public ActionResult LogOff(string id)
        {
            Response.Cookies["IdUser"].Expires = DateTime.Now.AddDays(-1); // Xóa Cookies
            Response.Cookies["PassWord"].Expires = DateTime.Now.AddDays(-1);
            Response.Cookies["isLogin"].Expires = DateTime.Now.AddDays(-1);
            Response.Cookies["isAdmin"].Expires = DateTime.Now.AddDays(-1);

            return View("Login");
        }

        // ----------------------------------------- Nhập Kho [HttpGet] --------------------------------------------------
        [HttpGet]
        public ActionResult NhapKho(string id, int? details, string mes)
        {
            if (CheckLogin())
            {
                if (mes != null)
                {
                    ViewBag.Message = mes;
                }
                db.ClipboardDetailBills.RemoveRange(db.ClipboardDetailBills);// Xóa bảng tạm
                db.SaveChanges();
                var bill = db.ReceiptBills.SingleOrDefault(s => s.IdReceiptBill == id);
                if (bill == null)// Create idDeliveriBill
                {
                    DateTime date = DateTime.Now;
                    id = "HDN" + date.Year.ToString().Substring(2, 2) + date.Month + date.Day + date.Hour + date.Minute + date.Second + date.Millisecond; // Tạo Mã hóa đơn Nhập 
                    ViewBag.date = DateTime.Today.ToString("yyyy-MM-dd"); // update ngày 
                    ViewBag.note = "N/A"; // Note
                    ViewBag.user = Request.Cookies["IdUser"].Value.ToString(); // Lấy user người tạo hóa đơn
                    ViewBag.supplỉer = 4; // Nhà cung cấp TODO Chưa code
                }
                else
                {
                    var detailReceipts = db.DetailReceipts.Where(s => s.IdReceiptBill == id); // lấy chi tiết hóa đơn Nhập
                    foreach (var i in detailReceipts)
                    {
                        ClipboardDetailBill clipboard = new ClipboardDetailBill();
                        clipboard.IdProductList = (long)i.IdProductList;
                        clipboard.Amount = i.ReceiptCount;
                        clipboard.Price = i.Price;
                        db.ClipboardDetailBills.Add(clipboard);
                    }
                    db.SaveChanges();
                    // Update Hóa đơn Nhập
                    var a = db.ReceiptBills.SingleOrDefault(s => s.IdReceiptBill == id);
                    ViewBag.date = a.DateCreate.ToString("yyyy-MM-dd");
                    ViewBag.note = a.Note.Split('#')[1];
                    ViewBag.user = a.IdUser;
                    ViewBag.supplỉer = a.IdSupplier;
                }
                //
                ViewBag.IdProductList = new SelectList(db.ProductLists, "IdProductList", "ProductName");
                ViewBag.idDBill = id;
                if (details != null)
                {
                    ViewBag.details = details;
                }
                else
                {
                    ViewBag.details = 0;
                }
                return View();
            }
            else
            {
                return View("Login");
            }

        }
        // ----------------------------------------- Nhập Kho [HttpPost] --------------------------------------------------
        [HttpPost]
        public ActionResult NhapKho([Bind(Include = "IdProductList,ReceiptCount,Price")] DetailReceipt detailReceipt)
        {
            if (CheckLogin())
            {
                ClipboardDetailBill clipboard = db.ClipboardDetailBills.SingleOrDefault(n => n.IdProductList == detailReceipt.IdProductList);
                if (clipboard == null)
                {
                    ClipboardDetailBill clipboard2 = new ClipboardDetailBill();
                    clipboard2.IdProductList = (long)detailReceipt.IdProductList;
                    clipboard2.Amount = detailReceipt.ReceiptCount;
                    clipboard2.Price = detailReceipt.Price;
                    db.ClipboardDetailBills.Add(clipboard2);
                }
                else
                {
                    clipboard.Price = detailReceipt.Price;
                    clipboard.Amount = detailReceipt.ReceiptCount;
                }
                db.SaveChanges();
                ViewBag.IdProductList = new SelectList(db.ProductLists, "IdProductList", "ProductName");
                return RedirectToAction("loadTable2");
            }
            else
            {
                return View("Login");
            }

        }
        // ----------------------------------------- Xuất Kho [HttpGet] --------------------------------------------------
        [HttpGet]
        public ActionResult XuatKho(string id, int? details, string mes)
        {
            if (CheckLogin())
            {
                if (mes != null)
                {
                    ViewBag.Message = mes;
                }
                db.ClipboardDetailBills.RemoveRange(db.ClipboardDetailBills);// Xóa bảng tạm
                db.SaveChanges();
                var bill = db.DeliveryBills.SingleOrDefault(s => s.IdDeliveryBill == id);
                if (bill == null)// Create idDeliveriBill
                {
                    DateTime date = DateTime.Now;
                    id = "HDX" + date.Year.ToString().Substring(2, 2) + date.Month + date.Day + date.Hour + date.Minute + date.Second + date.Millisecond;
                    ViewBag.date = DateTime.Today.ToString("yyyy-MM-dd");
                    ViewBag.note = "N/A";
                    ViewBag.user = Request.Cookies["IdUser"].Value.ToString();
                }
                else
                {
                    var detailDeliveries = db.DetailDeliveries.Where(s => s.IdDeliveryBill == id);
                    foreach (var i in detailDeliveries)
                    {
                        ClipboardDetailBill clipboard = new ClipboardDetailBill();
                        clipboard.IdProductList = (long)i.IdProductList;
                        clipboard.Amount = i.DeliveryCount;
                        db.ClipboardDetailBills.Add(clipboard);
                    }
                    db.SaveChanges();
                    var a = db.DeliveryBills.SingleOrDefault(s => s.IdDeliveryBill == id);
                    ViewBag.date = a.DateCreate.ToString("yyyy-MM-dd");
                    ViewBag.note = a.Note.Split('#')[1];
                    ViewBag.user = a.IdUser;
                }
                ViewBag.IdProductList = new SelectList(db.ProductLists, "IdProductList", "ProductName");
                ViewBag.idDBill = id;
                if (details != null)
                {
                    ViewBag.details = details;
                }
                else
                {
                    ViewBag.details = 0;
                }
                return View();
            }
            else
            {
                return View("Login");
            }

        }
        // ----------------------------------------- Xuất Kho [HttpPost] --------------------------------------------------
        [HttpPost]
        public ActionResult XuatKho([Bind(Include = "IdProductList,DeliveryCount")] DetailDelivery detailDelivery)
        {
            if (CheckLogin())
            {
                ClipboardDetailBill clipboard = db.ClipboardDetailBills.SingleOrDefault(n => n.IdProductList == detailDelivery.IdProductList);
                if (clipboard == null)
                {
                    ClipboardDetailBill clipboard2 = new ClipboardDetailBill();
                    clipboard2.IdProductList = (long)detailDelivery.IdProductList;
                    clipboard2.Amount = detailDelivery.DeliveryCount;
                    db.ClipboardDetailBills.Add(clipboard2);
                }
                else
                {
                    clipboard.Amount = detailDelivery.DeliveryCount;
                }
                db.SaveChanges();

                ViewBag.IdProductList = new SelectList(db.ProductLists, "IdProductList", "ProductName");

                return RedirectToAction("loadTable");
            }
            else
            {
                return View("Login");
            }

        }
        // ----------------------------------------- Thêm sản phẩm [HttpGet] --------------------------------------------------
        [HttpGet]
        public ActionResult AddProduct(int? id)
        {
            if (CheckLogin())
            {
                if (id != null)
                {
                    var clipboard = db.ProductLists.SingleOrDefault(s => s.IdProductList == id);
                    ViewBag.NameSP = clipboard.ProductName;
                    ViewBag.Detail = clipboard.Detail;
                    ViewBag.Unit = clipboard.Unit;
                    ViewBag.IdProductCategory = new SelectList(db.ProductCategories.Where(s => s.IdProductCategory == clipboard.IdProductCategory), "IdProductCategory", "CategoryName");
                }
                else
                {
                    ViewBag.IdProductCategory = new SelectList(db.ProductCategories, "IdProductCategory", "CategoryName");

                }
                return View();
            }
            else
            {
                return View("Login");
            }

        }
        // ----------------------------------------- Thêm sản phẩm [HttpPost] --------------------------------------------------
        [HttpPost]
        public ActionResult AddProduct([Bind(Include = "IdProductCategory,ProductName,Detail,Unit")] ProductList productList)
        {
            if (CheckLogin())
            {
                var product = db.ProductLists.SingleOrDefault(s => s.ProductName == productList.ProductName);
                if (product != null)
                {
                    product.Detail = productList.Detail;
                    product.Unit = productList.Unit;
                    product.ProductCount = 0;
                }
                else
                {
                    productList.ProductCount = 0;
                    db.ProductLists.Add(productList);
                }
                db.SaveChanges();
                ViewBag.Message = "Add product successfully!";
                ViewBag.IdProductCategory = new SelectList(db.ProductCategories, "IdProductCategory", "CategoryName");
                return View();
            }
            else
            {
                return View("Login");
            }
        }
        // ----------------------------------------- Thông tin cá nhân [HttpGet] --------------------------------------------------
        [HttpGet]
        public ActionResult Profile()
        {
            if (CheckLogin())
            {
                string id = Request.Cookies["IdUser"].Value.ToString();
                var user = db.Users.SingleOrDefault(s => s.IdUser == id);
                user.PasswordUser = Decrypt(user.PasswordUser);
                return View(user);
            }
            else
            {
                return View("Login");
            }

        }
        // ----------------------------------------- Thông tin cá nhân [HttpPost] --------------------------------------------------
        [HttpPost]
        public ActionResult Profile([Bind(Include = "IdUser,NameUser,Place,PasswordUser,PhoneNumber,Email,Gender,UserStatus,IdRoleUser,NameUser,Img")] User user)
        {
            if (CheckLogin())
            {
                if (ModelState.IsValid)
                {
                    var user1 = db.Users.SingleOrDefault(s => s.IdUser == user.IdUser);
                    user1.NameUser = user.NameUser;
                    user1.Gender = user.Gender;
                    user1.PasswordUser = Encrypt(user.PasswordUser);
                    user1.PhoneNumber = user.PhoneNumber;
                    user1.Place = user.Place;
                    if (user.Img != null)
                    {
                        user1.Img = user.Img;
                    }
                    //
                    db.SaveChanges();
                    //System.Threading.Thread.Sleep(3000);
                }
                string id = user.IdUser;
                return View(db.Users.SingleOrDefault(s => s.IdUser == id));
            }
            else
            {
                return View("Login");
            }
        }
        // ----------------------------------------- Danh sách hóa đơn Xuất [HttpGet] --------------------------------------------------
        public ActionResult ListDeliveries()
        {
            if (CheckLogin())
            {
                return View();
            }
            else
            {
                return View("Login");
            }
        }

        // ----------------------------------------- Danh sách hóa đơn Nhập [HttpGet] --------------------------------------------------
        public ActionResult ListReceipt()
        {
            if (CheckLogin())
            {
                return View();
            }
            else
            {
                return View("Login");
            }
        }
        // ----------------------------------------- Danh sách sản phẩm [HttpGet] --------------------------------------------------
        public ActionResult ListSP()
        {
            if (CheckLogin())
            {

                return View(db.ProductCategories.ToList());
            }
            else
            {
                return View("Login");

            }
        }
        // ----------------------------------------- Lưu hóa đơn Xuất [HttpPost] --------------------------------------------------
        public ActionResult SaveBill(string idDBill, string user, string note, DateTime dateCreate)
        {
            if (CheckLogin())
            {
                var clipb = db.ClipboardDetailBills.ToList();
                if (clipb.Count() < 1)
                {
                    return RedirectToAction("XuatKho", new { id = idDBill, mes = "Please add products!" });
                }
                else
                {
                    DeliveryBill deliveryB = db.DeliveryBills.SingleOrDefault(n => n.IdDeliveryBill == idDBill);
                    if (deliveryB == null)
                    {
                        DeliveryBill deliveryBill = new DeliveryBill();
                        deliveryBill.IdDeliveryBill = idDBill;
                        deliveryBill.IdUser = user;
                        deliveryBill.DateCreate = dateCreate;
                        deliveryBill.Total = 0;
                        deliveryBill.Note = " #" + note;
                        db.DeliveryBills.Add(deliveryBill);
                    }
                    else
                    {
                        deliveryB.Note = user + " *Đã chỉnh sửa: " + DateTime.Now.ToString() + " #" + note;
                    }
                    var clipboards = db.ClipboardDetailBills.ToList();
                    db.DetailDeliveries.RemoveRange(db.DetailDeliveries.Where(a => a.IdDeliveryBill == idDBill));//Xóa table DetailDeliveries với IdDeliveryBill = idDBill
                    foreach (var i in clipboards)
                    {
                        DetailDelivery detailDelivery = new DetailDelivery();
                        detailDelivery.IdProductList = (int)i.IdProductList;
                        detailDelivery.DeliveryCount = (int)i.Amount;
                        detailDelivery.IdDeliveryBill = idDBill;
                        db.DetailDeliveries.Add(detailDelivery);
                    }
                    db.SaveChanges();
                    return RedirectToAction("ListDeliveries");
                }
            }
            else
            {
                return View("Login");
            }

        }
        // ----------------------------------------- Lưu hóa đơn Nhập [HttpPost] --------------------------------------------------
        public ActionResult SaveBill2(string idDBill, string user, string supplỉer, string note, DateTime dateCreate)
        {
            if (CheckLogin())
            {
                var clipb = db.ClipboardDetailBills.ToList();
                if (clipb.Count() < 1)
                {
                    return RedirectToAction("NhapKho", new { id = idDBill, mes = "Please add products!" });
                }
                else
                {
                    ReceiptBill deliveryB = db.ReceiptBills.SingleOrDefault(n => n.IdReceiptBill == idDBill);
                    if (deliveryB == null)
                    {
                        ReceiptBill receiptBill = new ReceiptBill();
                        receiptBill.IdReceiptBill = idDBill;
                        receiptBill.IdUser = user;
                        receiptBill.DateCreate = dateCreate;
                        receiptBill.Total = 0;
                        receiptBill.IdSupplier = int.Parse(supplỉer);
                        receiptBill.Note = " #" + note;
                        db.ReceiptBills.Add(receiptBill);
                    }
                    else
                    {
                        deliveryB.Note = user + " *Đã chỉnh sửa: " + DateTime.Now.ToString() + " #" + note;
                    }
                    var clipboards = db.ClipboardDetailBills.ToList();
                    db.DetailReceipts.RemoveRange(db.DetailReceipts.Where(a => a.IdReceiptBill == idDBill));//Xóa table DetailDeliveries với IdDeliveryBill = idDBill
                    foreach (var i in clipboards)
                    {
                        DetailReceipt detailReceipt = new DetailReceipt();
                        detailReceipt.IdProductList = (int)i.IdProductList;
                        detailReceipt.ReceiptCount = (int)i.Amount;
                        detailReceipt.Price = (int)i.Price;
                        detailReceipt.IdReceiptBill = idDBill;
                        db.DetailReceipts.Add(detailReceipt);
                    }
                    db.SaveChanges();

                    // 
                    return RedirectToAction("ListReceipt");
                }
            }
            else
            {
                return View("Login");
            }
        }
        // ----------------------------------------- Xóa sản phẩm trong chi tiết hóa đơn [HttpPost] --------------------------------------------------
        public ActionResult deleteItem(int? id, int? IsXuat)
        {
            if (CheckLogin())
            {
                ViewBag.IdProductList = new SelectList(db.ProductLists, "IdProductList", "ProductName");
                ClipboardDetailBill clipboard = db.ClipboardDetailBills.SingleOrDefault(n => n.IdProductList == id);
                db.ClipboardDetailBills.Remove(clipboard);
                db.SaveChanges();
                if (IsXuat == 1)
                {
                    return RedirectToAction("loadTable2");
                }
                return RedirectToAction("loadTable");
            }
            else
            {
                return View("Login");
            }
        }
        // ----------------------------------------- Bảng chi tiết hóa đơn Xuất [HttpGet] --------------------------------------------------
        public ActionResult loadTable(string mes)
        {
            if (CheckLogin())
            {
                var clipBoard = db.ClipboardDetailBills;
                return PartialView("~/Views/Shared/_TableProduct.cshtml", clipBoard);
            }
            else
            {
                return View("Login");
            }

        }
        // ----------------------------------------- Bảng chi tiết hóa đơn Nhập [HttpGet] --------------------------------------------------
        public ActionResult loadTable2(string mes)
        {
            if (CheckLogin())
            {
                if (mes != null)
                {
                    ViewBag.Message = mes;
                }
                var clipBoard = db.ClipboardDetailBills;
                return PartialView("~/Views/Shared/_TableProduct2.cshtml", clipBoard);
            }
            else
            {
                return View("Login");
            }
        }
        // ----------------------------------------- Bảng danh sách hóa đơn Xuất [HttpGet] --------------------------------------------------
        public ActionResult loadTableListDeliveries(int? idPro, int? page)
        {
            if (CheckLogin())
            {
                var clipBoard = db.DeliveryBills.ToList();
                if (page > 0)
                {
                    page = page + 0;
                }
                else
                {
                    page = 1;
                }
                int start = (int)(page - 1) * pageSize;
                ViewBag.pageCurrent = page;
                int totalPage = clipBoard.Count(); // Số phần tử của list
                float totalNumsize = (totalPage / (float)pageSize); // số trang
                int numSize = (int)Math.Ceiling(totalNumsize); // Convert to INT
                ViewBag.numSize = numSize;
                var clipBoardA = clipBoard.OrderBy(x => x.IdDeliveryBill).Skip(start).Take(pageSize); // sắp xếp theo IdDeliveryBill lấy từ item Start lấy pageSize item
                return PartialView("~/Views/Home/_loadTableDB.cshtml", clipBoardA); // trả về partialView
            }
            else
            {
                return View("Login");
            }
        }

        // ----------------------------------------- Bảng danh sách hóa đơn Xuất HttpGet] --------------------------------------------------
        public ActionResult loadTableListReceipt(int? idPro, int? page)
        {
            if (CheckLogin())
            {
                var clipBoard = db.ReceiptBills.ToList();
                if (page > 0)
                {
                    page = page + 0;
                }
                else
                {
                    page = 1;
                }
                int start = (int)(page - 1) * pageSize;
                ViewBag.pageCurrent = page;
                int totalPage = clipBoard.Count();
                float totalNumsize = (totalPage / (float)pageSize);
                int numSize = (int)Math.Ceiling(totalNumsize);
                ViewBag.numSize = numSize;
                var clipBoardA = clipBoard.OrderBy(x => x.IdReceiptBill).Skip(start).Take(pageSize);
                return PartialView("~/Views/Home/_loadTableDBReceipt.cshtml", clipBoardA);
            }
            else
            {
                return View("Login");
            }
        }
        // ----------------------------------------- Bảng sản phẩm [HttpGet] --------------------------------------------------
        public ActionResult loadTableListSP(int? idPro, int? page)
        {
            if (CheckLogin())
            {
                var clipBoard = db.ProductLists.ToList();
                if (page > 0)
                {
                    page = page + 0;
                }
                else
                {
                    page = 1;
                }
                int start = (int)(page - 1) * pageSize;
                ViewBag.pageCurrent = page;
                int totalPage = clipBoard.Count();
                float totalNumsize = (totalPage / (float)pageSize);
                int numSize = (int)Math.Ceiling(totalNumsize);
                ViewBag.numSize = numSize;
                var clipBoardA = clipBoard.OrderBy(x => x.ProductName).Skip(start).Take(pageSize);

                return PartialView("~/Views/Home/_loadTableListSP.cshtml", clipBoardA);
            }
            else
            {
                return View("Login");

            }
        }
        // ----------------------------------------- Bảng sản phẩm theo loại [HttpPost] --------------------------------------------------
        public ActionResult loadTablebyCategory(long idCategory, int? idPro, int? page)
        {
            if (CheckLogin())
            {
                var clipBoard = db.ProductLists.Where(s => s.IdProductCategory == idCategory);
                ViewBag.pageCurrent = 0;
                ViewBag.numSize = 0;
                return PartialView("~/Views/Home/_loadTableListSP.cshtml", clipBoard);
            }
            else
            {
                return View("Login");
            }
        }
        // ----------------------------------------- Bảng Search hóa đơn Xuất [HttpPost] --------------------------------------------------
        public ActionResult loadTableSearch1(string txtSearch, int? idPro, int? page)
        {
            if (CheckLogin())
            {
                var clipBoard = db.DeliveryBills.Where(s => s.IdDeliveryBill.Contains(txtSearch));
                ViewBag.pageCurrent = 0;
                ViewBag.numSize = 0;
                return PartialView("~/Views/Home/_loadTableDB.cshtml", clipBoard);
            }
            else
            {
                return View("Login");
            }
        }
        // ----------------------------------------- Bảng Search hóa đơn Nhập [HttpPost] --------------------------------------------------
        public ActionResult loadTableSearch2(string txtSearch, int? idPro, int? page)
        {
            if (CheckLogin())
            {
                var clipBoard = db.ReceiptBills.Where(s => s.IdReceiptBill.Contains(txtSearch));
                ViewBag.pageCurrent = 0;
                ViewBag.numSize = 0;
                return PartialView("~/Views/Home/_loadTableDBReceipt.cshtml", clipBoard);
            }
            else
            {
                return View("Login");
            }
        }
        // ----------------------------------------- Bảng Search sản phẩm [HttpPost] --------------------------------------------------
        public ActionResult loadTableSearch3(string txtSearch, int? idPro, int? page)
        {
            if (CheckLogin())
            {
                var clipBoard = db.ProductLists.Where(s => s.ProductName.Contains(txtSearch));
                ViewBag.pageCurrent = 0;
                ViewBag.numSize = 0;
                return PartialView("~/Views/Home/_loadTableListSP.cshtml", clipBoard);
            }
            else
            {
                return View("Login");
            }
        }
        // ----------------------------------------- Kiểm tra đăng nhập --------------------------------------------------
        public Boolean CheckLogin()
        {
            if (Session["User"] != null)
            {
                if (Request.Cookies["isLogin"] != null)
                {
                    return true;
                }
            }
            return false;
        }
        // ----------------------------------------- Giải mã PassWord --------------------------------------------------
        public static string Decrypt(string toDecrypt)
        {
            string key = "A";
            bool useHashing = true;
            byte[] keyArray;
            byte[] toEncryptArray = Convert.FromBase64String(toDecrypt);

            if (useHashing)
            {
                MD5CryptoServiceProvider hashmd5 = new MD5CryptoServiceProvider();
                keyArray = hashmd5.ComputeHash(UTF8Encoding.UTF8.GetBytes(key));
            }
            else
                keyArray = UTF8Encoding.UTF8.GetBytes(key);

            TripleDESCryptoServiceProvider tdes = new TripleDESCryptoServiceProvider();
            tdes.Key = keyArray;
            tdes.Mode = CipherMode.ECB;
            tdes.Padding = PaddingMode.PKCS7;
            ICryptoTransform cTransform = tdes.CreateDecryptor();
            byte[] resultArray = cTransform.TransformFinalBlock(toEncryptArray, 0, toEncryptArray.Length);
            return UTF8Encoding.UTF8.GetString(resultArray);
        }
        // ----------------------------------------- Mã hóa Password --------------------------------------------------
        public static string Encrypt(string toEncrypt)
        {
            string key = "A";
            bool useHashing = true;
            byte[] keyArray;
            byte[] toEncryptArray = UTF8Encoding.UTF8.GetBytes(toEncrypt);

            if (useHashing)
            {
                MD5CryptoServiceProvider hashmd5 = new MD5CryptoServiceProvider();
                keyArray = hashmd5.ComputeHash(UTF8Encoding.UTF8.GetBytes(key));
            }
            else
                keyArray = UTF8Encoding.UTF8.GetBytes(key);

            TripleDESCryptoServiceProvider tdes = new TripleDESCryptoServiceProvider();
            tdes.Key = keyArray;
            tdes.Mode = CipherMode.ECB;
            tdes.Padding = PaddingMode.PKCS7;

            ICryptoTransform cTransform = tdes.CreateEncryptor();
            byte[] resultArray = cTransform.TransformFinalBlock(toEncryptArray, 0, toEncryptArray.Length);

            return Convert.ToBase64String(resultArray, 0, resultArray.Length);
        }
        // ----------------------------------------- Admin Quản lý tài khoản --------------------------------------------------
        public ActionResult ListUser()
        {
            return View(db.Users.Where(s => s.IdRoleUser == 0));
        }
        // ----------------------------------------- Admin Sửa tài khoản --------------------------------------------------
        public ActionResult EditUser(string id)
        {
            var user = db.Users.SingleOrDefault(s => s.IdUser == id);
            user.PasswordUser = Decrypt(user.PasswordUser);
            return View(user);
        }
        // ----------------------------------------- Admin Sửa tài khoản --------------------------------------------------
        [HttpPost]
        public ActionResult EditUser([Bind(Include = "IdUser,NameUser,Place,PasswordUser,PhoneNumber,Email,Gender,UserStatus,Img")] User user)
        {
            user.PasswordUser = Encrypt(user.PasswordUser);
            db.Entry(user).State = EntityState.Modified;
            db.SaveChanges();
            return RedirectToAction("ListUser");
        }
        // ----------------------------------------- Admin Xóa tài khoản --------------------------------------------------
        public ActionResult DeleteUser(string id)
        {
            return View(db.Users.SingleOrDefault(s => s.IdUser == id));
        }
        // ----------------------------------------- Admin Xóa tài khoản --------------------------------------------------
        public ActionResult DeleteUserConfirmed(string id)
        {
            var user = db.Users.SingleOrDefault(s => s.IdUser == id);
            user.UserStatus = "Nghỉ Việc";
            db.SaveChanges();
            return RedirectToAction("ListUser");
        }
        
    }
}