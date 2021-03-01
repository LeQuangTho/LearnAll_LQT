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
    public partial class Login : Form
    {
        int checkEye = 0;
        DataBase data = new DataBase();

        public Login()
        {
            InitializeComponent();
        }

        private void btnDangNhap_Click(object sender, EventArgs e)
        {
            if (tbUserName.Text != "" && tbPassword.Text != "")
            {
                DataTable dt = data.dataReaderTable("select * from Login where UserName ='"+tbUserName.Text+"' and Password ='"+tbPassword.Text+"'");
                if (dt.Rows.Count == 0)
                {
                    MessageBox.Show("Sai User Name hoặc Password!", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                }
                else
                {
                    Home home = new Home(tbUserName.Text);
                    this.Hide();
                    home.ShowDialog();
                }
            }
            else
            {
                MessageBox.Show("Bạn chưa nhập User hoặc Password!", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }

        private void btThoatDangNhap_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void tbUserName_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Down || e.KeyCode == Keys.Enter) tbPassword.Focus();
        }

        private void tbPassword_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Down) btnDangNhap.Focus();
            else if (e.KeyCode == Keys.Up) tbUserName.Focus();
            else if (e.KeyCode == Keys.Enter) btnDangNhap_Click(sender,e);
        }

        private void btEye_Click(object sender, EventArgs e)
        {
            checkEye++;
            if (checkEye % 2 == 0)
            {
                tbPassword.UseSystemPasswordChar = true;
            }
            else
            {
                tbPassword.UseSystemPasswordChar = false;
            }
        }

        private void Login_Load(object sender, EventArgs e)
        {
            if (checkEye % 2 == 0)
            {
                tbPassword.UseSystemPasswordChar = true;

            }
            else
            {
                tbPassword.UseSystemPasswordChar = false;
            }
        }
    }
}
