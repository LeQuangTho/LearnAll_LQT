using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Restaurant
{
    public partial class FormLogin : Form
    {
        public FormLogin()
        {
            InitializeComponent();
        }

        private void buttonExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void buttonShowPassword_Click(object sender, EventArgs e)
        {
            if(textPassword.UseSystemPasswordChar==true)
            {
                textPassword.UseSystemPasswordChar = false;
                buttonShowPassword.IconChar = FontAwesome.Sharp.IconChar.EyeSlash;
            }
            else
            {
                buttonShowPassword.IconChar = FontAwesome.Sharp.IconChar.Eye;
                textPassword.UseSystemPasswordChar = true;
            }
        }
    }
}
