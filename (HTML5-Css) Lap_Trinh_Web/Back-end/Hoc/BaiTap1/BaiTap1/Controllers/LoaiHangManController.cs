using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using BaiTap1.Models.DAO;
using BaiTap1.Models.Entities;

namespace BaiTap1.Controllers
{
    public class LoaiHangManController : Controller
    {
        // GET: LoaiHangMan
        public ActionResult Index()
        {
            LoaiHangDAO loaiHangdao = new LoaiHangDAO();
            return View(loaiHangdao.SelectAll());
        }

        public ActionResult Detail(int id)
        {
            LoaiHangDAO loaiHangdao = new LoaiHangDAO();
            return View(loaiHangdao.GetById(id));
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
                LoaiHangDAO loahang  = new LoaiHangDAO();
                loahang.Insert(lh);
            }

            return View("Create");
        }
    }
}