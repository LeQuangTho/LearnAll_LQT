using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Restaurant.CustomControls;
using FontAwesome.Sharp;

namespace Restaurant.Forms
{
    public partial class FormPanelCalendar : Form
    {
        private int currentYear = DateTime.Now.Year, currentMonth = DateTime.Now.Month, currentDay = DateTime.Now.Day;
        string textDay = "";
        public FormPanelCalendar()
        {
            InitializeComponent();
        }

        private void FormPanelCalendar_Load(object sender, EventArgs e)
        {
            setCalendar();
        }

        private int getFirstDayOfMonth(int year, int month)
        {
            DateTime dateTime = new DateTime(year, month, 1);
            return dateTime.DayOfWeek.GetHashCode();
        }

        private void buttonUpMonth_Click(object sender, EventArgs e)
        {
            setCurrentDateTime(1);
            setCalendar();
        }

        private void buttonDownMonth_Click(object sender, EventArgs e)
        {
            setCurrentDateTime(-1);
            setCalendar();
        }

        private void buttonNow_Click(object sender, EventArgs e)
        {
            currentYear = DateTime.Now.Year;
            currentMonth = DateTime.Now.Month;
            setCurrentDateTime(0);
            setCalendar();
        }

        private void setCurrentDateTime(int index)
        {
            currentMonth += index;
            if (currentMonth > 12)
            {
                currentMonth = 1;
                currentYear++;
            }
            else if (currentMonth < 1)
            {
                currentMonth = 12;
                currentYear--;
            }
            if (currentMonth <= 9)
            {
                labelMonthYear.Text = "Tháng 0" + currentMonth + "," + currentYear;
            }
            else
            {
                labelMonthYear.Text = "Tháng " + currentMonth + "," + currentYear;
            }
        }

        private void textSDT_KeyPress(object sender, KeyPressEventArgs e)
        {
            if ((Convert.ToInt16(e.KeyChar) < Convert.ToInt16('0') || Convert.ToInt16(e.KeyChar) > Convert.ToInt16('9')) && Convert.ToInt16(e.KeyChar) != 8)
            {
                FormAlert formAlert = new FormAlert();
                formAlert.showAlert("Bạn chỉ được nhập số!", IconChar.ExclamationCircle, Color.Red);
                e.Handled = true;
            }
        }

        private void buttonCanel_Click(object sender, EventArgs e)
        {
            foreach(Control control in panelEvent.Controls)
            {
                if(control is TextBox)
                {
                    control.Text = "";
                }
                if(control is DateTimePicker)
                {
                    ((DateTimePicker)control).Value = DateTime.Now;
                }
            }
        }
        
        private void animatedRadiusIconButton_Click(object sender, EventArgs e)
        {
            textDay = ((AnimatedRadiusIconButton)sender).Text;
            radiusIconButton_Click(textDay);
        }
        private void radiusIconButton_Click(string textDay)
        {
            if (textDay != "")
            {
                foreach (AnimatedRadiusIconButton radiusIconButton in panelDaysInMonth.Controls)
                {
                    if (textDay == radiusIconButton.Text)
                    {
                        radiusIconButton.BackColor = Color.Red;
                    }
                    else if (textDay != radiusIconButton.Text)
                    {
                        if (radiusIconButton.Text == DateTime.Now.Day.ToString() && currentMonth == DateTime.Now.Month && currentYear == DateTime.Now.Year)
                        {
                            radiusIconButton.BackColor = Color.BlueViolet;
                        }
                        else radiusIconButton.BackColor = Color.Transparent;
                    }
                }
                currentDay = Convert.ToInt32(textDay);
            }
            dateTimePicker.Value = new DateTime(currentYear, currentMonth, currentDay);
        }
        private void dateTimePicker_ValueChanged(object sender, EventArgs e)
        {
            currentDay = dateTimePicker.Value.Day;
            currentMonth = dateTimePicker.Value.Month;
            currentYear = dateTimePicker.Value.Year;
            FormPanelCalendar_Load(sender, e);
            setCurrentDateTime(0);
            radiusIconButton_Click(currentDay.ToString());
        }

        private int getLastDayOfMonth(int year, int month)
        {
            return DateTime.DaysInMonth(year, month);
        }

        private void setCalendar()
        {
            int firstDayOfMonth = getFirstDayOfMonth(currentYear, currentMonth);
            int lastDayOfMonth = getLastDayOfMonth(currentYear, currentMonth) + firstDayOfMonth;
            int indexButton = 0;
            foreach (AnimatedRadiusIconButton animatedRadiusIconButton in panelDaysInMonth.Controls)
            {
                indexButton++;
                animatedRadiusIconButton.Text = "";
                animatedRadiusIconButton.CustomButtonText = animatedRadiusIconButton.Text;
                animatedRadiusIconButton.BackColor = Color.FromArgb(240, 240, 240);
                if (firstDayOfMonth != 0)
                {
                    if (firstDayOfMonth <= indexButton && indexButton < lastDayOfMonth)
                    {
                        animatedRadiusIconButton.Text = "" + (indexButton - firstDayOfMonth + 1);
                        animatedRadiusIconButton.CustomButtonText = animatedRadiusIconButton.Text;
                    }
                }
                else
                {
                    if (indexButton >= firstDayOfMonth + 7 && indexButton < (lastDayOfMonth + 7))
                    {
                        animatedRadiusIconButton.Text = "" + (indexButton - 6 - firstDayOfMonth);
                        animatedRadiusIconButton.CustomButtonText = animatedRadiusIconButton.Text;
                    }
                }
                if (indexButton % 7 == 0)
                {
                    animatedRadiusIconButton.ForeColor = Color.FromArgb(255, 128, 128);
                    animatedRadiusIconButton.TextHoverColor = animatedRadiusIconButton.ForeColor;
                }
                if (animatedRadiusIconButton.Text == DateTime.Now.Day.ToString() && currentMonth == DateTime.Now.Month && currentYear == DateTime.Now.Year)
                {
                    animatedRadiusIconButton.BackColor = Color.BlueViolet;
                    animatedRadiusIconButton.BackHoverColor = animatedRadiusIconButton.BackColor;
                }
            }
        }
    }
}
