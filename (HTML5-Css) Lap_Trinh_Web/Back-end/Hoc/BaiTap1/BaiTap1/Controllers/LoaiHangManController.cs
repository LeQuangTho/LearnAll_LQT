using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using BaiTap1.Models.DAO;

namespace BaiTap1.Controllers
{
    public class LoaiHangManController : Controller
    {
        // GET: LoaiHangMan
        public ActionResult Index()
        {
            loaiHangDAO loaiHangdao = new loaiHangDAO();
            return View(loaiHangdao.SelectAll());
        }

        public ActionResult Detail(int id)
        {
            loaiHangDAO loaiHangdao = new loaiHangDAO();
            return View(loaiHangdao.GetById(id));
        }
    }
}