using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LeQuangTho_1812202289.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View("LeQuangTho_MainContent");
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}