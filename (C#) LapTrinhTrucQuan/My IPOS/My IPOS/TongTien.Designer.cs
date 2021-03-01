namespace My_IPOS
{
    partial class TongTien
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
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle2 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle3 = new System.Windows.Forms.DataGridViewCellStyle();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(TongTien));
            Microsoft.Reporting.WinForms.ReportDataSource reportDataSource1 = new Microsoft.Reporting.WinForms.ReportDataSource();
            this.dataTable1BindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.my_IPos = new My_IPOS.bin.Debug.report.My_IPos();
            this.dgvTongTien = new Guna.UI.WinForms.GunaDataGridView();
            this.Column1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.lbTheGiamGia = new Guna.UI.WinForms.GunaLabel();
            this.lbThanhToan = new Guna.UI.WinForms.GunaLabel();
            this.lbKhachDua = new Guna.UI.WinForms.GunaLabel();
            this.lbTienThua = new Guna.UI.WinForms.GunaLabel();
            this.tbTheGiamGia = new Guna.UI.WinForms.GunaTextBox();
            this.tbKhachDua = new Guna.UI.WinForms.GunaTextBox();
            this.tbThanhToan = new Guna.UI.WinForms.GunaTextBox();
            this.tbTienThua = new Guna.UI.WinForms.GunaTextBox();
            this.btTAorDI = new Guna.UI.WinForms.GunaGradientCircleButton();
            this.btnInHoaDon = new Guna.UI.WinForms.GunaButton();
            this.btnDong = new Guna.UI.WinForms.GunaButton();
            this.btnVoucher = new Guna.UI.WinForms.GunaButton();
            this.btThanhToan = new Guna.UI.WinForms.GunaButton();
            this.reportViewer1 = new Microsoft.Reporting.WinForms.ReportViewer();
            this.dataTable1TableAdapter = new My_IPOS.bin.Debug.report.My_IPosTableAdapters.DataTable1TableAdapter();
            ((System.ComponentModel.ISupportInitialize)(this.dataTable1BindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.my_IPos)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvTongTien)).BeginInit();
            this.SuspendLayout();
            // 
            // dataTable1BindingSource
            // 
            this.dataTable1BindingSource.DataMember = "DataTable1";
            this.dataTable1BindingSource.DataSource = this.my_IPos;
            // 
            // my_IPos
            // 
            this.my_IPos.DataSetName = "My_IPos";
            this.my_IPos.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // dgvTongTien
            // 
            this.dgvTongTien.AllowUserToAddRows = false;
            this.dgvTongTien.AllowUserToDeleteRows = false;
            dataGridViewCellStyle1.BackColor = System.Drawing.Color.White;
            this.dgvTongTien.AlternatingRowsDefaultCellStyle = dataGridViewCellStyle1;
            this.dgvTongTien.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgvTongTien.BackgroundColor = System.Drawing.Color.White;
            this.dgvTongTien.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.dgvTongTien.CellBorderStyle = System.Windows.Forms.DataGridViewCellBorderStyle.SingleHorizontal;
            dataGridViewCellStyle2.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(128)))));
            dataGridViewCellStyle2.Font = new System.Drawing.Font("Segoe UI", 10.5F);
            dataGridViewCellStyle2.ForeColor = System.Drawing.Color.White;
            dataGridViewCellStyle2.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle2.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle2.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dgvTongTien.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle2;
            this.dgvTongTien.ColumnHeadersHeight = 28;
            this.dgvTongTien.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.DisableResizing;
            this.dgvTongTien.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column1,
            this.Column2,
            this.Column3,
            this.Column4});
            dataGridViewCellStyle3.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle3.BackColor = System.Drawing.Color.White;
            dataGridViewCellStyle3.Font = new System.Drawing.Font("Segoe UI", 10.5F);
            dataGridViewCellStyle3.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(71)))), ((int)(((byte)(69)))), ((int)(((byte)(94)))));
            dataGridViewCellStyle3.SelectionBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(231)))), ((int)(((byte)(229)))), ((int)(((byte)(255)))));
            dataGridViewCellStyle3.SelectionForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(71)))), ((int)(((byte)(69)))), ((int)(((byte)(94)))));
            dataGridViewCellStyle3.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
            this.dgvTongTien.DefaultCellStyle = dataGridViewCellStyle3;
            this.dgvTongTien.EnableHeadersVisualStyles = false;
            this.dgvTongTien.GridColor = System.Drawing.Color.White;
            this.dgvTongTien.Location = new System.Drawing.Point(20, 12);
            this.dgvTongTien.Name = "dgvTongTien";
            this.dgvTongTien.ReadOnly = true;
            this.dgvTongTien.RowHeadersVisible = false;
            this.dgvTongTien.RowTemplate.ReadOnly = true;
            this.dgvTongTien.RowTemplate.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.dgvTongTien.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvTongTien.Size = new System.Drawing.Size(421, 306);
            this.dgvTongTien.TabIndex = 0;
            this.dgvTongTien.Theme = Guna.UI.WinForms.GunaDataGridViewPresetThemes.Guna;
            this.dgvTongTien.ThemeStyle.AlternatingRowsStyle.BackColor = System.Drawing.Color.White;
            this.dgvTongTien.ThemeStyle.AlternatingRowsStyle.Font = null;
            this.dgvTongTien.ThemeStyle.AlternatingRowsStyle.ForeColor = System.Drawing.Color.Empty;
            this.dgvTongTien.ThemeStyle.AlternatingRowsStyle.SelectionBackColor = System.Drawing.Color.Empty;
            this.dgvTongTien.ThemeStyle.AlternatingRowsStyle.SelectionForeColor = System.Drawing.Color.Empty;
            this.dgvTongTien.ThemeStyle.BackColor = System.Drawing.Color.White;
            this.dgvTongTien.ThemeStyle.GridColor = System.Drawing.Color.White;
            this.dgvTongTien.ThemeStyle.HeaderStyle.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(128)))));
            this.dgvTongTien.ThemeStyle.HeaderStyle.BorderStyle = System.Windows.Forms.DataGridViewHeaderBorderStyle.Raised;
            this.dgvTongTien.ThemeStyle.HeaderStyle.Font = new System.Drawing.Font("Segoe UI", 10.5F);
            this.dgvTongTien.ThemeStyle.HeaderStyle.ForeColor = System.Drawing.Color.White;
            this.dgvTongTien.ThemeStyle.HeaderStyle.HeaightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.DisableResizing;
            this.dgvTongTien.ThemeStyle.HeaderStyle.Height = 28;
            this.dgvTongTien.ThemeStyle.ReadOnly = true;
            this.dgvTongTien.ThemeStyle.RowsStyle.BackColor = System.Drawing.Color.White;
            this.dgvTongTien.ThemeStyle.RowsStyle.BorderStyle = System.Windows.Forms.DataGridViewCellBorderStyle.SingleHorizontal;
            this.dgvTongTien.ThemeStyle.RowsStyle.Font = new System.Drawing.Font("Segoe UI", 10.5F);
            this.dgvTongTien.ThemeStyle.RowsStyle.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(71)))), ((int)(((byte)(69)))), ((int)(((byte)(94)))));
            this.dgvTongTien.ThemeStyle.RowsStyle.Height = 22;
            this.dgvTongTien.ThemeStyle.RowsStyle.SelectionBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(231)))), ((int)(((byte)(229)))), ((int)(((byte)(255)))));
            this.dgvTongTien.ThemeStyle.RowsStyle.SelectionForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(71)))), ((int)(((byte)(69)))), ((int)(((byte)(94)))));
            // 
            // Column1
            // 
            this.Column1.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.Column1.FillWeight = 1F;
            this.Column1.Frozen = true;
            this.Column1.HeaderText = "STT";
            this.Column1.MinimumWidth = 50;
            this.Column1.Name = "Column1";
            this.Column1.ReadOnly = true;
            this.Column1.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.Column1.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.NotSortable;
            this.Column1.Width = 50;
            // 
            // Column2
            // 
            this.Column2.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.Column2.FillWeight = 1F;
            this.Column2.Frozen = true;
            this.Column2.HeaderText = "Tên Món";
            this.Column2.MinimumWidth = 220;
            this.Column2.Name = "Column2";
            this.Column2.ReadOnly = true;
            this.Column2.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.Column2.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.NotSortable;
            this.Column2.Width = 220;
            // 
            // Column3
            // 
            this.Column3.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.Column3.FillWeight = 1F;
            this.Column3.Frozen = true;
            this.Column3.HeaderText = "Số lượng";
            this.Column3.MinimumWidth = 50;
            this.Column3.Name = "Column3";
            this.Column3.ReadOnly = true;
            this.Column3.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.Column3.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.NotSortable;
            this.Column3.Width = 50;
            // 
            // Column4
            // 
            this.Column4.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.Column4.FillWeight = 1F;
            this.Column4.Frozen = true;
            this.Column4.HeaderText = "Thành Tiền";
            this.Column4.MinimumWidth = 100;
            this.Column4.Name = "Column4";
            this.Column4.ReadOnly = true;
            this.Column4.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.Column4.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.NotSortable;
            // 
            // lbTheGiamGia
            // 
            this.lbTheGiamGia.AutoSize = true;
            this.lbTheGiamGia.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.lbTheGiamGia.Location = new System.Drawing.Point(19, 358);
            this.lbTheGiamGia.Name = "lbTheGiamGia";
            this.lbTheGiamGia.Size = new System.Drawing.Size(77, 15);
            this.lbTheGiamGia.TabIndex = 1;
            this.lbTheGiamGia.Text = "Thẻ Giảm Giá";
            // 
            // lbThanhToan
            // 
            this.lbThanhToan.AutoSize = true;
            this.lbThanhToan.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.lbThanhToan.Location = new System.Drawing.Point(19, 392);
            this.lbThanhToan.Name = "lbThanhToan";
            this.lbThanhToan.Size = new System.Drawing.Size(68, 15);
            this.lbThanhToan.TabIndex = 2;
            this.lbThanhToan.Text = "Thanh Toán";
            // 
            // lbKhachDua
            // 
            this.lbKhachDua.AutoSize = true;
            this.lbKhachDua.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.lbKhachDua.Location = new System.Drawing.Point(19, 427);
            this.lbKhachDua.Name = "lbKhachDua";
            this.lbKhachDua.Size = new System.Drawing.Size(64, 15);
            this.lbKhachDua.TabIndex = 3;
            this.lbKhachDua.Text = "Khách Đưa";
            // 
            // lbTienThua
            // 
            this.lbTienThua.AutoSize = true;
            this.lbTienThua.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.lbTienThua.Location = new System.Drawing.Point(19, 463);
            this.lbTienThua.Name = "lbTienThua";
            this.lbTienThua.Size = new System.Drawing.Size(58, 15);
            this.lbTienThua.TabIndex = 4;
            this.lbTienThua.Text = "Tiền Thừa";
            // 
            // tbTheGiamGia
            // 
            this.tbTheGiamGia.BaseColor = System.Drawing.Color.White;
            this.tbTheGiamGia.BorderColor = System.Drawing.Color.Silver;
            this.tbTheGiamGia.Cursor = System.Windows.Forms.Cursors.IBeam;
            this.tbTheGiamGia.FocusedBaseColor = System.Drawing.Color.White;
            this.tbTheGiamGia.FocusedBorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.tbTheGiamGia.FocusedForeColor = System.Drawing.SystemColors.ControlText;
            this.tbTheGiamGia.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.tbTheGiamGia.Location = new System.Drawing.Point(138, 343);
            this.tbTheGiamGia.Name = "tbTheGiamGia";
            this.tbTheGiamGia.PasswordChar = '\0';
            this.tbTheGiamGia.SelectedText = "";
            this.tbTheGiamGia.Size = new System.Drawing.Size(160, 30);
            this.tbTheGiamGia.TabIndex = 5;
            // 
            // tbKhachDua
            // 
            this.tbKhachDua.BaseColor = System.Drawing.Color.White;
            this.tbKhachDua.BorderColor = System.Drawing.Color.Silver;
            this.tbKhachDua.Cursor = System.Windows.Forms.Cursors.IBeam;
            this.tbKhachDua.FocusedBaseColor = System.Drawing.Color.White;
            this.tbKhachDua.FocusedBorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.tbKhachDua.FocusedForeColor = System.Drawing.SystemColors.ControlText;
            this.tbKhachDua.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.tbKhachDua.Location = new System.Drawing.Point(138, 412);
            this.tbKhachDua.Name = "tbKhachDua";
            this.tbKhachDua.PasswordChar = '\0';
            this.tbKhachDua.SelectedText = "";
            this.tbKhachDua.Size = new System.Drawing.Size(160, 30);
            this.tbKhachDua.TabIndex = 6;
            this.tbKhachDua.TextChanged += new System.EventHandler(this.tbKhachDua_TextChanged);
            this.tbKhachDua.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.tbKhachDua_KeyPress);
            // 
            // tbThanhToan
            // 
            this.tbThanhToan.BaseColor = System.Drawing.Color.White;
            this.tbThanhToan.BorderColor = System.Drawing.Color.Silver;
            this.tbThanhToan.Cursor = System.Windows.Forms.Cursors.IBeam;
            this.tbThanhToan.Enabled = false;
            this.tbThanhToan.FocusedBaseColor = System.Drawing.Color.White;
            this.tbThanhToan.FocusedBorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.tbThanhToan.FocusedForeColor = System.Drawing.SystemColors.ControlText;
            this.tbThanhToan.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.tbThanhToan.Location = new System.Drawing.Point(138, 377);
            this.tbThanhToan.Name = "tbThanhToan";
            this.tbThanhToan.PasswordChar = '\0';
            this.tbThanhToan.ReadOnly = true;
            this.tbThanhToan.SelectedText = "";
            this.tbThanhToan.Size = new System.Drawing.Size(160, 30);
            this.tbThanhToan.TabIndex = 7;
            // 
            // tbTienThua
            // 
            this.tbTienThua.BaseColor = System.Drawing.Color.White;
            this.tbTienThua.BorderColor = System.Drawing.Color.Silver;
            this.tbTienThua.Cursor = System.Windows.Forms.Cursors.IBeam;
            this.tbTienThua.Enabled = false;
            this.tbTienThua.FocusedBaseColor = System.Drawing.Color.White;
            this.tbTienThua.FocusedBorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.tbTienThua.FocusedForeColor = System.Drawing.SystemColors.ControlText;
            this.tbTienThua.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.tbTienThua.Location = new System.Drawing.Point(138, 448);
            this.tbTienThua.Name = "tbTienThua";
            this.tbTienThua.PasswordChar = '\0';
            this.tbTienThua.ReadOnly = true;
            this.tbTienThua.SelectedText = "";
            this.tbTienThua.Size = new System.Drawing.Size(160, 30);
            this.tbTienThua.TabIndex = 8;
            // 
            // btTAorDI
            // 
            this.btTAorDI.AnimationHoverSpeed = 0.07F;
            this.btTAorDI.AnimationSpeed = 0.03F;
            this.btTAorDI.BaseColor1 = System.Drawing.Color.SlateBlue;
            this.btTAorDI.BaseColor2 = System.Drawing.Color.Fuchsia;
            this.btTAorDI.BorderColor = System.Drawing.Color.Black;
            this.btTAorDI.DialogResult = System.Windows.Forms.DialogResult.None;
            this.btTAorDI.FocusedColor = System.Drawing.Color.Empty;
            this.btTAorDI.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btTAorDI.ForeColor = System.Drawing.Color.White;
            this.btTAorDI.Image = null;
            this.btTAorDI.ImageSize = new System.Drawing.Size(52, 52);
            this.btTAorDI.Location = new System.Drawing.Point(344, 379);
            this.btTAorDI.Name = "btTAorDI";
            this.btTAorDI.OnHoverBaseColor1 = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(145)))), ((int)(((byte)(221)))));
            this.btTAorDI.OnHoverBaseColor2 = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(85)))), ((int)(((byte)(255)))));
            this.btTAorDI.OnHoverBorderColor = System.Drawing.Color.Black;
            this.btTAorDI.OnHoverForeColor = System.Drawing.Color.White;
            this.btTAorDI.OnHoverImage = null;
            this.btTAorDI.OnPressedColor = System.Drawing.Color.Black;
            this.btTAorDI.Size = new System.Drawing.Size(30, 29);
            this.btTAorDI.TabIndex = 10;
            this.btTAorDI.Text = "TA";
            this.btTAorDI.Click += new System.EventHandler(this.btTAorDI_Click);
            // 
            // btnInHoaDon
            // 
            this.btnInHoaDon.AnimationHoverSpeed = 0.07F;
            this.btnInHoaDon.AnimationSpeed = 0.03F;
            this.btnInHoaDon.BaseColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.btnInHoaDon.BorderColor = System.Drawing.Color.Black;
            this.btnInHoaDon.DialogResult = System.Windows.Forms.DialogResult.None;
            this.btnInHoaDon.Enabled = false;
            this.btnInHoaDon.FocusedColor = System.Drawing.Color.Empty;
            this.btnInHoaDon.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btnInHoaDon.ForeColor = System.Drawing.Color.White;
            this.btnInHoaDon.Image = ((System.Drawing.Image)(resources.GetObject("btnInHoaDon.Image")));
            this.btnInHoaDon.ImageSize = new System.Drawing.Size(20, 20);
            this.btnInHoaDon.Location = new System.Drawing.Point(22, 542);
            this.btnInHoaDon.Name = "btnInHoaDon";
            this.btnInHoaDon.OnHoverBaseColor = System.Drawing.Color.FromArgb(((int)(((byte)(151)))), ((int)(((byte)(143)))), ((int)(((byte)(255)))));
            this.btnInHoaDon.OnHoverBorderColor = System.Drawing.Color.Black;
            this.btnInHoaDon.OnHoverForeColor = System.Drawing.Color.White;
            this.btnInHoaDon.OnHoverImage = null;
            this.btnInHoaDon.OnPressedColor = System.Drawing.Color.Black;
            this.btnInHoaDon.Size = new System.Drawing.Size(44, 20);
            this.btnInHoaDon.TabIndex = 11;
            this.btnInHoaDon.Text = "In hóa đơn";
            this.btnInHoaDon.Visible = false;
            this.btnInHoaDon.Click += new System.EventHandler(this.btnInHoaDon_Click);
            // 
            // btnDong
            // 
            this.btnDong.AnimationHoverSpeed = 0.07F;
            this.btnDong.AnimationSpeed = 0.03F;
            this.btnDong.BaseColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.btnDong.BorderColor = System.Drawing.Color.Black;
            this.btnDong.DialogResult = System.Windows.Forms.DialogResult.None;
            this.btnDong.FocusedColor = System.Drawing.Color.Empty;
            this.btnDong.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btnDong.ForeColor = System.Drawing.Color.White;
            this.btnDong.Image = ((System.Drawing.Image)(resources.GetObject("btnDong.Image")));
            this.btnDong.ImageSize = new System.Drawing.Size(20, 20);
            this.btnDong.Location = new System.Drawing.Point(344, 520);
            this.btnDong.Name = "btnDong";
            this.btnDong.OnHoverBaseColor = System.Drawing.Color.FromArgb(((int)(((byte)(151)))), ((int)(((byte)(143)))), ((int)(((byte)(255)))));
            this.btnDong.OnHoverBorderColor = System.Drawing.Color.Black;
            this.btnDong.OnHoverForeColor = System.Drawing.Color.White;
            this.btnDong.OnHoverImage = null;
            this.btnDong.OnPressedColor = System.Drawing.Color.Black;
            this.btnDong.Size = new System.Drawing.Size(95, 42);
            this.btnDong.TabIndex = 12;
            this.btnDong.Text = "Đóng";
            this.btnDong.Click += new System.EventHandler(this.btnDong_Click);
            // 
            // btnVoucher
            // 
            this.btnVoucher.AnimationHoverSpeed = 0.07F;
            this.btnVoucher.AnimationSpeed = 0.03F;
            this.btnVoucher.BaseColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.btnVoucher.BorderColor = System.Drawing.Color.Black;
            this.btnVoucher.DialogResult = System.Windows.Forms.DialogResult.None;
            this.btnVoucher.FocusedColor = System.Drawing.Color.Empty;
            this.btnVoucher.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btnVoucher.ForeColor = System.Drawing.Color.White;
            this.btnVoucher.Image = ((System.Drawing.Image)(resources.GetObject("btnVoucher.Image")));
            this.btnVoucher.ImageSize = new System.Drawing.Size(20, 20);
            this.btnVoucher.Location = new System.Drawing.Point(344, 344);
            this.btnVoucher.Name = "btnVoucher";
            this.btnVoucher.OnHoverBaseColor = System.Drawing.Color.FromArgb(((int)(((byte)(151)))), ((int)(((byte)(143)))), ((int)(((byte)(255)))));
            this.btnVoucher.OnHoverBorderColor = System.Drawing.Color.Black;
            this.btnVoucher.OnHoverForeColor = System.Drawing.Color.White;
            this.btnVoucher.OnHoverImage = null;
            this.btnVoucher.OnPressedColor = System.Drawing.Color.Black;
            this.btnVoucher.Size = new System.Drawing.Size(97, 29);
            this.btnVoucher.TabIndex = 14;
            this.btnVoucher.Text = "Voucher";
            this.btnVoucher.Click += new System.EventHandler(this.btnVoucher_Click);
            // 
            // btThanhToan
            // 
            this.btThanhToan.AnimationHoverSpeed = 0.07F;
            this.btThanhToan.AnimationSpeed = 0.03F;
            this.btThanhToan.BaseColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.btThanhToan.BorderColor = System.Drawing.Color.Black;
            this.btThanhToan.DialogResult = System.Windows.Forms.DialogResult.None;
            this.btThanhToan.FocusedColor = System.Drawing.Color.Empty;
            this.btThanhToan.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btThanhToan.ForeColor = System.Drawing.Color.White;
            this.btThanhToan.Image = ((System.Drawing.Image)(resources.GetObject("btThanhToan.Image")));
            this.btThanhToan.ImageSize = new System.Drawing.Size(20, 20);
            this.btThanhToan.Location = new System.Drawing.Point(22, 520);
            this.btThanhToan.Name = "btThanhToan";
            this.btThanhToan.OnHoverBaseColor = System.Drawing.Color.FromArgb(((int)(((byte)(151)))), ((int)(((byte)(143)))), ((int)(((byte)(255)))));
            this.btThanhToan.OnHoverBorderColor = System.Drawing.Color.Black;
            this.btThanhToan.OnHoverForeColor = System.Drawing.Color.White;
            this.btThanhToan.OnHoverImage = null;
            this.btThanhToan.OnPressedColor = System.Drawing.Color.Black;
            this.btThanhToan.Size = new System.Drawing.Size(118, 42);
            this.btThanhToan.TabIndex = 16;
            this.btThanhToan.Text = "In Hóa Đơn";
            this.btThanhToan.Click += new System.EventHandler(this.btThanhToan_Click);
            // 
            // reportViewer1
            // 
            reportDataSource1.Name = "DataSet1";
            reportDataSource1.Value = this.dataTable1BindingSource;
            this.reportViewer1.LocalReport.DataSources.Add(reportDataSource1);
            this.reportViewer1.LocalReport.ReportEmbeddedResource = "My_IPOS.bin.Debug.report.Report.rdlc";
            this.reportViewer1.Location = new System.Drawing.Point(20, 253);
            this.reportViewer1.Name = "reportViewer1";
            this.reportViewer1.ServerReport.BearerToken = null;
            this.reportViewer1.Size = new System.Drawing.Size(421, 65);
            this.reportViewer1.TabIndex = 17;
            this.reportViewer1.Visible = false;
            // 
            // dataTable1TableAdapter
            // 
            this.dataTable1TableAdapter.ClearBeforeFill = true;
            // 
            // TongTien
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(192)))));
            this.ClientSize = new System.Drawing.Size(463, 582);
            this.Controls.Add(this.reportViewer1);
            this.Controls.Add(this.btThanhToan);
            this.Controls.Add(this.btnVoucher);
            this.Controls.Add(this.btnDong);
            this.Controls.Add(this.btnInHoaDon);
            this.Controls.Add(this.btTAorDI);
            this.Controls.Add(this.tbTienThua);
            this.Controls.Add(this.tbThanhToan);
            this.Controls.Add(this.tbKhachDua);
            this.Controls.Add(this.tbTheGiamGia);
            this.Controls.Add(this.lbTienThua);
            this.Controls.Add(this.lbKhachDua);
            this.Controls.Add(this.lbThanhToan);
            this.Controls.Add(this.lbTheGiamGia);
            this.Controls.Add(this.dgvTongTien);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "TongTien";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Tổng Tiền";
            this.Load += new System.EventHandler(this.TongTien_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataTable1BindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.my_IPos)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvTongTien)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Guna.UI.WinForms.GunaDataGridView dgvTongTien;
        private Guna.UI.WinForms.GunaLabel lbTheGiamGia;
        private Guna.UI.WinForms.GunaLabel lbThanhToan;
        private Guna.UI.WinForms.GunaLabel lbKhachDua;
        private Guna.UI.WinForms.GunaLabel lbTienThua;
        private Guna.UI.WinForms.GunaTextBox tbTheGiamGia;
        private Guna.UI.WinForms.GunaTextBox tbKhachDua;
        private Guna.UI.WinForms.GunaTextBox tbThanhToan;
        private Guna.UI.WinForms.GunaTextBox tbTienThua;
        private Guna.UI.WinForms.GunaGradientCircleButton btTAorDI;
        private Guna.UI.WinForms.GunaButton btnInHoaDon;
        private Guna.UI.WinForms.GunaButton btnDong;
        private Guna.UI.WinForms.GunaButton btnVoucher;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column1;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column2;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column3;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column4;
        private Guna.UI.WinForms.GunaButton btThanhToan;
        private Microsoft.Reporting.WinForms.ReportViewer reportViewer1;
        private bin.Debug.report.My_IPos my_IPos;
        private System.Windows.Forms.BindingSource dataTable1BindingSource;
        private bin.Debug.report.My_IPosTableAdapters.DataTable1TableAdapter dataTable1TableAdapter;
    }
}