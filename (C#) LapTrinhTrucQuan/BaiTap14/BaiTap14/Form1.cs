using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaiTap14
{
    public partial class Form1 : Form
    {
        bool hp;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            hp = true;
            timer1.Start();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            if(hp)
            {
                if (label1.Left + label1.Width < this.Width)
                {
                    label1.Left += 10;
                }
                else hp = false;
            }    
            else
            {
                if (label1.Left > 0)
                    label1.Left -= 10;
                else
                {
                    hp = true;
                }    
            }                
        }
    }
}
