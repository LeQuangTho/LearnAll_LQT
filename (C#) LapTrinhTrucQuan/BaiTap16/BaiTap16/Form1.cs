using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaiTap16
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string strPath;
            openFileDialog1.Filter = "JPG Images |*.jpg|Bitmap Images|*.bmp|All File |*.*";
            openFileDialog1.ShowDialog();
            strPath = openFileDialog1.FileName;
            pictureBox1.Image = Image.FromFile(strPath);
        }
    }
}
