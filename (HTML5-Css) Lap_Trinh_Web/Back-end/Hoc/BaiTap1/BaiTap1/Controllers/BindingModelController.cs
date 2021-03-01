using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using BaiTap1.Models;

namespace BaiTap1.Controllers
{
    public class BindingModelController : Controller
    {
        // GET: BindingModel
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost] //annotation chỉ định sẽ xử lí methol Post
        public ActionResult Index(Login l, User u)
        {
            if (l.username == "admin" && l.password =="123")
                return Content("Đăng Nhập thành công\n" + u.name +"\n"+u.address + "\n" + u.email);
            else
                return View();
        }

        public ActionResult CreateUser()
        {
            return View();
        }

        [HttpPost]
        public ActionResult CreateUser(User u)
        {
            if (u.id == null || u.address == null || u.email == null)
                return View();
            else
                return Content("Đăng Nhập thành công\n" + u.name + "\n" + u.address + "\n" + u.email);
        }

        public ActionResult EditUser()
        {
            return View();
        }

        public ActionResult DetaislUser()
        {
            return View();
        }

        public ActionResult DeleteUser()
        {
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
            list.Add(new Models.User(2, "Linh", "Hưng Yên", "Lequangtho2000lqtho@gmail.com"));

            return View(list);
        }
    }
}