using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Bai2_onl.Controllers
{
    public class FirstController : Controller
    {
        // GET: First
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult SayHello()
        {
            ViewBag.Message = "Chao";
            return View();
        }
    }
}