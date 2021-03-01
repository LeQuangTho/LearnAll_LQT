using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using My_IPOS.Model;

namespace My_IPOS
{
    public partial class ControlTP : UserControl
    {
        OrderTakeAway away;
        DataBase data = new DataBase();

        public ControlTP(OrderTakeAway a)
        {
            InitializeComponent();
            away = a;
        }

        private void btnTPTranChauQQ_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTPTranChauQQ.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTPTranChauQQ.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }
    }
}
