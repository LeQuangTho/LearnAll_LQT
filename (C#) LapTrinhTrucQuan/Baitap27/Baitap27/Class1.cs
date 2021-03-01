using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;
using CoSoDuLieu.Classes;

namespace Baitap27
{
    class Class1
    {
        DataBase dt = new DataBase();
        public string AutoCode(string tableName,string fildeName, string startString)
        {
            DataTable data = new DataTable();
            string code="";
            int id = 0;
            bool check = false;
            do
            {
                data = dt.DataReader("select * form " + tableName + "where " + fildeName + "= '" + startString + "'");

                if (data.Rows.Count > 0)
                {
                    check = true;
                    id = id + 1;
                }
                else
                {
                    check = true;
                    code = startString + id.ToString();
                }

            }
            while (check == false);
            return code;
        }
    }
}
