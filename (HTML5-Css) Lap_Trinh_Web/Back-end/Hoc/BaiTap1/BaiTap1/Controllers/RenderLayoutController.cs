using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using BaiTap1.Models.DAO;
using BaiTap1.Models.Entities;

namespace BaiTap1.Controllers
{
    public class RenderLayoutController : Controller
    {
        // GET: RenderLayout
        public ActionResult LoadLeft()
        {
            LoaiHangDAO loaihangdao = new LoaiHangDAO();

            ViewBag.lstCat = loaihangdao.SelectAll();
            return PartialView("~/Views/Shared/_Left.cshtml");
        }

        public ActionResult LoadLeftAjax()
        {
            LoaiHangDAO loaihangdao = new LoaiHangDAO();

            ViewBag.lstCat = loaihangdao.SelectAll();
            return PartialView("~/Views/Shared/_Leftajax.cshtml");
        }
    }
}