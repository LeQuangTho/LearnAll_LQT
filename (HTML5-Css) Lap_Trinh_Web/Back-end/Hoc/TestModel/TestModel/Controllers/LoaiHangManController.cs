using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using TestModel.Models.DAO;
using TestModel.Models.Entity;
namespace TestModel.Controllers
{
    public class LoaiHangManController : Controller
    {
        // GET: LoaiHangMan
        public ActionResult Index()
        {
            LoaiHangDAO loaiHangDao = new LoaiHangDAO();
            return View(loaiHangDao.SelectAll());
        }
        public ActionResult Detail(int id)
        {
            LoaiHangDAO loaiHangDAO = new LoaiHangDAO();
            return View(loaiHangDAO.GetById(id));
        }

        public ActionResult Create()
        {
            return View();
        }
        [HttpPost]
        public ActionResult CreateLoaiHang(LoaiHang lh)
        {
            if (ModelState.IsValid)
            {
                LoaiHangDAO loaiHangDAO = new LoaiHangDAO();
                LoaiHang llh = loaiHangDAO.Insert(lh);
                if (llh == null)
                {
                    return Content("Error");
                }
                return Redirect("Index");
            }

            return View("Create");
        }
    }
}