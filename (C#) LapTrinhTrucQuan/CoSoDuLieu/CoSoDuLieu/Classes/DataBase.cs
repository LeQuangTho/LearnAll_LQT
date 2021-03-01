using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;

namespace CoSoDuLieu.Classes
{
    class DataBase
    {
        string strConnect = "Data Source=DESKTOP-OH9IU5S\\SQLEXPRESS;" +
            "DataBase=DataBaseTestCSharp;" +
            "Integrated Security = true";
        SqlConnection sqlConnection = null;

        void OpenConnect()
        {
            sqlConnection = new SqlConnection(strConnect);
            if (sqlConnection.State != ConnectionState.Open)
                sqlConnection.Open();
        }

        void CloseConnect()
        {
            if (sqlConnection.State != ConnectionState.Closed)
            {
                sqlConnection.Close();
                sqlConnection.Dispose();
            }
        }

        public DataTable DataReader(string sqlSelect)
        {
            DataTable tblData = new DataTable();
            OpenConnect();
            SqlDataAdapter sqlData = new SqlDataAdapter(sqlSelect, sqlConnection);
            sqlData.Fill(tblData);
            CloseConnect();
            return tblData;
        }

        public void DataChange(string sql)
        {
            OpenConnect();
            SqlCommand sqlCommand = new SqlCommand();
            sqlCommand.Connection = sqlConnection;
            sqlCommand.CommandText = sql;
            sqlCommand.ExecuteNonQuery();
            CloseConnect();
        }
    }
}
