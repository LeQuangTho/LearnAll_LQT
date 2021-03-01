using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;

namespace Restaurant.Classes
{
    static class AutoId
    {
        static ConnectDataBase connectDataBase = new ConnectDataBase();
        public static string getID(string headerID,string sql)
        {
            int id=0;
            string idString = "";
            bool isHave = false;
            DataTable dataTable = connectDataBase.readData(sql);
            if (dataTable.Rows.Count >= 1)
            {
                do
                {
                    idString = headerID;
                    idString += "00" + id.ToString();
                    if (idString.Equals(dataTable.Rows[id].ItemArray[0].ToString()))
                    {
                        isHave = false;
                    }
                    else isHave = true;
                    id++;
                    idString = headerID;
                    idString += "00" + id.ToString();
                }
                while (isHave);
            }
            else
            {
                idString = headerID + "001";
            }                
            return idString;
        }
    }
}
