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
    public partial class frmHang : Form
    {
        string strImageFileName;
        Classes.DataBaseProcess dtBase = new Classes.DataBaseProcess();
        public frmHang()
        {
            InitializeComponent();
        }

        private void frmHang_Load(object sender, EventArgs e)
        {
            //Lấy dữ liệu từ bảng Chất liệu đổ vào ComboBox Chất liệu
            cboChatLieu.DataSource = dtBase.DataReader( "Select * from tblChatlieu");
            cboChatLieu.DisplayMember = "TenChatLieu";
            cboChatLieu.ValueMember = "MaChatLieu";
            //Load dữ liệu từ bảng hàng ra DataGridView
            dgvHang.DataSource = dtBase.DataReader("Select * from tblhang");
            dgvHang.Columns[0].HeaderText = "Mã hàng";
            dgvHang.Columns[1].HeaderText = "Tên hàng";
            dgvHang.Columns[2].HeaderText = "Chất liệu";
            dgvHang.Columns[3].HeaderText = "Số Lượng";
            dgvHang.Columns[4].HeaderText = "Đơn giá bán";
            dgvHang.Columns[5].HeaderText = "Đơn giá nhập";
            dgvHang.Columns[6].HeaderText = "Ảnh";
            dgvHang.Columns[7].HeaderText = "Ghi chú";


        }

        private void btnAnh_Click(object sender, EventArgs e)
        {
            string[] Anh;
            OpenFileDialog dlgOpen = new OpenFileDialog();
            dlgOpen.Filter = "JPEG Images|*.jpg|All Files|*.*";
            if(dlgOpen.ShowDialog()==DialogResult.OK)
            {
                picAnhSP.Image = Image.FromFile(dlgOpen.FileName);
                //E:\BaiGiang\Anh\H1.jpg
                Anh = dlgOpen.FileName.ToString().Split('\\');
                strImageFileName = Anh[Anh.Length - 1];
            }    
        }

        private void btnThem_Click(object sender, EventArgs e)
        {
            //Kiểm tra nhập đủ dữ liệu cho các trường bắt buộc
            if(txtMaHang.Text =="")
            {
                MessageBox.Show("Bạn phải nhập mã hàng");
                txtMaHang.Focus();
                return;
            }
            if (txtTenHang.Text == "")
            {
                MessageBox.Show("Bạn phải nhập tên hàng");
                txtTenHang.Focus();
                return;
            }
            //.....Tương tự các trường khác
            //Kiểm tra trùng mã hàng
            DataTable dtHang = dtBase.DataReader("Select * from tblHang where MaHang='"
                    +txtMaHang.Text+"'");
            if(dtHang.Rows.Count>0)
            {
                MessageBox.Show("mã hàng này đã có bạn cần nhập mã khác");
                txtMaHang.Focus();
                return;
            }
            //Thêm mới hàng
            dtBase.DataChange("insert into tblHang values('"+txtMaHang.Text
                +"',N'"+txtTenHang.Text+"','"+cboChatLieu.SelectedValue.ToString()+
                "',"+ Convert.ToInt16( txtSoLuong.Text)+","+
                Convert.ToDouble(txtDonGiaNhap.Text)+","+Convert.ToDouble(txtDonGiaBan.Text)+
                ",'"+strImageFileName+"',N'"+txtGhiChu.Text+"')");
            //Hiển thị trên Grid
            dgvHang.DataSource = dtBase.DataReader("Select * from tblHang"); 
        }

        private void dgvHang_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            txtMaHang.Text = dgvHang.CurrentRow.Cells[0].Value.ToString();
            txtTenHang.Text= dgvHang.CurrentRow.Cells[1].Value.ToString();
            cboChatLieu.SelectedValue= dgvHang.CurrentRow.Cells[2].Value.ToString();
            txtSoLuong.Text= dgvHang.CurrentRow.Cells[3].Value.ToString();
            txtDonGiaBan.Text= dgvHang.CurrentRow.Cells[4].Value.ToString();
            txtDonGiaNhap.Text= dgvHang.CurrentRow.Cells[5].Value.ToString();
            picAnhSP.Image = Image.FromFile(System.IO.Directory.GetCurrentDirectory().ToString()+
                "\\Images\\Hang\\"+ dgvHang.CurrentRow.Cells[6].Value.ToString());
            txtGhiChu.Text= dgvHang.CurrentRow.Cells[7].Value.ToString();
            strImageFileName = dgvHang.CurrentRow.Cells[6].Value.ToString();
        }

        private void btnSua_Click(object sender, EventArgs e)
        {
            if(txtMaHang.Text=="")
            {
                MessageBox.Show("Bạn cần chọn một mã để sửa");
                return;
            }
            dtBase.DataChange("update tblHang Set TenHang=N'"+txtTenHang.Text+
                "',ChatLieu='"+cboChatLieu.SelectedValue.ToString()+"',SoLuong="+Convert.ToInt16(txtSoLuong.Text)+
                ",DonGiaNhap="+Convert.ToDouble(txtDonGiaNhap.Text)+",DonGiaBan="+Convert.ToDouble(txtDonGiaBan.Text)
                +",Anh='"+strImageFileName+"',GhiChu='"+txtGhiChu.Text+
                "' where MaHang='"+txtMaHang.Text+"'");
            MessageBox.Show("Sửa thành công");
            //Load lại dữ liệu
            dgvHang.DataSource = dtBase.DataReader("Select * from tblHang");
        }
    }
}
