using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using BaiTap1.Models;

namespace BaiTap1.Controllers
{
    public class UserModelController : Controller
    {
        // GET: UserModel
        public ActionResult Index()
        {
            User u = new User();
            u.id = 1;
            u.name = "Lê Quang Thọ";
            u.address = "HY";
            u.email = "Lequangtho2000lqtho@gmail.com";

            ViewBag.user = u;
            return View();
        }

        public ActionResult SendListModel()
        {
            List<User> list = new List<User>();
            User u = new User();
            u.id = 1;
            u.name = "Lê Quang Thọ";
            u.address = "Hưng Yên";
            u.email = "Lequangtho2000lqtho@gmail.com";

            list.Add(u);
            list.Add(new Models.User(2, "Linh", "Hưng Yên", "Lequangtho2000lqtho@gmail.com","",""));

            return View(list);
        }
    }
}