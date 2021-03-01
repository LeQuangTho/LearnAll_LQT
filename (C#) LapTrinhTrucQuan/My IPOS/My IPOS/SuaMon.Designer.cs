namespace My_IPOS
{
    partial class SuaMon
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(SuaMon));
            this.gunaGradientButton1 = new Guna.UI.WinForms.GunaGradientButton();
            this.lbMenhGia = new System.Windows.Forms.Label();
            this.tbDonGia = new System.Windows.Forms.TextBox();
            this.tbTenMon = new System.Windows.Forms.TextBox();
            this.tbMaMon = new System.Windows.Forms.TextBox();
            this.lbDonGia = new System.Windows.Forms.Label();
            this.lbTenMon = new System.Windows.Forms.Label();
            this.lbMaMon = new System.Windows.Forms.Label();
            this.chuy = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // gunaGradientButton1
            // 
            this.gunaGradientButton1.AnimationHoverSpeed = 0.07F;
            this.gunaGradientButton1.AnimationSpeed = 0.03F;
            this.gunaGradientButton1.BaseColor1 = System.Drawing.Color.SlateBlue;
            this.gunaGradientButton1.BaseColor2 = System.Drawing.Color.Fuchsia;
            this.gunaGradientButton1.BorderColor = System.Drawing.Color.Black;
            this.gunaGradientButton1.DialogResult = System.Windows.Forms.DialogResult.None;
            this.gunaGradientButton1.FocusedColor = System.Drawing.Color.Empty;
            this.gunaGradientButton1.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.gunaGradientButton1.ForeColor = System.Drawing.Color.White;
            this.gunaGradientButton1.Image = ((System.Drawing.Image)(resources.GetObject("gunaGradientButton1.Image")));
            this.gunaGradientButton1.ImageSize = new System.Drawing.Size(20, 20);
            this.gunaGradientButton1.Location = new System.Drawing.Point(216, 179);
            this.gunaGradientButton1.Name = "gunaGradientButton1";
            this.gunaGradientButton1.OnHoverBaseColor1 = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(145)))), ((int)(((byte)(221)))));
            this.gunaGradientButton1.OnHoverBaseColor2 = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(85)))), ((int)(((byte)(255)))));
            this.gunaGradientButton1.OnHoverBorderColor = System.Drawing.Color.Black;
            this.gunaGradientButton1.OnHoverForeColor = System.Drawing.Color.White;
            this.gunaGradientButton1.OnHoverImage = null;
            this.gunaGradientButton1.OnPressedColor = System.Drawing.Color.Black;
            this.gunaGradientButton1.Size = new System.Drawing.Size(83, 42);
            this.gunaGradientButton1.TabIndex = 22;
            this.gunaGradientButton1.Text = "Sửa";
            this.gunaGradientButton1.Click += new System.EventHandler(this.gunaGradientButton1_Click);
            // 
            // lbMenhGia
            // 
            this.lbMenhGia.AutoSize = true;
            this.lbMenhGia.Font = new System.Drawing.Font("Times New Roman", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbMenhGia.Location = new System.Drawing.Point(305, 135);
            this.lbMenhGia.Name = "lbMenhGia";
            this.lbMenhGia.Size = new System.Drawing.Size(29, 17);
            this.lbMenhGia.TabIndex = 21;
            this.lbMenhGia.Text = "vnđ";
            // 
            // tbDonGia
            // 
            this.tbDonGia.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbDonGia.Location = new System.Drawing.Point(161, 126);
            this.tbDonGia.Name = "tbDonGia";
            this.tbDonGia.Size = new System.Drawing.Size(138, 26);
            this.tbDonGia.TabIndex = 20;
            // 
            // tbTenMon
            // 
            this.tbTenMon.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbTenMon.Location = new System.Drawing.Point(161, 82);
            this.tbTenMon.Name = "tbTenMon";
            this.tbTenMon.Size = new System.Drawing.Size(285, 26);
            this.tbTenMon.TabIndex = 19;
            // 
            // tbMaMon
            // 
            this.tbMaMon.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbMaMon.Location = new System.Drawing.Point(161, 34);
            this.tbMaMon.Name = "tbMaMon";
            this.tbMaMon.ReadOnly = true;
            this.tbMaMon.Size = new System.Drawing.Size(285, 26);
            this.tbMaMon.TabIndex = 18;
            // 
            // lbDonGia
            // 
            this.lbDonGia.AutoSize = true;
            this.lbDonGia.Font = new System.Drawing.Font("Times New Roman", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbDonGia.Location = new System.Drawing.Point(37, 135);
            this.lbDonGia.Name = "lbDonGia";
            this.lbDonGia.Size = new System.Drawing.Size(59, 17);
            this.lbDonGia.TabIndex = 17;
            this.lbDonGia.Text = "Đơn Giá";
            // 
            // lbTenMon
            // 
            this.lbTenMon.AutoSize = true;
            this.lbTenMon.Font = new System.Drawing.Font("Times New Roman", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbTenMon.Location = new System.Drawing.Point(37, 91);
            this.lbTenMon.Name = "lbTenMon";
            this.lbTenMon.Size = new System.Drawing.Size(62, 17);
            this.lbTenMon.TabIndex = 16;
            this.lbTenMon.Text = "Tên Món";
            // 
            // lbMaMon
            // 
            this.lbMaMon.AutoSize = true;
            this.lbMaMon.Font = new System.Drawing.Font("Times New Roman", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbMaMon.Location = new System.Drawing.Point(37, 43);
            this.lbMaMon.Name = "lbMaMon";
            this.lbMaMon.Size = new System.Drawing.Size(58, 17);
            this.lbMaMon.TabIndex = 15;
            this.lbMaMon.Text = "Mã Món";
            // 
            // chuy
            // 
            this.chuy.AutoSize = true;
            this.chuy.Font = new System.Drawing.Font("Times New Roman", 8.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.chuy.ForeColor = System.Drawing.Color.Red;
            this.chuy.Location = new System.Drawing.Point(158, 17);
            this.chuy.Name = "chuy";
            this.chuy.Size = new System.Drawing.Size(180, 14);
            this.chuy.TabIndex = 23;
            this.chuy.Text = "* Bạn không được phép sửa mã món";
            // 
            // SuaMon
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(474, 240);
            this.Controls.Add(this.chuy);
            this.Controls.Add(this.gunaGradientButton1);
            this.Controls.Add(this.lbMenhGia);
            this.Controls.Add(this.tbDonGia);
            this.Controls.Add(this.tbTenMon);
            this.Controls.Add(this.tbMaMon);
            this.Controls.Add(this.lbDonGia);
            this.Controls.Add(this.lbTenMon);
            this.Controls.Add(this.lbMaMon);
            this.Name = "SuaMon";
            this.Text = "SuaMon";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Guna.UI.WinForms.GunaGradientButton gunaGradientButton1;
        private System.Windows.Forms.Label lbMenhGia;
        private System.Windows.Forms.TextBox tbDonGia;
        private System.Windows.Forms.TextBox tbTenMon;
        private System.Windows.Forms.TextBox tbMaMon;
        private System.Windows.Forms.Label lbDonGia;
        private System.Windows.Forms.Label lbTenMon;
        private System.Windows.Forms.Label lbMaMon;
        private System.Windows.Forms.Label chuy;
    }
}