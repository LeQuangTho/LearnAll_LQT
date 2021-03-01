using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Text.RegularExpressions;

namespace Restaurant.UserControls
{
    public partial class UserControlOrderedFood : UserControl
    {
        public string regString = @"[0-9]";
        public int number = 1;
        public UserControlOrderedFood()
        {
            InitializeComponent();
        }

        private void textNumber_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!Regex.IsMatch(e.KeyChar.ToString(), regString) && Convert.ToInt16(e.KeyChar)!=8)
            {
                e.Handled = true;
            }
            if(textNumber.Text.Length==0 && Convert.ToInt16(e.KeyChar)==Convert.ToInt16('0'))
            {
                e.Handled = true;
            }
        }

        public void UserControlOrderedFood_Load(object sender, EventArgs e)
        {
            textNumber.Style = Zeroit.Framework.Metro.Design.Style.Custom;
            if (textNumber.Text != "")
            {
                textNumber.Text = "" + number;
                labelSum.Text = (Convert.ToInt32(labelPrice.Text) * Convert.ToInt32(textNumber.Text)) + "";
            }
        }
    }
}
