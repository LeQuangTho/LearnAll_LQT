namespace Baitap27
{
    partial class Form4
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
            this.label1 = new System.Windows.Forms.Label();
            this.grbThongTinChung = new System.Windows.Forms.GroupBox();
            this.dtpNgayBan = new Guna.UI.WinForms.GunaDateTimePicker();
            this.tbSoDienThoai = new System.Windows.Forms.MaskedTextBox();
            this.tbTenKhachHang = new System.Windows.Forms.MaskedTextBox();
            this.tbDiaChi = new System.Windows.Forms.MaskedTextBox();
            this.tbTenNhanVien = new System.Windows.Forms.MaskedTextBox();
            this.tbMaHoaDon = new System.Windows.Forms.TextBox();
            this.cbbMaNhanVien = new System.Windows.Forms.ComboBox();
            this.cbbMaKhachHang = new System.Windows.Forms.ComboBox();
            this.lbSoDienThoai = new System.Windows.Forms.Label();
            this.blDiaChi = new System.Windows.Forms.Label();
            this.lbTenKhachHang = new System.Windows.Forms.Label();
            this.lbMaKhachHang = new System.Windows.Forms.Label();
            this.lbTenNhanVien = new System.Windows.Forms.Label();
            this.lbMaNhanVien = new System.Windows.Forms.Label();
            this.lbNgayban = new System.Windows.Forms.Label();
            this.lbMaHoaDon = new System.Windows.Forms.Label();
            this.grbThongTinMatHang = new System.Windows.Forms.GroupBox();
            this.cbbMaHang = new System.Windows.Forms.ComboBox();
            this.btnDong = new System.Windows.Forms.Button();
            this.btnInHoaDon = new System.Windows.Forms.Button();
            this.btnHuyHoaDon = new System.Windows.Forms.Button();
            this.btnLuu = new System.Windows.Forms.Button();
            this.btnThemHoaDon = new System.Windows.Forms.Button();
            this.lbBangChu = new System.Windows.Forms.Label();
            this.tbTongTien = new System.Windows.Forms.MaskedTextBox();
            this.lbTongTien = new System.Windows.Forms.Label();
            this.lbDelete = new System.Windows.Forms.Label();
            this.dgvHoaDonBan = new System.Windows.Forms.DataGridView();
            this.tbThanhTien = new System.Windows.Forms.MaskedTextBox();
            this.tbDonGia = new System.Windows.Forms.MaskedTextBox();
            this.lbThanhTien = new System.Windows.Forms.Label();
            this.lbDonGia = new System.Windows.Forms.Label();
            this.tbGiamGia = new System.Windows.Forms.MaskedTextBox();
            this.tbTenHang = new System.Windows.Forms.MaskedTextBox();
            this.lbGiamGia = new System.Windows.Forms.Label();
            this.tbSoLuong = new System.Windows.Forms.MaskedTextBox();
            this.lbSoLuong = new System.Windows.Forms.Label();
            this.lbTenHang = new System.Windows.Forms.Label();
            this.lbMaHang = new System.Windows.Forms.Label();
            this.lbTimHoaDon = new System.Windows.Forms.Label();
            this.cbbTimHoaDon = new System.Windows.Forms.ComboBox();
            this.btnTimKiem = new System.Windows.Forms.Button();
            this.grbThongTinChung.SuspendLayout();
            this.grbThongTinMatHang.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvHoaDonBan)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(269, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(174, 24);
            this.label1.TabIndex = 0;
            this.label1.Text = "Hóa Đơn Bán Hàng";
            // 
            // grbThongTinChung
            // 
            this.grbThongTinChung.Controls.Add(this.dtpNgayBan);
            this.grbThongTinChung.Controls.Add(this.tbSoDienThoai);
            this.grbThongTinChung.Controls.Add(this.tbTenKhachHang);
            this.grbThongTinChung.Controls.Add(this.tbDiaChi);
            this.grbThongTinChung.Controls.Add(this.tbTenNhanVien);
            this.grbThongTinChung.Controls.Add(this.tbMaHoaDon);
            this.grbThongTinChung.Controls.Add(this.cbbMaNhanVien);
            this.grbThongTinChung.Controls.Add(this.cbbMaKhachHang);
            this.grbThongTinChung.Controls.Add(this.lbSoDienThoai);
            this.grbThongTinChung.Controls.Add(this.blDiaChi);
            this.grbThongTinChung.Controls.Add(this.lbTenKhachHang);
            this.grbThongTinChung.Controls.Add(this.lbMaKhachHang);
            this.grbThongTinChung.Controls.Add(this.lbTenNhanVien);
            this.grbThongTinChung.Controls.Add(this.lbMaNhanVien);
            this.grbThongTinChung.Controls.Add(this.lbNgayban);
            this.grbThongTinChung.Controls.Add(this.lbMaHoaDon);
            this.grbThongTinChung.Location = new System.Drawing.Point(13, 40);
            this.grbThongTinChung.Name = "grbThongTinChung";
            this.grbThongTinChung.Size = new System.Drawing.Size(669, 140);
            this.grbThongTinChung.TabIndex = 1;
            this.grbThongTinChung.TabStop = false;
            this.grbThongTinChung.Text = "Thông Tin Chung";
            // 
            // dtpNgayBan
            // 
            this.dtpNgayBan.BaseColor = System.Drawing.Color.White;
            this.dtpNgayBan.BorderColor = System.Drawing.Color.Silver;
            this.dtpNgayBan.CustomFormat = null;
            this.dtpNgayBan.DropDownAlign = System.Windows.Forms.LeftRightAlignment.Right;
            this.dtpNgayBan.FocusedColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.dtpNgayBan.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.dtpNgayBan.ForeColor = System.Drawing.Color.Black;
            this.dtpNgayBan.Format = System.Windows.Forms.DateTimePickerFormat.Short;
            this.dtpNgayBan.Location = new System.Drawing.Point(107, 38);
            this.dtpNgayBan.MaxDate = new System.DateTime(9998, 12, 31, 0, 0, 0, 0);
            this.dtpNgayBan.MinDate = new System.DateTime(1753, 1, 1, 0, 0, 0, 0);
            this.dtpNgayBan.Name = "dtpNgayBan";
            this.dtpNgayBan.OnHoverBaseColor = System.Drawing.Color.White;
            this.dtpNgayBan.OnHoverBorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.dtpNgayBan.OnHoverForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.dtpNgayBan.OnPressedColor = System.Drawing.Color.Black;
            this.dtpNgayBan.Size = new System.Drawing.Size(147, 23);
            this.dtpNgayBan.TabIndex = 16;
            this.dtpNgayBan.Text = "10/22/2020";
            this.dtpNgayBan.Value = new System.DateTime(2020, 10, 22, 7, 56, 33, 480);
            // 
            // tbSoDienThoai
            // 
            this.tbSoDienThoai.Enabled = false;
            this.tbSoDienThoai.Location = new System.Drawing.Point(487, 94);
            this.tbSoDienThoai.Name = "tbSoDienThoai";
            this.tbSoDienThoai.Size = new System.Drawing.Size(160, 20);
            this.tbSoDienThoai.TabIndex = 15;
            // 
            // tbTenKhachHang
            // 
            this.tbTenKhachHang.Enabled = false;
            this.tbTenKhachHang.Location = new System.Drawing.Point(487, 39);
            this.tbTenKhachHang.Name = "tbTenKhachHang";
            this.tbTenKhachHang.Size = new System.Drawing.Size(160, 20);
            this.tbTenKhachHang.TabIndex = 14;
            // 
            // tbDiaChi
            // 
            this.tbDiaChi.Enabled = false;
            this.tbDiaChi.Location = new System.Drawing.Point(487, 68);
            this.tbDiaChi.Name = "tbDiaChi";
            this.tbDiaChi.Size = new System.Drawing.Size(160, 20);
            this.tbDiaChi.TabIndex = 13;
            // 
            // tbTenNhanVien
            // 
            this.tbTenNhanVien.Enabled = false;
            this.tbTenNhanVien.Location = new System.Drawing.Point(107, 97);
            this.tbTenNhanVien.Name = "tbTenNhanVien";
            this.tbTenNhanVien.Size = new System.Drawing.Size(147, 20);
            this.tbTenNhanVien.TabIndex = 12;
            // 
            // tbMaHoaDon
            // 
            this.tbMaHoaDon.Location = new System.Drawing.Point(107, 12);
            this.tbMaHoaDon.Name = "tbMaHoaDon";
            this.tbMaHoaDon.Size = new System.Drawing.Size(147, 20);
            this.tbMaHoaDon.TabIndex = 11;
            // 
            // cbbMaNhanVien
            // 
            this.cbbMaNhanVien.FormattingEnabled = true;
            this.cbbMaNhanVien.Location = new System.Drawing.Point(107, 67);
            this.cbbMaNhanVien.Name = "cbbMaNhanVien";
            this.cbbMaNhanVien.Size = new System.Drawing.Size(147, 21);
            this.cbbMaNhanVien.TabIndex = 9;
            this.cbbMaNhanVien.SelectedIndexChanged += new System.EventHandler(this.cbbMaNhanVien_SelectedIndexChanged);
            // 
            // cbbMaKhachHang
            // 
            this.cbbMaKhachHang.FormattingEnabled = true;
            this.cbbMaKhachHang.Location = new System.Drawing.Point(487, 12);
            this.cbbMaKhachHang.Name = "cbbMaKhachHang";
            this.cbbMaKhachHang.Size = new System.Drawing.Size(160, 21);
            this.cbbMaKhachHang.TabIndex = 8;
            this.cbbMaKhachHang.SelectedIndexChanged += new System.EventHandler(this.cbbMaKhachHang_SelectedIndexChanged);
            // 
            // lbSoDienThoai
            // 
            this.lbSoDienThoai.AutoSize = true;
            this.lbSoDienThoai.Location = new System.Drawing.Point(355, 104);
            this.lbSoDienThoai.Name = "lbSoDienThoai";
            this.lbSoDienThoai.Size = new System.Drawing.Size(75, 13);
            this.lbSoDienThoai.TabIndex = 7;
            this.lbSoDienThoai.Text = "Số Điện Thoại";
            // 
            // blDiaChi
            // 
            this.blDiaChi.AutoSize = true;
            this.blDiaChi.Location = new System.Drawing.Point(355, 75);
            this.blDiaChi.Name = "blDiaChi";
            this.blDiaChi.Size = new System.Drawing.Size(41, 13);
            this.blDiaChi.TabIndex = 6;
            this.blDiaChi.Text = "Địa Chỉ";
            // 
            // lbTenKhachHang
            // 
            this.lbTenKhachHang.AutoSize = true;
            this.lbTenKhachHang.Location = new System.Drawing.Point(355, 48);
            this.lbTenKhachHang.Name = "lbTenKhachHang";
            this.lbTenKhachHang.Size = new System.Drawing.Size(89, 13);
            this.lbTenKhachHang.TabIndex = 5;
            this.lbTenKhachHang.Text = "Tên Khách Hàng";
            // 
            // lbMaKhachHang
            // 
            this.lbMaKhachHang.AutoSize = true;
            this.lbMaKhachHang.Location = new System.Drawing.Point(355, 20);
            this.lbMaKhachHang.Name = "lbMaKhachHang";
            this.lbMaKhachHang.Size = new System.Drawing.Size(85, 13);
            this.lbMaKhachHang.TabIndex = 4;
            this.lbMaKhachHang.Text = "Mã Khách Hàng";
            // 
            // lbTenNhanVien
            // 
            this.lbTenNhanVien.AutoSize = true;
            this.lbTenNhanVien.Location = new System.Drawing.Point(7, 104);
            this.lbTenNhanVien.Name = "lbTenNhanVien";
            this.lbTenNhanVien.Size = new System.Drawing.Size(79, 13);
            this.lbTenNhanVien.TabIndex = 3;
            this.lbTenNhanVien.Text = "Tên Nhân Viên";
            // 
            // lbMaNhanVien
            // 
            this.lbMaNhanVien.AutoSize = true;
            this.lbMaNhanVien.Location = new System.Drawing.Point(7, 75);
            this.lbMaNhanVien.Name = "lbMaNhanVien";
            this.lbMaNhanVien.Size = new System.Drawing.Size(75, 13);
            this.lbMaNhanVien.TabIndex = 2;
            this.lbMaNhanVien.Text = "Mã Nhân Viên";
            // 
            // lbNgayban
            // 
            this.lbNgayban.AutoSize = true;
            this.lbNgayban.Location = new System.Drawing.Point(7, 48);
            this.lbNgayban.Name = "lbNgayban";
            this.lbNgayban.Size = new System.Drawing.Size(54, 13);
            this.lbNgayban.TabIndex = 1;
            this.lbNgayban.Text = "Ngày Bán";
            // 
            // lbMaHoaDon
            // 
            this.lbMaHoaDon.AutoSize = true;
            this.lbMaHoaDon.Location = new System.Drawing.Point(7, 20);
            this.lbMaHoaDon.Name = "lbMaHoaDon";
            this.lbMaHoaDon.Size = new System.Drawing.Size(68, 13);
            this.lbMaHoaDon.TabIndex = 0;
            this.lbMaHoaDon.Text = "Mã Hóa Đơn";
            // 
            // grbThongTinMatHang
            // 
            this.grbThongTinMatHang.Controls.Add(this.cbbMaHang);
            this.grbThongTinMatHang.Controls.Add(this.btnDong);
            this.grbThongTinMatHang.Controls.Add(this.btnInHoaDon);
            this.grbThongTinMatHang.Controls.Add(this.btnHuyHoaDon);
            this.grbThongTinMatHang.Controls.Add(this.btnLuu);
            this.grbThongTinMatHang.Controls.Add(this.btnThemHoaDon);
            this.grbThongTinMatHang.Controls.Add(this.lbBangChu);
            this.grbThongTinMatHang.Controls.Add(this.tbTongTien);
            this.grbThongTinMatHang.Controls.Add(this.lbTongTien);
            this.grbThongTinMatHang.Controls.Add(this.lbDelete);
            this.grbThongTinMatHang.Controls.Add(this.dgvHoaDonBan);
            this.grbThongTinMatHang.Controls.Add(this.tbThanhTien);
            this.grbThongTinMatHang.Controls.Add(this.tbDonGia);
            this.grbThongTinMatHang.Controls.Add(this.lbThanhTien);
            this.grbThongTinMatHang.Controls.Add(this.lbDonGia);
            this.grbThongTinMatHang.Controls.Add(this.tbGiamGia);
            this.grbThongTinMatHang.Controls.Add(this.tbTenHang);
            this.grbThongTinMatHang.Controls.Add(this.lbGiamGia);
            this.grbThongTinMatHang.Controls.Add(this.tbSoLuong);
            this.grbThongTinMatHang.Controls.Add(this.lbSoLuong);
            this.grbThongTinMatHang.Controls.Add(this.lbTenHang);
            this.grbThongTinMatHang.Controls.Add(this.lbMaHang);
            this.grbThongTinMatHang.Location = new System.Drawing.Point(13, 224);
            this.grbThongTinMatHang.Name = "grbThongTinMatHang";
            this.grbThongTinMatHang.Size = new System.Drawing.Size(669, 294);
            this.grbThongTinMatHang.TabIndex = 2;
            this.grbThongTinMatHang.TabStop = false;
            this.grbThongTinMatHang.Text = "Thông Tin Mặt Hàng";
            // 
            // cbbMaHang
            // 
            this.cbbMaHang.FormattingEnabled = true;
            this.cbbMaHang.Location = new System.Drawing.Point(87, 19);
            this.cbbMaHang.Name = "cbbMaHang";
            this.cbbMaHang.Size = new System.Drawing.Size(121, 21);
            this.cbbMaHang.TabIndex = 36;
            this.cbbMaHang.SelectedIndexChanged += new System.EventHandler(this.cbbMaHang_SelectedIndexChanged);
            // 
            // btnDong
            // 
            this.btnDong.Location = new System.Drawing.Point(560, 265);
            this.btnDong.Name = "btnDong";
            this.btnDong.Size = new System.Drawing.Size(87, 23);
            this.btnDong.TabIndex = 35;
            this.btnDong.Text = "Đóng";
            this.btnDong.UseVisualStyleBackColor = true;
            this.btnDong.Click += new System.EventHandler(this.btnDong_Click);
            // 
            // btnInHoaDon
            // 
            this.btnInHoaDon.Location = new System.Drawing.Point(467, 265);
            this.btnInHoaDon.Name = "btnInHoaDon";
            this.btnInHoaDon.Size = new System.Drawing.Size(87, 23);
            this.btnInHoaDon.TabIndex = 34;
            this.btnInHoaDon.Text = "In hóa đơn";
            this.btnInHoaDon.UseVisualStyleBackColor = true;
            this.btnInHoaDon.Click += new System.EventHandler(this.btnInHoaDon_Click);
            // 
            // btnHuyHoaDon
            // 
            this.btnHuyHoaDon.Location = new System.Drawing.Point(374, 265);
            this.btnHuyHoaDon.Name = "btnHuyHoaDon";
            this.btnHuyHoaDon.Size = new System.Drawing.Size(87, 23);
            this.btnHuyHoaDon.TabIndex = 33;
            this.btnHuyHoaDon.Text = "Hủy hóa đơn";
            this.btnHuyHoaDon.UseVisualStyleBackColor = true;
            // 
            // btnLuu
            // 
            this.btnLuu.Location = new System.Drawing.Point(281, 265);
            this.btnLuu.Name = "btnLuu";
            this.btnLuu.Size = new System.Drawing.Size(87, 23);
            this.btnLuu.TabIndex = 32;
            this.btnLuu.Text = "Lưu";
            this.btnLuu.UseVisualStyleBackColor = true;
            this.btnLuu.Click += new System.EventHandler(this.btnLuu_Click);
            // 
            // btnThemHoaDon
            // 
            this.btnThemHoaDon.Location = new System.Drawing.Point(188, 265);
            this.btnThemHoaDon.Name = "btnThemHoaDon";
            this.btnThemHoaDon.Size = new System.Drawing.Size(87, 23);
            this.btnThemHoaDon.TabIndex = 31;
            this.btnThemHoaDon.Text = "Thêm hóa đơn";
            this.btnThemHoaDon.UseVisualStyleBackColor = true;
            this.btnThemHoaDon.Click += new System.EventHandler(this.btnThemHoaDon_Click);
            // 
            // lbBangChu
            // 
            this.lbBangChu.AutoSize = true;
            this.lbBangChu.Location = new System.Drawing.Point(10, 238);
            this.lbBangChu.Name = "lbBangChu";
            this.lbBangChu.Size = new System.Drawing.Size(54, 13);
            this.lbBangChu.TabIndex = 29;
            this.lbBangChu.Text = "Bằng Chữ";
            // 
            // tbTongTien
            // 
            this.tbTongTien.Location = new System.Drawing.Point(526, 198);
            this.tbTongTien.Name = "tbTongTien";
            this.tbTongTien.Size = new System.Drawing.Size(121, 20);
            this.tbTongTien.TabIndex = 28;
            // 
            // lbTongTien
            // 
            this.lbTongTien.AutoSize = true;
            this.lbTongTien.Location = new System.Drawing.Point(450, 205);
            this.lbTongTien.Name = "lbTongTien";
            this.lbTongTien.Size = new System.Drawing.Size(52, 13);
            this.lbTongTien.TabIndex = 27;
            this.lbTongTien.Text = "Tổng tiền";
            // 
            // lbDelete
            // 
            this.lbDelete.AutoSize = true;
            this.lbDelete.Location = new System.Drawing.Point(10, 205);
            this.lbDelete.Name = "lbDelete";
            this.lbDelete.Size = new System.Drawing.Size(139, 13);
            this.lbDelete.TabIndex = 26;
            this.lbDelete.Text = "Kích đúp vào dòng để xóa ";
            // 
            // dgvHoaDonBan
            // 
            this.dgvHoaDonBan.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvHoaDonBan.Location = new System.Drawing.Point(10, 85);
            this.dgvHoaDonBan.Name = "dgvHoaDonBan";
            this.dgvHoaDonBan.Size = new System.Drawing.Size(637, 103);
            this.dgvHoaDonBan.TabIndex = 25;
            // 
            // tbThanhTien
            // 
            this.tbThanhTien.Enabled = false;
            this.tbThanhTien.Location = new System.Drawing.Point(526, 49);
            this.tbThanhTien.Name = "tbThanhTien";
            this.tbThanhTien.Size = new System.Drawing.Size(121, 20);
            this.tbThanhTien.TabIndex = 24;
            // 
            // tbDonGia
            // 
            this.tbDonGia.Enabled = false;
            this.tbDonGia.Location = new System.Drawing.Point(526, 22);
            this.tbDonGia.Name = "tbDonGia";
            this.tbDonGia.Size = new System.Drawing.Size(121, 20);
            this.tbDonGia.TabIndex = 23;
            // 
            // lbThanhTien
            // 
            this.lbThanhTien.AutoSize = true;
            this.lbThanhTien.Location = new System.Drawing.Point(456, 56);
            this.lbThanhTien.Name = "lbThanhTien";
            this.lbThanhTien.Size = new System.Drawing.Size(62, 13);
            this.lbThanhTien.TabIndex = 22;
            this.lbThanhTien.Text = "Thành Tiền";
            // 
            // lbDonGia
            // 
            this.lbDonGia.AutoSize = true;
            this.lbDonGia.Location = new System.Drawing.Point(456, 29);
            this.lbDonGia.Name = "lbDonGia";
            this.lbDonGia.Size = new System.Drawing.Size(46, 13);
            this.lbDonGia.TabIndex = 21;
            this.lbDonGia.Text = "Đơn Giá";
            // 
            // tbGiamGia
            // 
            this.tbGiamGia.Location = new System.Drawing.Point(309, 49);
            this.tbGiamGia.Name = "tbGiamGia";
            this.tbGiamGia.Size = new System.Drawing.Size(121, 20);
            this.tbGiamGia.TabIndex = 20;
            // 
            // tbTenHang
            // 
            this.tbTenHang.Enabled = false;
            this.tbTenHang.Location = new System.Drawing.Point(309, 22);
            this.tbTenHang.Name = "tbTenHang";
            this.tbTenHang.Size = new System.Drawing.Size(121, 20);
            this.tbTenHang.TabIndex = 19;
            // 
            // lbGiamGia
            // 
            this.lbGiamGia.AutoSize = true;
            this.lbGiamGia.Location = new System.Drawing.Point(232, 56);
            this.lbGiamGia.Name = "lbGiamGia";
            this.lbGiamGia.Size = new System.Drawing.Size(61, 13);
            this.lbGiamGia.TabIndex = 18;
            this.lbGiamGia.Text = "Giảm Giá %";
            // 
            // tbSoLuong
            // 
            this.tbSoLuong.Location = new System.Drawing.Point(87, 49);
            this.tbSoLuong.Name = "tbSoLuong";
            this.tbSoLuong.Size = new System.Drawing.Size(121, 20);
            this.tbSoLuong.TabIndex = 17;
            this.tbSoLuong.TextChanged += new System.EventHandler(this.tbSoLuong_TextChanged);
            // 
            // lbSoLuong
            // 
            this.lbSoLuong.AutoSize = true;
            this.lbSoLuong.Location = new System.Drawing.Point(7, 56);
            this.lbSoLuong.Name = "lbSoLuong";
            this.lbSoLuong.Size = new System.Drawing.Size(53, 13);
            this.lbSoLuong.TabIndex = 6;
            this.lbSoLuong.Text = "Số Lượng";
            // 
            // lbTenHang
            // 
            this.lbTenHang.AutoSize = true;
            this.lbTenHang.Location = new System.Drawing.Point(232, 29);
            this.lbTenHang.Name = "lbTenHang";
            this.lbTenHang.Size = new System.Drawing.Size(55, 13);
            this.lbTenHang.TabIndex = 5;
            this.lbTenHang.Text = "Tên Hàng";
            // 
            // lbMaHang
            // 
            this.lbMaHang.AutoSize = true;
            this.lbMaHang.Enabled = false;
            this.lbMaHang.Location = new System.Drawing.Point(7, 29);
            this.lbMaHang.Name = "lbMaHang";
            this.lbMaHang.Size = new System.Drawing.Size(51, 13);
            this.lbMaHang.TabIndex = 4;
            this.lbMaHang.Text = "Mã Hàng";
            // 
            // lbTimHoaDon
            // 
            this.lbTimHoaDon.AutoSize = true;
            this.lbTimHoaDon.Location = new System.Drawing.Point(12, 542);
            this.lbTimHoaDon.Name = "lbTimHoaDon";
            this.lbTimHoaDon.Size = new System.Drawing.Size(65, 13);
            this.lbTimHoaDon.TabIndex = 36;
            this.lbTimHoaDon.Text = "Mã hóa đơn";
            // 
            // cbbTimHoaDon
            // 
            this.cbbTimHoaDon.FormattingEnabled = true;
            this.cbbTimHoaDon.Location = new System.Drawing.Point(83, 534);
            this.cbbTimHoaDon.Name = "cbbTimHoaDon";
            this.cbbTimHoaDon.Size = new System.Drawing.Size(121, 21);
            this.cbbTimHoaDon.TabIndex = 37;
            // 
            // btnTimKiem
            // 
            this.btnTimKiem.Location = new System.Drawing.Point(213, 532);
            this.btnTimKiem.Name = "btnTimKiem";
            this.btnTimKiem.Size = new System.Drawing.Size(87, 23);
            this.btnTimKiem.TabIndex = 36;
            this.btnTimKiem.Text = "Tìm kiêm";
            this.btnTimKiem.UseVisualStyleBackColor = true;
            // 
            // Form4
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(704, 574);
            this.Controls.Add(this.btnTimKiem);
            this.Controls.Add(this.cbbTimHoaDon);
            this.Controls.Add(this.lbTimHoaDon);
            this.Controls.Add(this.grbThongTinMatHang);
            this.Controls.Add(this.grbThongTinChung);
            this.Controls.Add(this.label1);
            this.Name = "Form4";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form4";
            this.Load += new System.EventHandler(this.Form4_Load);
            this.grbThongTinChung.ResumeLayout(false);
            this.grbThongTinChung.PerformLayout();
            this.grbThongTinMatHang.ResumeLayout(false);
            this.grbThongTinMatHang.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvHoaDonBan)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox grbThongTinChung;
        private Guna.UI.WinForms.GunaDateTimePicker dtpNgayBan;
        private System.Windows.Forms.MaskedTextBox tbSoDienThoai;
        private System.Windows.Forms.MaskedTextBox tbTenKhachHang;
        private System.Windows.Forms.MaskedTextBox tbDiaChi;
        private System.Windows.Forms.MaskedTextBox tbTenNhanVien;
        private System.Windows.Forms.TextBox tbMaHoaDon;
        private System.Windows.Forms.ComboBox cbbMaNhanVien;
        private System.Windows.Forms.ComboBox cbbMaKhachHang;
        private System.Windows.Forms.Label lbSoDienThoai;
        private System.Windows.Forms.Label blDiaChi;
        private System.Windows.Forms.Label lbTenKhachHang;
        private System.Windows.Forms.Label lbMaKhachHang;
        private System.Windows.Forms.Label lbTenNhanVien;
        private System.Windows.Forms.Label lbMaNhanVien;
        private System.Windows.Forms.Label lbNgayban;
        private System.Windows.Forms.Label lbMaHoaDon;
        private System.Windows.Forms.GroupBox grbThongTinMatHang;
        private System.Windows.Forms.Button btnDong;
        private System.Windows.Forms.Button btnInHoaDon;
        private System.Windows.Forms.Button btnHuyHoaDon;
        private System.Windows.Forms.Button btnLuu;
        private System.Windows.Forms.Button btnThemHoaDon;
        private System.Windows.Forms.Label lbBangChu;
        private System.Windows.Forms.MaskedTextBox tbTongTien;
        private System.Windows.Forms.Label lbTongTien;
        private System.Windows.Forms.Label lbDelete;
        private System.Windows.Forms.DataGridView dgvHoaDonBan;
        private System.Windows.Forms.MaskedTextBox tbThanhTien;
        private System.Windows.Forms.MaskedTextBox tbDonGia;
        private System.Windows.Forms.Label lbThanhTien;
        private System.Windows.Forms.Label lbDonGia;
        private System.Windows.Forms.MaskedTextBox tbGiamGia;
        private System.Windows.Forms.MaskedTextBox tbTenHang;
        private System.Windows.Forms.Label lbGiamGia;
        private System.Windows.Forms.MaskedTextBox tbSoLuong;
        private System.Windows.Forms.Label lbSoLuong;
        private System.Windows.Forms.Label lbTenHang;
        private System.Windows.Forms.Label lbMaHang;
        private System.Windows.Forms.Label lbTimHoaDon;
        private System.Windows.Forms.ComboBox cbbTimHoaDon;
        private System.Windows.Forms.Button btnTimKiem;
        private System.Windows.Forms.ComboBox cbbMaHang;
    }
}