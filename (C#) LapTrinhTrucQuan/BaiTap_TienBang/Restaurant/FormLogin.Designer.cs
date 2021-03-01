namespace Restaurant
{
    partial class FormLogin
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormLogin));
            this.pictureBox = new System.Windows.Forms.PictureBox();
            this.textUser = new Zeroit.Framework.LollipopControls.Controls.ZeroitLollipopTextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.buttonShowPassword = new FontAwesome.Sharp.IconButton();
            this.buttonExit = new Restaurant.CustomControls.RadiusIconButton();
            this.buttonLogin = new Restaurant.CustomControls.RadiusIconButton();
            this.textPassword = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox)).BeginInit();
            this.SuspendLayout();
            // 
            // pictureBox
            // 
            this.pictureBox.Dock = System.Windows.Forms.DockStyle.Top;
            this.pictureBox.Image = global::Restaurant.Properties.Resources.LoginPicture;
            this.pictureBox.Location = new System.Drawing.Point(0, 0);
            this.pictureBox.Name = "pictureBox";
            this.pictureBox.Size = new System.Drawing.Size(411, 307);
            this.pictureBox.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox.TabIndex = 0;
            this.pictureBox.TabStop = false;
            // 
            // textUser
            // 
            this.textUser.DisabledStringColor = System.Drawing.Color.FromArgb(((int)(((byte)(186)))), ((int)(((byte)(187)))), ((int)(((byte)(189)))));
            this.textUser.DisabledUnFocusedColor = System.Drawing.Color.FromArgb(((int)(((byte)(233)))), ((int)(((byte)(236)))), ((int)(((byte)(238)))));
            this.textUser.EnabledUnFocusedColor = System.Drawing.Color.FromArgb(((int)(((byte)(219)))), ((int)(((byte)(219)))), ((int)(((byte)(219)))));
            this.textUser.FocusedColor = System.Drawing.Color.FromArgb(((int)(((byte)(80)))), ((int)(((byte)(142)))), ((int)(((byte)(245)))));
            this.textUser.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(153)))), ((int)(((byte)(153)))), ((int)(((byte)(153)))));
            this.textUser.IsEnabled = true;
            this.textUser.Location = new System.Drawing.Point(82, 373);
            this.textUser.MaxLength = 32767;
            this.textUser.Multiline = false;
            this.textUser.Name = "textUser";
            this.textUser.PasswordChar = '\0';
            this.textUser.ReadOnly = false;
            this.textUser.Size = new System.Drawing.Size(244, 24);
            this.textUser.TabIndex = 3;
            this.textUser.TextAlignment = System.Windows.Forms.HorizontalAlignment.Left;
            this.textUser.TextBackgroundColor = System.Drawing.SystemColors.Control;
            this.textUser.UseSystemPasswordChar = false;
            this.textUser.WordWrap = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(89)))), ((int)(((byte)(89)))), ((int)(((byte)(89)))));
            this.label1.Location = new System.Drawing.Point(78, 350);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(92, 20);
            this.label1.TabIndex = 5;
            this.label1.Text = "Tài khoản:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(89)))), ((int)(((byte)(89)))), ((int)(((byte)(89)))));
            this.label2.Location = new System.Drawing.Point(78, 409);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(88, 20);
            this.label2.TabIndex = 6;
            this.label2.Text = "Mật khẩu:";
            // 
            // buttonShowPassword
            // 
            this.buttonShowPassword.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonShowPassword.FlatAppearance.BorderSize = 0;
            this.buttonShowPassword.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonShowPassword.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonShowPassword.IconChar = FontAwesome.Sharp.IconChar.Eye;
            this.buttonShowPassword.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(89)))), ((int)(((byte)(89)))), ((int)(((byte)(89)))));
            this.buttonShowPassword.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonShowPassword.IconSize = 24;
            this.buttonShowPassword.Location = new System.Drawing.Point(332, 432);
            this.buttonShowPassword.Name = "buttonShowPassword";
            this.buttonShowPassword.Rotation = 0D;
            this.buttonShowPassword.Size = new System.Drawing.Size(24, 24);
            this.buttonShowPassword.TabIndex = 7;
            this.buttonShowPassword.UseVisualStyleBackColor = true;
            this.buttonShowPassword.Click += new System.EventHandler(this.buttonShowPassword_Click);
            // 
            // buttonExit
            // 
            this.buttonExit.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(239)))), ((int)(((byte)(239)))), ((int)(((byte)(239)))));
            this.buttonExit.BorderColor = System.Drawing.Color.Transparent;
            this.buttonExit.BorderRadiusBottomLeft = 25;
            this.buttonExit.BorderRadiusBottomRight = 25;
            this.buttonExit.BorderRadiusTopLeft = 25;
            this.buttonExit.BorderRadiusTopRight = 25;
            this.buttonExit.BorderWidth = 0F;
            this.buttonExit.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonExit.FlatAppearance.BorderSize = 0;
            this.buttonExit.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonExit.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonExit.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonExit.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(89)))), ((int)(((byte)(89)))), ((int)(((byte)(89)))));
            this.buttonExit.IconChar = FontAwesome.Sharp.IconChar.None;
            this.buttonExit.IconColor = System.Drawing.Color.Black;
            this.buttonExit.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonExit.IconSize = 48;
            this.buttonExit.Location = new System.Drawing.Point(130, 513);
            this.buttonExit.Name = "buttonExit";
            this.buttonExit.Rotation = 0D;
            this.buttonExit.Size = new System.Drawing.Size(140, 38);
            this.buttonExit.TabIndex = 2;
            this.buttonExit.Text = "Thoát";
            this.buttonExit.UseVisualStyleBackColor = false;
            this.buttonExit.Click += new System.EventHandler(this.buttonExit_Click);
            // 
            // buttonLogin
            // 
            this.buttonLogin.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(239)))), ((int)(((byte)(239)))), ((int)(((byte)(239)))));
            this.buttonLogin.BorderColor = System.Drawing.Color.Transparent;
            this.buttonLogin.BorderRadiusBottomLeft = 25;
            this.buttonLogin.BorderRadiusBottomRight = 25;
            this.buttonLogin.BorderRadiusTopLeft = 25;
            this.buttonLogin.BorderRadiusTopRight = 25;
            this.buttonLogin.BorderWidth = 0F;
            this.buttonLogin.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonLogin.FlatAppearance.BorderSize = 0;
            this.buttonLogin.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonLogin.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonLogin.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonLogin.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(89)))), ((int)(((byte)(89)))), ((int)(((byte)(89)))));
            this.buttonLogin.IconChar = FontAwesome.Sharp.IconChar.None;
            this.buttonLogin.IconColor = System.Drawing.Color.Black;
            this.buttonLogin.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonLogin.IconSize = 48;
            this.buttonLogin.Location = new System.Drawing.Point(130, 466);
            this.buttonLogin.Name = "buttonLogin";
            this.buttonLogin.Rotation = 0D;
            this.buttonLogin.Size = new System.Drawing.Size(140, 41);
            this.buttonLogin.TabIndex = 1;
            this.buttonLogin.Text = "Đăng nhập";
            this.buttonLogin.UseVisualStyleBackColor = false;
            // 
            // textPassword
            // 
            this.textPassword.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(219)))), ((int)(((byte)(219)))), ((int)(((byte)(219)))));
            this.textPassword.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.textPassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.textPassword.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(153)))), ((int)(((byte)(153)))), ((int)(((byte)(153)))));
            this.textPassword.Location = new System.Drawing.Point(82, 432);
            this.textPassword.Name = "textPassword";
            this.textPassword.Size = new System.Drawing.Size(244, 24);
            this.textPassword.TabIndex = 8;
            this.textPassword.UseSystemPasswordChar = true;
            // 
            // FormLogin
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.White;
            this.ClientSize = new System.Drawing.Size(411, 564);
            this.Controls.Add(this.textPassword);
            this.Controls.Add(this.buttonShowPassword);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.textUser);
            this.Controls.Add(this.buttonExit);
            this.Controls.Add(this.buttonLogin);
            this.Controls.Add(this.pictureBox);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(89)))), ((int)(((byte)(89)))), ((int)(((byte)(89)))));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "FormLogin";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "FormLogin";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBox;
        private CustomControls.RadiusIconButton buttonLogin;
        private CustomControls.RadiusIconButton buttonExit;
        private Zeroit.Framework.LollipopControls.Controls.ZeroitLollipopTextBox textUser;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private FontAwesome.Sharp.IconButton buttonShowPassword;
        private System.Windows.Forms.TextBox textPassword;
    }
}