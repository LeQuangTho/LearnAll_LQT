using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Zeroit.Framework.LollipopControls.Controls;
using Restaurant.Classes;
using FontAwesome.Sharp;

namespace Restaurant.Forms
{
    public partial class FormPanelEmployee : Form
    {
        ConnectDataBase connectDataBase = new ConnectDataBase();
        DataTable dataTable = null;
        public FormPanelEmployee()
        {
            InitializeComponent();
        }

        private void FormPanelEmployee_Load(object sender, EventArgs e)
        {
            dataTable = connectDataBase.readData("select MaNV,HoTenNV,AnhNV,TinhTrang from NhanVien");
            for(int i=0;i<dataTable.Rows.Count;++i)
            {
                panelDisplayEmployee.Controls.Add(cardEmployee(dataTable.Rows[i].ItemArray[0].ToString(), dataTable.Rows[i].ItemArray[1].ToString(), dataTable.Rows[i].ItemArray[2].ToString(), dataTable.Rows[i].ItemArray[3].ToString()));
            }
            if (dataTable.Rows.Count * 50 > panelDisplayEmployee.Height)
            {
                panelDisplayEmployee.AutoScroll = false;
                panelDisplayEmployee.VerticalScroll.Enabled = false;
                panelDisplayEmployee.VerticalScroll.Visible = false;
                panelDisplayEmployee.VerticalScroll.Maximum = 0;
                panelDisplayEmployee.AutoScroll = true;
            }
            
        }

        private ZeroitLollipopSmallCard cardEmployee(string maNV,string tenNV,string link,string tt)
        {
            ZeroitLollipopSmallCard card = new ZeroitLollipopSmallCard();
            card.AllowTransparency = true;
            card.ForeColor = System.Drawing.Color.Black;
            card.Image = Image.FromFile(Application.StartupPath+ "\\Images\\Employee\\"+link+".jpg");
            card.Info = tt;  
            card.Name = maNV;
            card.Size = new System.Drawing.Size(215, 50);
            card.Text = tenNV;
            card.ThumbnailColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            card.TitleColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            card.Cursor = System.Windows.Forms.Cursors.Hand;
            card.Click += new System.EventHandler(this.card_Click);
            return card; 
        }
        private void card_Click(object sender, EventArgs e)
        {
            foreach(Control control in panelDisplayEmployee.Controls)
            {
                if(control is ZeroitLollipopSmallCard)
                {
                    if(((Control)sender).Name==control.Name)
                    {
                        
                        break;
                    }    
                }    
            }    
        }

        private void textBox5_TextChanged(object sender, EventArgs e)
        {

        }

        private void radiusIconButton1_Click(object sender, EventArgs e)
        {

        }

        private void buttonAvatar_Click(object sender, EventArgs e)
        {

        }

        private void textBox9_TextChanged(object sender, EventArgs e)
        {

        }

        private void buttonAdd_Click(object sender, EventArgs e)
        {

        }

        private void textNumber_KeyPress(object sender, KeyPressEventArgs e)
        {
            if ((Convert.ToInt16(e.KeyChar) < Convert.ToInt16('0') || Convert.ToInt16(e.KeyChar) > Convert.ToInt16('9')) && Convert.ToInt16(e.KeyChar) != 8)
            {
                FormAlert formAlert = new FormAlert();
                formAlert.showAlert("Bạn chỉ được nhập số!", IconChar.ExclamationCircle, Color.Red);
                e.Handled = true;
            }
        }
    }
}
