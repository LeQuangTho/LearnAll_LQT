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

namespace Baitap27
{
    public partial class Form3 : Form
    {
        DataBase dtBase = new DataBase();

        public Form3()
        {
            InitializeComponent();
        }

        private void Form3_Load(object sender, EventArgs e)
        {
            cbChatLieu.DataSource = dtBase.DataReader("select * from tblChatLieu");
            cbChatLieu.DisplayMember = "TenChatLieu";
            cbChatLieu.ValueMember = "MaChatLieu";

            dgvHang.DataSource = dtBase.DataReader("select * from tblHang");
            dgvHang.Columns[0].HeaderText = "Mã Hàng";
            dgvHang.Columns[1].HeaderText = "Tên Hàng";
            dgvHang.Columns[2].HeaderText = "Mã Chất Liệu";
            dgvHang.Columns[3].HeaderText = "Số Lượng";
            dgvHang.Columns[4].HeaderText = "Đơn Giá Nhập";
            dgvHang.Columns[5].HeaderText = "Đơn Giá Bán";
            dgvHang.Columns[6].HeaderText = "Ảnh";
            dgvHang.Columns[7].HeaderText = "Ghi Chú";
        }

        private void btAnh_Click(object sender, EventArgs e)
        {
            OpenFileDialog dlgOpen = new OpenFileDialog();
            if (dlgOpen.ShowDialog() == DialogResult.OK)
            {
                pictureBox1.Image = Image.FromFile(dlgOpen.FileName);
                MessageBox.Show(dlgOpen.FileName);
                MessageBox.Show(pictureBox1.ToString());
            }    
        }

        private void btThem_Click(object sender, EventArgs e)
        {
            string anh = "null";
            if (pictureBox1.Image != null) anh = pictureBox1.Image.ToString();
            string sql = "insert into tblHang values ('"
                + tbMaHang.Text + "', N'" + tbTenHang.Text + "', '" +
                cbChatLieu.SelectedValue.ToString() + "', '" + tbSoLuong.Text + "', '" +
                tbDonGiaNhap.Text + "', '" + tbDonGiaBan.Text + "', '" +
                anh + "', '" + tbGhiChu.Text + "')";
                dtBase.DataChange(sql);

           dgvHang.DataSource = dtBase.DataReader("select * from tblHang");
        }
    }
}
