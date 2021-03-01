using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaiTap2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnKQ_Click(object sender, EventArgs e)
        {
            int a, b;
            a = Convert.ToInt32(textBox1.Text);
            b = Convert.ToInt32(textBox2.Text);
            if (checkInput() == true)
            {
                label3.Text = "Tổng từ " + textBox1.Text + " đến " + textBox2.Text + " có " + (b - a + 1);
            }
        }

        bool checkInput()
        {
            if (textBox1.Text == "")
            {
                MessageBox.Show("Bạn chưa nhập tháng!");
                textBox1.Focus();
                return false;
            }
            if (textBox2.Text == "")
            {
                MessageBox.Show("Bạn chưa nhập năm!");
                textBox2.Focus();
                return false;
            }
            return true;
        }

        private void btnLL_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
            textBox2.Text = "";
            label3.Text = "";
        }

        private void btnT_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Bạn có muốn đóng không?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void textBox1_KeyPress(object sender, KeyPressEventArgs e)
        {
            if ((Convert.ToInt16(e.KeyChar) < '0' || Convert.ToInt16(e.KeyChar) > '9')
                && Convert.ToInt16(e.KeyChar) != 8)
            {
                MessageBox.Show("Bạn phải nhập số!");
                e.Handled = true;
            }
        }
    }
}
