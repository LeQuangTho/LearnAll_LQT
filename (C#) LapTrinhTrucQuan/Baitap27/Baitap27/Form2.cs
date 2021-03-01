using CoSoDuLieu.Classes;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Baitap27
{
    public partial class Form2 : Form
    {
        DataBase dataBase = new DataBase();

        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            
            dgvNhanVien.DataSource = dataBase.DataReader("select * from tblNhanVien");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string sql = "insert into tblNhanVien (MaNhanVien,TenNhanVien,GioiTinh,DiaChi,NgaySinh)" +
                "values ('" +tbMaNhanVien.Text + "'," + "'," + "',";
            dataBase.DataChange(sql);
            dgvNhanVien.DataSource = dataBase.DataReader("select * from tblNhanVien");
        }
    }
}
