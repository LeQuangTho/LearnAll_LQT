using CoSoDuLieu.Classes;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Excel = Microsoft.Office.Interop.Excel;

namespace Baitap27
{
    public partial class Form4 : Form
    {
        DataBase data = new DataBase();


        public Form4()
        {
            InitializeComponent();
        }

        private void Form4_Load(object sender, EventArgs e)
        {
            cbbMaNhanVien.DataSource = data.DataReader("select MaNhanVien from tblNhanVien");
            cbbMaNhanVien.DisplayMember = "MaNhanVien";
            cbbMaNhanVien.ValueMember = "MaNhanVien";

            cbbMaKhachHang.DataSource = data.DataReader("select MaKhach from tblKhach");
            cbbMaKhachHang.DisplayMember = "MaKhach";
            cbbMaKhachHang.ValueMember = "MaKhach";

            cbbMaHang.DataSource = data.DataReader("select MaHang from tblHang");
            cbbMaHang.DisplayMember = "MaHang";
            cbbMaHang.ValueMember = "MaHang";
        }

        private void cbbMaNhanVien_SelectedIndexChanged(object sender, EventArgs e)
        {
            DataTable dtNhanVien = data.DataReader("select * from tblNhanVien where MaNhanVien ='" + cbbMaNhanVien.Text.ToString() + "'");
            try { tbTenNhanVien.Text = "" + dtNhanVien.Rows[0]["TenNhanVien"].ToString(); }
            catch { }
        }

        private void cbbMaKhachHang_SelectedIndexChanged(object sender, EventArgs e)
        {
            DataTable dtKhachHang = data.DataReader("select * from tblKhach where MaKhach ='" + cbbMaKhachHang.Text.ToString() + "'");
            try { tbTenKhachHang.Text = "" + dtKhachHang.Rows[0]["TenKhach"].ToString(); }
            catch { }
        }

        private void cbbMaHang_SelectedIndexChanged(object sender, EventArgs e)
        {
            DataTable dtHang = data.DataReader("select * from tblHang where MaHang ='" + cbbMaHang.Text.ToString() + "'");
            try { 
                tbTenHang.Text = "" + dtHang.Rows[0]["TenHang"].ToString();
                tbDonGia.Text = dtHang.Rows[0]["DonGiaBan"].ToString();
            }
            catch { }
        }

        private void tbSoLuong_TextChanged(object sender, EventArgs e)
        {
            try
            {
                int sl, gg, dg;
                double tt;
                if (tbGiamGia.Text == "") gg = 0;
                else gg = Convert.ToInt16(tbGiamGia.Text);
                if (tbSoLuong.Text == "") sl = 0;
                else
                    sl = Convert.ToInt16(tbSoLuong.Text);
                dg = Convert.ToInt32(tbDonGia.Text);
                tt = sl * dg * (1 - (gg * 1.0) / 100);
                tbThanhTien.Text = tt.ToString();
            }
            catch { }
        }

        private void btnThemHoaDon_Click(object sender, EventArgs e)
        {
            Random rd = new Random();
            tbMaHoaDon.Text = "" + rd.Next(1, 99999);
        }

        private void btnLuu_Click(object sender, EventArgs e)
        {
            double tongtien = 0;
            DataTable dtHDB = data.DataReader("select * from tblHDBan where MaHDBan ='" + tbMaHoaDon.Text.ToString() + "'");
            if(dtHDB.Rows.Count == 0)
            {
                data.DataChange("insert into tblHDBan values('"+tbMaHoaDon.Text+"','"+cbbMaNhanVien.Text+"','"+dtpNgayBan.Text+"','"+cbbMaKhachHang.Text+"','"+tbTongTien.Text+"')");
            }
            else
            {
                DataTable dtHD = data.DataReader("select * from tblHDBan where MaHDBan ='" + tbMaHoaDon.Text + "'");
                tongtien = Convert.ToDouble(tbThanhTien.Text.ToString()) + Convert.ToDouble(dtHD.Rows[0]["TongTien"]);
                data.DataChange("Update tblHDBan set TongTien = '" + tongtien.ToString() +"'"+ "where MaHDBan = '" + tbMaHoaDon.Text + "'");
            }
            data.DataChange("insert into tblChiTietHDBan values('" + tbMaHoaDon.Text + "','" + cbbMaHang.SelectedValue.ToString() +
                "','" + Convert.ToInt16(tbSoLuong.Text) +
                "','" + Convert.ToInt16(tbGiamGia.Text) + "','" + Convert.ToDouble(tbThanhTien.Text) + "')");
            dgvHoaDonBan.DataSource = data.DataReader("Select tblChiTietHDBan.MaHang,tblHang.TenHang,tblChiTietHDBan.SoLuong,tblHang.DonGiaBan,GiamGia,ThanhTien" +
                " from tblChiTietHDBan inner join tblHang on tblChiTietHDBan.MaHang=tblHang.MaHang where MaHDBan='" + tbMaHoaDon.Text + "'");
        }

        private void btnDong_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnInHoaDon_Click(object sender, EventArgs e)
        {
            //Khai báo và khởi tạo các đối tượng

            /*Excel.Application exApp = new Excel.Application();
            Excel.Workbook exBook = exApp.Workbooks.Add(Excel.XlWBATemplate.xlWBATWorksheet);
            Excel.Worksheet exSheet = (Excel.Worksheet)exBook.Worksheets[1];
            Excel.Range tenTruong = (Excel.Range)exSheet.Cells[1, 1]; //Đưa con trỏ vào ô A1*/

        }
    }
}
