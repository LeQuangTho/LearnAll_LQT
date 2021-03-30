using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using TestModel.Models.Entity;

namespace TestModel.Models.DAO
{
    public class LoaiHangDAO
    {
        QLHangHoa_Context db;
        public LoaiHangDAO()
        {
            db = new QLHangHoa_Context();
        }

        public List<LoaiHang> SelectAll()
        {
            return db.LoaiHangs.ToList();
        }

        public LoaiHang GetById(int id)
        {
            return db.LoaiHangs.Where(lh => lh.MaLoai == id).FirstOrDefault();
        }

        public LoaiHang Insert(LoaiHang lh)
        {
            LoaiHang lhClone = db.LoaiHangs.Add(lh);
            db.SaveChanges();
            return lhClone;
        }
    }
}