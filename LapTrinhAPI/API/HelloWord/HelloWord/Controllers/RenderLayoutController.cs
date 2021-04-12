using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HelloWord.Controllers
{
    public class RenderLayoutController : Controller
    {
        // GET: RenderLayout
        public ActionResult LoadLeft()
        {
            List<String> lstCat = new List<String>();
            lstCat.Add("Mot");
            lstCat.Add("hai");
            lstCat.Add("ba");
            ViewBag.lstCat = lstCat;
            return PartialView("~/Views/Shared/_Left.cshtml");
        }
    }
}