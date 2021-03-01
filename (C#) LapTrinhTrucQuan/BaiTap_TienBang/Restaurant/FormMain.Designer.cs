namespace Restaurant
{
    partial class FormMain
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Drawing.Drawing2D.GraphicsPath graphicsPath1 = new System.Drawing.Drawing2D.GraphicsPath();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormMain));
            this.toolTip = new Zeroit.Framework.Tooltip.ZeroitTetraToolTip();
            this.buttonNotification = new FontAwesome.Sharp.IconButton();
            this.buttonCalendar = new FontAwesome.Sharp.IconButton();
            this.buttonSetting = new FontAwesome.Sharp.IconButton();
            this.buttonMaterial = new FontAwesome.Sharp.IconButton();
            this.buttonEmployees = new FontAwesome.Sharp.IconButton();
            this.buttonCustomers = new FontAwesome.Sharp.IconButton();
            this.buttonChart = new FontAwesome.Sharp.IconButton();
            this.buttonBill = new FontAwesome.Sharp.IconButton();
            this.buttonOrderFoods = new FontAwesome.Sharp.IconButton();
            this.buttonBookTable = new FontAwesome.Sharp.IconButton();
            this.panelMenu = new System.Windows.Forms.Panel();
            this.buttonLoginAdmin = new Zeroit.Framework.MaterialWinforms.Controls.MaterialRaisedButton();
            this.iconLogo = new System.Windows.Forms.PictureBox();
            this.groupBoxMenuButton = new XanderUI.XUICustomGroupbox();
            this.panelTop = new System.Windows.Forms.Panel();
            this.labelTitle = new System.Windows.Forms.Label();
            this.iconTitle = new FontAwesome.Sharp.IconPictureBox();
            this.iconSearch = new FontAwesome.Sharp.IconPictureBox();
            this.textSearch = new Zeroit.Framework.LollipopControls.Controls.ZeroitLollipopTextBox();
            this.timerSlider = new System.Windows.Forms.Timer(this.components);
            this.panelMain = new System.Windows.Forms.Panel();
            this.panelMenu.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.iconLogo)).BeginInit();
            this.groupBoxMenuButton.SuspendLayout();
            this.panelTop.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.iconTitle)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.iconSearch)).BeginInit();
            this.SuspendLayout();
            // 
            // buttonNotification
            // 
            this.buttonNotification.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonNotification.Dock = System.Windows.Forms.DockStyle.Right;
            this.buttonNotification.FlatAppearance.BorderSize = 0;
            this.buttonNotification.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonNotification.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonNotification.IconChar = FontAwesome.Sharp.IconChar.Bell;
            this.buttonNotification.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonNotification.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonNotification.IconSize = 32;
            this.buttonNotification.Location = new System.Drawing.Point(864, 0);
            this.buttonNotification.Name = "buttonNotification";
            this.buttonNotification.Rotation = 0D;
            this.buttonNotification.Size = new System.Drawing.Size(50, 50);
            this.buttonNotification.TabIndex = 2;
            this.toolTip.SetToolTipTitle(this.buttonNotification, "Thông báo");
            this.buttonNotification.UseVisualStyleBackColor = true;
            // 
            // buttonCalendar
            // 
            this.buttonCalendar.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonCalendar.Dock = System.Windows.Forms.DockStyle.Right;
            this.buttonCalendar.FlatAppearance.BorderSize = 0;
            this.buttonCalendar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonCalendar.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonCalendar.IconChar = FontAwesome.Sharp.IconChar.CalendarAlt;
            this.buttonCalendar.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonCalendar.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonCalendar.IconSize = 32;
            this.buttonCalendar.Location = new System.Drawing.Point(914, 0);
            this.buttonCalendar.Name = "buttonCalendar";
            this.buttonCalendar.Rotation = 0D;
            this.buttonCalendar.Size = new System.Drawing.Size(50, 50);
            this.buttonCalendar.TabIndex = 1;
            this.toolTip.SetToolTipTitle(this.buttonCalendar, "Lịch");
            this.buttonCalendar.UseVisualStyleBackColor = true;
            this.buttonCalendar.Click += new System.EventHandler(this.buttonCalendar_Click);
            // 
            // buttonSetting
            // 
            this.buttonSetting.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonSetting.Dock = System.Windows.Forms.DockStyle.Right;
            this.buttonSetting.FlatAppearance.BorderSize = 0;
            this.buttonSetting.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonSetting.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonSetting.IconChar = FontAwesome.Sharp.IconChar.Cog;
            this.buttonSetting.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonSetting.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonSetting.IconSize = 32;
            this.buttonSetting.Location = new System.Drawing.Point(964, 0);
            this.buttonSetting.Name = "buttonSetting";
            this.buttonSetting.Rotation = 0D;
            this.buttonSetting.Size = new System.Drawing.Size(50, 50);
            this.buttonSetting.TabIndex = 0;
            this.toolTip.SetToolTipTitle(this.buttonSetting, "Cài đặt");
            this.buttonSetting.UseVisualStyleBackColor = true;
            this.buttonSetting.Click += new System.EventHandler(this.buttonSetting_Click);
            // 
            // buttonMaterial
            // 
            this.buttonMaterial.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonMaterial.FlatAppearance.BorderSize = 0;
            this.buttonMaterial.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonMaterial.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonMaterial.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonMaterial.IconChar = FontAwesome.Sharp.IconChar.Cannabis;
            this.buttonMaterial.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonMaterial.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonMaterial.IconSize = 36;
            this.buttonMaterial.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.buttonMaterial.Location = new System.Drawing.Point(12, 243);
            this.buttonMaterial.Name = "buttonMaterial";
            this.buttonMaterial.Rotation = 0D;
            this.buttonMaterial.Size = new System.Drawing.Size(138, 50);
            this.buttonMaterial.TabIndex = 9;
            this.buttonMaterial.Text = "Nguyên liệu";
            this.buttonMaterial.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.toolTip.SetToolTipTitle(this.buttonMaterial, "Nhân viên");
            this.buttonMaterial.UseVisualStyleBackColor = true;
            this.buttonMaterial.Visible = false;
            // 
            // buttonEmployees
            // 
            this.buttonEmployees.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonEmployees.FlatAppearance.BorderSize = 0;
            this.buttonEmployees.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonEmployees.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonEmployees.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonEmployees.IconChar = FontAwesome.Sharp.IconChar.Users;
            this.buttonEmployees.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonEmployees.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonEmployees.IconSize = 36;
            this.buttonEmployees.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.buttonEmployees.Location = new System.Drawing.Point(12, 299);
            this.buttonEmployees.Name = "buttonEmployees";
            this.buttonEmployees.Rotation = 0D;
            this.buttonEmployees.Size = new System.Drawing.Size(138, 50);
            this.buttonEmployees.TabIndex = 4;
            this.buttonEmployees.Text = "Nhân viên";
            this.buttonEmployees.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.toolTip.SetToolTipTitle(this.buttonEmployees, "Nhân viên");
            this.buttonEmployees.UseVisualStyleBackColor = true;
            this.buttonEmployees.Visible = false;
            this.buttonEmployees.Click += new System.EventHandler(this.buttonEmployees_Click);
            this.buttonEmployees.MouseLeave += new System.EventHandler(this.buttonEmployee_MouseLeave);
            this.buttonEmployees.MouseHover += new System.EventHandler(this.buttonEmployee_MouseHover);
            // 
            // buttonCustomers
            // 
            this.buttonCustomers.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonCustomers.FlatAppearance.BorderSize = 0;
            this.buttonCustomers.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonCustomers.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonCustomers.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonCustomers.IconChar = FontAwesome.Sharp.IconChar.UserAlt;
            this.buttonCustomers.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonCustomers.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonCustomers.IconSize = 36;
            this.buttonCustomers.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.buttonCustomers.Location = new System.Drawing.Point(12, 187);
            this.buttonCustomers.Name = "buttonCustomers";
            this.buttonCustomers.Rotation = 0D;
            this.buttonCustomers.Size = new System.Drawing.Size(138, 50);
            this.buttonCustomers.TabIndex = 5;
            this.buttonCustomers.Text = "Khách hàng";
            this.buttonCustomers.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.toolTip.SetToolTipTitle(this.buttonCustomers, "Khách hàng");
            this.buttonCustomers.UseVisualStyleBackColor = true;
            this.buttonCustomers.MouseLeave += new System.EventHandler(this.buttonGuest_MouseLeave);
            this.buttonCustomers.MouseHover += new System.EventHandler(this.buttonGuest_MouseHover);
            // 
            // buttonChart
            // 
            this.buttonChart.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonChart.FlatAppearance.BorderSize = 0;
            this.buttonChart.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonChart.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonChart.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonChart.IconChar = FontAwesome.Sharp.IconChar.ChartBar;
            this.buttonChart.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonChart.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonChart.IconSize = 36;
            this.buttonChart.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.buttonChart.Location = new System.Drawing.Point(12, 355);
            this.buttonChart.Name = "buttonChart";
            this.buttonChart.Rotation = 0D;
            this.buttonChart.Size = new System.Drawing.Size(138, 50);
            this.buttonChart.TabIndex = 7;
            this.buttonChart.Text = "Thống kê";
            this.buttonChart.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.toolTip.SetToolTipTitle(this.buttonChart, "Biểu đồ");
            this.buttonChart.UseVisualStyleBackColor = true;
            this.buttonChart.Visible = false;
            this.buttonChart.Click += new System.EventHandler(this.buttonChart_Click);
            this.buttonChart.MouseLeave += new System.EventHandler(this.buttonChart_MouseLeave);
            this.buttonChart.MouseHover += new System.EventHandler(this.buttonChart_MouseHover);
            // 
            // buttonBill
            // 
            this.buttonBill.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonBill.FlatAppearance.BorderSize = 0;
            this.buttonBill.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonBill.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonBill.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonBill.IconChar = FontAwesome.Sharp.IconChar.FileInvoiceDollar;
            this.buttonBill.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonBill.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonBill.IconSize = 36;
            this.buttonBill.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.buttonBill.Location = new System.Drawing.Point(12, 131);
            this.buttonBill.Name = "buttonBill";
            this.buttonBill.Rotation = 0D;
            this.buttonBill.Size = new System.Drawing.Size(138, 50);
            this.buttonBill.TabIndex = 3;
            this.buttonBill.Text = "Hóa đơn";
            this.buttonBill.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.toolTip.SetToolTipTitle(this.buttonBill, "Hóa đơn");
            this.buttonBill.UseVisualStyleBackColor = true;
            this.buttonBill.Click += new System.EventHandler(this.buttonBill_Click);
            this.buttonBill.MouseLeave += new System.EventHandler(this.buttonBill_MouseLeave);
            this.buttonBill.MouseHover += new System.EventHandler(this.buttonBill_MouseHover);
            // 
            // buttonOrderFoods
            // 
            this.buttonOrderFoods.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonOrderFoods.FlatAppearance.BorderSize = 0;
            this.buttonOrderFoods.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonOrderFoods.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonOrderFoods.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonOrderFoods.IconChar = FontAwesome.Sharp.IconChar.Fax;
            this.buttonOrderFoods.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonOrderFoods.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonOrderFoods.IconSize = 36;
            this.buttonOrderFoods.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.buttonOrderFoods.Location = new System.Drawing.Point(12, 75);
            this.buttonOrderFoods.Name = "buttonOrderFoods";
            this.buttonOrderFoods.Rotation = 0D;
            this.buttonOrderFoods.Size = new System.Drawing.Size(138, 50);
            this.buttonOrderFoods.TabIndex = 2;
            this.buttonOrderFoods.Text = "Chọn món";
            this.buttonOrderFoods.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.toolTip.SetToolTipTitle(this.buttonOrderFoods, "Chọn món");
            this.buttonOrderFoods.UseVisualStyleBackColor = true;
            this.buttonOrderFoods.Click += new System.EventHandler(this.buttonOrderFoods_Click);
            this.buttonOrderFoods.MouseLeave += new System.EventHandler(this.buttonOrderFoods_MouseLeave);
            this.buttonOrderFoods.MouseHover += new System.EventHandler(this.buttonOrderFoods_MouseHover);
            // 
            // buttonBookTable
            // 
            this.buttonBookTable.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonBookTable.FlatAppearance.BorderSize = 0;
            this.buttonBookTable.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonBookTable.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonBookTable.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonBookTable.IconChar = FontAwesome.Sharp.IconChar.Table;
            this.buttonBookTable.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonBookTable.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonBookTable.IconSize = 36;
            this.buttonBookTable.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.buttonBookTable.Location = new System.Drawing.Point(12, 19);
            this.buttonBookTable.Name = "buttonBookTable";
            this.buttonBookTable.Rotation = 0D;
            this.buttonBookTable.Size = new System.Drawing.Size(138, 50);
            this.buttonBookTable.TabIndex = 1;
            this.buttonBookTable.Text = "Đặt bàn";
            this.buttonBookTable.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.toolTip.SetToolTipTitle(this.buttonBookTable, "Đặt bàn");
            this.buttonBookTable.UseVisualStyleBackColor = true;
            this.buttonBookTable.Click += new System.EventHandler(this.buttonBookTable_Click);
            this.buttonBookTable.MouseLeave += new System.EventHandler(this.buttonBookTable_MouseLeave);
            this.buttonBookTable.MouseHover += new System.EventHandler(this.buttonBookTable_MouseHover);
            // 
            // panelMenu
            // 
            this.panelMenu.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(251)))));
            this.panelMenu.Controls.Add(this.buttonLoginAdmin);
            this.panelMenu.Controls.Add(this.iconLogo);
            this.panelMenu.Controls.Add(this.groupBoxMenuButton);
            this.panelMenu.Dock = System.Windows.Forms.DockStyle.Left;
            this.panelMenu.Location = new System.Drawing.Point(0, 0);
            this.panelMenu.Name = "panelMenu";
            this.panelMenu.Size = new System.Drawing.Size(170, 661);
            this.panelMenu.TabIndex = 0;
            // 
            // buttonLoginAdmin
            // 
            this.buttonLoginAdmin.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonLoginAdmin.Depth = 0;
            this.buttonLoginAdmin.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.buttonLoginAdmin.Elevation = 1;
            this.buttonLoginAdmin.Location = new System.Drawing.Point(0, 611);
            this.buttonLoginAdmin.MouseState = Zeroit.Framework.MaterialWinforms.MouseState.HOVER;
            this.buttonLoginAdmin.Name = "buttonLoginAdmin";
            this.buttonLoginAdmin.Primary = true;
            graphicsPath1.FillMode = System.Drawing.Drawing2D.FillMode.Alternate;
            this.buttonLoginAdmin.ShadowBorder = graphicsPath1;
            this.buttonLoginAdmin.Size = new System.Drawing.Size(170, 50);
            this.buttonLoginAdmin.TabIndex = 7;
            this.buttonLoginAdmin.Text = "Quản trị viên";
            this.buttonLoginAdmin.UseVisualStyleBackColor = true;
            this.buttonLoginAdmin.Click += new System.EventHandler(this.buttonLoginAdmin_Click);
            // 
            // iconLogo
            // 
            this.iconLogo.Cursor = System.Windows.Forms.Cursors.Hand;
            this.iconLogo.Image = global::Restaurant.Properties.Resources.Logo_Restaurant1;
            this.iconLogo.Location = new System.Drawing.Point(0, 12);
            this.iconLogo.Name = "iconLogo";
            this.iconLogo.Size = new System.Drawing.Size(170, 91);
            this.iconLogo.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.iconLogo.TabIndex = 0;
            this.iconLogo.TabStop = false;
            this.iconLogo.Click += new System.EventHandler(this.iconLogo_Click);
            this.iconLogo.MouseLeave += new System.EventHandler(this.iconLogo_MouseLeave);
            this.iconLogo.MouseHover += new System.EventHandler(this.iconLogo_MouseHover);
            // 
            // groupBoxMenuButton
            // 
            this.groupBoxMenuButton.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(251)))));
            this.groupBoxMenuButton.BorderWidth = 1;
            this.groupBoxMenuButton.Controls.Add(this.buttonMaterial);
            this.groupBoxMenuButton.Controls.Add(this.buttonEmployees);
            this.groupBoxMenuButton.Controls.Add(this.buttonCustomers);
            this.groupBoxMenuButton.Controls.Add(this.buttonChart);
            this.groupBoxMenuButton.Controls.Add(this.buttonBill);
            this.groupBoxMenuButton.Controls.Add(this.buttonOrderFoods);
            this.groupBoxMenuButton.Controls.Add(this.buttonBookTable);
            this.groupBoxMenuButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBoxMenuButton.Location = new System.Drawing.Point(0, 132);
            this.groupBoxMenuButton.Name = "groupBoxMenuButton";
            this.groupBoxMenuButton.ShowText = true;
            this.groupBoxMenuButton.Size = new System.Drawing.Size(170, 421);
            this.groupBoxMenuButton.TabIndex = 6;
            this.groupBoxMenuButton.TabStop = false;
            this.groupBoxMenuButton.Text = "Chức năng";
            this.groupBoxMenuButton.TextColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            // 
            // panelTop
            // 
            this.panelTop.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(251)))));
            this.panelTop.Controls.Add(this.labelTitle);
            this.panelTop.Controls.Add(this.iconTitle);
            this.panelTop.Controls.Add(this.iconSearch);
            this.panelTop.Controls.Add(this.textSearch);
            this.panelTop.Controls.Add(this.buttonNotification);
            this.panelTop.Controls.Add(this.buttonCalendar);
            this.panelTop.Controls.Add(this.buttonSetting);
            this.panelTop.Dock = System.Windows.Forms.DockStyle.Top;
            this.panelTop.Location = new System.Drawing.Point(170, 0);
            this.panelTop.Name = "panelTop";
            this.panelTop.Size = new System.Drawing.Size(1014, 50);
            this.panelTop.TabIndex = 1;
            // 
            // labelTitle
            // 
            this.labelTitle.Dock = System.Windows.Forms.DockStyle.Left;
            this.labelTitle.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelTitle.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.labelTitle.Location = new System.Drawing.Point(50, 0);
            this.labelTitle.Name = "labelTitle";
            this.labelTitle.Size = new System.Drawing.Size(100, 50);
            this.labelTitle.TabIndex = 6;
            this.labelTitle.Text = "Trang chủ";
            this.labelTitle.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // iconTitle
            // 
            this.iconTitle.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(251)))));
            this.iconTitle.Dock = System.Windows.Forms.DockStyle.Left;
            this.iconTitle.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.iconTitle.IconChar = FontAwesome.Sharp.IconChar.Home;
            this.iconTitle.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.iconTitle.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.iconTitle.IconSize = 50;
            this.iconTitle.Location = new System.Drawing.Point(0, 0);
            this.iconTitle.Name = "iconTitle";
            this.iconTitle.Size = new System.Drawing.Size(50, 50);
            this.iconTitle.TabIndex = 5;
            this.iconTitle.TabStop = false;
            // 
            // iconSearch
            // 
            this.iconSearch.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.iconSearch.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.iconSearch.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.iconSearch.IconChar = FontAwesome.Sharp.IconChar.Search;
            this.iconSearch.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.iconSearch.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.iconSearch.IconSize = 19;
            this.iconSearch.Location = new System.Drawing.Point(689, 14);
            this.iconSearch.Name = "iconSearch";
            this.iconSearch.Size = new System.Drawing.Size(19, 19);
            this.iconSearch.TabIndex = 4;
            this.iconSearch.TabStop = false;
            // 
            // textSearch
            // 
            this.textSearch.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.textSearch.DisabledStringColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(251)))));
            this.textSearch.DisabledUnFocusedColor = System.Drawing.Color.FromArgb(((int)(((byte)(233)))), ((int)(((byte)(236)))), ((int)(((byte)(238)))));
            this.textSearch.EnabledUnFocusedColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.textSearch.FocusedColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.textSearch.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.textSearch.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(153)))), ((int)(((byte)(153)))), ((int)(((byte)(153)))));
            this.textSearch.IsEnabled = true;
            this.textSearch.Location = new System.Drawing.Point(294, 12);
            this.textSearch.MaxLength = 40;
            this.textSearch.Multiline = false;
            this.textSearch.Name = "textSearch";
            this.textSearch.PasswordChar = '\0';
            this.textSearch.ReadOnly = false;
            this.textSearch.Size = new System.Drawing.Size(413, 24);
            this.textSearch.TabIndex = 3;
            this.textSearch.TextAlignment = System.Windows.Forms.HorizontalAlignment.Left;
            this.textSearch.TextBackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.textSearch.UseSystemPasswordChar = false;
            this.textSearch.WordWrap = true;
            // 
            // timerSlider
            // 
            this.timerSlider.Interval = 7500;
            this.timerSlider.Tick += new System.EventHandler(this.timerSlider_Tick);
            // 
            // panelMain
            // 
            this.panelMain.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panelMain.Location = new System.Drawing.Point(170, 50);
            this.panelMain.Name = "panelMain";
            this.panelMain.Size = new System.Drawing.Size(1014, 611);
            this.panelMain.TabIndex = 3;
            // 
            // FormMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.ClientSize = new System.Drawing.Size(1184, 661);
            this.Controls.Add(this.panelMain);
            this.Controls.Add(this.panelTop);
            this.Controls.Add(this.panelMenu);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MinimumSize = new System.Drawing.Size(1100, 650);
            this.Name = "FormMain";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Restaurant";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.FormMain_FormClosing);
            this.Load += new System.EventHandler(this.FormMain_Load);
            this.panelMenu.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.iconLogo)).EndInit();
            this.groupBoxMenuButton.ResumeLayout(false);
            this.groupBoxMenuButton.PerformLayout();
            this.panelTop.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.iconTitle)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.iconSearch)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private Zeroit.Framework.Tooltip.ZeroitTetraToolTip toolTip;
        private CustomControls.FloatingCircleButton floatingButton1;
        private System.Windows.Forms.Panel panelMenu;
        private System.Windows.Forms.PictureBox iconLogo;
        private FontAwesome.Sharp.IconButton buttonCustomers;
        private FontAwesome.Sharp.IconButton buttonEmployees;
        private FontAwesome.Sharp.IconButton buttonBill;
        private FontAwesome.Sharp.IconButton buttonOrderFoods;
        private FontAwesome.Sharp.IconButton buttonBookTable;
        private XanderUI.XUICustomGroupbox groupBoxMenuButton;
        private FontAwesome.Sharp.IconButton buttonChart;
        private System.Windows.Forms.Panel panelTop;
        private FontAwesome.Sharp.IconButton buttonNotification;
        private FontAwesome.Sharp.IconButton buttonCalendar;
        private FontAwesome.Sharp.IconButton buttonSetting;
        private Zeroit.Framework.LollipopControls.Controls.ZeroitLollipopTextBox textSearch;
        private FontAwesome.Sharp.IconPictureBox iconSearch;
        private System.Windows.Forms.Label labelTitle;
        private FontAwesome.Sharp.IconPictureBox iconTitle;
        private System.Windows.Forms.Timer timerSlider;
        private System.Windows.Forms.Panel panelMain;
        private Zeroit.Framework.MaterialWinforms.Controls.MaterialRaisedButton buttonLoginAdmin;
        private FontAwesome.Sharp.IconButton buttonMaterial;
    }
}

