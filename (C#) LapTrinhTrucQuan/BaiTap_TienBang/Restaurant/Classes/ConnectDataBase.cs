using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;

namespace Restaurant.Classes
{
    class ConnectDataBase
    {
        string strConnect = @"Data Source=DESKTOP-OH9IU5S\SQLEXPRESS;Initial Catalog=Restaurant;Integrated Security=True";
        SqlConnection sqlConnection = null;
        private void openConnectSQL()
        {
            sqlConnection = new SqlConnection(strConnect);
            if(sqlConnection.State!=ConnectionState.Open)
            {
                sqlConnection.Open();
            }    
        }

        private void closeConnectSQL()
        {
            if(sqlConnection.State != ConnectionState.Closed)            
            {
                sqlConnection.Close();
            }
            sqlConnection.Dispose();
        }

        public DataTable readData(string sql)
        {
            DataTable dataTable = new DataTable();
            openConnectSQL();
            SqlDataAdapter sqlDataAdapter = new SqlDataAdapter(sql, sqlConnection);
            sqlDataAdapter.Fill(dataTable);
            closeConnectSQL();
            return dataTable;
        }

        public void dataChange(string sql)
        {
            openConnectSQL();
            SqlCommand sqlCommand = new SqlCommand();
            sqlCommand.Connection = sqlConnection;
            sqlCommand.CommandText = sql;
            sqlCommand.ExecuteNonQuery();
            closeConnectSQL();
        }
    }
}
