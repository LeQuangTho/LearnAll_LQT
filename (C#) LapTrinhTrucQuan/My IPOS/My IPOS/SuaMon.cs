using CrystalDecisions.CrystalReports.Engine;
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
    public partial class SuaMon : Form
    {
        DataBase data = new DataBase();
        public SuaMon(string MaMon, string TenMon, string DonGia)
        {
            InitializeComponent();
            this.tbMaMon.Text = MaMon;
            this.tbTenMon.Text = TenMon;
            this.tbDonGia.Text = DonGia;
        }

        private void gunaGradientButton1_Click(object sender, EventArgs e)
        {
            data.dataChange("update Mon set ID_Mon ='" + tbMaMon.Text + "',TenMon= N'" + tbTenMon.Text + "', DonGiaMon = '" + tbDonGia.Text + "' where ID_Mon ='" + tbMaMon.Text + "'");
            MessageBox.Show("Đã Sửa!");
            this.Close();
        }
    }
}
