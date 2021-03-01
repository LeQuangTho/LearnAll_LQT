namespace Baitap27
{
    partial class Form1
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
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.mnuDanhMuc = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuChatLieu = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuNhanVien = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuKhachHang = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuHangHoa = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuHoaDon = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuHoaDonBan = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuTimKiem = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuTKHoaDon = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuTKKhachHang = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuTKHang = new System.Windows.Forms.ToolStripMenuItem();
            this.mnBaoCao = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuHangTon = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuDoanhThu = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuTroGiup = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuThoat = new System.Windows.Forms.ToolStripMenuItem();
            this.lbTitle1 = new System.Windows.Forms.Label();
            this.lbTitle2 = new System.Windows.Forms.Label();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.mnuDanhMuc,
            this.mnuHoaDon,
            this.mnuTimKiem,
            this.mnBaoCao,
            this.mnuTroGiup,
            this.mnuThoat});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(441, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // mnuDanhMuc
            // 
            this.mnuDanhMuc.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.mnuChatLieu,
            this.mnuNhanVien,
            this.mnuKhachHang,
            this.mnuHangHoa});
            this.mnuDanhMuc.Name = "mnuDanhMuc";
            this.mnuDanhMuc.Size = new System.Drawing.Size(74, 20);
            this.mnuDanhMuc.Text = "Danh Mục";
            // 
            // mnuChatLieu
            // 
            this.mnuChatLieu.Name = "mnuChatLieu";
            this.mnuChatLieu.Size = new System.Drawing.Size(180, 22);
            this.mnuChatLieu.Text = "Chất Liệu";
            // 
            // mnuNhanVien
            // 
            this.mnuNhanVien.Name = "mnuNhanVien";
            this.mnuNhanVien.Size = new System.Drawing.Size(180, 22);
            this.mnuNhanVien.Text = "Nhân Viên";
            this.mnuNhanVien.Click += new System.EventHandler(this.mnuNhanVien_Click);
            // 
            // mnuKhachHang
            // 
            this.mnuKhachHang.Name = "mnuKhachHang";
            this.mnuKhachHang.Size = new System.Drawing.Size(180, 22);
            this.mnuKhachHang.Text = "Khách Hàng";
            // 
            // mnuHangHoa
            // 
            this.mnuHangHoa.Name = "mnuHangHoa";
            this.mnuHangHoa.Size = new System.Drawing.Size(180, 22);
            this.mnuHangHoa.Text = "Hàng Hóa";
            this.mnuHangHoa.Click += new System.EventHandler(this.mnuHangHoa_Click);
            // 
            // mnuHoaDon
            // 
            this.mnuHoaDon.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.mnuHoaDonBan});
            this.mnuHoaDon.Name = "mnuHoaDon";
            this.mnuHoaDon.Size = new System.Drawing.Size(66, 20);
            this.mnuHoaDon.Text = "Hóa Đơn";
            // 
            // mnuHoaDonBan
            // 
            this.mnuHoaDonBan.Name = "mnuHoaDonBan";
            this.mnuHoaDonBan.Size = new System.Drawing.Size(180, 22);
            this.mnuHoaDonBan.Text = "Hóa Đơn Bán";
            this.mnuHoaDonBan.Click += new System.EventHandler(this.mnuHoaDonBan_Click);
            // 
            // mnuTimKiem
            // 
            this.mnuTimKiem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.mnuTKHoaDon,
            this.mnuTKKhachHang,
            this.mnuTKHang});
            this.mnuTimKiem.Name = "mnuTimKiem";
            this.mnuTimKiem.Size = new System.Drawing.Size(69, 20);
            this.mnuTimKiem.Text = "Tìm Kiếm";
            // 
            // mnuTKHoaDon
            // 
            this.mnuTKHoaDon.Name = "mnuTKHoaDon";
            this.mnuTKHoaDon.Size = new System.Drawing.Size(139, 22);
            this.mnuTKHoaDon.Text = "Hóa Đơn";
            // 
            // mnuTKKhachHang
            // 
            this.mnuTKKhachHang.Name = "mnuTKKhachHang";
            this.mnuTKKhachHang.Size = new System.Drawing.Size(139, 22);
            this.mnuTKKhachHang.Text = "Khách Hàng";
            // 
            // mnuTKHang
            // 
            this.mnuTKHang.Name = "mnuTKHang";
            this.mnuTKHang.Size = new System.Drawing.Size(139, 22);
            this.mnuTKHang.Text = "Hàng";
            // 
            // mnBaoCao
            // 
            this.mnBaoCao.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.mnuHangTon,
            this.mnuDoanhThu});
            this.mnBaoCao.Name = "mnBaoCao";
            this.mnBaoCao.Size = new System.Drawing.Size(63, 20);
            this.mnBaoCao.Text = "Báo Cáo";
            // 
            // mnuHangTon
            // 
            this.mnuHangTon.Name = "mnuHangTon";
            this.mnuHangTon.Size = new System.Drawing.Size(132, 22);
            this.mnuHangTon.Text = "Hàng Tồn";
            // 
            // mnuDoanhThu
            // 
            this.mnuDoanhThu.Name = "mnuDoanhThu";
            this.mnuDoanhThu.Size = new System.Drawing.Size(132, 22);
            this.mnuDoanhThu.Text = "Doanh Thu";
            // 
            // mnuTroGiup
            // 
            this.mnuTroGiup.Name = "mnuTroGiup";
            this.mnuTroGiup.Size = new System.Drawing.Size(63, 20);
            this.mnuTroGiup.Text = "Trợ Giúp";
            // 
            // mnuThoat
            // 
            this.mnuThoat.Name = "mnuThoat";
            this.mnuThoat.Size = new System.Drawing.Size(49, 20);
            this.mnuThoat.Text = "Thoát";
            // 
            // lbTitle1
            // 
            this.lbTitle1.AutoSize = true;
            this.lbTitle1.Location = new System.Drawing.Point(84, 84);
            this.lbTitle1.Name = "lbTitle1";
            this.lbTitle1.Size = new System.Drawing.Size(114, 13);
            this.lbTitle1.TabIndex = 1;
            this.lbTitle1.Text = "Chương Trình Quản Lý";
            // 
            // lbTitle2
            // 
            this.lbTitle2.AutoSize = true;
            this.lbTitle2.Location = new System.Drawing.Point(84, 134);
            this.lbTitle2.Name = "lbTitle2";
            this.lbTitle2.Size = new System.Drawing.Size(103, 13);
            this.lbTitle2.TabIndex = 2;
            this.lbTitle2.Text = "Bán Hàng Lưu Niệm";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(441, 334);
            this.Controls.Add(this.lbTitle2);
            this.Controls.Add(this.lbTitle1);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form1";
            this.Text = "Form1";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem mnuDanhMuc;
        private System.Windows.Forms.ToolStripMenuItem mnuChatLieu;
        private System.Windows.Forms.ToolStripMenuItem mnuNhanVien;
        private System.Windows.Forms.ToolStripMenuItem mnuKhachHang;
        private System.Windows.Forms.ToolStripMenuItem mnuHangHoa;
        private System.Windows.Forms.ToolStripMenuItem mnuHoaDon;
        private System.Windows.Forms.ToolStripMenuItem mnuHoaDonBan;
        private System.Windows.Forms.ToolStripMenuItem mnuTimKiem;
        private System.Windows.Forms.ToolStripMenuItem mnuTKHoaDon;
        private System.Windows.Forms.ToolStripMenuItem mnuTKKhachHang;
        private System.Windows.Forms.ToolStripMenuItem mnuTKHang;
        private System.Windows.Forms.ToolStripMenuItem mnBaoCao;
        private System.Windows.Forms.ToolStripMenuItem mnuHangTon;
        private System.Windows.Forms.ToolStripMenuItem mnuDoanhThu;
        private System.Windows.Forms.ToolStripMenuItem mnuTroGiup;
        private System.Windows.Forms.ToolStripMenuItem mnuThoat;
        private System.Windows.Forms.Label lbTitle1;
        private System.Windows.Forms.Label lbTitle2;
    }
}

