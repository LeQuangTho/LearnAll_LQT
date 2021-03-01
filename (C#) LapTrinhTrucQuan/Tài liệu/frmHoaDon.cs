using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CSDLN01.Forms
{
    public partial class frmHoaDon : Form
    {
        Classes.DataBaseProcess dtBase = new Classes.DataBaseProcess();
        public frmHoaDon()
        {
            InitializeComponent();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            
        }

        private void frmHoaDon_Load(object sender, EventArgs e)
        {
            cboMaNV.DataSource = dtBase.DataReader("Select * from tblNhanVien");
            cboMaNV.DisplayMember = "MaNV";
            cboMaNV.ValueMember = "MaNV";
            cboMaNV.SelectedIndex = 0;
            cboMaKH.DataSource = dtBase.DataReader("Select * from tblKhachHang");
            cboMaKH.DisplayMember = "MaKH";
            cboMaKH.ValueMember = "MaKH";
            cboMaKH.SelectedIndex = 0;
            cboMaHang.DataSource = dtBase.DataReader( "Select MaHang from tblHang");
            cboMaHang.DisplayMember = "MaHang";
            cboMaHang.ValueMember = "MaHang";
            cboMaHang.SelectedIndex = 0;
        }

        private void cboMaNV_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {
                DataTable dtNhanVien = dtBase.DataReader("Select * from tblNhanVien where MaNV='" + cboMaNV.SelectedValue.ToString() + "'");
                txtTenNV.Text = dtNhanVien.Rows[0]["TenNV"].ToString();

            }
            catch { }


        }

        private void cboMaKH_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {
                DataTable dtKH = dtBase.DataReader("Select * from tblKhachHang where MaKH='" + cboMaKH.SelectedValue.ToString() + "'");
                txtTenKH.Text = dtKH.Rows[0]["TenKH"].ToString();
                txtDCKH.Text= dtKH.Rows[0]["DiaChi"].ToString();
                txtDTKH.Text= dtKH.Rows[0]["DienThoai"].ToString();

            }
            catch { }
        }

        private void cboMaHang_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {
                DataTable dtHang = dtBase.DataReader("Select * from tblHang where MaHang='" + cboMaHang.SelectedValue.ToString() + "'");
                txtTenHang.Text = dtHang.Rows[0]["TenHang"].ToString();
                txtDonGia.Text = dtHang.Rows[0]["DonGiaBan"].ToString();
                
            }
            catch { }
        }

        private void txtSoLuong_TextChanged(object sender, EventArgs e)
        {
            try
            {
                int sl, gg, dg;
                double tt;
                if (txtGiamGia.Text == "")
                    gg = 0;
                else
                    gg = Convert.ToInt16(txtGiamGia.Text);
                if (txtSoLuong.Text == "")
                    sl = 0;
                else
                    sl = Convert.ToInt16(txtSoLuong.Text);
                dg = Convert.ToInt32(txtDonGia.Text);
                tt = sl * dg * (1 - (gg*1.0)/100);
                txtThanhTien.Text = tt.ToString();
            }
            catch { }
           
           
        }

        private void btnThem_Click(object sender, EventArgs e)
        {
            Classes.Common com = new Classes.Common();
            txtMaHD.Text = com.AutoCode("tblHDBan", "MaHDB", "HĐ" + DateTime.Now.ToShortDateString());
        }

        private void btnLuu_Click(object sender, EventArgs e)
        {
            DataTable dtHDB = dtBase.DataReader("Select * from tblHDBan where MaHDB='" + txtMaHD.Text + "'");
            //Các bạn tự ktra nhập đủ dữ liệu
            double tongtien;
            if(dtHDB.Rows.Count==0)
            {
                dtBase.DataChange("Insert into tblHDBan values('"+txtMaHD.Text+"','"+cboMaNV.SelectedValue.ToString()+
                    "','"+cboMaKH.SelectedValue.ToString()+"','"+dtpNgayBan.Value.ToString()+"',"+Convert.ToDouble(txtThanhTien.Text)+")");
                txtTongTien.Text = txtThanhTien.Text;
            }
            else
            {
                //Tính lại tổng tiền
                DataTable dtHD = dtBase.DataReader("Select * from tblHDBan where MaHDB='" + txtMaHD.Text + "'");
                tongtien = Convert.ToDouble(txtThanhTien.Text) + Convert.ToDouble(dtHD.Rows[0]["TongTien"]);
                dtBase.DataChange("Update tblHDBan set TongTien=" + tongtien + " where MaHDB='" + txtMaHD.Text + "'");
                txtTongTien.Text = tongtien.ToString();
            }
            dtBase.DataChange("insert into tblChiTietHD values('" + txtMaHD.Text + "','" + cboMaHang.SelectedValue.ToString() +
                "'," + Convert.ToInt16(txtSoLuong.Text) + 
                "," + Convert.ToInt16(txtGiamGia.Text) + "," + Convert.ToDouble(txtThanhTien.Text) + ")");
            dgvChiTietHD.DataSource = dtBase.DataReader("Select tblChiTietHD.MaHang,tblHang.TenHang,tblChiTietHD.SoLuong,tblHang.DonGiaBan,GiamGia,ThanhTien"+
                " from tblChiTietHD inner join tblHang on tblChiTietHD.MaHang=tblHang.MaHang where MaHDBan='"+txtMaHD.Text+"'");
           

        }
    }
}
