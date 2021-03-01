using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaiTap6
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnok_Click(object sender, EventArgs e)
        {
            string n = "";
            foreach(string item in listBox1.SelectedItems)
            {
                n = n + item +", "; 
            }
            n = n.Remove(n.Length - 2, 2);
            MessageBox.Show("Bạn đã chọn các phần tử " + n);
        }
    }
}
