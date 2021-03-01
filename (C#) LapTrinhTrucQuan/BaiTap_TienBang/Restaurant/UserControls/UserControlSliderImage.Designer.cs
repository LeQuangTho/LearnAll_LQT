namespace Restaurant.UserControls
{
    partial class UserControlSliderImage
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(UserControlSliderImage));
            this.labelTitleSlider = new System.Windows.Forms.Label();
            this.labelSubTitleSlider = new System.Windows.Forms.Label();
            this.pictureBoxSlider = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxSlider)).BeginInit();
            this.SuspendLayout();
            // 
            // labelTitleSlider
            // 
            this.labelTitleSlider.Dock = System.Windows.Forms.DockStyle.Top;
            this.labelTitleSlider.Font = new System.Drawing.Font("Microsoft Sans Serif", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelTitleSlider.Location = new System.Drawing.Point(0, 0);
            this.labelTitleSlider.Name = "labelTitleSlider";
            this.labelTitleSlider.Size = new System.Drawing.Size(914, 84);
            this.labelTitleSlider.TabIndex = 0;
            this.labelTitleSlider.Text = "Tiết kiệm tiền";
            this.labelTitleSlider.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // labelSubTitleSlider
            // 
            this.labelSubTitleSlider.Dock = System.Windows.Forms.DockStyle.Fill;
            this.labelSubTitleSlider.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelSubTitleSlider.Location = new System.Drawing.Point(0, 461);
            this.labelSubTitleSlider.Name = "labelSubTitleSlider";
            this.labelSubTitleSlider.Size = new System.Drawing.Size(914, 150);
            this.labelSubTitleSlider.TabIndex = 2;
            this.labelSubTitleSlider.Text = "Giá thành hợp lý chỉ với 100$ / năm";
            this.labelSubTitleSlider.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // pictureBoxSlider
            // 
            this.pictureBoxSlider.Dock = System.Windows.Forms.DockStyle.Top;
            this.pictureBoxSlider.Image = ((System.Drawing.Image)(resources.GetObject("pictureBoxSlider.Image")));
            this.pictureBoxSlider.Location = new System.Drawing.Point(0, 84);
            this.pictureBoxSlider.Name = "pictureBoxSlider";
            this.pictureBoxSlider.Size = new System.Drawing.Size(914, 377);
            this.pictureBoxSlider.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBoxSlider.TabIndex = 1;
            this.pictureBoxSlider.TabStop = false;
            // 
            // UserControlSliderImage
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.Controls.Add(this.labelSubTitleSlider);
            this.Controls.Add(this.pictureBoxSlider);
            this.Controls.Add(this.labelTitleSlider);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.Name = "UserControlSliderImage";
            this.Size = new System.Drawing.Size(914, 611);
            this.Load += new System.EventHandler(this.UserControlSliderImage_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxSlider)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Label labelTitleSlider;
        private System.Windows.Forms.PictureBox pictureBoxSlider;
        private System.Windows.Forms.Label labelSubTitleSlider;
    }
}
