namespace Restaurant.Forms
{
    partial class FormCode
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
            System.Drawing.Drawing2D.GraphicsPath graphicsPath7 = new System.Drawing.Drawing2D.GraphicsPath();
            System.Drawing.Drawing2D.GraphicsPath graphicsPath8 = new System.Drawing.Drawing2D.GraphicsPath();
            System.Drawing.Drawing2D.GraphicsPath graphicsPath9 = new System.Drawing.Drawing2D.GraphicsPath();
            this.groupBoxCode = new XanderUI.XUICustomGroupbox();
            this.buttonChange = new Zeroit.Framework.MaterialWinforms.Controls.MaterialRaisedButton();
            this.buttonCancel = new Zeroit.Framework.MaterialWinforms.Controls.MaterialRaisedButton();
            this.buttonTry = new Zeroit.Framework.MaterialWinforms.Controls.MaterialRaisedButton();
            this.checkQRCode = new MaterialSkin.Controls.MaterialCheckbox();
            this.checkBarCode = new MaterialSkin.Controls.MaterialCheckbox();
            this.textQRCode = new System.Windows.Forms.RichTextBox();
            this.pictureBoxQRCode = new System.Windows.Forms.PictureBox();
            this.textBarCode = new System.Windows.Forms.TextBox();
            this.pictureBoxBarCode = new System.Windows.Forms.PictureBox();
            this.groupBoxCode.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxQRCode)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxBarCode)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBoxCode
            // 
            this.groupBoxCode.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.groupBoxCode.BorderWidth = 1;
            this.groupBoxCode.Controls.Add(this.pictureBoxBarCode);
            this.groupBoxCode.Controls.Add(this.textBarCode);
            this.groupBoxCode.Controls.Add(this.pictureBoxQRCode);
            this.groupBoxCode.Controls.Add(this.textQRCode);
            this.groupBoxCode.Controls.Add(this.checkBarCode);
            this.groupBoxCode.Controls.Add(this.checkQRCode);
            this.groupBoxCode.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBoxCode.Location = new System.Drawing.Point(12, 12);
            this.groupBoxCode.Name = "groupBoxCode";
            this.groupBoxCode.ShowText = true;
            this.groupBoxCode.Size = new System.Drawing.Size(560, 264);
            this.groupBoxCode.TabIndex = 0;
            this.groupBoxCode.TabStop = false;
            this.groupBoxCode.Text = "Code";
            this.groupBoxCode.TextColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            // 
            // buttonChange
            // 
            this.buttonChange.Depth = 0;
            this.buttonChange.Elevation = 5;
            this.buttonChange.Location = new System.Drawing.Point(224, 282);
            this.buttonChange.MouseState = Zeroit.Framework.MaterialWinforms.MouseState.HOVER;
            this.buttonChange.Name = "buttonChange";
            this.buttonChange.Primary = true;
            graphicsPath7.FillMode = System.Drawing.Drawing2D.FillMode.Alternate;
            this.buttonChange.ShadowBorder = graphicsPath7;
            this.buttonChange.Size = new System.Drawing.Size(130, 50);
            this.buttonChange.TabIndex = 1;
            this.buttonChange.Text = "Thay đổi";
            this.buttonChange.UseVisualStyleBackColor = true;
            this.buttonChange.Click += new System.EventHandler(this.buttonChange_Click);
            // 
            // buttonCancel
            // 
            this.buttonCancel.Depth = 0;
            this.buttonCancel.Elevation = 5;
            this.buttonCancel.Location = new System.Drawing.Point(442, 282);
            this.buttonCancel.MouseState = Zeroit.Framework.MaterialWinforms.MouseState.HOVER;
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Primary = true;
            graphicsPath8.FillMode = System.Drawing.Drawing2D.FillMode.Alternate;
            this.buttonCancel.ShadowBorder = graphicsPath8;
            this.buttonCancel.Size = new System.Drawing.Size(130, 50);
            this.buttonCancel.TabIndex = 2;
            this.buttonCancel.Text = "Hủy";
            this.buttonCancel.UseVisualStyleBackColor = true;
            this.buttonCancel.Click += new System.EventHandler(this.buttonCancel_Click);
            // 
            // buttonTry
            // 
            this.buttonTry.Depth = 0;
            this.buttonTry.Elevation = 5;
            this.buttonTry.Location = new System.Drawing.Point(12, 282);
            this.buttonTry.MouseState = Zeroit.Framework.MaterialWinforms.MouseState.HOVER;
            this.buttonTry.Name = "buttonTry";
            this.buttonTry.Primary = true;
            graphicsPath9.FillMode = System.Drawing.Drawing2D.FillMode.Alternate;
            this.buttonTry.ShadowBorder = graphicsPath9;
            this.buttonTry.Size = new System.Drawing.Size(130, 50);
            this.buttonTry.TabIndex = 3;
            this.buttonTry.Text = "Thử";
            this.buttonTry.UseVisualStyleBackColor = true;
            this.buttonTry.Click += new System.EventHandler(this.buttonTry_Click);
            // 
            // checkQRCode
            // 
            this.checkQRCode.AutoSize = true;
            this.checkQRCode.Depth = 0;
            this.checkQRCode.Location = new System.Drawing.Point(3, 24);
            this.checkQRCode.Margin = new System.Windows.Forms.Padding(0);
            this.checkQRCode.MouseLocation = new System.Drawing.Point(-1, -1);
            this.checkQRCode.MouseState = MaterialSkin.MouseState.HOVER;
            this.checkQRCode.Name = "checkQRCode";
            this.checkQRCode.Ripple = true;
            this.checkQRCode.Size = new System.Drawing.Size(97, 37);
            this.checkQRCode.TabIndex = 5;
            this.checkQRCode.Text = "QR Code";
            this.checkQRCode.UseVisualStyleBackColor = true;
            this.checkQRCode.CheckedChanged += new System.EventHandler(this.checkQRCode_CheckedChanged);
            // 
            // checkBarCode
            // 
            this.checkBarCode.AutoSize = true;
            this.checkBarCode.Depth = 0;
            this.checkBarCode.Location = new System.Drawing.Point(3, 210);
            this.checkBarCode.Margin = new System.Windows.Forms.Padding(0);
            this.checkBarCode.MouseLocation = new System.Drawing.Point(-1, -1);
            this.checkBarCode.MouseState = MaterialSkin.MouseState.HOVER;
            this.checkBarCode.Name = "checkBarCode";
            this.checkBarCode.Ripple = true;
            this.checkBarCode.Size = new System.Drawing.Size(97, 37);
            this.checkBarCode.TabIndex = 6;
            this.checkBarCode.Text = "Mã vạch";
            this.checkBarCode.UseVisualStyleBackColor = true;
            this.checkBarCode.CheckedChanged += new System.EventHandler(this.checkBarCode_CheckedChanged);
            // 
            // textQRCode
            // 
            this.textQRCode.Enabled = false;
            this.textQRCode.Location = new System.Drawing.Point(141, 16);
            this.textQRCode.Name = "textQRCode";
            this.textQRCode.Size = new System.Drawing.Size(413, 167);
            this.textQRCode.TabIndex = 7;
            this.textQRCode.Text = "RESTAURANT\nĐịa Chỉ: Số 3 Cầu Giấy, Láng Thượng, Đống Đa, Hà Nội\nSĐT: 0123456789\nS" +
    "ố Hóa Đơn: HDB00001\nMã Khách Hàng: KH001\nNếu có thắc mắc gì hãy nói với chúng tô" +
    "i";
            // 
            // pictureBoxQRCode
            // 
            this.pictureBoxQRCode.Location = new System.Drawing.Point(13, 64);
            this.pictureBoxQRCode.Name = "pictureBoxQRCode";
            this.pictureBoxQRCode.Size = new System.Drawing.Size(117, 117);
            this.pictureBoxQRCode.TabIndex = 8;
            this.pictureBoxQRCode.TabStop = false;
            // 
            // textBarCode
            // 
            this.textBarCode.Enabled = false;
            this.textBarCode.Location = new System.Drawing.Point(162, 214);
            this.textBarCode.MaxLength = 12;
            this.textBarCode.Name = "textBarCode";
            this.textBarCode.Size = new System.Drawing.Size(209, 26);
            this.textBarCode.TabIndex = 9;
            this.textBarCode.Text = "HDB00001";
            // 
            // pictureBoxBarCode
            // 
            this.pictureBoxBarCode.Location = new System.Drawing.Point(377, 189);
            this.pictureBoxBarCode.Name = "pictureBoxBarCode";
            this.pictureBoxBarCode.Size = new System.Drawing.Size(177, 69);
            this.pictureBoxBarCode.TabIndex = 10;
            this.pictureBoxBarCode.TabStop = false;
            // 
            // FormCode
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.ClientSize = new System.Drawing.Size(584, 339);
            this.Controls.Add(this.buttonTry);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonChange);
            this.Controls.Add(this.groupBoxCode);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.Name = "FormCode";
            this.Text = "FormCode";
            this.Load += new System.EventHandler(this.FormCode_Load);
            this.groupBoxCode.ResumeLayout(false);
            this.groupBoxCode.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxQRCode)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxBarCode)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private XanderUI.XUICustomGroupbox groupBoxCode;
        private Zeroit.Framework.MaterialWinforms.Controls.MaterialRaisedButton buttonChange;
        private Zeroit.Framework.MaterialWinforms.Controls.MaterialRaisedButton buttonCancel;
        private Zeroit.Framework.MaterialWinforms.Controls.MaterialRaisedButton buttonTry;
        private System.Windows.Forms.PictureBox pictureBoxQRCode;
        private System.Windows.Forms.RichTextBox textQRCode;
        private MaterialSkin.Controls.MaterialCheckbox checkBarCode;
        private MaterialSkin.Controls.MaterialCheckbox checkQRCode;
        private System.Windows.Forms.PictureBox pictureBoxBarCode;
        private System.Windows.Forms.TextBox textBarCode;
    }
}