using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Bai2_onl.Models;

namespace Bai2_onl.Controllers
{
    public class UserModelController : Controller
    {
        // GET: UserModel
        public ActionResult Index()
        {
            User u = new User();

            return View();
        }
    }
}