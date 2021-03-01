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
    public partial class NewCa : Form
    {
        private double duDau = 0;

        public NewCa()
        {
            InitializeComponent();
        }

        public void setDuDau(double a)
        {
            this.duDau = a;
        }

        public double getDuDau()
        {
            return this.duDau;
        }

        private void btBatDau_Click(object sender, EventArgs e)
        {
            /*setDuDau(Convert.ToInt32(tbDuDau.Text.ToString()));
            this.Hide();
            Home home = new Home();
            home.Show();*/
        }

        private void NewCa_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (MessageBox.Show("Bạn có muốn đóng chương trình không?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                System.Windows.Forms.Application.Exit();    //đóng toàn bộ chương trình
            }
            else
            {
                e.Cancel = true;
            }
        }

        private void NewCa_FormClosed(object sender, FormClosedEventArgs e)
        {
                System.Windows.Forms.Application.Exit();    //đóng toàn bộ chương trình
        }

        private void tbDuDau_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter) btBatDau_Click(sender, e);
        }

        private void tbDuDau_KeyPress(object sender, KeyPressEventArgs e)
        {
            if(!Char.IsDigit(e.KeyChar) && !Char.IsControl(e.KeyChar))
            {
                e.Handled = true;
            }
        }
    }
}
