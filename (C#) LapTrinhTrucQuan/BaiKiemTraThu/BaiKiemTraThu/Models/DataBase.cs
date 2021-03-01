using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;

namespace BaiKiemTraThu.Models
{
    class DataBase
    {
        string strConnect = "Data Source=DESKTOP-OH9IU5S\\SQLEXPRESS;Initial Catalog=DuLieu;Integrated Security=True";
        SqlConnection sqlConnection = null;

        void openConnect()
        {
            sqlConnection = new SqlConnection(strConnect);
            if (sqlConnection.State != ConnectionState.Open)
            {
                sqlConnection.Open();
            }
        }

        void closeConnect()
        {
            if (sqlConnection.State != ConnectionState.Closed)
            {
                sqlConnection.Close();
                sqlConnection.Dispose();
            }
        }

        public void dataChange(string sql)
        {
            openConnect();
            SqlCommand sqlCommand = new SqlCommand();
            sqlCommand.Connection = sqlConnection;
            sqlCommand.CommandText = sql;
            sqlCommand.ExecuteNonQuery();
            closeConnect();
        }

        public DataTable dataReaderTable(string sql)
        {
            DataTable dt = new DataTable();
            openConnect();
            SqlDataAdapter sqlDataAdapter = new SqlDataAdapter(sql, sqlConnection);
            sqlDataAdapter.Fill(dt);
            closeConnect();
            return dt;
        }
    }
}