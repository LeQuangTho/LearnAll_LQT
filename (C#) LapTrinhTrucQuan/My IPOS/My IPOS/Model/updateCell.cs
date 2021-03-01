using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace My_IPOS.Model
{
    public partial class edit : Form
    {
        OrderTakeAway tw;
        int row;
        int column;
        public edit(OrderTakeAway away,int row, int column)
        {
            InitializeComponent();
            tw = away;
            this.row = row;
            this.column = column;
        }

        private void btnOK_Click(object sender, EventArgs e)
        {
            tw.updateCell(row, column, Convert.ToInt32(tbSua.Text));
            this.Close();
        }

        private void tbSua_KeyDown(object sender, KeyEventArgs e)
        {
            if(e.KeyCode == Keys.Enter)
            {
                btnOK_Click(sender, e);
            }
        }
    }
}
