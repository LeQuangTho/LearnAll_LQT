using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace Restaurant.Classes
{
    static class LoadSystemAdminFile
    {
        public static string UserName = "";
        public static string PassWord = "";
        private static string path = Application.StartupPath + "//SystemAdmin.txt";
        private static FileStream fileStream = new FileStream(path, FileMode.Open, FileAccess.ReadWrite, FileShare.None);
        public static void readFile()
        {
            using(fileStream=File.OpenRead(path))
            {
                string line;
                string[] str;
                //while(fileStream.)
            }    
        }
    }
}
