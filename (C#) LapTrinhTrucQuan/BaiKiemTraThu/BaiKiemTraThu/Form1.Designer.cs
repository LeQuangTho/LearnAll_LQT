namespace BaiKiemTraThu
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
            this.label1 = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.tbLuongThang = new System.Windows.Forms.TextBox();
            this.tbTenCongViec = new System.Windows.Forms.TextBox();
            this.tbMaCongViec = new System.Windows.Forms.TextBox();
            this.lbLuongThang = new System.Windows.Forms.Label();
            this.lbTenCongViec = new System.Windows.Forms.Label();
            this.lbMaCongViec = new System.Windows.Forms.Label();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.dgvCongViec = new System.Windows.Forms.DataGridView();
            this.btThem = new System.Windows.Forms.Button();
            this.btSua = new System.Windows.Forms.Button();
            this.btXoa = new System.Windows.Forms.Button();
            this.btThoat = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvCongViec)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Times New Roman", 30F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(227, 54);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(378, 45);
            this.label1.TabIndex = 0;
            this.label1.Text = "Danh mục Công Việc";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.tbLuongThang);
            this.groupBox1.Controls.Add(this.tbTenCongViec);
            this.groupBox1.Controls.Add(this.tbMaCongViec);
            this.groupBox1.Controls.Add(this.lbLuongThang);
            this.groupBox1.Controls.Add(this.lbTenCongViec);
            this.groupBox1.Controls.Add(this.lbMaCongViec);
            this.groupBox1.Location = new System.Drawing.Point(91, 128);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(628, 158);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Thông tin công việc";
            // 
            // tbLuongThang
            // 
            this.tbLuongThang.Font = new System.Drawing.Font("Times New Roman", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbLuongThang.Location = new System.Drawing.Point(285, 107);
            this.tbLuongThang.Name = "tbLuongThang";
            this.tbLuongThang.Size = new System.Drawing.Size(190, 23);
            this.tbLuongThang.TabIndex = 5;
            this.tbLuongThang.TextChanged += new System.EventHandler(this.TextChanged);
            this.tbLuongThang.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.tbLuongThang_KeyPress);
            // 
            // tbTenCongViec
            // 
            this.tbTenCongViec.Font = new System.Drawing.Font("Times New Roman", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbTenCongViec.Location = new System.Drawing.Point(285, 63);
            this.tbTenCongViec.Name = "tbTenCongViec";
            this.tbTenCongViec.Size = new System.Drawing.Size(190, 23);
            this.tbTenCongViec.TabIndex = 4;
            this.tbTenCongViec.TextChanged += new System.EventHandler(this.TextChanged);
            // 
            // tbMaCongViec
            // 
            this.tbMaCongViec.Font = new System.Drawing.Font("Times New Roman", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbMaCongViec.Location = new System.Drawing.Point(285, 25);
            this.tbMaCongViec.Name = "tbMaCongViec";
            this.tbMaCongViec.Size = new System.Drawing.Size(190, 23);
            this.tbMaCongViec.TabIndex = 3;
            this.tbMaCongViec.TextChanged += new System.EventHandler(this.TextChanged);
            // 
            // lbLuongThang
            // 
            this.lbLuongThang.AutoSize = true;
            this.lbLuongThang.Font = new System.Drawing.Font("Times New Roman", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbLuongThang.Location = new System.Drawing.Point(106, 113);
            this.lbLuongThang.Name = "lbLuongThang";
            this.lbLuongThang.Size = new System.Drawing.Size(91, 17);
            this.lbLuongThang.TabIndex = 2;
            this.lbLuongThang.Text = "Lương Tháng";
            // 
            // lbTenCongViec
            // 
            this.lbTenCongViec.AutoSize = true;
            this.lbTenCongViec.Font = new System.Drawing.Font("Times New Roman", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbTenCongViec.Location = new System.Drawing.Point(106, 69);
            this.lbTenCongViec.Name = "lbTenCongViec";
            this.lbTenCongViec.Size = new System.Drawing.Size(94, 17);
            this.lbTenCongViec.TabIndex = 1;
            this.lbTenCongViec.Text = "Tên Công Việc";
            // 
            // lbMaCongViec
            // 
            this.lbMaCongViec.AutoSize = true;
            this.lbMaCongViec.Font = new System.Drawing.Font("Times New Roman", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbMaCongViec.Location = new System.Drawing.Point(106, 31);
            this.lbMaCongViec.Name = "lbMaCongViec";
            this.lbMaCongViec.Size = new System.Drawing.Size(90, 17);
            this.lbMaCongViec.TabIndex = 0;
            this.lbMaCongViec.Text = "Mã Công Việc";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.dgvCongViec);
            this.groupBox2.Location = new System.Drawing.Point(91, 324);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(628, 177);
            this.groupBox2.TabIndex = 6;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Danh sách công việc";
            // 
            // dgvCongViec
            // 
            this.dgvCongViec.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgvCongViec.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvCongViec.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dgvCongViec.EnableHeadersVisualStyles = false;
            this.dgvCongViec.Location = new System.Drawing.Point(3, 16);
            this.dgvCongViec.Name = "dgvCongViec";
            this.dgvCongViec.RowTemplate.Height = 26;
            this.dgvCongViec.RowTemplate.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.dgvCongViec.Size = new System.Drawing.Size(622, 158);
            this.dgvCongViec.TabIndex = 0;
            this.dgvCongViec.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvCongViec_CellClick);
            // 
            // btThem
            // 
            this.btThem.Enabled = false;
            this.btThem.Font = new System.Drawing.Font("Times New Roman", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btThem.Location = new System.Drawing.Point(148, 507);
            this.btThem.Name = "btThem";
            this.btThem.Size = new System.Drawing.Size(75, 53);
            this.btThem.TabIndex = 7;
            this.btThem.Text = "Thêm";
            this.btThem.UseVisualStyleBackColor = true;
            this.btThem.Click += new System.EventHandler(this.btThem_Click);
            // 
            // btSua
            // 
            this.btSua.Enabled = false;
            this.btSua.Font = new System.Drawing.Font("Times New Roman", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btSua.Location = new System.Drawing.Point(293, 507);
            this.btSua.Name = "btSua";
            this.btSua.Size = new System.Drawing.Size(75, 53);
            this.btSua.TabIndex = 8;
            this.btSua.Text = "Sửa";
            this.btSua.UseVisualStyleBackColor = true;
            this.btSua.Click += new System.EventHandler(this.btSua_Click);
            // 
            // btXoa
            // 
            this.btXoa.Enabled = false;
            this.btXoa.Font = new System.Drawing.Font("Times New Roman", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btXoa.Location = new System.Drawing.Point(427, 507);
            this.btXoa.Name = "btXoa";
            this.btXoa.Size = new System.Drawing.Size(75, 53);
            this.btXoa.TabIndex = 9;
            this.btXoa.Text = "Xóa";
            this.btXoa.UseVisualStyleBackColor = true;
            this.btXoa.Click += new System.EventHandler(this.btXoa_Click);
            // 
            // btThoat
            // 
            this.btThoat.Font = new System.Drawing.Font("Times New Roman", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btThoat.Location = new System.Drawing.Point(556, 507);
            this.btThoat.Name = "btThoat";
            this.btThoat.Size = new System.Drawing.Size(75, 53);
            this.btThoat.TabIndex = 10;
            this.btThoat.Text = "Thoát";
            this.btThoat.UseVisualStyleBackColor = true;
            this.btThoat.Click += new System.EventHandler(this.btThoat_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(849, 572);
            this.Controls.Add(this.btThoat);
            this.Controls.Add(this.btXoa);
            this.Controls.Add(this.btSua);
            this.Controls.Add(this.btThem);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dgvCongViec)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label lbTenCongViec;
        private System.Windows.Forms.Label lbMaCongViec;
        private System.Windows.Forms.Label lbLuongThang;
        private System.Windows.Forms.TextBox tbLuongThang;
        private System.Windows.Forms.TextBox tbTenCongViec;
        private System.Windows.Forms.TextBox tbMaCongViec;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.DataGridView dgvCongViec;
        private System.Windows.Forms.Button btThem;
        private System.Windows.Forms.Button btSua;
        private System.Windows.Forms.Button btXoa;
        private System.Windows.Forms.Button btThoat;
    }
}

