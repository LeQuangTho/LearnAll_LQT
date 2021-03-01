namespace Restaurant.Forms
{
    partial class FormPanelHDB
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormPanelHDB));
            this.panel1 = new System.Windows.Forms.Panel();
            this.buttonCancel = new FontAwesome.Sharp.IconButton();
            this.buttonCode = new FontAwesome.Sharp.IconButton();
            this.buttonPrint = new FontAwesome.Sharp.IconButton();
            this.panelHDBPreview = new System.Windows.Forms.Panel();
            this.userControlBillFooter1 = new Restaurant.UserControls.UserControlBillFooter();
            this.userControlBillHeader = new Restaurant.UserControls.UserControlBillHeader();
            this.panel1.SuspendLayout();
            this.panelHDBPreview.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.buttonCancel);
            this.panel1.Controls.Add(this.buttonCode);
            this.panel1.Controls.Add(this.buttonPrint);
            this.panel1.Controls.Add(this.panelHDBPreview);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(377, 571);
            this.panel1.TabIndex = 0;
            // 
            // buttonCancel
            // 
            this.buttonCancel.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonCancel.Dock = System.Windows.Forms.DockStyle.Left;
            this.buttonCancel.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonCancel.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonCancel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonCancel.IconChar = FontAwesome.Sharp.IconChar.Times;
            this.buttonCancel.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonCancel.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonCancel.IconSize = 36;
            this.buttonCancel.Location = new System.Drawing.Point(250, 511);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Rotation = 0D;
            this.buttonCancel.Size = new System.Drawing.Size(125, 60);
            this.buttonCancel.TabIndex = 5;
            this.buttonCancel.Text = "Hủy";
            this.buttonCancel.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            this.buttonCancel.UseVisualStyleBackColor = true;
            this.buttonCancel.Click += new System.EventHandler(this.buttonCancel_Click);
            // 
            // buttonCode
            // 
            this.buttonCode.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonCode.Dock = System.Windows.Forms.DockStyle.Left;
            this.buttonCode.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonCode.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonCode.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonCode.IconChar = FontAwesome.Sharp.IconChar.Qrcode;
            this.buttonCode.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonCode.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonCode.IconSize = 36;
            this.buttonCode.Location = new System.Drawing.Point(125, 511);
            this.buttonCode.Name = "buttonCode";
            this.buttonCode.Rotation = 0D;
            this.buttonCode.Size = new System.Drawing.Size(125, 60);
            this.buttonCode.TabIndex = 4;
            this.buttonCode.Text = "Code";
            this.buttonCode.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            this.buttonCode.UseVisualStyleBackColor = true;
            this.buttonCode.Click += new System.EventHandler(this.buttonCode_Click);
            // 
            // buttonPrint
            // 
            this.buttonPrint.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonPrint.Dock = System.Windows.Forms.DockStyle.Left;
            this.buttonPrint.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonPrint.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonPrint.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonPrint.IconChar = FontAwesome.Sharp.IconChar.Print;
            this.buttonPrint.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonPrint.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonPrint.IconSize = 36;
            this.buttonPrint.Location = new System.Drawing.Point(0, 511);
            this.buttonPrint.Name = "buttonPrint";
            this.buttonPrint.Rotation = 0D;
            this.buttonPrint.Size = new System.Drawing.Size(125, 60);
            this.buttonPrint.TabIndex = 3;
            this.buttonPrint.Text = "In hóa đơn";
            this.buttonPrint.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            this.buttonPrint.UseVisualStyleBackColor = true;
            // 
            // panelHDBPreview
            // 
            this.panelHDBPreview.AutoScroll = true;
            this.panelHDBPreview.Controls.Add(this.userControlBillFooter1);
            this.panelHDBPreview.Controls.Add(this.userControlBillHeader);
            this.panelHDBPreview.Dock = System.Windows.Forms.DockStyle.Top;
            this.panelHDBPreview.Location = new System.Drawing.Point(0, 0);
            this.panelHDBPreview.Name = "panelHDBPreview";
            this.panelHDBPreview.Size = new System.Drawing.Size(377, 511);
            this.panelHDBPreview.TabIndex = 0;
            // 
            // userControlBillFooter1
            // 
            this.userControlBillFooter1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.userControlBillFooter1.BarcodeText = "8934602001078";
            this.userControlBillFooter1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.userControlBillFooter1.Location = new System.Drawing.Point(0, 727);
            this.userControlBillFooter1.Name = "userControlBillFooter1";
            this.userControlBillFooter1.Size = new System.Drawing.Size(360, 223);
            this.userControlBillFooter1.TabIndex = 1;
            // 
            // userControlBillHeader
            // 
            this.userControlBillHeader.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.userControlBillHeader.Dock = System.Windows.Forms.DockStyle.Top;
            this.userControlBillHeader.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.userControlBillHeader.Location = new System.Drawing.Point(0, 0);
            this.userControlBillHeader.Name = "userControlBillHeader";
            this.userControlBillHeader.QRCodeText = "HDB0001";
            this.userControlBillHeader.Size = new System.Drawing.Size(360, 325);
            this.userControlBillHeader.TabIndex = 0;
            // 
            // FormPanelHDB
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.ClientSize = new System.Drawing.Size(377, 571);
            this.Controls.Add(this.panel1);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "FormPanelHDB";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "FormPanelHDB";
            this.Load += new System.EventHandler(this.FormPanelHDB_Load);
            this.panel1.ResumeLayout(false);
            this.panelHDBPreview.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panelHDBPreview;
        private FontAwesome.Sharp.IconButton buttonCancel;
        private FontAwesome.Sharp.IconButton buttonCode;
        private FontAwesome.Sharp.IconButton buttonPrint;
        private UserControls.UserControlBillFooter userControlBillFooter1;
        private UserControls.UserControlBillHeader userControlBillHeader;
    }
}