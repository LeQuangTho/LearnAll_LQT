using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Data.SqlClient;

using System.Threading.Tasks;

namespace CSDLN01.Classes
{
    class Common
    {
        DataBaseProcess dtbase = new DataBaseProcess();
        public string AutoCode(string TableName,string FildeName,string startString)
        {
            DataTable dtData = new DataTable();
            string code="";
            int id = 0;
            bool check= false;
            do
            {
                dtData = dtbase.DataReader("Select * from " + TableName + " where " + FildeName + "= '" + startString + id.ToString()+ "'");
                if (dtData.Rows.Count > 0)
                {
                    id = id + 1;
                    check = false;                   
                }
                else
                {
                    code = startString + id.ToString();
                    check = true;
                }
            }
            while (check == false);
            return code;
        }
    }
}
