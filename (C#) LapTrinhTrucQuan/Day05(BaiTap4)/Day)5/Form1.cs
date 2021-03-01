using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Day_5
{
    public partial class Form1 : Form
    {

        int red, green, blue;
        public Form1()
        {
            InitializeComponent();
        }

        private void cMax_Click(object sender, EventArgs e)
        {
            double Max, a, b;
            if (checkInput() == true)
            {
                if (cMax.Checked == true)
                {
                    a = Convert.ToDouble(tb1.Text);
                    b = Convert.ToDouble(tb2.Text);
                    Max = a > b ? a : b;
                    cMax.Text = "Max = " + Max;
                }
                else
                {
                    cMax.Text = "Max = ";
                }
            }
        }
        bool checkInput()
        {
            if(tb1.Text == "")
            {
                MessageBox.Show("Bạn phải nhập a!");
                tb1.Focus();
                return false;
            }
            if(tb2.Text == "")
            {
                MessageBox.Show("Bạn phải nhập b!");
                tb2.Focus();
                return false;
            }
            return true;
        }

        private void cMin_CheckedChanged(object sender, EventArgs e)
        {
            double Min, a, b;
            if (checkInput() == true)
            {
                if (cMin.Checked == true)
                {
                    a = Convert.ToDouble(tb1.Text);
                    b = Convert.ToDouble(tb2.Text);
                    Min = a < b ? a : b;
                    cMin.Text = "Min = " + Min;
                }
                else
                {
                    cMin.Text = "Min = ";
                }
            }
        }

        private void radioCong_CheckedChanged(object sender, EventArgs e)
        {
           
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            if(tbAdd.Text == "")
            {
                MessageBox.Show("Bạn Chưa Nhập Nội Dung Nào!");
                tbAdd.Focus();
            }
            else
            {
                listBox1.Items.Add(tbAdd.Text);
                tbAdd.Text = "";
            }
        }

        private void listBox1_DoubleClick(object sender, EventArgs e)
        {
            int index;
            index = listBox1.SelectedIndex;
            if (MessageBox.Show("Mày có muốn xóa không?", "Cảnh báo", MessageBoxButtons.YesNo, MessageBoxIcon.Warning) == DialogResult.Yes)
                listBox1.Items.RemoveAt(index);
        }

        private void radioCong_Click(object sender, EventArgs e)
        {
            if (checkInput() == true)
            {
                double a, b;
                a = Convert.ToDouble(tb1.Text);
                b = Convert.ToDouble(tb2.Text);
                if (radioCong.Checked == true)
                {
                    tb3.Text = " " + (a + b);
                }
            }
        }

        private void radioTru_Click(object sender, EventArgs e)
        {

            if (checkInput() == true)
            {
                double a, b;
                a = Convert.ToDouble(tb1.Text);
                b = Convert.ToDouble(tb2.Text);
                if (radioTru.Checked == true)
                {
                    tb3.Text = " " + (a - b);
                }
            }
        }

        private void radioNhan_Click(object sender, EventArgs e)
        {

            if (checkInput() == true)
            {
                double a, b;
                a = Convert.ToDouble(tb1.Text);
                b = Convert.ToDouble(tb2.Text);
                if (radioNhan.Checked == true)
                {
                    tb3.Text = " " + (a * b);
                }
            }
        }

        private void radioChia_Click(object sender, EventArgs e)
        {

            if (checkInput() == true)
            {
                double a, b;
                a = Convert.ToDouble(tb1.Text);
                b = Convert.ToDouble(tb2.Text);
                if (radioChia.Checked == true)
                {
                    tb3.Text = " " + (a / b);
                }
            }
        }

        private void HSBGreen_Scroll(object sender, ScrollEventArgs e)
        {
            green = Convert.ToInt16(HSBGreen.Value.ToString());
            vGreen.Text = HSBGreen.Value.ToString();
            this.BackColor = Color.FromArgb(red, green, blue);
        }

        private void HSBBlue_Scroll(object sender, ScrollEventArgs e)
        {
            blue = Convert.ToInt16(HSBBlue.Value.ToString());
            vBlue.Text = HSBBlue.Value.ToString();
            this.BackColor = Color.FromArgb(red, green, blue);
        }

        private void numberFont_ValueChanged(object sender, EventArgs e)
        {
            int giatri = Convert.ToInt16(numberFont.Value);
            listBox1.Font = new Font(listBox1.Font.Name, giatri, FontStyle.Bold);
        }

        

        private void hScrollBar1_Scroll(object sender, ScrollEventArgs e)
        {
            red = Convert.ToInt16(HSBRed.Value.ToString());
            vRed.Text = HSBRed.Value.ToString();
            this.BackColor = Color.FromArgb(red, green, blue);
        }
    }
}
