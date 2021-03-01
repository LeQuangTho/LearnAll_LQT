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
    public partial class function : UserControl
    {
        DataBase dt = new DataBase();
        public function()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = dt.dataReaderTable("select * from dbo.g('" + comboBox1.SelectedValue.ToString() + "')");
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            
        }

        private void function_Load(object sender, EventArgs e)
        {
            comboBox1.DataSource = dt.dataReaderTable("select * from KhachHang");
            comboBox1.DisplayMember = "TenKhachHang";
            comboBox1.ValueMember = "ID_KhachHang";
        }

        private void button2_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = dt.dataReaderTable("select doanhthu as N'Tổng doanh thu tháng "+comboBox2.SelectedItem.ToString() + " năm "+comboBox3.SelectedItem.ToString()+"' from dbo.doanhthu(" + comboBox2.SelectedItem.ToString() + ","+comboBox3.SelectedItem.ToString()+")");
        }
    }
}
