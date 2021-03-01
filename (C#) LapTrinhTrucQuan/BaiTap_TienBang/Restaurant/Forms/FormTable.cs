using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Restaurant.Classes;
using Restaurant.CustomControls;
using FontAwesome.Sharp;
using XanderUI;
using Zeroit.Framework.Button.Helper.Animation;

namespace Restaurant.Forms
{
    public partial class FormTable : Form
    {
        private ConnectDataBase connectDataBase = new ConnectDataBase();
        private DataTable dataTable=null;
        private DataTable subDataTable = null;
        private DataTable data = null;
        private TabPage tabPage = null;
        private FlowLayoutPanel flowLayoutPanel = null;
        private string textNumberTable = "";
        private string textRoom = "";
        private string textIDTable = "";
        private Color backColor ;
        public string textBan = "";
        public string textPhong = "";
        public string textMaBan = "";
        public bool isPlusVisible = false;
        public FormTable()
        {
            InitializeComponent();
        }

        private void FormTable_Load(object sender, EventArgs e)
        {
            tabTable.Controls.Clear();
            dataTable= connectDataBase.readData("select * from Phong");
            for (int i=0;i< dataTable.Rows.Count;++i)
            {
                tabPage = new TabPage();
                tabPage.Name = "tabPage" + (string)dataTable.Rows[i].ItemArray[0];
                tabPage.Text = "Phòng " + dataTable.Rows[i].ItemArray[1];
                flowLayoutPanel = new FlowLayoutPanel();
                flowLayoutPanel.Name = "panel" + (string)dataTable.Rows[i].ItemArray[0];
                flowLayoutPanel.Dock = DockStyle.Fill;
                subDataTable = connectDataBase.readData("select * from ThongTinBan where MaPhong=N'" + (string)dataTable.Rows[i].ItemArray[0] + "'");
                for (int j = 0; j < subDataTable.Rows.Count; ++j)
                {
                    flowLayoutPanel.Controls.Add(addButtonTable((string)subDataTable.Rows[j].ItemArray[0], "Bàn " + (string)subDataTable.Rows[j].ItemArray[2], IconChar.UserAltSlash));
                }
                if (isPlusVisible)
                {
                    flowLayoutPanel.Controls.Add(addButtonTable("Them", "Thêm", IconChar.Plus));
                }
                if (flowLayoutPanel.Controls.Count / 4 * 92 > flowLayoutPanel.Height)
                {
                    flowLayoutPanel.AutoScroll = false;
                    flowLayoutPanel.VerticalScroll.Enabled = false;
                    flowLayoutPanel.VerticalScroll.Visible = false;
                    flowLayoutPanel.HorizontalScroll.Visible = false;
                    flowLayoutPanel.HorizontalScroll.Maximum = 0;
                    flowLayoutPanel.VerticalScroll.Maximum = 0;
                    flowLayoutPanel.AutoScroll = true;
                }
                tabPage.Controls.Add(flowLayoutPanel);
                tabTable.TabPages.Add(tabPage);
            }               
        }
        private RadiusIconButton addButtonTable(string maBan,string soBan,IconChar iconChar)
        {
            RadiusIconButton radiusIconButton = new RadiusIconButton();
            data = connectDataBase.readData(" select * from PhieuDatBan where MaBan=N'" + maBan + "' and NgayDung <= '" + DateTime.Now.ToString("yyyy-MM-dd hh:mm:ss") + "' and NgayKetThuc is null");
            if (data.Rows.Count >= 1)
            {
                radiusIconButton.BackColor = Color.OrangeRed;
                radiusIconButton.IconChar = IconChar.UserAlt;
            }
            else
            {
                radiusIconButton.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
                radiusIconButton.IconChar = iconChar;
            }
            radiusIconButton.BorderColor = System.Drawing.Color.Transparent;
            radiusIconButton.Cursor= System.Windows.Forms.Cursors.Hand;
            radiusIconButton.BorderRadiusBottomLeft = 10;
            radiusIconButton.BorderRadiusBottomRight = 10;
            radiusIconButton.BorderRadiusTopLeft = 10;
            radiusIconButton.BorderRadiusTopRight = 10;
            radiusIconButton.BorderWidth = 0F;
            radiusIconButton.FlatAppearance.BorderSize = 0;
            radiusIconButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            radiusIconButton.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            radiusIconButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            radiusIconButton.ForeColor = System.Drawing.Color.White;            
            radiusIconButton.IconColor = System.Drawing.Color.White;
            radiusIconButton.IconFont = FontAwesome.Sharp.IconFont.Auto;
            radiusIconButton.IconSize = 50;
            radiusIconButton.Name = maBan;
            radiusIconButton.Rotation = 0D;
            radiusIconButton.Size = new System.Drawing.Size(92, 92);
            radiusIconButton.TabIndex = 0;
            radiusIconButton.Text = soBan;
            radiusIconButton.TextImageRelation = System.Windows.Forms.TextImageRelation.TextAboveImage;
            radiusIconButton.UseVisualStyleBackColor = false;
            radiusIconButton.Click += new EventHandler(radiusIconButton_Click);
            return radiusIconButton;
        }
        private void radiusIconButton_Click(object sender, EventArgs e)
        {
            tabPage = tabTable.SelectedTab;
            textRoom = tabPage.Text.Split(' ')[1];
            textNumberTable = ((IconButton)sender).Text.Split(' ')[1];
            textIDTable = ((IconButton)sender).Name;
            textPhong = "";
            textBan = "";
            textMaBan = "";
            ((IconButton)sender).BackColor = Color.OrangeRed;
        }

        private void buttonChangeTable_Click(object sender, EventArgs e)
        {
            
        }

        private void buttonChooseTable_Click(object sender, EventArgs e)
        {
            textPhong = textRoom;
            textBan = textNumberTable;
            textMaBan = textIDTable;
            textRoom = "";
            textNumberTable = "";
            textIDTable = "";
            this.Dispose();
        }
    }
}
