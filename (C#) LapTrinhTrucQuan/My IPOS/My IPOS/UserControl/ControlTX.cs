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
    public partial class ControlTX : UserControl
    {
        OrderTakeAway away;
        DataBase data = new DataBase();

        public ControlTX(OrderTakeAway a)
        {
            InitializeComponent();
            away = a;
        }


        private void btnTX_M_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'"+btnTX_M.Text+"'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTX_M.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }

        private void btnTXXoai_M_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTXXoai_M.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTXXoai_M.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }

        private void btnTXDuaHongHac_M_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTXDuaHongHac_M.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTXDuaHongHac_M.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }

        private void btnTX_L_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTX_L.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTX_L.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }

        private void btnTXXoai_L_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTXXoai_L.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTXXoai_L.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }

        private void btnTXDauTamPhaLeTuyet_L_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTXDauTamPhaLeTuyet_L.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTXDauTamPhaLeTuyet_L.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }

        private void btnTXDuaHongHac_L_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTXDuaHongHac_L.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTXDuaHongHac_L.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }

        private void btnTXKiwiChanhLeo_M_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTXKiwiChanhLeo_M.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTXKiwiChanhLeo_M.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }

        private void btnTXChanhLeo_M_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTXChanhLeo_M.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTXChanhLeo_M.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }

        private void btnTXDuaNhietDoi_M_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTXDuaNhietDoi_M.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTXDuaNhietDoi_M.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }

        private void btnTXHongLongPhaLeTuyet_M_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTXHongLongPhaLeTuyet_M.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTXHongLongPhaLeTuyet_M.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }

        private void btnTXKiwiChanhLeo_L_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTXKiwiChanhLeo_L.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTXKiwiChanhLeo_L.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }

        private void btnTXChanhLeo_L_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTXChanhLeo_L.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTXChanhLeo_L.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }

        private void btnTXDuaNhietDoi_L_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTXDuaNhietDoi_L.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTXDuaNhietDoi_L.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }

        private void btnTXHongLongPhaLeTuyet_L_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTXHongLongPhaLeTuyet_L.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            away.addMon(++away.stt, btnTXHongLongPhaLeTuyet_L.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }

        private void btnTXDauTamPhaLeTuyet_M_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select DonGiaMon from Mon where TenMon = N'" + btnTXDauTamPhaLeTuyet_M.Text + "'");
            int dongia = Convert.ToInt32(dt.Rows[0]["DonGiaMon"].ToString());
            int soluong = 1;
            float giamgia = 0;
            string ghichu = "";
            string time = DateTime.Now.ToString();
            string MaMon = "";
            
            away.addMon(++away.stt, btnTXDauTamPhaLeTuyet_M.Text, soluong, giamgia, dongia, ghichu, time, soluong * dongia - (soluong * dongia * giamgia), MaMon);
        }
    }
}
