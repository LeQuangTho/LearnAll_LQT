using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Restaurant.UserControls;

namespace Restaurant.Forms
{
    public partial class FormPanelHDB : Form
    {
        public FormCode formCode = new FormCode();
        public FormPanelHDB()
        {
            InitializeComponent();
        }

        private void FormPanelHDB_Load(object sender, EventArgs e)
        {

        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void buttonCode_Click(object sender, EventArgs e)
        {
            formCode.ShowDialog();
        }
    }
}
