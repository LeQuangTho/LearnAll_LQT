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
using Restaurant.Forms;
using FontAwesome.Sharp;
using Restaurant.Forms;

namespace Restaurant
{
    public partial class FormMain : Form
    {
        private Color colorFont = Color.FromArgb(102, 120, 201);
        private Color colorBack = Color.FromArgb(253, 253, 251);
        private Color colorBackMain = Color.FromArgb(237, 241, 246);
        private int currentSlider = 0;
        private FormPanelCalendar formPanelCalendar = new FormPanelCalendar();
        private FormPanelBill formPanelBill = new FormPanelBill();
        private FormPanelChart formPanelChart = new FormPanelChart();
        private FormPanelOrderFoods formPanelOrderFoods = new FormPanelOrderFoods();
        private FormPanelEmployee formPanelEmployee = new FormPanelEmployee();
        private FormPanelMaterial formPanelMaterial = new FormPanelMaterial();
        private bool isSuccessLogin = false;
        private bool isLoading = false;
        private List<string> listButton;
        public FormMain()
        {
            InitializeComponent();
            formPanelOrderFoods.FormPanelOrderFoods_Load(null, null);
        }

        private void iconLogo_MouseHover(object sender, EventArgs e)
        {
            iconLogo.Image = Restaurant.Properties.Resources.Logo_Restaurant;
        }

        private void iconLogo_MouseLeave(object sender, EventArgs e)
        {
            iconLogo.Image = Restaurant.Properties.Resources.Logo_Restaurant1;
        }

        private void FormMain_Load(object sender, EventArgs e)
        {
            iconLogo.Image = Restaurant.Properties.Resources.Logo_Restaurant1;
            timerSlider.Start();
        }

        private void setUserControlSlider(UserControlSliderImage userControlSliderImage, string fileImage, string titleMain, string subTitle)
        {
            userControlSliderImage.PictureBoxSlider.Image = Image.FromFile(fileImage);
            userControlSliderImage.LabelTitleSlider.Text = titleMain;
            userControlSliderImage.LabelSubTitleSlider.Text = subTitle;
        }

        private void timerSlider_Tick(object sender, EventArgs e)
        {
        }

        private void buttonNext_Click(object sender, EventArgs e)
        {
            timerSlider.Stop();
            timerSlider.Start();
        }

        private void buttonPrevious_Click(object sender, EventArgs e)
        {
            timerSlider.Stop();
            timerSlider.Start();
        }

        private void changeColorButton(IconButton iconButton, Color colorBG, Color colorFore)
        {
            iconButton.IconColor = colorFore;
            iconButton.BackColor = colorBG;
            iconButton.ForeColor = colorFore;
        }

        private void openChildForm(Form childForm,IconChar iconChar,string title)
        {
            labelTitle.Text = title;
            iconTitle.IconChar = iconChar;
            childForm.TopLevel = false;
            childForm.FormBorderStyle = FormBorderStyle.None;
            childForm.Dock = DockStyle.Fill;
            panelMain.Controls.Add(childForm);
            panelMain.Tag = childForm;
            childForm.Size = panelMain.Size;
            childForm.BringToFront();
            childForm.Show();
        }

        private void buttonBookTable_MouseHover(object sender, EventArgs e)
        {
            changeColorButton(buttonBookTable, panelMenu.ForeColor, panelMenu.BackColor);
        }

        private void buttonBookTable_MouseLeave(object sender, EventArgs e)
        {
            changeColorButton(buttonBookTable, panelMenu.BackColor, panelMenu.ForeColor);
        }

        private void buttonOrderFoods_MouseHover(object sender, EventArgs e)
        {
            changeColorButton(buttonOrderFoods, panelMenu.ForeColor, panelMenu.BackColor);
        }

        private void buttonOrderFoods_MouseLeave(object sender, EventArgs e)
        {
            changeColorButton(buttonOrderFoods, panelMenu.BackColor, panelMenu.ForeColor);
        }

        private void buttonBill_MouseHover(object sender, EventArgs e)
        {
            changeColorButton(buttonBill, panelMenu.ForeColor, panelMenu.BackColor);
        }

        private void buttonBill_MouseLeave(object sender, EventArgs e)
        {
            changeColorButton(buttonBill, panelMenu.BackColor, panelMenu.ForeColor);
        }

        private void buttonEmployee_MouseHover(object sender, EventArgs e)
        {
            changeColorButton(buttonEmployees, panelMenu.ForeColor, panelMenu.BackColor);
        }

        private void buttonEmployee_MouseLeave(object sender, EventArgs e)
        {
            changeColorButton(buttonEmployees, panelMenu.BackColor, panelMenu.ForeColor);
        }

