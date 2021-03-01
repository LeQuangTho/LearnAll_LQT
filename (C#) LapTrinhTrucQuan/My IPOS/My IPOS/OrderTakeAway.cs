using My_IPOS.Model;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace My_IPOS
{
    public partial class OrderTakeAway : Form
    {
        Bitmap back, hour, minute, dot, second;

        public int stt = 0;
        public string MaKhach = "TA01";
        string user;

        public OrderTakeAway(string user)
        {
            InitializeComponent();
            this.user = user;

            back = new Bitmap(".\\image\\back.png");
            hour = new Bitmap(".\\image\\hour.png");
            minute = new Bitmap(".\\image\\minute.png");
            dot = new Bitmap(".\\image\\dot.png");
            second = new Bitmap(".\\image\\second.png");
            ControlTS a = new ControlTS(this);
            panel5.Controls.Clear();
            panel5.Controls.Add(a);
        }

        private Bitmap rotateImage(Bitmap rotateMe, float angle)
        {
            Bitmap rotatedImage = new Bitmap(rotateMe.Width, rotateMe.Height);

            using (Graphics g = Graphics.FromImage(rotatedImage))
            {
                g.TranslateTransform(rotateMe.Width / 2, rotateMe.Height / 2);
                g.RotateTransform(angle);
                g.TranslateTransform(-rotateMe.Width / 2, -rotateMe.Height / 2);
                g.DrawImage(rotateMe, new Point(0, 0));
            }
            return rotatedImage;
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            DateTime Now = DateTime.Now;
            int Hour = Now.Hour;
            int Minute = Now.Minute;
            int Second = Now.Second;

            Single AngleS = Second * 6;
            Single AngleM = Minute * 6 + AngleS / 60;
            Single AngleH = Hour * 30 + AngleM / 12;

            backBox.Image = back;
            backBox.Controls.Add(hourBox);
            hourBox.Location = new Point(0, 0);
            hourBox.Image = rotateImage(hour, AngleH);


            hourBox.Controls.Add(minuteBox);
            minuteBox.Location = new Point(0, 0);
            minuteBox.Image = rotateImage(minute, AngleM);

            minuteBox.Controls.Add(dotBox);
            dotBox.Location = new Point(0, 0);
            dotBox.Image = dot;

            dotBox.Controls.Add(secondBox);
            secondBox.Location = new Point(0, 0);
            secondBox.Image = rotateImage(second, AngleS);
        }

        private void btnTongTien_Click(object sender, EventArgs e)
        {
            TongTien tongtien = new TongTien(dgvxTakeAway,this, user);
            tongtien.ShowDialog();
        }

        public void addMon(int stt, string TenMon, int SoLuong, float GiamGia, int DonGia, string GhiChu, string GioGoi, float ThanhTien, string MaMon)
        { 
            dgvxTakeAway.Rows.Add(stt, TenMon, SoLuong, GiamGia, DonGia, GhiChu, GioGoi, ThanhTien, MaMon);
        }

        private void gunaGradientTileButton4_Click(object sender, EventArgs e)
        {
            ControlTX a = new ControlTX(this);
            panel5.Controls.Clear();
            panel5.Controls.Add(a);
        }

        private void gunaGradientTileButton1_Click(object sender, EventArgs e)
        {
            ControlTS a = new ControlTS(this);
            panel5.Controls.Clear();
            panel5.Controls.Add(a);
        }

        private void gunaGradientTileButton2_Click(object sender, EventArgs e)
        {
            ControlTP a = new ControlTP(this);
            panel5.Controls.Clear();
            panel5.Controls.Add(a);
        }

        private void btHoiVien_Click(object sender, EventArgs e)
        {
            HoiVien hv = new HoiVien(this);
            hv.ShowDialog();
        }

        public void updateCell(int a, int b, int values)
        {
            try
            {
                dgvxTakeAway.Rows[a].Cells[b].Value = values;
                dgvxTakeAway.Rows[a].Cells[7].Value = Convert.ToInt32(dgvxTakeAway.Rows[a].Cells[7].Value.ToString()) * values;
            }
            catch { }
        }

        private void bntBoMon_Click(object sender, EventArgs e)
        {
            if (stt > 0)
            {
                int rowIndex = dgvxTakeAway.CurrentCell.RowIndex;
                int sttIndex = Convert.ToInt32(dgvxTakeAway.Rows[rowIndex].Cells[0].Value.ToString());
                dgvxTakeAway.Rows.RemoveAt(rowIndex);
                stt--;
                for(int i = rowIndex; i < dgvxTakeAway.RowCount; i++)
                {
                    dgvxTakeAway.Rows[i].Cells[0].Value = sttIndex++;
                }
            }
        }

        private void dgvxTakeAway_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.ColumnIndex == 2 && dgvxTakeAway.RowCount != 0)
            {
                edit ed = new edit(this, e.RowIndex, e.ColumnIndex);
                ed.ShowDialog();
            }
        }

        public void outOrder()
        {
            this.Close();
        }

        public void tat()
        {
            btHoiVien.Enabled = false;
        }
    }
}
