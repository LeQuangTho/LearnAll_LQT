using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaiTap20
{
    public partial class Form2 : Form
    {
        private Color colorSave;
        public bool save = false;
        public Form1 form1;
        public Form2()
        {
            InitializeComponent();
            this.save = false;
        }

        public Font getFont()
        {
            return textBox1.Font;
        }

        public void setForm(Form1 a)
        {
            form1 = a;
        }

        public Color getColor()
        {
            return textBox1.ForeColor;
        }

      
        public void setColor(Color a)
        {
            this.colorSave = a;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.save = true;
            setColor(textBox1.ForeColor);
            /*form1.doiFont();*/
            this.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Bạn có muốn đóng không?", "Hỏi", MessageBoxButtons.YesNo) == DialogResult.Yes)
                this.Close();
        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.Font = new Font(radioButton1.Font.FontFamily, textBox1.Font.Size, textBox1.Font.Style);
        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.Font = new Font(radioButton2.Font.FontFamily, textBox1.Font.Size, textBox1.Font.Style);
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.Font = new Font(textBox1.Font.FontFamily, textBox1.Font.Size, textBox1.Font.Style ^ FontStyle.Bold);
        }

        private void checkBox2_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.Font = new Font(textBox1.Font.FontFamily, textBox1.Font.Size, textBox1.Font.Style ^ FontStyle.Italic);
        }

        private void checkBox3_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.Font = new Font(textBox1.Font.FontFamily, textBox1.Font.Size, textBox1.Font.Style ^ FontStyle.Strikeout);
        }

        private void checkBox4_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.Font = new Font(textBox1.Font.FontFamily, textBox1.Font.Size, textBox1.Font.Style ^ FontStyle.Underline);
        }

        private void radioButton6_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.ForeColor = Color.Blue;
        }

        private void radioButton5_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.ForeColor = Color.Red;
        }

        private void radioButton4_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.ForeColor = Color.Green;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if(colorDialog1.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                textBox1.ForeColor = Color.FromArgb(colorDialog1.Color.A, colorDialog1.Color.R, colorDialog1.Color.G, colorDialog1.Color.B);
            }                
        }
    }
}
