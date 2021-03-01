namespace Restaurant
{
    partial class FormLoading
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
            this.components = new System.ComponentModel.Container();
            this.progressBar = new XanderUI.XUICircleProgressBar();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.labelLoading = new System.Windows.Forms.Label();
            this.timerLoad = new System.Windows.Forms.Timer(this.components);
            this.radiusCircleProgressBar1 = new Restaurant.CustomControls.RadiusCircleProgressBar();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // progressBar
            // 
            this.progressBar.AnimationSpeed = 5;
            this.progressBar.FilledColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.progressBar.FilledColorAlpha = 255;
            this.progressBar.FilledThickness = 500;
            this.progressBar.IsAnimated = false;
            this.progressBar.Location = new System.Drawing.Point(-122, -323);
            this.progressBar.Name = "progressBar";
            this.progressBar.Percentage = 63;
            this.progressBar.ShowText = true;
            this.progressBar.Size = new System.Drawing.Size(1250, 1250);
            this.progressBar.TabIndex = 0;
            this.progressBar.TextColor = System.Drawing.Color.Transparent;
            this.progressBar.TextSize = 25;
            this.progressBar.UnFilledColor = System.Drawing.Color.Transparent;
            this.progressBar.UnfilledThickness = 24;
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::Restaurant.Properties.Resources.Logo_Restaurant;
            this.pictureBox1.Location = new System.Drawing.Point(457, 242);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(142, 105);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 2;
            this.pictureBox1.TabStop = false;
            // 
            // labelLoading
            // 
            this.labelLoading.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.labelLoading.Font = new System.Drawing.Font("Cooper Black", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelLoading.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.labelLoading.Location = new System.Drawing.Point(442, 387);
            this.labelLoading.Name = "labelLoading";
            this.labelLoading.Size = new System.Drawing.Size(175, 27);
            this.labelLoading.TabIndex = 3;
            this.labelLoading.Text = "Loading . . . 100%";
            this.labelLoading.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // timerLoad
            // 
            this.timerLoad.Interval = 20;
            this.timerLoad.Tick += new System.EventHandler(this.timerLoad_Tick);
            // 
            // radiusCircleProgressBar1
            // 
            this.radiusCircleProgressBar1.AnimationSpeed = 5;
            this.radiusCircleProgressBar1.BorderColor = System.Drawing.Color.Transparent;
            this.radiusCircleProgressBar1.BorderRadiusBottomLeft = 300;
            this.radiusCircleProgressBar1.BorderRadiusBottomRight = 300;
            this.radiusCircleProgressBar1.BorderRadiusTopLeft = 300;
            this.radiusCircleProgressBar1.BorderRadiusTopRight = 300;
            this.radiusCircleProgressBar1.BorderWidth = 5F;
            this.radiusCircleProgressBar1.FilledColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.radiusCircleProgressBar1.FilledColorAlpha = 255;
            this.radiusCircleProgressBar1.FilledThickness = 60;
            this.radiusCircleProgressBar1.IsAnimated = false;
            this.radiusCircleProgressBar1.Location = new System.Drawing.Point(378, 145);
            this.radiusCircleProgressBar1.Name = "radiusCircleProgressBar1";
            this.radiusCircleProgressBar1.Percentage = 100;
            this.radiusCircleProgressBar1.ShowText = true;
            this.radiusCircleProgressBar1.Size = new System.Drawing.Size(300, 300);
            this.radiusCircleProgressBar1.TabIndex = 1;
            this.radiusCircleProgressBar1.TextColor = System.Drawing.Color.Transparent;
            this.radiusCircleProgressBar1.TextSize = 25;
            this.radiusCircleProgressBar1.UnFilledColor = System.Drawing.Color.Transparent;
            this.radiusCircleProgressBar1.UnfilledThickness = 24;
            // 
            // FormLoading
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(251)))));
            this.ClientSize = new System.Drawing.Size(934, 611);
            this.Controls.Add(this.labelLoading);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.radiusCircleProgressBar1);
            this.Controls.Add(this.progressBar);
            this.Name = "FormLoading";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "FormLoading";
            this.Load += new System.EventHandler(this.FormLoading_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private XanderUI.XUICircleProgressBar progressBar;
        private CustomControls.RadiusCircleProgressBar radiusCircleProgressBar1;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label labelLoading;
        private System.Windows.Forms.Timer timerLoad;
    }
}