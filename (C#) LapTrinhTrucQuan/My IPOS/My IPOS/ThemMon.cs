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
    public partial class ThemMon : Form
    {
        DataBase data = new DataBase();
        public ThemMon()
        {
            InitializeComponent();
        }

        private void gunaGradientButton1_Click(object sender, EventArgs e)
        {
            if (tbDonGia.Text == "" || tbTenMon.Text == "" || tbMaMon.Text == "") MessageBox.Show("Bạn Chưa Nhập Dữ liệu!");
            else
            {
                DataTable dt = data.dataReaderTable("select * from Mon where ID_Mon ='" + tbMaMon.Text + "'");
                //if (tbDonGia.Text != "" && tbTenMon.Text != "" && tbMaMon.Text != "")
                if (dt.Rows.Count == 0)
                {
                    data.dataChange("insert into Mon values('" + tbMaMon.Text + "',N'" + tbTenMon.Text + "','" + tbDonGia.Text + "')");
                    tbMaMon.Text = "";
                    tbTenMon.Text = "";
                    tbDonGia.Text = "";
                    this.Close();
                }
                else
                {
                    MessageBox.Show("Mã Công Việc Bị Trùng. Mời Nhập Lại!");
                }
            }
        }
    }
}
