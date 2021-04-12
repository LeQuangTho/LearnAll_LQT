using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using BaiTap1.Models.Entities;

namespace BaiTap1.Controllers
{

    public class ShoppingController : Controller {


        private QLHangHoa_Context db = new QLHangHoa_Context();
        // GET: Shopping
        public ActionResult Index()
        {
            return View(db.HangHoas.ToList());
        }
    }
}