namespace My_IPOS
{
    partial class Login
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Login));
            this.tbPassword = new System.Windows.Forms.TextBox();
            this.tbUserName = new System.Windows.Forms.TextBox();
            this.btThoatDangNhap = new System.Windows.Forms.Button();
            this.lbPassword = new System.Windows.Forms.Label();
            this.lbUserName = new System.Windows.Forms.Label();
            this.btnDangNhap = new System.Windows.Forms.Button();
            this.btEye = new Guna.UI.WinForms.GunaImageButton();
            this.gunaPictureBox1 = new Guna.UI.WinForms.GunaPictureBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            ((System.ComponentModel.ISupportInitialize)(this.gunaPictureBox1)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // tbPassword
            // 
            this.tbPassword.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbPassword.Location = new System.Drawing.Point(155, 154);
            this.tbPassword.Name = "tbPassword";
            this.tbPassword.Size = new System.Drawing.Size(160, 26);
            this.tbPassword.TabIndex = 13;
            this.tbPassword.KeyDown += new System.Windows.Forms.KeyEventHandler(this.tbPassword_KeyDown);
            // 
            // tbUserName
            // 
            this.tbUserName.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbUserName.Location = new System.Drawing.Point(155, 113);
            this.tbUserName.Name = "tbUserName";
            this.tbUserName.Size = new System.Drawing.Size(160, 26);
            this.tbUserName.TabIndex = 0;
            this.tbUserName.KeyDown += new System.Windows.Forms.KeyEventHandler(this.tbUserName_KeyDown);
            // 
            // btThoatDangNhap
            // 
            this.btThoatDangNhap.BackColor = System.Drawing.Color.Transparent;
            this.btThoatDangNhap.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.btThoatDangNhap.Font = new System.Drawing.Font("Times New Roman", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btThoatDangNhap.ForeColor = System.Drawing.SystemColors.ControlText;
            this.btThoatDangNhap.Location = new System.Drawing.Point(189, 210);
            this.btThoatDangNhap.Name = "btThoatDangNhap";
            this.btThoatDangNhap.Size = new System.Drawing.Size(87, 37);
            this.btThoatDangNhap.TabIndex = 11;
            this.btThoatDangNhap.Text = "Thoát";
            this.btThoatDangNhap.UseVisualStyleBackColor = false;
            this.btThoatDangNhap.Click += new System.EventHandler(this.btThoatDangNhap_Click);
            // 
            // lbPassword
            // 
            this.lbPassword.AutoSize = true;
            this.lbPassword.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbPassword.ForeColor = System.Drawing.Color.MidnightBlue;
            this.lbPassword.Location = new System.Drawing.Point(29, 158);
            this.lbPassword.Name = "lbPassword";
            this.lbPassword.Size = new System.Drawing.Size(77, 19);
            this.lbPassword.TabIndex = 9;
            this.lbPassword.Text = "Password:";
            // 
            // lbUserName
            // 
            this.lbUserName.AutoSize = true;
            this.lbUserName.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbUserName.ForeColor = System.Drawing.Color.MidnightBlue;
            this.lbUserName.Location = new System.Drawing.Point(29, 120);
            this.lbUserName.Name = "lbUserName";
            this.lbUserName.Size = new System.Drawing.Size(90, 19);
            this.lbUserName.TabIndex = 8;
            this.lbUserName.Text = "User Name:";
            // 
            // btnDangNhap
            // 
            this.btnDangNhap.BackColor = System.Drawing.Color.Transparent;
            this.btnDangNhap.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.btnDangNhap.Font = new System.Drawing.Font("Times New Roman", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnDangNhap.ForeColor = System.Drawing.SystemColors.ControlText;
            this.btnDangNhap.ImageAlign = System.Drawing.ContentAlignment.TopLeft;
            this.btnDangNhap.Location = new System.Drawing.Point(67, 210);
            this.btnDangNhap.Name = "btnDangNhap";
            this.btnDangNhap.Size = new System.Drawing.Size(89, 37);
            this.btnDangNhap.TabIndex = 10;
            this.btnDangNhap.Text = "Đăng Nhập";
            this.btnDangNhap.UseVisualStyleBackColor = false;
            this.btnDangNhap.Click += new System.EventHandler(this.btnDangNhap_Click);
            // 
            // btEye
            // 
            this.btEye.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.btEye.Cursor = System.Windows.Forms.Cursors.Default;
            this.btEye.DialogResult = System.Windows.Forms.DialogResult.None;
            this.btEye.Image = ((System.Drawing.Image)(resources.GetObject("btEye.Image")));
            this.btEye.ImageSize = new System.Drawing.Size(16, 16);
            this.btEye.Location = new System.Drawing.Point(6, 10);
            this.btEye.Name = "btEye";
            this.btEye.OnHoverImage = null;
            this.btEye.OnHoverImageOffset = new System.Drawing.Point(0, 0);
            this.btEye.Size = new System.Drawing.Size(21, 20);
            this.btEye.TabIndex = 14;
            this.btEye.Click += new System.EventHandler(this.btEye_Click);
            // 
            // gunaPictureBox1
            // 
            this.gunaPictureBox1.BaseColor = System.Drawing.Color.White;
            this.gunaPictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("gunaPictureBox1.Image")));
            this.gunaPictureBox1.Location = new System.Drawing.Point(129, 12);
            this.gunaPictureBox1.Name = "gunaPictureBox1";
            this.gunaPictureBox1.Size = new System.Drawing.Size(95, 95);
            this.gunaPictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.gunaPictureBox1.TabIndex = 15;
            this.gunaPictureBox1.TabStop = false;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.btEye);
            this.groupBox1.Location = new System.Drawing.Point(321, 147);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(32, 33);
            this.groupBox1.TabIndex = 16;
            this.groupBox1.TabStop = false;
            // 
            // Login
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(192)))));
            this.ClientSize = new System.Drawing.Size(362, 272);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.gunaPictureBox1);
            this.Controls.Add(this.tbPassword);
            this.Controls.Add(this.tbUserName);
            this.Controls.Add(this.btThoatDangNhap);
            this.Controls.Add(this.btnDangNhap);
            this.Controls.Add(this.lbPassword);
            this.Controls.Add(this.lbUserName);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Login";
            this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Hide;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Đăng Nhập";
            this.Load += new System.EventHandler(this.Login_Load);
            ((System.ComponentModel.ISupportInitialize)(this.gunaPictureBox1)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox tbPassword;
        private System.Windows.Forms.TextBox tbUserName;
        private System.Windows.Forms.Button btThoatDangNhap;
        private System.Windows.Forms.Label lbPassword;
        private System.Windows.Forms.Label lbUserName;
        private System.Windows.Forms.Button btnDangNhap;
        private Guna.UI.WinForms.GunaImageButton btEye;
        private Guna.UI.WinForms.GunaPictureBox gunaPictureBox1;
        private System.Windows.Forms.GroupBox groupBox1;
    }
}