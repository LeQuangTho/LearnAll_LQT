using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Security.AccessControl;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace My_IPOS
{
    public partial class Home : Form
    {
        string user;
        public Home(string user)
        {
            this.user = user;
            InitializeComponent();
        }

        private void Home_FormClosed(object sender, FormClosedEventArgs e)
        {
            System.Windows.Forms.Application.Exit();
        }

        private void btnTakeAway_Click_1(object sender, EventArgs e)
        {
            OrderTakeAway orderTakeAway = new OrderTakeAway(user);
            orderTakeAway.Show();
        }

        private void btnDangXuat_Click(object sender, EventArgs e)
        {
            Application.Restart();
        }

        private void btnSuaMenu_Click(object sender, EventArgs e)
        {
            SuaMenu suaMenu = new SuaMenu();
            suaMenu.ShowDialog();
        }

        private void btnKhoaSo_Click(object sender, EventArgs e)
        {
            BaoCao bc = new BaoCao();
            bc.ShowDialog();
        }

        private void Home_Load(object sender, EventArgs e)
        {
            if (user != "admin") btnSuaMenu.Visible = false;
        }
    }
}
