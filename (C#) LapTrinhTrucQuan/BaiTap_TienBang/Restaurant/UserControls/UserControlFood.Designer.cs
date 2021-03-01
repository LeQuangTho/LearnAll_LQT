namespace Restaurant.UserControls
{
    partial class UserControlFood
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

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(UserControlFood));
            this.pictureMonAn = new System.Windows.Forms.PictureBox();
            this.labelTenMonAn = new System.Windows.Forms.Label();
            this.buttonAdd = new FontAwesome.Sharp.IconButton();
            this.labelMaMonAn = new System.Windows.Forms.Label();
            this.labelDonGia = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.pictureMonAn)).BeginInit();
            this.SuspendLayout();
            // 
            // pictureMonAn
            // 
            this.pictureMonAn.Dock = System.Windows.Forms.DockStyle.Top;
            this.pictureMonAn.Image = ((System.Drawing.Image)(resources.GetObject("pictureMonAn.Image")));
            this.pictureMonAn.Location = new System.Drawing.Point(0, 0);
            this.pictureMonAn.Name = "pictureMonAn";
            this.pictureMonAn.Size = new System.Drawing.Size(250, 175);
            this.pictureMonAn.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureMonAn.TabIndex = 0;
            this.pictureMonAn.TabStop = false;
            // 
            // labelTenMonAn
            // 
            this.labelTenMonAn.Dock = System.Windows.Forms.DockStyle.Top;
            this.labelTenMonAn.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelTenMonAn.Location = new System.Drawing.Point(0, 175);
            this.labelTenMonAn.Name = "labelTenMonAn";
            this.labelTenMonAn.Size = new System.Drawing.Size(250, 25);
            this.labelTenMonAn.TabIndex = 1;
            this.labelTenMonAn.Text = "Sườn xào chua ngọt";
            this.labelTenMonAn.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // buttonAdd
            // 
            this.buttonAdd.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonAdd.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonAdd.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonAdd.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonAdd.IconChar = FontAwesome.Sharp.IconChar.Plus;
            this.buttonAdd.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonAdd.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonAdd.IconSize = 32;
            this.buttonAdd.Location = new System.Drawing.Point(60, 228);
            this.buttonAdd.Name = "buttonAdd";
            this.buttonAdd.Rotation = 0D;
            this.buttonAdd.Size = new System.Drawing.Size(130, 38);
            this.buttonAdd.TabIndex = 2;
            this.buttonAdd.Text = "Thêm món ăn";
            this.buttonAdd.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.buttonAdd.UseVisualStyleBackColor = true;
            // 
            // labelMaMonAn
            // 
            this.labelMaMonAn.AutoSize = true;
            this.labelMaMonAn.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.labelMaMonAn.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelMaMonAn.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(251)))));
            this.labelMaMonAn.Location = new System.Drawing.Point(0, 0);
            this.labelMaMonAn.Name = "labelMaMonAn";
            this.labelMaMonAn.Size = new System.Drawing.Size(85, 20);
            this.labelMaMonAn.TabIndex = 4;
            this.labelMaMonAn.Text = "MonAn29";
            // 
            // labelDonGia
            // 
            this.labelDonGia.Dock = System.Windows.Forms.DockStyle.Top;
            this.labelDonGia.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelDonGia.Location = new System.Drawing.Point(0, 200);
            this.labelDonGia.Name = "labelDonGia";
            this.labelDonGia.Size = new System.Drawing.Size(250, 25);
            this.labelDonGia.TabIndex = 5;
            this.labelDonGia.Text = "Giá: 100000";
            this.labelDonGia.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // UserControlFood
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(251)))));
            this.Controls.Add(this.labelDonGia);
            this.Controls.Add(this.labelMaMonAn);
            this.Controls.Add(this.buttonAdd);
            this.Controls.Add(this.labelTenMonAn);
            this.Controls.Add(this.pictureMonAn);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.Name = "UserControlFood";
            this.Size = new System.Drawing.Size(250, 275);
            ((System.ComponentModel.ISupportInitialize)(this.pictureMonAn)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        public System.Windows.Forms.PictureBox pictureMonAn;
        public System.Windows.Forms.Label labelTenMonAn;
        public System.Windows.Forms.Label labelMaMonAn;
        public System.Windows.Forms.Label labelDonGia;
        public FontAwesome.Sharp.IconButton buttonAdd;
    }
}
