namespace My_IPOS
{
    partial class SuaMenu
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(SuaMenu));
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.dgvDanhSachMon = new System.Windows.Forms.DataGridView();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.lbMenhGia = new System.Windows.Forms.Label();
            this.tbDonGia = new System.Windows.Forms.TextBox();
            this.tbTenMon = new System.Windows.Forms.TextBox();
            this.tbMaMon = new System.Windows.Forms.TextBox();
            this.lbDonGia = new System.Windows.Forms.Label();
            this.lbTenMon = new System.Windows.Forms.Label();
            this.lbMaMon = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.btThem = new Guna.UI.WinForms.GunaGradientButton();
            this.btSua = new Guna.UI.WinForms.GunaGradientButton();
            this.btXoa = new Guna.UI.WinForms.GunaGradientButton();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvDanhSachMon)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.dgvDanhSachMon);
            this.groupBox2.Location = new System.Drawing.Point(50, 240);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(628, 177);
            this.groupBox2.TabIndex = 12;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Danh sách món";
            // 
            // dgvDanhSachMon
            // 
            this.dgvDanhSachMon.AllowUserToAddRows = false;
            this.dgvDanhSachMon.AllowUserToDeleteRows = false;
            this.dgvDanhSachMon.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgvDanhSachMon.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvDanhSachMon.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dgvDanhSachMon.EnableHeadersVisualStyles = false;
            this.dgvDanhSachMon.Location = new System.Drawing.Point(3, 16);
            this.dgvDanhSachMon.MultiSelect = false;
            this.dgvDanhSachMon.Name = "dgvDanhSachMon";
            this.dgvDanhSachMon.ReadOnly = true;
            this.dgvDanhSachMon.RowTemplate.Height = 26;
            this.dgvDanhSachMon.RowTemplate.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.dgvDanhSachMon.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvDanhSachMon.Size = new System.Drawing.Size(622, 158);
            this.dgvDanhSachMon.TabIndex = 0;
            this.dgvDanhSachMon.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvDanhSachMon_CellClick);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.lbMenhGia);
            this.groupBox1.Controls.Add(this.tbDonGia);
            this.groupBox1.Controls.Add(this.tbTenMon);
            this.groupBox1.Controls.Add(this.tbMaMon);
            this.groupBox1.Controls.Add(this.lbDonGia);
            this.groupBox1.Controls.Add(this.lbTenMon);
            this.groupBox1.Controls.Add(this.lbMaMon);
            this.groupBox1.Location = new System.Drawing.Point(53, 64);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(628, 158);
            this.groupBox1.TabIndex = 11;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Thông tin công việc";
            // 
            // lbMenhGia
            // 
            this.lbMenhGia.AutoSize = true;
            this.lbMenhGia.Font = new System.Drawing.Font("Times New Roman", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbMenhGia.Location = new System.Drawing.Point(374, 113);
            this.lbMenhGia.Name = "lbMenhGia";
            this.lbMenhGia.Size = new System.Drawing.Size(29, 17);
            this.lbMenhGia.TabIndex = 6;
            this.lbMenhGia.Text = "vnđ";
            // 
            // tbDonGia
            // 
            this.tbDonGia.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbDonGia.Location = new System.Drawing.Point(230, 104);
            this.tbDonGia.Name = "tbDonGia";
            this.tbDonGia.Size = new System.Drawing.Size(138, 26);
            this.tbDonGia.TabIndex = 5;
            this.tbDonGia.TextChanged += new System.EventHandler(this.tbLDonGia_TextChanged);
            this.tbDonGia.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.tbLDonGia_KeyPress);
            // 
            // tbTenMon
            // 
            this.tbTenMon.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbTenMon.Location = new System.Drawing.Point(230, 60);
            this.tbTenMon.Name = "tbTenMon";
            this.tbTenMon.Size = new System.Drawing.Size(285, 26);
            this.tbTenMon.TabIndex = 4;
            this.tbTenMon.TextChanged += new System.EventHandler(this.tbLDonGia_TextChanged);
            // 
            // tbMaMon
            // 
            this.tbMaMon.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbMaMon.Location = new System.Drawing.Point(230, 22);
            this.tbMaMon.Name = "tbMaMon";
            this.tbMaMon.ReadOnly = true;
            this.tbMaMon.Size = new System.Drawing.Size(285, 26);
            this.tbMaMon.TabIndex = 3;
            this.tbMaMon.TextChanged += new System.EventHandler(this.tbLDonGia_TextChanged);
            // 
            // lbDonGia
            // 
            this.lbDonGia.AutoSize = true;
            this.lbDonGia.Font = new System.Drawing.Font("Times New Roman", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbDonGia.Location = new System.Drawing.Point(106, 113);
            this.lbDonGia.Name = "lbDonGia";
            this.lbDonGia.Size = new System.Drawing.Size(59, 17);
            this.lbDonGia.TabIndex = 2;
            this.lbDonGia.Text = "Đơn Giá";
            // 
            // lbTenMon
            // 
            this.lbTenMon.AutoSize = true;
            this.lbTenMon.Font = new System.Drawing.Font("Times New Roman", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbTenMon.Location = new System.Drawing.Point(106, 69);
            this.lbTenMon.Name = "lbTenMon";
            this.lbTenMon.Size = new System.Drawing.Size(62, 17);
            this.lbTenMon.TabIndex = 1;
            this.lbTenMon.Text = "Tên Món";
            // 
            // lbMaMon
            // 
            this.lbMaMon.AutoSize = true;
            this.lbMaMon.Font = new System.Drawing.Font("Times New Roman", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbMaMon.Location = new System.Drawing.Point(106, 31);
            this.lbMaMon.Name = "lbMaMon";
            this.lbMaMon.Size = new System.Drawing.Size(58, 17);
            this.lbMaMon.TabIndex = 0;
            this.lbMaMon.Text = "Mã Món";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Times New Roman", 30F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(275, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(175, 45);
            this.label1.TabIndex = 13;
            this.label1.Text = "Sửa Món";
            // 
            // btThem
            // 
            this.btThem.AnimationHoverSpeed = 0.07F;
            this.btThem.AnimationSpeed = 0.03F;
            this.btThem.BaseColor1 = System.Drawing.Color.SlateBlue;
            this.btThem.BaseColor2 = System.Drawing.Color.Fuchsia;
            this.btThem.BorderColor = System.Drawing.Color.Black;
            this.btThem.DialogResult = System.Windows.Forms.DialogResult.None;
            this.btThem.FocusedColor = System.Drawing.Color.Empty;
            this.btThem.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btThem.ForeColor = System.Drawing.Color.White;
            this.btThem.Image = ((System.Drawing.Image)(resources.GetObject("btThem.Image")));
            this.btThem.ImageSize = new System.Drawing.Size(20, 20);
            this.btThem.Location = new System.Drawing.Point(148, 436);
            this.btThem.Name = "btThem";
            this.btThem.OnHoverBaseColor1 = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(145)))), ((int)(((byte)(221)))));
            this.btThem.OnHoverBaseColor2 = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(85)))), ((int)(((byte)(255)))));
            this.btThem.OnHoverBorderColor = System.Drawing.Color.Black;
            this.btThem.OnHoverForeColor = System.Drawing.Color.White;
            this.btThem.OnHoverImage = null;
            this.btThem.OnPressedColor = System.Drawing.Color.Black;
            this.btThem.Size = new System.Drawing.Size(92, 42);
            this.btThem.TabIndex = 14;
            this.btThem.Text = "Thêm";
            this.btThem.Click += new System.EventHandler(this.btThem_Click);
            // 
            // btSua
            // 
            this.btSua.AnimationHoverSpeed = 0.07F;
            this.btSua.AnimationSpeed = 0.03F;
            this.btSua.BaseColor1 = System.Drawing.Color.SlateBlue;
            this.btSua.BaseColor2 = System.Drawing.Color.Fuchsia;
            this.btSua.BorderColor = System.Drawing.Color.Black;
            this.btSua.DialogResult = System.Windows.Forms.DialogResult.None;
            this.btSua.FocusedColor = System.Drawing.Color.Empty;
            this.btSua.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btSua.ForeColor = System.Drawing.Color.White;
            this.btSua.Image = ((System.Drawing.Image)(resources.GetObject("btSua.Image")));
            this.btSua.ImageSize = new System.Drawing.Size(20, 20);
            this.btSua.Location = new System.Drawing.Point(329, 436);
            this.btSua.Name = "btSua";
            this.btSua.OnHoverBaseColor1 = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(145)))), ((int)(((byte)(221)))));
            this.btSua.OnHoverBaseColor2 = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(85)))), ((int)(((byte)(255)))));
            this.btSua.OnHoverBorderColor = System.Drawing.Color.Black;
            this.btSua.OnHoverForeColor = System.Drawing.Color.White;
            this.btSua.OnHoverImage = null;
            this.btSua.OnPressedColor = System.Drawing.Color.Black;
            this.btSua.Size = new System.Drawing.Size(92, 42);
            this.btSua.TabIndex = 15;
            this.btSua.Text = "Sửa";
            this.btSua.Click += new System.EventHandler(this.btSua_Click);
            // 
            // btXoa
            // 
            this.btXoa.AnimationHoverSpeed = 0.07F;
            this.btXoa.AnimationSpeed = 0.03F;
            this.btXoa.BaseColor1 = System.Drawing.Color.SlateBlue;
            this.btXoa.BaseColor2 = System.Drawing.Color.Fuchsia;
            this.btXoa.BorderColor = System.Drawing.Color.Black;
            this.btXoa.DialogResult = System.Windows.Forms.DialogResult.None;
            this.btXoa.FocusedColor = System.Drawing.Color.Empty;
            this.btXoa.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btXoa.ForeColor = System.Drawing.Color.White;
            this.btXoa.Image = ((System.Drawing.Image)(resources.GetObject("btXoa.Image")));
            this.btXoa.ImageSize = new System.Drawing.Size(20, 20);
            this.btXoa.Location = new System.Drawing.Point(493, 436);
            this.btXoa.Name = "btXoa";
            this.btXoa.OnHoverBaseColor1 = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(145)))), ((int)(((byte)(221)))));
            this.btXoa.OnHoverBaseColor2 = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(85)))), ((int)(((byte)(255)))));
            this.btXoa.OnHoverBorderColor = System.Drawing.Color.Black;
            this.btXoa.OnHoverForeColor = System.Drawing.Color.White;
            this.btXoa.OnHoverImage = null;
            this.btXoa.OnPressedColor = System.Drawing.Color.Black;
            this.btXoa.Size = new System.Drawing.Size(92, 42);
            this.btXoa.TabIndex = 16;
            this.btXoa.Text = "Xóa";
            this.btXoa.Click += new System.EventHandler(this.btXoa_Click);
            // 
            // SuaMenu
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(232)))), ((int)(((byte)(232)))));
            this.ClientSize = new System.Drawing.Size(729, 490);
            this.Controls.Add(this.btXoa);
            this.Controls.Add(this.btSua);
            this.Controls.Add(this.btThem);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "SuaMenu";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Sửa Món";
            this.Load += new System.EventHandler(this.SuaMenu_Load);
            this.groupBox2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dgvDanhSachMon)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.DataGridView dgvDanhSachMon;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TextBox tbDonGia;
        private System.Windows.Forms.TextBox tbTenMon;
        private System.Windows.Forms.TextBox tbMaMon;
        private System.Windows.Forms.Label lbDonGia;
        private System.Windows.Forms.Label lbTenMon;
        private System.Windows.Forms.Label lbMaMon;
        private System.Windows.Forms.Label label1;
        private Guna.UI.WinForms.GunaGradientButton btThem;
        private Guna.UI.WinForms.GunaGradientButton btSua;
        private Guna.UI.WinForms.GunaGradientButton btXoa;
        private System.Windows.Forms.Label lbMenhGia;
    }
}