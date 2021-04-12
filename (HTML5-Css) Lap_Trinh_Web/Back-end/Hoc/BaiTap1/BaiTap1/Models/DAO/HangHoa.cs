using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using BaiTap1.Models.Entities;

namespace BaiTap1.Models.DAO
{
    public class HangHoa
    {
        QLHangHoa_Context db;
        public HangHoa()
        {
            db = new QLHangHoa_Context();
        }

        //select * from LoaiHang
        public List<LoaiHang> SelectAll()
        {
            //sử dụng cú pháp LINQ cho phép viet câu truy vấn
            //dang chaining method
            return db.LoaiHangs.ToList();
        }
    }
}