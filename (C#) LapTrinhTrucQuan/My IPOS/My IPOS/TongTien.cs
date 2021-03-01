using DevComponents.DotNetBar.Controls;
using Microsoft.Reporting.WinForms;
using My_IPOS.Model;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Hosting;
using System.Windows.Forms;

namespace My_IPOS
{
    public partial class TongTien : Form
    {
        DataGridView dt;
        DataBase data = new DataBase();
        OrderTakeAway od;

        MaHoaDon taoID = new MaHoaDon();
        string ID_HoaDon, TT, ID_KhachHang, ID_Voucher;
        DataTable dt1;
        DateTime dateTime = DateTime.Now;
        string user;

        public TongTien(DataGridView a, OrderTakeAway od, string user)
        {
            InitializeComponent();
            dt = a;
            this.od = od;
            this.user = user;
        }

        private void TongTien_Load(object sender, EventArgs e)
        {
            try
            {
                this.dataTable1TableAdapter.Fill(this.my_IPos.DataTable1);
            }
            catch { }
            int thanhtoan = 0, khachdua = 0, tienthua = 0;
            int n = 0;
            foreach (DataGridViewRow row in dt.Rows)
            {
                dgvTongTien.Rows.Add();
                dgvTongTien.Rows[n].Cells[0].Value = row.Cells[0].Value.ToString();
                dgvTongTien.Rows[n].Cells[1].Value = row.Cells[1].Value.ToString();
                dgvTongTien.Rows[n].Cells[2].Value = row.Cells[2].Value.ToString();
                dgvTongTien.Rows[n].Cells[3].Value = row.Cells[7].Value.ToString();
                thanhtoan += Convert.ToInt32(row.Cells[7].Value.ToString());
                n++;
            }
            khachdua = thanhtoan;
            tienthua = khachdua - thanhtoan;
            tbThanhToan.Text = thanhtoan.ToString();
            tbKhachDua.Text = khachdua.ToString();
            tbTienThua.Text = tienthua.ToString();
            this.reportViewer1.RefreshReport();
        }

        private void btTAorDI_Click(object sender, EventArgs e)
        {
            if (btTAorDI.Text.ToString() == "TA")
            {
                btTAorDI.Text = "DI";
            }
            else btTAorDI.Text = "TA";
        }

        private void btnDong_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnVoucher_Click(object sender, EventArgs e)
        {

            if (tbTheGiamGia.Text == "")
            {
                MessageBox.Show("voucher này không giảm giá!");
            }
            else
            { 
                DataTable dt = data.dataReaderTable("select * from Voucher where ID_Voucher like '" + tbTheGiamGia.Text + "'");
                if (dt.Rows.Count != 0)
                {
                    tbThanhToan.Text = "" + (Convert.ToInt32(tbThanhToan.Text) * (1 - 0.5));
                    try
                    {
                        MessageBox.Show("Đã áp dụng voucher");
                        tbTienThua.Text = "" + (Convert.ToInt32(tbKhachDua.Text.ToString()) - Convert.ToInt32(tbThanhToan.Text.ToString()));
                    }
                    catch { }
                }
                else MessageBox.Show("Không Có Voucher Này!");
            }
        }

        private void tbKhachDua_TextChanged(object sender, EventArgs e)
        {
            try
            {
                tbTienThua.Text = "" + (Convert.ToInt32(tbKhachDua.Text.ToString()) - Convert.ToInt32(tbThanhToan.Text.ToString()));
                /*if (Convert.ToInt32(tbKhachDua.Text.ToString()) - Convert.ToInt32(tbThanhToan.Text.ToString()) >= 0) btnInHoaDon.Enabled = true;
                else btnInHoaDon.Enabled = false;*/
            }
            catch { }
        }

        private void btThanhToan_Click(object sender, EventArgs e)
        {
            luu();
            btnInHoaDon.Enabled = true;
            if (MessageBox.Show("Đã lưu hóa đơn!") == DialogResult.OK) btnInHoaDon_Click(sender,e);
        }

        private void tbKhachDua_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!Char.IsDigit(e.KeyChar) && !Char.IsControl(e.KeyChar))
                e.Handled = true;
        }

        private void btnInHoaDon_Click(object sender, EventArgs e)
        {
            try
            {
                reportViewer1.PrintDialog();
            }
            catch { }
            this.Close();
            od.outOrder();
        }

        void luu()
        {
            string date = "" + dateTime;
            if (tbTheGiamGia.Text == "") ID_Voucher = "None";
            else ID_Voucher = tbTheGiamGia.Text;
            TT = tbThanhToan.Text;
            ID_HoaDon = "" + taoID.TaoID_HoaDon();
            ID_KhachHang = od.MaKhach;

            data.dataChange("insert into HoaDon values('" + ID_HoaDon + "','" + date + "','" + TT + "','" + ID_KhachHang + "','" + ID_Voucher + "','"+user+"')");
            for (int i = 0; i < dgvTongTien.RowCount; i++)
            {
                dt1 = data.dataReaderTable("select * from Mon where TenMon = N'" + dgvTongTien.Rows[i].Cells[1].Value.ToString() + "'");
                if (dt1.Rows.Count != 0)
                    data.dataChange("insert into ChiTietHoaDon values('" + dgvTongTien.Rows[i].Cells[2].Value.ToString() + "','" + ID_HoaDon + "','" + dt1.Rows[0]["ID_Mon"].ToString() + "')");
                else MessageBox.Show("Có lỗi");
            }
            try
            {
                this.dataTable1TableAdapter.FillBy(this.my_IPos.DataTable1, ID_HoaDon);
            }
            catch { }
            this.reportViewer1.RefreshReport();
        }
    }
}
