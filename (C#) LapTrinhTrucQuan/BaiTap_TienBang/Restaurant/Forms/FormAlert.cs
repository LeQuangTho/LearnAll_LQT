using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using FontAwesome.Sharp;

namespace Restaurant.Forms
{
    public partial class FormAlert : Form
    {
        public FormAlert()
        {
            InitializeComponent();
        }

        private void buttonClose_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        public enum enmAction
        {
            wait,
            start,
            close
        }

        public enum enmType
        {
            Success,
            Warning,
            Error,
            Info
        }
        private FormAlert.enmAction action;
        private int x, y;

        private void timerAlert_Tick(object sender, EventArgs e)
        {
            switch (this.action)
            {
                case enmAction.wait:
                    timerAlert.Interval = 2000;
                    action = enmAction.close;
                    break;
                case FormAlert.enmAction.start:
                    this.timerAlert.Interval = 1;
                    this.Opacity += 0.1;
                    if (this.x < this.Location.X)
                    {
                        this.Left--;
                    }
                    else
                    {
                        if (this.Opacity == 1.0)
                        {
                            action = FormAlert.enmAction.wait;
                        }
                    }
                    break;
                case FormAlert.enmAction.close:
                    timerAlert.Interval = 1;
                    this.Opacity -= 0.1;

                    this.Left -= 3;
                    if (base.Opacity == 0.0)
                    {
                        base.Close();
                    }
                    break;
            }
        }

        public void showAlert(string msg, IconChar iconChar, Color backColor)
        {
            this.Opacity = 0.0;
            this.StartPosition = FormStartPosition.Manual;
            string fname;

            for (int i = 1; i < 10; i++)
            {
                fname = "alert" + i.ToString();
                FormAlert frm = (FormAlert)Application.OpenForms[fname];

                if (frm == null)
                {
                    this.Name = fname;
                    this.x = Screen.PrimaryScreen.WorkingArea.Width - this.Width + 15;
                    this.y = Screen.PrimaryScreen.WorkingArea.Height - this.Height * i - 5 * i;
                    this.Location = new Point(this.x, this.y);
                    break;

                }

            }
            this.x = Screen.PrimaryScreen.WorkingArea.Width - base.Width - 5;

            this.iconAlert.IconChar = iconChar;
            this.labelTitleAlert.Text = msg;
            this.BackColor = backColor;
            this.iconAlert.BackColor = backColor;
            this.buttonClose.FlatAppearance.BorderColor = backColor;
            this.buttonClose.FlatAppearance.MouseDownBackColor = backColor;
            this.buttonClose.FlatAppearance.MouseOverBackColor = backColor;

            this.Show();
            this.action = enmAction.start;
            this.timerAlert.Interval = 1;
            this.timerAlert.Start();
        }
    }
}
