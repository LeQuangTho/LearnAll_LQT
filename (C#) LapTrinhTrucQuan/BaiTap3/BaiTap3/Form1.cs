using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaiTap3
{

    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        Random random = new Random();
        
        int[] a;
        private void btn1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == "")
            {
                MessageBox.Show("Bạn chưa nhập số!");
                textBox1.Focus();
            }
            else
            {
                string DaySo = "Dãy Số: ";
                int n = Convert.ToInt32(textBox1.Text);
                a = new int[n];
                for (int i = 0; i < n; i++)
                {
                    a[i] = random.Next(1, 100);
                    DaySo = DaySo + " " + a[i].ToString();
                }
                lb2.Text = DaySo;
            }
        }

        private void btn5_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Bạn có muốn đóng không?","Thông báo", MessageBoxButtons.YesNoCancel, MessageBoxIcon.Question) == DialogResult.Yes) this.Close();
        }

        private void btn3_Click(object sender, EventArgs e)
        {
            string sapxep= "Dãy sắp xếp giảm dần: ";
            Array.Sort(a);
            Array.Reverse(a);
            for (int i = 0; i < Convert.ToInt32(textBox1.Text); i++)
            {
                sapxep = sapxep + " " + a[i];
            }
            lb4.Text = sapxep;
        }

        private void btn2_Click(object sender, EventArgs e)
        {
            int tong = 0;
            for (int i = 0; i < Convert.ToInt32(textBox1.Text); i++)
            {
                tong +=  a[i];
            }
            lb3.Text = "Tổng bằng:  " + tong.ToString();
        }

        private void textBox1_KeyPress(object sender, KeyPressEventArgs e)
        {
            if((Convert.ToInt16(e.KeyChar) < '0' || Convert.ToInt16(e.KeyChar) > '9') 
                && Convert.ToInt16(e.KeyChar) != 8)
            {
                MessageBox.Show("Bạn phải nhập số!");
                e.Handled = true;
            }
        }

        private void btn4_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
            lb2.Text = "";
            lb3.Text = "";
            lb4.Text = "";
        }
    }
}
