using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaiTap09
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void f1_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.Font = new Font(new FontFamily("Times New Roman"),textBox1.Font.Size,textBox1.Font.Style);
        }

        private void f4_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.Font = new Font(new FontFamily("Tahoma"), textBox1.Font.Size, textBox1.Font.Style);
        }

        private void h1_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.Font = new Font(textBox1.Font.FontFamily, textBox1.Font.Size, textBox1.Font.Style ^ FontStyle.Bold);
        }

        private void h2_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.Font = new Font(textBox1.Font.FontFamily, textBox1.Font.Size, textBox1.Font.Style ^ FontStyle.Italic);
        }

        private void h3_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.Font = new Font(textBox1.Font.FontFamily, textBox1.Font.Size, textBox1.Font.Style ^ FontStyle.Strikeout);
        }

        private void h4_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.Font = new Font(textBox1.Font.FontFamily, textBox1.Font.Size, textBox1.Font.Style ^ FontStyle.Underline);
        }

        private void m1_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.ForeColor = Color.Blue;
        }

        private void m2_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.ForeColor = Color.Red;
        }

        private void m3_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.ForeColor = Color.Green;
        }

        private void m4_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.ForeColor = Color.Purple;
        }
    }
}
