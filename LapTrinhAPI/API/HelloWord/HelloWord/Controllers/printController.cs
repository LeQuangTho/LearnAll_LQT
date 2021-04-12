using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HelloWord.Controllers
{
    public class printController : Controller
    {
        // GET: print
        public ActionResult Index()
        {
            ViewBag.Message = "Welcome to ASP.NET MVC";
            return View();
        }

        public ActionResult DataTran(string username)
        {
            ViewBag.username = username;
            ViewData["Name"] = "James Bond";
            ViewBag.Name = "James Bond";
            ViewBag.Age = "22";
            ViewBag.Email = "Jamesbond@gmail.com";
            return View();
        }

        public ActionResult Gcd()
        {
            
            return View();
        }

        public ActionResult GetParamView()
        {
            
            return View();
        }

        public ActionResult getTenTuoi(string ten, int tuoi)
        {
            ViewBag.name = ten;
            ViewBag.age = tuoi;
            return View();
        }

        public ActionResult getPartialView()
        {
            return View();
        }
        /*String maSV, String hoTen, int gioiTinh, double diemSV, int soThich, int doiTuong, String diaChi*/
        public ActionResult ttSV(string textBoxMaSV, string textBoxHoTen)
        {
            ViewBag.textBoxMaSV = textBoxMaSV;
            ViewBag.textBoxHoTen = textBoxHoTen;
            return View();
        }
    }
}