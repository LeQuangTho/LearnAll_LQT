using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace BaiTap1.Controllers
{
    public class AjaxController : Controller
    {
        // GET: Ajax
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult LoadAllProduct()
        {
            HangHoaDao hanghoadao = new HangHoaDao();

            return PartialView(hanghoadao.SelectAll()); 
        }
    }
}