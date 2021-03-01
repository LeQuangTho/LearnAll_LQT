namespace My_IPOS
{
    partial class BaoCao
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(BaoCao));
            this.Title = new System.Windows.Forms.Label();
            this.tbDate = new Guna.UI.WinForms.GunaDateTimePicker();
            this.lbDate = new System.Windows.Forms.Label();
            this.lbDate2 = new System.Windows.Forms.Label();
            this.tbDate2 = new Guna.UI.WinForms.GunaDateTimePicker();
            this.lbTongTien = new System.Windows.Forms.Label();
            this.lbTongVoucher = new System.Windows.Forms.Label();
            this.lbTongHoaDon = new System.Windows.Forms.Label();
            this.tongdoanhthu = new Guna.UI.WinForms.GunaLabel();
            this.tongphieugiamgia = new Guna.UI.WinForms.GunaLabel();
            this.tonghoadon = new Guna.UI.WinForms.GunaLabel();
            this.btTinhDoanhThu = new Guna.UI.WinForms.GunaButton();
            this.SuspendLayout();
            // 
            // Title
            // 
            this.Title.AutoSize = true;
            this.Title.Font = new System.Drawing.Font("Times New Roman", 30F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Title.Location = new System.Drawing.Point(148, 28);
            this.Title.Name = "Title";
            this.Title.Size = new System.Drawing.Size(362, 45);
            this.Title.TabIndex = 0;
            this.Title.Text = "Báo Cáo Doanh Thu";
            // 
            // tbDate
            // 
            this.tbDate.BaseColor = System.Drawing.Color.White;
            this.tbDate.BorderColor = System.Drawing.Color.Silver;
            this.tbDate.CustomFormat = null;
            this.tbDate.DropDownAlign = System.Windows.Forms.LeftRightAlignment.Right;
            this.tbDate.FocusedColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.tbDate.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.tbDate.ForeColor = System.Drawing.Color.Black;
            this.tbDate.Location = new System.Drawing.Point(66, 108);
            this.tbDate.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.tbDate.MaxDate = new System.DateTime(9998, 12, 31, 0, 0, 0, 0);
            this.tbDate.MinDate = new System.DateTime(1753, 1, 1, 0, 0, 0, 0);
            this.tbDate.Name = "tbDate";
            this.tbDate.OnHoverBaseColor = System.Drawing.Color.White;
            this.tbDate.OnHoverBorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.tbDate.OnHoverForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.tbDate.OnPressedColor = System.Drawing.Color.Black;
            this.tbDate.Size = new System.Drawing.Size(223, 30);
            this.tbDate.TabIndex = 1;
            this.tbDate.Text = "Saturday, November 7, 2020";
            this.tbDate.Value = new System.DateTime(2020, 11, 7, 14, 41, 41, 955);
            // 
            // lbDate
            // 
            this.lbDate.AutoSize = true;
            this.lbDate.Font = new System.Drawing.Font("Times New Roman", 11F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbDate.Location = new System.Drawing.Point(28, 119);
            this.lbDate.Name = "lbDate";
            this.lbDate.Size = new System.Drawing.Size(32, 17);
            this.lbDate.TabIndex = 2;
            this.lbDate.Text = "Từ:";
            // 
            // lbDate2
            // 
            this.lbDate2.AutoSize = true;
            this.lbDate2.Font = new System.Drawing.Font("Times New Roman", 11F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbDate2.Location = new System.Drawing.Point(345, 119);
            this.lbDate2.Name = "lbDate2";
            this.lbDate2.Size = new System.Drawing.Size(40, 17);
            this.lbDate2.TabIndex = 3;
            this.lbDate2.Text = "Đến:";
            // 
            // tbDate2
            // 
            this.tbDate2.BaseColor = System.Drawing.Color.White;
            this.tbDate2.BorderColor = System.Drawing.Color.Silver;
            this.tbDate2.CustomFormat = null;
            this.tbDate2.DropDownAlign = System.Windows.Forms.LeftRightAlignment.Right;
            this.tbDate2.FocusedColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.tbDate2.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.tbDate2.ForeColor = System.Drawing.Color.Black;
            this.tbDate2.Location = new System.Drawing.Point(405, 108);
            this.tbDate2.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.tbDate2.MaxDate = new System.DateTime(9998, 12, 31, 0, 0, 0, 0);
            this.tbDate2.MinDate = new System.DateTime(1753, 1, 1, 0, 0, 0, 0);
            this.tbDate2.Name = "tbDate2";
            this.tbDate2.OnHoverBaseColor = System.Drawing.Color.White;
            this.tbDate2.OnHoverBorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.tbDate2.OnHoverForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.tbDate2.OnPressedColor = System.Drawing.Color.Black;
            this.tbDate2.Size = new System.Drawing.Size(223, 30);
            this.tbDate2.TabIndex = 4;
            this.tbDate2.Text = "Saturday, November 7, 2020";
            this.tbDate2.Value = new System.DateTime(2020, 11, 7, 14, 41, 41, 955);
            // 
            // lbTongTien
            // 
            this.lbTongTien.AutoSize = true;
            this.lbTongTien.Font = new System.Drawing.Font("Times New Roman", 11F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbTongTien.Location = new System.Drawing.Point(181, 169);
            this.lbTongTien.Name = "lbTongTien";
            this.lbTongTien.Size = new System.Drawing.Size(115, 17);
            this.lbTongTien.TabIndex = 5;
            this.lbTongTien.Text = "Tổng doanh thu:";
            // 
            // lbTongVoucher
            // 
            this.lbTongVoucher.AutoSize = true;
            this.lbTongVoucher.Font = new System.Drawing.Font("Times New Roman", 11F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbTongVoucher.Location = new System.Drawing.Point(144, 212);
            this.lbTongVoucher.Name = "lbTongVoucher";
            this.lbTongVoucher.Size = new System.Drawing.Size(152, 17);
            this.lbTongVoucher.TabIndex = 6;
            this.lbTongVoucher.Text = "Tổng Phiếu Giảm Giá:";
            // 
            // lbTongHoaDon
            // 
            this.lbTongHoaDon.AutoSize = true;
            this.lbTongHoaDon.Font = new System.Drawing.Font("Times New Roman", 11F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbTongHoaDon.Location = new System.Drawing.Point(187, 264);
            this.lbTongHoaDon.Name = "lbTongHoaDon";
            this.lbTongHoaDon.Size = new System.Drawing.Size(109, 17);
            this.lbTongHoaDon.TabIndex = 7;
            this.lbTongHoaDon.Text = "Tổng Hóa Đơn:";
            // 
            // tongdoanhthu
            // 
            this.tongdoanhthu.AutoSize = true;
            this.tongdoanhthu.BackColor = System.Drawing.Color.White;
            this.tongdoanhthu.Font = new System.Drawing.Font("Segoe UI", 12F);
            this.tongdoanhthu.Location = new System.Drawing.Point(345, 169);
            this.tongdoanhthu.Name = "tongdoanhthu";
            this.tongdoanhthu.Size = new System.Drawing.Size(0, 21);
            this.tongdoanhthu.TabIndex = 8;
            // 
            // tongphieugiamgia
            // 
            this.tongphieugiamgia.AutoSize = true;
            this.tongphieugiamgia.BackColor = System.Drawing.Color.White;
            this.tongphieugiamgia.Font = new System.Drawing.Font("Segoe UI", 12F);
            this.tongphieugiamgia.Location = new System.Drawing.Point(345, 212);
            this.tongphieugiamgia.Name = "tongphieugiamgia";
            this.tongphieugiamgia.Size = new System.Drawing.Size(0, 21);
            this.tongphieugiamgia.TabIndex = 9;
            // 
            // tonghoadon
            // 
            this.tonghoadon.AutoSize = true;
            this.tonghoadon.BackColor = System.Drawing.Color.White;
            this.tonghoadon.Font = new System.Drawing.Font("Segoe UI", 12F);
            this.tonghoadon.Location = new System.Drawing.Point(345, 266);
            this.tonghoadon.Name = "tonghoadon";
            this.tonghoadon.Size = new System.Drawing.Size(0, 21);
            this.tonghoadon.TabIndex = 10;
            // 
            // btTinhDoanhThu
            // 
            this.btTinhDoanhThu.AnimationHoverSpeed = 0.07F;
            this.btTinhDoanhThu.AnimationSpeed = 0.03F;
            this.btTinhDoanhThu.BaseColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.btTinhDoanhThu.BorderColor = System.Drawing.Color.Black;
            this.btTinhDoanhThu.DialogResult = System.Windows.Forms.DialogResult.None;
            this.btTinhDoanhThu.FocusedColor = System.Drawing.Color.Empty;
            this.btTinhDoanhThu.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btTinhDoanhThu.ForeColor = System.Drawing.Color.White;
            this.btTinhDoanhThu.Image = ((System.Drawing.Image)(resources.GetObject("btTinhDoanhThu.Image")));
            this.btTinhDoanhThu.ImageSize = new System.Drawing.Size(20, 20);
            this.btTinhDoanhThu.Location = new System.Drawing.Point(265, 359);
            this.btTinhDoanhThu.Name = "btTinhDoanhThu";
            this.btTinhDoanhThu.OnHoverBaseColor = System.Drawing.Color.FromArgb(((int)(((byte)(151)))), ((int)(((byte)(143)))), ((int)(((byte)(255)))));
            this.btTinhDoanhThu.OnHoverBorderColor = System.Drawing.Color.Black;
            this.btTinhDoanhThu.OnHoverForeColor = System.Drawing.Color.White;
            this.btTinhDoanhThu.OnHoverImage = null;
            this.btTinhDoanhThu.OnPressedColor = System.Drawing.Color.Black;
            this.btTinhDoanhThu.Size = new System.Drawing.Size(130, 75);
            this.btTinhDoanhThu.TabIndex = 11;
            this.btTinhDoanhThu.Text = "Tính Doanh Thu";
            this.btTinhDoanhThu.Click += new System.EventHandler(this.gunaButton1_Click);
            // 
            // BaoCao
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(192)))));
            this.ClientSize = new System.Drawing.Size(662, 446);
            this.Controls.Add(this.btTinhDoanhThu);
            this.Controls.Add(this.tonghoadon);
            this.Controls.Add(this.tongphieugiamgia);
            this.Controls.Add(this.tongdoanhthu);
            this.Controls.Add(this.lbTongHoaDon);
            this.Controls.Add(this.lbTongVoucher);
            this.Controls.Add(this.lbTongTien);
            this.Controls.Add(this.tbDate2);
            this.Controls.Add(this.lbDate2);
            this.Controls.Add(this.lbDate);
            this.Controls.Add(this.tbDate);
            this.Controls.Add(this.Title);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "BaoCao";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "BaoCao";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label Title;
        private Guna.UI.WinForms.GunaDateTimePicker tbDate;
        private System.Windows.Forms.Label lbDate;
        private System.Windows.Forms.Label lbDate2;
        private Guna.UI.WinForms.GunaDateTimePicker tbDate2;
        private System.Windows.Forms.Label lbTongTien;
        private System.Windows.Forms.Label lbTongVoucher;
        private System.Windows.Forms.Label lbTongHoaDon;
        private Guna.UI.WinForms.GunaLabel tongdoanhthu;
        private Guna.UI.WinForms.GunaLabel tongphieugiamgia;
        private Guna.UI.WinForms.GunaLabel tonghoadon;
        private Guna.UI.WinForms.GunaButton btTinhDoanhThu;
    }
}