using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using BaiTap1.Models.DAO;
using BaiTap1.Models.Entities;

namespace BaiTap1.Controllers
{
    public class SessionCookiesController : Controller
    {
        // GET: SessionCookies
        public ActionResult Index()
        {
            if (Session["User"] != null)
                return Content("You logged with account: " + Session["User"]);
            else
            return View();
        }

        [HttpPost]
        public ActionResult Index(tblAccount acc)
        {
            AccountDAO accountdao = new AccountDAO();
            if (accountdao.isValid(acc))
            {
                Session["User"] = acc.Username;
                Response.Cookies["User"].Value = acc.Username;
                return Content("Cookies have been written on client");
            }
            else
            {
                return View();
            }
        }
    }
}