using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using BaiTap1.Models.Entities;

namespace BaiTap1.Models.DAO
{
    public class HangHoaDAO
    {
        QLHangHoa_Context db;
        public HangHoaDAO()
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

        public List<HangHoa> SelectByCatId(int id)
        {
            return db.HangHoas.Where(c => c.MaLoai == id).ToList();
        }
    }
}