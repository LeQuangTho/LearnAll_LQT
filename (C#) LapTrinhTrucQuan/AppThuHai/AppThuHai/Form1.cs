using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace AppThuHai
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void textBox1_KeyPress(object sender, KeyPressEventArgs e)
        {
            if(Convert.ToInt16(e.KeyChar) < Convert.ToInt16('0')
                || Convert.ToInt16(e.KeyChar) > Convert.ToInt16('9'))
            {
                MessageBox.Show("Bạn Chỉ Được Nhập Số!");
            }
        }

        private void btn1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == "")
            {
                MessageBox.Show("Bạn phải nhập tháng!");
                textBox1.Focus();
            }
            else
            {
                int thang, nam;
                thang = Convert.ToInt16(textBox1.Text);
                nam = Convert.ToInt16(textBox2.Text);
                if (thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12)
                {
                    lb3.Text = "Tháng " + thang.ToString() + " năm " + nam.ToString() + " có 31 ngày!";
                }
                else if (thang == 2)
                {
                    if (nam % 4 == 0) lb3.Text = "Tháng " + thang.ToString() + " năm " + nam.ToString() + " có 29 ngày!";
                    else lb3.Text = "Tháng " + thang.ToString() + " năm " + nam.ToString() + " có 28 ngày!";
                }
                else lb3.Text = "Tháng " + thang.ToString() + " năm " + nam.ToString() + " có 30 ngày!";
            }
              
        }

        private void btn2_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
            textBox2.Text = "";
            lb3.Text = "";
        }

        private void btn3_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Bạn có muốn thoát không?", "Thông Báo", MessageBoxButtons.YesNoCancel) == DialogResult.Yes)
                this.Close();
        }
    }
}
