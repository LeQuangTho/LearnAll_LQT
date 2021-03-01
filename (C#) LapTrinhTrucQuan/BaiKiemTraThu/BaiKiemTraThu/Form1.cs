using BaiKiemTraThu.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaiKiemTraThu
{
    public partial class Form1 : Form
    {
        DataBase data = new DataBase();
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            loadBang();   
        }

        void loadBang()
        {
            dgvCongViec.DataSource = data.dataReaderTable("select * from CongViec");
            dgvCongViec.Columns[0].HeaderText = "Mã công việc";
            dgvCongViec.Columns[1].HeaderText = "Tên công việc";
            dgvCongViec.Columns[2].HeaderText = "Luong tháng";
        }

        private void tbLuongThang_KeyPress(object sender, KeyPressEventArgs e)
        {
            if(!Char.IsDigit(e.KeyChar) && !Char.IsControl(e.KeyChar))
            {
                e.Handled = true;
            }
        }

        private void btThoat_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Bạn có muốn thoát không?", "Hỏi", MessageBoxButtons.YesNo) == DialogResult.Yes) this.Close();
        }

        private void btThem_Click(object sender, EventArgs e)
        {
            if (tbLuongThang.Text == "" || tbTenCongViec.Text == "" || tbMaCongViec.Text == "") MessageBox.Show("Bạn Chưa Nhập Dữ liệu");
            else
            {
                DataTable dt = data.dataReaderTable("select * from CongViec where MaCongViec ='" + tbMaCongViec.Text + "'");
                if (dt.Rows.Count == 0)
                {
                    data.dataChange("insert into CongViec values('" + tbMaCongViec.Text + "',N'" + tbTenCongViec.Text + "','" + tbLuongThang.Text + "')");
                    loadBang();
                    tbMaCongViec.Text = "";
                    tbTenCongViec.Text = "";
                    tbLuongThang.Text = "";
                }
                else
                {
                    MessageBox.Show("Mã Công Việc Bị Trùng. Mời Nhập Lại!");
                }
            }
        }

        private void dgvCongViec_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                tbLuongThang.Text = dgvCongViec.Rows[e.RowIndex].Cells[2].Value.ToString();
                tbMaCongViec.Text = dgvCongViec.Rows[e.RowIndex].Cells[0].Value.ToString();
                tbTenCongViec.Text = dgvCongViec.Rows[e.RowIndex].Cells[1].Value.ToString();
            }
            catch { }
        }

        private new void TextChanged(object sender, EventArgs e)
        {
            if (tbLuongThang.Text == "" || tbTenCongViec.Text == "" || tbMaCongViec.Text == "")
            {
                btSua.Enabled = false;
                btXoa.Enabled = false;
                btThem.Enabled = false;
            }else if (tbLuongThang.Text != "" && tbTenCongViec.Text != "" && tbMaCongViec.Text != "")
            {
                btSua.Enabled = true;
                btXoa.Enabled = true;
                btThem.Enabled = true;
            }
        }

        private void btSua_Click(object sender, EventArgs e)
        {
            data.dataChange("update CongViec set MaCongViec ='" + tbMaCongViec.Text + "',TenCongViec=N'" + tbTenCongViec.Text + "', LuongThang = '" + tbLuongThang.Text + "' where MaCongViec ='" + tbMaCongViec.Text + "'");
            loadBang();
        }

        private void btXoa_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select * from CongViec where MaCongViec ='" + tbMaCongViec.Text + "'");
            if(dt.Rows.Count !=0)
            if (MessageBox.Show("Bạn có muốn xóa không?", "Hỏi", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                data.dataChange("delete from CongViec where MaCongViec ='" + tbMaCongViec.Text + "'");
                tbMaCongViec.Text = "";
                tbTenCongViec.Text = "";
                tbLuongThang.Text = "";
                loadBang();
            }
        }
    }
}
