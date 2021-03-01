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
    public partial class SuaMenu : Form
    {
        DataBase data = new DataBase();
        public SuaMenu()
        {
            InitializeComponent();
        }

        private void tbLDonGia_TextChanged(object sender, EventArgs e)
        {
            if (tbDonGia.Text == "" || tbTenMon.Text == "" || tbMaMon.Text == "")
            {
                btSua.Enabled = false;
                btXoa.Enabled = false;
                btThem.Enabled = false;
            }
            else if (tbDonGia.Text != "" && tbTenMon.Text != "" && tbMaMon.Text != "")
            {
                btSua.Enabled = true;
                btXoa.Enabled = true;
                btThem.Enabled = true;
            }
        }

        private void btThem_Click(object sender, EventArgs e)
        {
            ThemMon tm = new ThemMon();
            tm.ShowDialog();
            loadBang();      
        }

        private void tbLDonGia_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!Char.IsDigit(e.KeyChar) && !Char.IsControl(e.KeyChar))
            {
                e.Handled = true;
            }
        }

        private void SuaMenu_Load(object sender, EventArgs e)
        {
            dgvDanhSachMon.DataSource = data.dataReaderTable("select * from Mon");
            dgvDanhSachMon.Columns[0].HeaderText = "Mã món";
            dgvDanhSachMon.Columns[1].HeaderText = "Tên món";
            dgvDanhSachMon.Columns[2].HeaderText = "Đơn Giá";
        }
        void loadBang()
        {
            dgvDanhSachMon.DataSource = data.dataReaderTable("select * from Mon");
            dgvDanhSachMon.Columns[0].HeaderText = "Mã món";
            dgvDanhSachMon.Columns[1].HeaderText = "Tên món";
            dgvDanhSachMon.Columns[2].HeaderText = "Đơn Giá";
        }

        private void dgvDanhSachMon_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                tbDonGia.Text = dgvDanhSachMon.Rows[e.RowIndex].Cells[2].Value.ToString();
                tbMaMon.Text = dgvDanhSachMon.Rows[e.RowIndex].Cells[0].Value.ToString();
                tbTenMon.Text = dgvDanhSachMon.Rows[e.RowIndex].Cells[1].Value.ToString();
            }
            catch { }
        }

        private void btSua_Click(object sender, EventArgs e)
        {
            if (tbDonGia.Text != "" && tbTenMon.Text != "" && tbMaMon.Text != "")
            {
                SuaMon s = new SuaMon(tbMaMon.Text, tbTenMon.Text, tbDonGia.Text);
                s.ShowDialog();
                tbMaMon.Text = "";
                tbTenMon.Text = "";
                tbDonGia.Text = "";
                loadBang();
            }
            else
            {
                MessageBox.Show("Bạn chưa chọn món nào để sửa");
            }
        }

        private void btXoa_Click(object sender, EventArgs e)
        {
            DataTable dt = data.dataReaderTable("select * from Mon where ID_Mon ='" + tbMaMon.Text + "'");
            if (dt.Rows.Count != 0)
                if (MessageBox.Show("Bạn có muốn xóa không?", "Hỏi", MessageBoxButtons.YesNo) == DialogResult.Yes)
                {
                    data.dataChange("delete from Mon where ID_Mon ='" + tbMaMon.Text + "'");
                    tbMaMon.Text = "";
                    tbTenMon.Text = "";
                    tbDonGia.Text = "";
                    loadBang();
                }
        }
    }
}
