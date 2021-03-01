using My_IPOS.Model;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace My_IPOS
{
    class MaHoaDon
    {
        DataBase dt = new DataBase();
        public string TaoID_HoaDon()
        {
            string ID = " ";
            DateTime dateTime = DateTime.Now;
            int dem = 0;
            DataTable a = dt.dataReaderTable("select * from HoaDon where Year(NgayBan) = '"
                              + dateTime.Year + "' and MONTH(NgayBan) = '" + dateTime.Month + "' " +
                              "and DAY(NgayBan) = '" + dateTime.Day + "'");

            dem = a.Rows.Count;
            dem++;
            ID = dem + "_"+ dateTime.Day + dateTime.Month + dateTime.Year;
            return ID;
        }
    }
}
