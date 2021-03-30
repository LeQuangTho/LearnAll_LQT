using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using TestModel.Models;

namespace TestModel.Controllers
{
    public class BindingModelController : Controller
    {
        // GET: BindingModel
        public ActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Login(Login l)
        {
            if (l.username == "admin" && l.password == "123")
            {
                return View();
            }
            return View();
        }
    }
}