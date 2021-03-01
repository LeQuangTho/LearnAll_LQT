using CoSoDuLieu.Classes;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Sql;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CoSoDuLieu
{
    public partial class Form1 : Form
    {
        DataBase dataBase = new DataBase();
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            /*//lấy dữ liệu đổ ra form
            //B1: tạo chuỗi kết nối
            string strConnect = "Data Source=DESKTOP-OH9IU5S\\SQLEXPRESS;DataBase=DataBaseTestCSharp;Integrated Security = true";
            //B2: mở kết nối 
            SqlConnection sqlConnection = new SqlConnection(strConnect);
            if (sqlConnection.State != ConnectionState.Open)
            {
                sqlConnection.Open();
                MessageBox.Show("Thành công!");
            }
            //B3: Tạo lệnh SQL
            string sqlSelect = "select * from tblChatLieu";
            *//*"insert into tblChatLieu (MaChatLieu,TenChatLieu)" +
            "value (1431,N'sắt')";*//*
            //B4: Thực thi lệnh Sql

            SqlDataAdapter dt = new SqlDataAdapter(sqlSelect, sqlConnection);
            DataTable tbChatLieu = new DataTable();
            dt.Fill(tbChatLieu);
            *//*dt.Update(tbChatLieu);*//*

            //B5: Đóng kết nối và hủy đối tượng
            if (sqlConnection.State != ConnectionState.Closed)
            {
                sqlConnection.Close();
                sqlConnection.Dispose();
            }
            //Đổ dữ liệu bào gridview
            dtgChatLieu.DataSource = tbChatLieu;*/

            dataBase.DataReader("select * from tblChatLieu");
            dtgChatLieu.DataSource = dataBase.DataReader("select * from tblChatLieu");
            dtgChatLieu.Columns[0].HeaderText = "Mã Chất Liệu";
            dtgChatLieu.Columns[1].HeaderText = "Tên Chất Liệu";
        }



        private void btnThem_Click(object sender, EventArgs e)
        {
            /*//lấy dữ liệu đổ ra form
            //B1: tạo chuỗi kết nối
            string strConnect = "Data Source=DESKTOP-OH9IU5S\\SQLEXPRESS;DataBase=DataBaseTestCSharp;Integrated Security = true";
            //B2: mở kết nối 
            SqlConnection sqlConnection = new SqlConnection(strConnect);
            if (sqlConnection.State != ConnectionState.Open)
            {
                sqlConnection.Open();
                MessageBox.Show("Thành công!");
            }
           

            string sqlInsert = "insert into tblChatLieu (MaChatLieu, TenChatLieu)" +
            "values ('" + tbAddMaChatLieu.Text + "',N'" + tbAddTenChatLieu + "')";

            SqlCommand sqlCommand = new SqlCommand();
            sqlCommand.Connection = sqlConnection;
            sqlCommand.CommandText = sqlInsert;
            sqlCommand.ExecuteNonQuery();

            //B5: Đóng kết nối và hủy đối tượng
            if (sqlConnection.State != ConnectionState.Closed)
            {
                sqlConnection.Close();
                sqlConnection.Dispose();
            }*/
            DataTable dtCL = dataBase.DataReader("select * from tblChatLieu where MaChatLieu ='" +
                tbAddMaChatLieu.Text+"'");
            if (dtCL.Rows.Count > 0)
            {
                MessageBox.Show("Mã này đã có, bạn hãy nhập mã khác!");
                tbAddMaChatLieu.Focus();
                tbAddMaChatLieu.Text = "";
                return;
            }
            dataBase.DataChange("insert into tblChatLieu(MaChatLieu, TenChatLieu)" +
            "values ('" + tbAddMaChatLieu.Text + "',N'" + tbAddTenChatLieu.Text + "')");

            dtgChatLieu.DataSource = dataBase.DataReader("select * from tblChatLieu");
            tbAddMaChatLieu.Text = "";
            tbAddTenChatLieu.Text = "";
        }

        private void dtgChatLieu_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            tbAddMaChatLieu.Text = dtgChatLieu.CurrentRow.Cells[0].Value.ToString();
            tbAddTenChatLieu.Text = dtgChatLieu.CurrentRow.Cells[1].Value.ToString();
        }

        private void btnSua_Click(object sender, EventArgs e)
        {
            if (tbAddMaChatLieu.Text == "")
            {
                MessageBox.Show("Bạn Chưa Chọn Gì Cả");
            }
            else
            {
                dataBase.DataChange("update tblChatLieu set MaChatLieu ='" + tbAddMaChatLieu.Text + "', TenChatLieu = N'" +
                tbAddTenChatLieu.Text + "'where MaChatLieu = '" + dtgChatLieu.CurrentRow.Cells[0].Value.ToString() + "'");

                dtgChatLieu.DataSource = dataBase.DataReader("select * from tblChatLieu");
            }
            
        }

        private void btnXoa_Click(object sender, EventArgs e)
        {
            if (tbAddMaChatLieu.Text == "")
            {
                MessageBox.Show("Bạn Chưa Chọn Gì Cả");
            }
            else
            {
                dataBase.DataChange("delete from tblChatLieu where MaChatLieu =" + tbAddMaChatLieu.Text);
                dtgChatLieu.DataSource = dataBase.DataReader("select * from tblChatLieu");
                tbAddMaChatLieu.Text = "";
                tbAddTenChatLieu.Text = "";
            }
        }
    }
}
