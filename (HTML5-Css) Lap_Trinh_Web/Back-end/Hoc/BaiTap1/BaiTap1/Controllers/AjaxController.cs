using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using BaiTap1.Models.DAO;

namespace BaiTap1.Controllers
{
    public class AjaxController : Controller
    {
        // GET: Ajax
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult LoadAllProduct()
        {
            HangHoaDAO hanghoadao = new HangHoaDAO();

            return PartialView(hanghoadao.SelectAll()); 
        }

        public ActionResult LoadProductByCatId(int id)
        {
            HangHoaDAO hanghoadao = new HangHoaDAO();

            return PartialView(hanghoadao.SelectByCatId(id));
        }
    }
}