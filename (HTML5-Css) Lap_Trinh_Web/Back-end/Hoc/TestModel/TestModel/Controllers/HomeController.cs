using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using TestModel.Models;

namespace TestModel.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public ActionResult UpdatePeople(People p)
        {
            var PeopleId = p.PeopleId;
            var Name = p.Name;
            var City = p.City;
            var Gender = p.Gender;
            ViewBag.people = p;
            return View();
        }

        public ActionResult UpdatePeople()
        {
            return View("UpdatePeopleForm");
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

        public ActionResult HotLine()
        {
            return View();
        }
    }
}