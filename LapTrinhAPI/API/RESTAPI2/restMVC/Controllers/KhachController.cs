using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using restMVC;
using RESTAPI2;
using System.Web.Script.Serialization;

namespace restMVC.Controllers
{
    public class KhachController : Controller
    {
        // GET: Khach
        public ActionResult Index(string searchString)
        {
            string ApiRequest = "customers";
            if (!string.IsNullOrEmpty(searchString))
            {
                ApiRequest = string.Concat(ApiRequest, "?id=", searchString);
            }
            string method = "Get";
            string dataResponse = Method.GetJson(ApiRequest, method);
            IEnumerable<tblKhach> khachList = new JavaScriptSerializer().Deserialize<List<tblKhach>>(dataResponse);
            return View(khachList);
        }


        public ActionResult Delete(long id)
        {
            string ApiRequest = "customers/" + id.ToString();
            string method = "Delete";
            string dataResponse = Method.GetJson(ApiRequest, method);
            return RedirectToAction("Index");
        }


        [HttpGet]
        public ActionResult Edit(long id)
        {
            string ApiRequest = "customers/" + id.ToString();
            string method = "Get";
            string dataResponse = Method.GetJson(ApiRequest, method);
            tblKhach khach = new JavaScriptSerializer().Deserialize<tblKhach>(dataResponse);
            return View(khach);
        }

        [HttpPost]
        public ActionResult Edit(tblKhach khach)
        {
            string ApiRequest = "customers?";
            ApiRequest = string.Concat(ApiRequest, "id=", khach.Makhach);
            ApiRequest = string.Concat(ApiRequest, "&name=", khach.TenKhach);
            ApiRequest = string.Concat(ApiRequest, "&adress=", khach.DiaChi);
            ApiRequest = string.Concat(ApiRequest, "&phoneNumber=", khach.DienThoai);
            string method = "Put";
            string dataResponse = Method.GetJson(ApiRequest, method);
            return RedirectToAction("Index");
        }


        [HttpGet]
        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Create(tblKhach khach)
        {
            string ApiRequest = "customers?";
            ApiRequest = string.Concat(ApiRequest, "id=", khach.Makhach);
            ApiRequest = string.Concat(ApiRequest, "&name=", khach.TenKhach);
            ApiRequest = string.Concat(ApiRequest, "&adress=", khach.DiaChi);
            ApiRequest = string.Concat(ApiRequest, "&phoneNumber=", khach.DienThoai);
            string method = "Post";
            string dataResponse = Method.GetJson(ApiRequest, method);
            return RedirectToAction("Index");
        }
    }
}