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
    public partial class HoiVien : Form
    {
        DataBase data = new DataBase();
        OrderTakeAway od;
        public HoiVien(OrderTakeAway od)
        {
            InitializeComponent();
            this.od = od;
        }

        private void tbMaHoiVien_TextChanged(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select * from KhachHang where ID_KhachHang like '"+tbMaHoiVien.Text+"'");
            if (dt.Rows.Count != 0)
            {
                tbMaHoiVien.Enabled = false;

                tbTenHoiVien.Enabled = false;
                tbTenHoiVien.Text = dt.Rows[0]["TenKhachHang"].ToString();

                cbGioiTinh.Enabled = false;
                cbGioiTinh.Text = dt.Rows[0]["GioiTinh"].ToString();

                dtpNgaySinh.Enabled = false;
                dtpNgaySinh.Value = Convert.ToDateTime(dt.Rows[0]["NgaySinh"].ToString()).Date.Date;

                tbDienThoai.Enabled = false;
                tbDienThoai.Text = dt.Rows[0]["LienHe"].ToString();

                tbDiem.Enabled = false;
                tbDiem.Text = dt.Rows[0]["Diem"].ToString();

                MessageBox.Show("Khách hàng này đã có!");
            }
        }

        private void btChapNhan_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select * from KhachHang where ID_KhachHang like '" + tbMaHoiVien.Text + "'");
            if (tbMaHoiVien.Enabled == false)
            {
                int diem = Convert.ToInt32(dt.Rows[0]["Diem"].ToString());
                data.dataChange("UPDATE KhachHang SET Diem = '" + ++diem + "' WHERE ID_KhachHang = '"+tbMaHoiVien.Text+"'");
                od.tat();
                this.Close();
            }else if(tbMaHoiVien.Text !="" && tbTenHoiVien.Text != "" && tbDienThoai.Text != "" && dt.Rows.Count == 0)
            {
                data.dataChange("insert into KhachHang values('"+tbMaHoiVien.Text+"',N'"+tbTenHoiVien.Text+"','"+dtpNgaySinh.Value.Date.Date.ToString()+"',N'"+cbGioiTinh.SelectedItem.ToString()+"','"+tbDienThoai.Text+"','1')");
                od.MaKhach = tbMaHoiVien.Text;
                this.Close();
            }

        }
    }
}