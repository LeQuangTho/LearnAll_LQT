using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using TestModel.Models;

namespace TestModel.Controllers
{
    public class UserController : Controller
    {
        List<User> list = new List<User>
            {
                new User() { Id = 3, Name = "John", Email = "dxcanh3103@gmail.com" },
                new User() { Id = 4, Name = "Smith", Email = "Smith@gmail.com" }
            };
        // GET: User
        public ActionResult Index()
        {
            User user = new User();
            user.Id = 1;
            user.Name = "Canh";
            user.Email = "Dxcanh310320@gmail.com";
            ViewBag.user = user;
            return View();
        }

        public ActionResult UserForm()
        {
            return View("UserFormView");
        }

        public ActionResult ReceiveData(User user)
        {
            return View("DisplayData", user);
        }

        public ActionResult SendModel()
        {
            return View(new User() { Id = 2, Name = "Smith", Email = "dxcanh3103@gmail.com" });
        }

        public ActionResult Edit()
        {
            return View();
        }

        public ActionResult Details(int id)
        {
            User user = list.Where(u => u.Id == id).FirstOrDefault();
            return View(user);
        }
        public ActionResult SendListModel()
        {
            return View(list);
        }

        public ActionResult CreateUser()
        {
            return View();
        }

        [HttpPost]
        public ActionResult CreateUser(User user)
        {
            return View();
        }
    }
}