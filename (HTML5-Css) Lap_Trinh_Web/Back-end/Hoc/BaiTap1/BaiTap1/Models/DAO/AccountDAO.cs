using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using BaiTap1.Models.Entities;

namespace BaiTap1.Models.DAO
{
    public class AccountDAO
    {
        QLHangHoa_Context db;
        public AccountDAO()
        {
            db = new QLHangHoa_Context();
        }

        public bool isValid(tblAccount acc)
        {
            if (db.tblAccounts.Where(a => a.Username == acc.Username && a.Password == acc.Password).Count() > 0)
                return true;
            else
                return false;
        }
    }
}