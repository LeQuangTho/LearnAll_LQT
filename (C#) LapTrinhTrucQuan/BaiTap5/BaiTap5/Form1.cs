using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaiTap5
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            if(checkInput()== true)
            {
                listNN.Items.Add(textBox1.Text);
                textBox1.Text = "";
            }
        }

        bool checkInput()      
        {
            if(textBox1.Text == "")
            {
                MessageBox.Show("Bạn chưa nhập tên môn!");
                textBox1.Focus();
                return false;
            }
            return true;
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            int VT = listNN.SelectedIndex;
                if(VT < 0) MessageBox.Show("Bạn chưa chọn tên ngoại ngữ nào!");
                else if (MessageBox.Show("Bạn có muốn xóa không?", "Hỏi", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
                listNN.Items.RemoveAt(VT);
        }

        private void btnTiemKiem_Click(object sender, EventArgs e)
        {
            if(checkInput()== true)
            {
                for(int i = 0; i < listNN.Items.Count; i++)
                {
                    if(listNN.Items[i].Equals(textBox1.Text))
                    {
                        MessageBox.Show("Có môn ngoại ngữ này rồi nhé bạn nhỏ!");
                        break;
                    }
                    else
                    {
                        MessageBox.Show("Chưa có môn ngoại ngữ này rồi nhé bạn nhỏ!");
                        break;
                    }
                }
            }
        }

        private void btnThoat_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Bạn có muốn thoát không?", "Hỏi", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                this.Close();
            }
        }
    }
}
