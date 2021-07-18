using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using LeQuangTho181202289_2.Models.Entities;

namespace LeQuangTho181202289_2.Controllers
{
    public class BaiThiController : Controller
    {

        private LeQuangTho_Context db = new LeQuangTho_Context();

        // GET: BaiThi
        public ActionResult Index()
        {
            return View();
        }

        //phân trang
        public ActionResult RenderByPage(int pageNo = 0, int pageSize = 3)
        {
            List<HangHoa> hangHoa = db.HangHoa.ToList();
            ViewBag.CountPage = Math.Ceiling(1.0 * hangHoa.Count / pageSize);

            ViewBag.PageNo = pageNo;

            List<HangHoa> hangHoas = db.HangHoa.ToList();
            return PartialView("LeQuangTho_MainContent", hangHoas.Skip(pageNo * pageSize).Take(pageSize));
        }

        public ActionResult RenderNav()
        {
            List<LoaiHang> loaiHangs = db.LoaiHang.ToList(); 

            return PartialView("LeQuangTho_Header", loaiHangs);
        }

        //Load Hàng thồng thường
        public ActionResult RenderProduct()
        {
            List<HangHoa> hangHoas = db.HangHoa.Where(h => h.Gia >= 100).ToList();

            return PartialView("LeQuangTho_MainContent", hangHoas);
        }

        public ActionResult RenderProductByCatId(int CatId)
        {
            List<HangHoa> hangHoas = db.HangHoa.Where(h => h.MaLoai == CatId).ToList();

            return PartialView("LeQuangTho_MainContent", hangHoas);
        }

        public ActionResult Create()
        {
            ViewBag.MaLoai = new SelectList(db.LoaiHang, "MaLoai", "TenLoai");
            return View();
        }

        [HttpPost]
        public ActionResult Create(HangHoa hh)
        {
            if (ModelState.IsValid)
            {
                db.HangHoa.Add(hh);
                db.SaveChanges();

                return Redirect("Index");
            }
            else
            {
                ViewBag.MaLoai = new SelectList(db.LoaiHang, "MaLoai", "TenLoai");
                return View();
            }
        }

        public ActionResult RenderProductBySearch(string values)
        {
            List<HangHoa> hangHoas;
            if (values.Equals("Search"))
            {
                hangHoas = db.HangHoa.ToList();
            }
            else
            {
                hangHoas = db.HangHoa.Where(h => h.TenHang.Contains(values)).ToList();
            }
            return PartialView("LeQuangTho_MainContent", hangHoas);
        }

    }
}