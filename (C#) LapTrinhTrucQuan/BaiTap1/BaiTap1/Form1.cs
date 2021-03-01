using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaiTap1
{
    public partial class BaiTap1 : Form
    {
        public BaiTap1()
        {
            InitializeComponent();
        }

        private void btnKQ_Click(object sender, EventArgs e)
        {
            if(checkInput() == true)
            {
                int thang, nam;
                string kq = "";
                thang = Convert.ToInt32(textBox1.Text);
                nam = Convert.ToInt32(textBox2.Text);
                if (thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12)
                {
                    kq = kq + "Tháng " + thang + " năm " + nam + " có 31 ngày!";
                    lb3.Text = kq;
                }
                else if(thang == 2)
                {
                    if (nam % 4 == 0)
                    {
                        kq = kq + "Tháng " + thang + "năm " + nam + " có 29 ngày!";
                        lb3.Text = kq;
                    }
                    else
                    {
                        kq = kq + "Tháng " + thang + " năm " + nam + "có 28 ngày!";
                        lb3.Text = kq;
                    }    
                }
                else
                {
                    kq = kq + "Tháng " + thang + " năm " + nam + " có 30 ngày!";
                    lb3.Text = kq;
                }
            }

            bool checkInput()
        {
            if(textBox1.Text == "")
            {
                MessageBox.Show("Bạn chưa nhập tháng!");
                textBox1.Focus();
                return false;
            }
                if (Convert.ToInt32(textBox1.Text)  <= 0)
                {
                    MessageBox.Show("Không được nhập tháng âm!");
                    textBox1.Text = "";
                    textBox1.Focus();
                    return false;
                }
                if (textBox2.Text == "")
            {
                MessageBox.Show("Bạn chưa nhập năm!");
                textBox2.Focus();
                return false;
            }
                if (Convert.ToInt32(textBox2.Text) <= 0)
                {
                    MessageBox.Show("Không được nhập năm âm!");
                    textBox2.Text = "";
                    textBox2.Focus();
                    return false;
                }

                return true;
        }
        }

        private void btnLL_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
            textBox2.Text = "";
            lb3.Text = "";
        }

        private void btnT_Click(object sender, EventArgs e)
        {
            if(MessageBox.Show("Bạn có muốn đóng không?","Thông báo",MessageBoxButtons.YesNo,MessageBoxIcon.Question) == DialogResult.Yes)
            {
                this.Close();
            }
        }
    }
}