using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Project__Đầu_Tiên
{
    public partial class theFirstProgram : Form
    {
        public theFirstProgram()
        {
            InitializeComponent();
        }

        private void btnDisplay_Click(object sender, EventArgs e)
        {
            txtWelcome.Text = "Welcome to VisualBasic for C#";
            txtWelcome.BackColor = Color.Yellow;
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            txtWelcome.Text = "";
            txtWelcome.BackColor = Color.White;
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Bạn có muốn thoát không", "Hỏi", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)               
                this.Close();
        }

        private void Random_Click(object sender, EventArgs e)
        {
            Random a = new Random();
            txtWelcome.Text = a.Next(1, 100).ToString();
        }
    }
}
