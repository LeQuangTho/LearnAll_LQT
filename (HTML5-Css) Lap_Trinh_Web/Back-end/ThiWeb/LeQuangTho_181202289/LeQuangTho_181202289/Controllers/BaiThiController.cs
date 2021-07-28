using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using LeQuangTho_181202289.Models.Entities;

namespace LeQuangTho_181202289.Controllers
{
    public class BaiThiController : Controller
    {
        private LeQuangTho_Context db = new LeQuangTho_Context();
        // GET: BaiThi
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult RenderNav()
        {
            List<NavItems> navItems = db.NavItems.ToList();
            return PartialView("LeQuangTho_Nav", navItems);

        }

        public ActionResult RenderTop()
        {
            List<Products> product = db.Products.OrderByDescending(t => t.UnitPrice).Take(3).ToList();

            return PartialView("LeQuangTho_MainContent", product);
        }

        public ActionResult RenderSearch(string key)
        {
            List<Products> product = db.Products.Where(p => p.Name.Contains(key)).ToList();
            return PartialView("LeQuangTho_MainContent", product);
        }

        
    }
}