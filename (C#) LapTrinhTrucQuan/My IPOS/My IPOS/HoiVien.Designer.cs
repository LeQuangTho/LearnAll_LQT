namespace My_IPOS
{
    partial class HoiVien
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(HoiVien));
            this.lbMaHoiVien = new System.Windows.Forms.Label();
            this.lbTenHoiVien = new System.Windows.Forms.Label();
            this.lbNgaySinh = new System.Windows.Forms.Label();
            this.lbDienThoai = new System.Windows.Forms.Label();
            this.lbDiem = new System.Windows.Forms.Label();
            this.tbMaHoiVien = new System.Windows.Forms.TextBox();
            this.tbTenHoiVien = new System.Windows.Forms.TextBox();
            this.tbDienThoai = new System.Windows.Forms.TextBox();
            this.tbDiem = new System.Windows.Forms.TextBox();
            this.dtpNgaySinh = new Guna.UI.WinForms.GunaDateTimePicker();
            this.btChapNhan = new Guna.UI.WinForms.GunaButton();
            this.btDong = new Guna.UI.WinForms.GunaButton();
            this.lbGioiTinh = new System.Windows.Forms.Label();
            this.cbGioiTinh = new System.Windows.Forms.ComboBox();
            this.SuspendLayout();
            // 
            // lbMaHoiVien
            // 
            this.lbMaHoiVien.AutoSize = true;
            this.lbMaHoiVien.Font = new System.Drawing.Font("Times New Roman", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbMaHoiVien.Location = new System.Drawing.Point(46, 57);
            this.lbMaHoiVien.Name = "lbMaHoiVien";
            this.lbMaHoiVien.Size = new System.Drawing.Size(102, 20);
            this.lbMaHoiVien.TabIndex = 0;
            this.lbMaHoiVien.Text = "Mã hội viên";
            // 
            // lbTenHoiVien
            // 
            this.lbTenHoiVien.AutoSize = true;
            this.lbTenHoiVien.Font = new System.Drawing.Font("Times New Roman", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbTenHoiVien.Location = new System.Drawing.Point(46, 100);
            this.lbTenHoiVien.Name = "lbTenHoiVien";
            this.lbTenHoiVien.Size = new System.Drawing.Size(105, 20);
            this.lbTenHoiVien.TabIndex = 1;
            this.lbTenHoiVien.Text = "Tên hội viên";
            // 
            // lbNgaySinh
            // 
            this.lbNgaySinh.AutoSize = true;
            this.lbNgaySinh.Font = new System.Drawing.Font("Times New Roman", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbNgaySinh.Location = new System.Drawing.Point(46, 149);
            this.lbNgaySinh.Name = "lbNgaySinh";
            this.lbNgaySinh.Size = new System.Drawing.Size(86, 20);
            this.lbNgaySinh.TabIndex = 2;
            this.lbNgaySinh.Text = "Ngày sinh";
            // 
            // lbDienThoai
            // 
            this.lbDienThoai.AutoSize = true;
            this.lbDienThoai.Font = new System.Drawing.Font("Times New Roman", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbDienThoai.Location = new System.Drawing.Point(46, 243);
            this.lbDienThoai.Name = "lbDienThoai";
            this.lbDienThoai.Size = new System.Drawing.Size(90, 20);
            this.lbDienThoai.TabIndex = 3;
            this.lbDienThoai.Text = "Điện thoại";
            // 
            // lbDiem
            // 
            this.lbDiem.AutoSize = true;
            this.lbDiem.Font = new System.Drawing.Font("Times New Roman", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbDiem.Location = new System.Drawing.Point(46, 300);
            this.lbDiem.Name = "lbDiem";
            this.lbDiem.Size = new System.Drawing.Size(50, 20);
            this.lbDiem.TabIndex = 5;
            this.lbDiem.Text = "Điểm";
            // 
            // tbMaHoiVien
            // 
            this.tbMaHoiVien.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbMaHoiVien.Location = new System.Drawing.Point(192, 48);
            this.tbMaHoiVien.Name = "tbMaHoiVien";
            this.tbMaHoiVien.Size = new System.Drawing.Size(246, 29);
            this.tbMaHoiVien.TabIndex = 6;
            this.tbMaHoiVien.TextChanged += new System.EventHandler(this.tbMaHoiVien_TextChanged);
            // 
            // tbTenHoiVien
            // 
            this.tbTenHoiVien.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbTenHoiVien.Location = new System.Drawing.Point(192, 91);
            this.tbTenHoiVien.Name = "tbTenHoiVien";
            this.tbTenHoiVien.Size = new System.Drawing.Size(246, 29);
            this.tbTenHoiVien.TabIndex = 7;
            // 
            // tbDienThoai
            // 
            this.tbDienThoai.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbDienThoai.Location = new System.Drawing.Point(192, 234);
            this.tbDienThoai.Name = "tbDienThoai";
            this.tbDienThoai.Size = new System.Drawing.Size(246, 29);
            this.tbDienThoai.TabIndex = 8;
            // 
            // tbDiem
            // 
            this.tbDiem.Enabled = false;
            this.tbDiem.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbDiem.Location = new System.Drawing.Point(192, 291);
            this.tbDiem.Name = "tbDiem";
            this.tbDiem.ReadOnly = true;
            this.tbDiem.Size = new System.Drawing.Size(109, 29);
            this.tbDiem.TabIndex = 10;
            this.tbDiem.Text = "0";
            // 
            // dtpNgaySinh
            // 
            this.dtpNgaySinh.BaseColor = System.Drawing.Color.White;
            this.dtpNgaySinh.BorderColor = System.Drawing.Color.Silver;
            this.dtpNgaySinh.CustomFormat = null;
            this.dtpNgaySinh.DropDownAlign = System.Windows.Forms.LeftRightAlignment.Right;
            this.dtpNgaySinh.FocusedColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.dtpNgaySinh.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.dtpNgaySinh.ForeColor = System.Drawing.Color.Black;
            this.dtpNgaySinh.Location = new System.Drawing.Point(192, 139);
            this.dtpNgaySinh.MaxDate = new System.DateTime(9998, 12, 31, 0, 0, 0, 0);
            this.dtpNgaySinh.MinDate = new System.DateTime(1753, 1, 1, 0, 0, 0, 0);
            this.dtpNgaySinh.Name = "dtpNgaySinh";
            this.dtpNgaySinh.OnHoverBaseColor = System.Drawing.Color.White;
            this.dtpNgaySinh.OnHoverBorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.dtpNgaySinh.OnHoverForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.dtpNgaySinh.OnPressedColor = System.Drawing.Color.Black;
            this.dtpNgaySinh.Size = new System.Drawing.Size(246, 30);
            this.dtpNgaySinh.TabIndex = 11;
            this.dtpNgaySinh.Text = "Wednesday, November 11, 2020";
            this.dtpNgaySinh.Value = new System.DateTime(2020, 11, 11, 16, 25, 25, 491);
            // 
            // btChapNhan
            // 
            this.btChapNhan.AnimationHoverSpeed = 0.07F;
            this.btChapNhan.AnimationSpeed = 0.03F;
            this.btChapNhan.BaseColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.btChapNhan.BorderColor = System.Drawing.Color.Black;
            this.btChapNhan.DialogResult = System.Windows.Forms.DialogResult.None;
            this.btChapNhan.FocusedColor = System.Drawing.Color.Empty;
            this.btChapNhan.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btChapNhan.ForeColor = System.Drawing.Color.White;
            this.btChapNhan.Image = ((System.Drawing.Image)(resources.GetObject("btChapNhan.Image")));
            this.btChapNhan.ImageSize = new System.Drawing.Size(20, 20);
            this.btChapNhan.Location = new System.Drawing.Point(50, 356);
            this.btChapNhan.Name = "btChapNhan";
            this.btChapNhan.OnHoverBaseColor = System.Drawing.Color.FromArgb(((int)(((byte)(151)))), ((int)(((byte)(143)))), ((int)(((byte)(255)))));
            this.btChapNhan.OnHoverBorderColor = System.Drawing.Color.Black;
            this.btChapNhan.OnHoverForeColor = System.Drawing.Color.White;
            this.btChapNhan.OnHoverImage = null;
            this.btChapNhan.OnPressedColor = System.Drawing.Color.Black;
            this.btChapNhan.Size = new System.Drawing.Size(130, 75);
            this.btChapNhan.TabIndex = 12;
            this.btChapNhan.Text = "Chấp nhận";
            this.btChapNhan.Click += new System.EventHandler(this.btChapNhan_Click);
            // 
            // btDong
            // 
            this.btDong.AnimationHoverSpeed = 0.07F;
            this.btDong.AnimationSpeed = 0.03F;
            this.btDong.BaseColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.btDong.BorderColor = System.Drawing.Color.Black;
            this.btDong.DialogResult = System.Windows.Forms.DialogResult.None;
            this.btDong.FocusedColor = System.Drawing.Color.Empty;
            this.btDong.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btDong.ForeColor = System.Drawing.Color.White;
            this.btDong.Image = ((System.Drawing.Image)(resources.GetObject("btDong.Image")));
            this.btDong.ImageSize = new System.Drawing.Size(20, 20);
            this.btDong.Location = new System.Drawing.Point(308, 356);
            this.btDong.Name = "btDong";
            this.btDong.OnHoverBaseColor = System.Drawing.Color.FromArgb(((int)(((byte)(151)))), ((int)(((byte)(143)))), ((int)(((byte)(255)))));
            this.btDong.OnHoverBorderColor = System.Drawing.Color.Black;
            this.btDong.OnHoverForeColor = System.Drawing.Color.White;
            this.btDong.OnHoverImage = null;
            this.btDong.OnPressedColor = System.Drawing.Color.Black;
            this.btDong.Size = new System.Drawing.Size(130, 75);
            this.btDong.TabIndex = 13;
            this.btDong.Text = "Đóng";
            this.btDong.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // lbGioiTinh
            // 
            this.lbGioiTinh.AutoSize = true;
            this.lbGioiTinh.Font = new System.Drawing.Font("Times New Roman", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbGioiTinh.Location = new System.Drawing.Point(46, 196);
            this.lbGioiTinh.Name = "lbGioiTinh";
            this.lbGioiTinh.Size = new System.Drawing.Size(79, 20);
            this.lbGioiTinh.TabIndex = 14;
            this.lbGioiTinh.Text = "Giới tính";
            // 
            // cbGioiTinh
            // 
            this.cbGioiTinh.Font = new System.Drawing.Font("Times New Roman", 11F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cbGioiTinh.FormattingEnabled = true;
            this.cbGioiTinh.Items.AddRange(new object[] {
            "Nam",
            "Nữ"});
            this.cbGioiTinh.Location = new System.Drawing.Point(192, 191);
            this.cbGioiTinh.Name = "cbGioiTinh";
            this.cbGioiTinh.Size = new System.Drawing.Size(59, 25);
            this.cbGioiTinh.TabIndex = 15;
            this.cbGioiTinh.Text = "Nam";
            // 
            // HoiVien
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(192)))));
            this.ClientSize = new System.Drawing.Size(494, 480);
            this.Controls.Add(this.cbGioiTinh);
            this.Controls.Add(this.lbGioiTinh);
            this.Controls.Add(this.btDong);
            this.Controls.Add(this.btChapNhan);
            this.Controls.Add(this.dtpNgaySinh);
            this.Controls.Add(this.tbDiem);
            this.Controls.Add(this.tbDienThoai);
            this.Controls.Add(this.tbTenHoiVien);
            this.Controls.Add(this.tbMaHoiVien);
            this.Controls.Add(this.lbDiem);
            this.Controls.Add(this.lbDienThoai);
            this.Controls.Add(this.lbNgaySinh);
            this.Controls.Add(this.lbTenHoiVien);
            this.Controls.Add(this.lbMaHoiVien);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "HoiVien";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Hội Viên";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lbMaHoiVien;
        private System.Windows.Forms.Label lbTenHoiVien;
        private System.Windows.Forms.Label lbNgaySinh;
        private System.Windows.Forms.Label lbDienThoai;
        private System.Windows.Forms.Label lbDiem;
        private System.Windows.Forms.TextBox tbMaHoiVien;
        private System.Windows.Forms.TextBox tbTenHoiVien;
        private System.Windows.Forms.TextBox tbDienThoai;
        private System.Windows.Forms.TextBox tbDiem;
        private Guna.UI.WinForms.GunaDateTimePicker dtpNgaySinh;
        private Guna.UI.WinForms.GunaButton btChapNhan;
        private Guna.UI.WinForms.GunaButton btDong;
        private System.Windows.Forms.Label lbGioiTinh;
        private System.Windows.Forms.ComboBox cbGioiTinh;
    }
}