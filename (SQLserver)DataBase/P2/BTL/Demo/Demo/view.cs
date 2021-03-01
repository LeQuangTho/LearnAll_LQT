using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Demo
{
    public partial class view : UserControl
    {
        DataBase dt = new DataBase();
        public view()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = dt.dataReaderTable("select * from Doanhthu11");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = dt.dataReaderTable("select * from Giatrixy order by DonGiaTraSua desc");

        }

        private void button3_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = dt.dataReaderTable("select * from SLBAN");

        }
    }
}
