using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using BaiTap1.Models.Entities;

namespace BaiTap1.Models.DAO
{
    public class loaiHangDAO
    {
        QLHangHoa_Context db;
        public loaiHangDAO()
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

        public LoaiHang GetById(int id)
        {
            //su dung LINQ .Where ket hop Lambda Exression 
            return db.LoaiHangs.Where(lh => lh.MaLoai == id).First();
        }

        public void Insert(LoaiHang lh)
        {
            loaiHangDAO loaiHangdao = new loaiHangDAO();
        }
    }
}