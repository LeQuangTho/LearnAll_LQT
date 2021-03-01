using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Restaurant
{
    public partial class FormLoading : Form
    {
        public FormLoading()
        {
            InitializeComponent();
        }

        private void timerLoad_Tick(object sender, EventArgs e)
        {
            progressBar.Percentage++;
            labelLoading.Text = "Loading . . . " + progressBar.Percentage + "%";
            if (progressBar.Percentage>=100)
            {
                progressBar.Percentage = 0;
                this.Dispose();
            }
        }

        private void FormLoading_Load(object sender, EventArgs e)
        {
            progressBar.Percentage = 0;
            timerLoad.Start();
        }

    }
}
