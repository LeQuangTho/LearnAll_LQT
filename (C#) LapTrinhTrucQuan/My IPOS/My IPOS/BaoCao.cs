using My_IPOS.Model;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace My_IPOS
{
    public partial class BaoCao : Form
    {
        DataBase data = new DataBase();
        public BaoCao()
        {
            InitializeComponent();
        }

        private void gunaButton1_Click(object sender, EventArgs e)
        {
            if(tbDate.Value.Date == tbDate2.Value.Date)
            {
                DataTable tb = data.dataReaderTable("select Sum(HD.TongTien) tien from HoaDon HD where YEAR(HD.NgayBan) = '" + tbDate.Value.Year + "' and Month(HD.NgayBan) = '" + tbDate.Value.Month + "' and Day(HD.NgayBan) = '" + tbDate.Value.Day + "'");
                tongdoanhthu.Text = tb.Rows[0]["tien"].ToString()+" $";
                tb = data.dataReaderTable("select COUNT(*) as Voucher from HoaDon HD where YEAR(HD.NgayBan) = '" + tbDate.Value.Year + "' and Month(HD.NgayBan) = '" + tbDate.Value.Month + "' and Day(HD.NgayBan) = '" + tbDate.Value.Day + "' and HD.ID_Voucher !='None'");
                tongphieugiamgia.Text = tb.Rows[0]["Voucher"].ToString();
                tb = data.dataReaderTable("select COUNT(*) as bill from HoaDon HD where YEAR(HD.NgayBan) = '" + tbDate.Value.Year + "' and Month(HD.NgayBan) = '" + tbDate.Value.Month + "' and Day(HD.NgayBan) = '" + tbDate.Value.Day + "'");
                tonghoadon.Text = tb.Rows[0]["bill"].ToString();
            }
            else if(tbDate.Value.Date > tbDate2.Value.Date)
            {
                MessageBox.Show("Bạn cần chọn ngày bắt đâu nhỏ hơn ngày kết thúc!");
                tbDate.Value = DateTime.Now;
                tbDate2.Value = DateTime.Now;
            }
            else
            {
                DataTable tb = data.dataReaderTable("select Sum(HD.TongTien) tien from HoaDon HD where YEAR(HD.NgayBan) >= '" + tbDate.Value.Year + "' and Month(HD.NgayBan) >= '" + tbDate.Value.Month + "' and Day(HD.NgayBan) >= '" + tbDate.Value.Day + "' and" +
                    " (YEAR(HD.NgayBan) <= '" + tbDate2.Value.Year + "' and Month(HD.NgayBan) <= '" + tbDate2.Value.Month + "' and Day(HD.NgayBan) <= '" + tbDate2.Value.Day + "')");
                tongdoanhthu.Text = tb.Rows[0]["tien"].ToString() + " $";
                tb = data.dataReaderTable("select COUNT(*) as Voucher from HoaDon HD where YEAR(HD.NgayBan) >= '" + tbDate.Value.Year + "' and Month(HD.NgayBan) >= '" + tbDate.Value.Month + "' and Day(HD.NgayBan) >= '" + tbDate.Value.Day + "' and" +
                    " YEAR(HD.NgayBan) <= '" + tbDate2.Value.Year + "' and Month(HD.NgayBan) <= '" + tbDate2.Value.Month + "' and Day(HD.NgayBan) <= '" + tbDate2.Value.Day + "' and HD.ID_Voucher !='None'");
                tongphieugiamgia.Text = tb.Rows[0]["Voucher"].ToString();
                tb = data.dataReaderTable("select COUNT(*) as bill from HoaDon HD where YEAR(HD.NgayBan) >= '" + tbDate.Value.Year + "' and Month(HD.NgayBan) >= '" + tbDate.Value.Month + "' and Day(HD.NgayBan) >= '" + tbDate.Value.Day + "' and" +
                    " YEAR(HD.NgayBan) <= '" + tbDate2.Value.Year + "' and Month(HD.NgayBan) <= '" + tbDate2.Value.Month + "' and Day(HD.NgayBan) <= '" + tbDate2.Value.Day + "'");
                tonghoadon.Text = tb.Rows[0]["bill"].ToString();
            }
        }
    }
}
