using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Day06
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void timerDown_Tick(object sender, EventArgs e)
        {
            int m = 0, s = 0;
            if (checkInput() == true)
            {
                m = Convert.ToInt16(tbPhut.Text);
                s = Convert.ToInt16(tbGiay.Text);
                if (s == 0 && m == 0)
                {
                    timerDown.Stop();
                    MessageBox.Show("Đù má hết giờ rồi!");
                }
                else {

                    if (s > 0 && s <= 59)
                    {
                        s = s - 1;
                    }
                    else
                    {
                        if (s == 0)
                        {
                            m -= 1;
                            s = 59;
                        }
                    }
                }
            }
            tbPhut.Text = "" + m;
            tbGiay.Text = " "+ s;
        }

        bool checkInput()
        {
            if (tbPhut.Text == "")
            {
                MessageBox.Show("Nhập phút đi mày!");
                return false; 
            }
            if (tbPhut.Text == "")
            {
                MessageBox.Show("Nhập giây đi mày!");
                return false;
            }
            return true;
        }
        private void btnRun_Click(object sender, EventArgs e)
        {
            timerDown.Start();
        }

        private void btnStop_Click(object sender, EventArgs e)
        {
            timerDown.Stop();
        }

        private void btnEnd_Click(object sender, EventArgs e)
        {
            timerDown.Stop();
            tbPhut.Text = "0";
            tbGiay.Text = "0";
        }
    }
}
