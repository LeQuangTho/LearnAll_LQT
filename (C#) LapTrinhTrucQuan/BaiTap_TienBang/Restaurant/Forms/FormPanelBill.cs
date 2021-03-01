using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Restaurant.Forms
{
    public partial class FormPanelBill : Form
    {
        public TabPage tabPage = new TabPage();
        public FormPanelBill()
        {
            InitializeComponent();
            tabPage = tabHDNhap;
            tabBill.TabPages.Remove(tabHDNhap);
        }

        private void buttonPrint_Click(object sender, EventArgs e)
        {
            printPreviewDialog.ShowDialog();
        }

        private void FormPanelBill_Load(object sender, EventArgs e)
        {
            openChildForm(new FormPanelHDB());
        }

        private void openChildForm(Form childForm)
        {
            childForm.TopLevel = false;
            childForm.FormBorderStyle = FormBorderStyle.None;
            childForm.Dock = DockStyle.Fill;
            panelBillPreview.Controls.Add(childForm);
            panelBillPreview.Tag = childForm;
            childForm.Size = panelBillPreview.Size;
            childForm.BringToFront();
            childForm.Show();
        }
    }
}