        private void buttonGuest_MouseHover(object sender, EventArgs e)
        {
            changeColorButton(buttonCustomers, panelMenu.ForeColor, panelMenu.BackColor);
        }

        private void buttonGuest_MouseLeave(object sender, EventArgs e)
        {
            changeColorButton(buttonCustomers, panelMenu.BackColor, panelMenu.ForeColor);
        }

        private void buttonChart_MouseHover(object sender, EventArgs e)
        {
            changeColorButton(buttonChart, panelMenu.ForeColor, panelMenu.BackColor);
        }

        private void buttonChart_MouseLeave(object sender, EventArgs e)
        {
            changeColorButton(buttonChart, panelMenu.BackColor, panelMenu.ForeColor);
        }

        private void buttonCalendar_Click(object sender, EventArgs e)
        {
            openChildForm(formPanelCalendar,buttonCalendar.IconChar,"Lịch");
        }

        private void iconLogo_Click(object sender, EventArgs e)
        {
            formPanelCalendar.Hide();
            formPanelBill.Hide();
            formPanelChart.Hide();
            formPanelOrderFoods.Hide();
        }

        private void buttonBill_Click(object sender, EventArgs e)
        {
            openChildForm(formPanelBill,buttonBill.IconChar,buttonBill.Text);
        }

        private void buttonChart_Click(object sender, EventArgs e)
        {
            openChildForm(formPanelChart, buttonChart.IconChar, buttonChart.Text);
        }

        private void buttonSetting_Click(object sender, EventArgs e)
        {
           // ChangeTheme(Color.Red, Color.White, this.Controls);

        }

        public void ChangeTheme(Color backgroundScheme,Color foreScheme, Control.ControlCollection container)
        {
            foreach (Control component in container)
            {
                if (component is Panel)
                {
                    ChangeTheme(backgroundScheme, foreScheme, component.Controls);
                    changeBackForeColor(component, backgroundScheme, foreScheme);
                }
                else if (component is Button)
                {
                    changeBackForeColor(component, backgroundScheme, foreScheme);
                }
                else if (component is TextBox)
                {
                    changeBackForeColor(component, backgroundScheme, foreScheme);
                }
                else if (component is IconButton)
                {
                    changeBackForeColor(component, backgroundScheme, foreScheme);
                    ((IconButton)component).IconColor = foreScheme;
                }    
            }  
        }

        private void changeBackForeColor(Control component, Color backgroundScheme, Color foreScheme)
        {
            component.BackColor = backgroundScheme;
            component.ForeColor = foreScheme;
        }

        private void buttonOrderFoods_Click(object sender, EventArgs e)
        {
            openChildForm(formPanelOrderFoods,buttonOrderFoods.IconChar,buttonOrderFoods.Text);
        }

        private void buttonLoginAdmin_Click(object sender, EventArgs e)
        {
            if (isSuccessLogin == false)
            {
                new FormLogin().ShowDialog();
                buttonLoginAdmin.Text = "Đăng xuất";
                isSuccessLogin = true;
                buttonEmployees.Visible = true;
                buttonChart.Visible = true;
                buttonMaterial.Visible = true;
                formPanelOrderFoods.panelOrderFoods.TabPages.Add(formPanelOrderFoods.tabPage);
                formPanelBill.tabBill.TabPages.Add(formPanelBill.tabPage);
            }
            else
            {
                if (MessageBox.Show("Bạn có muốn đăng xuất", "Đăng xuất", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
                {
                    buttonLoginAdmin.Text = "Quản trị viên";
                    isSuccessLogin = false;
                    buttonEmployees.Visible = false;
                    buttonChart.Visible = false;
                    buttonMaterial.Visible = false;
                    formPanelOrderFoods.panelOrderFoods.TabPages.Remove(formPanelOrderFoods.tabPage);
                    formPanelBill.tabBill.TabPages.Remove(formPanelBill.tabPage);
                }
            }  
        }

        private void buttonBookTable_Click(object sender, EventArgs e)
        {
            
        }

        private void FormMain_FormClosing(object sender, FormClosingEventArgs e)
        {
            if(MessageBox.Show("Bạn có chắc muốn thoát?","Thoát",MessageBoxButtons.YesNo,MessageBoxIcon.Question)==DialogResult.No)
            {
                e.Cancel=true;
            }  
        }

        private void buttonEmployees_Click(object sender, EventArgs e)
        {
            openChildForm(formPanelEmployee, buttonEmployees.IconChar,buttonEmployees.Text);
        }
    }
}
