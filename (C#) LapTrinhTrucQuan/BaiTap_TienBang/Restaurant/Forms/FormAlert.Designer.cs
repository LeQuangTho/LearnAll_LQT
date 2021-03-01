namespace Restaurant.Forms
{
    partial class FormAlert
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
            this.iconAlert = new FontAwesome.Sharp.IconPictureBox();
            this.buttonClose = new FontAwesome.Sharp.IconButton();
            this.labelTitleAlert = new System.Windows.Forms.Label();
            this.timerAlert = new System.Windows.Forms.Timer(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.iconAlert)).BeginInit();
            this.SuspendLayout();
            // 
            // iconAlert
            // 
            this.iconAlert.BackColor = System.Drawing.Color.Red;
            this.iconAlert.Dock = System.Windows.Forms.DockStyle.Left;
            this.iconAlert.IconChar = FontAwesome.Sharp.IconChar.ExclamationCircle;
            this.iconAlert.IconColor = System.Drawing.Color.White;
            this.iconAlert.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.iconAlert.IconSize = 40;
            this.iconAlert.Location = new System.Drawing.Point(0, 0);
            this.iconAlert.Name = "iconAlert";
            this.iconAlert.Size = new System.Drawing.Size(40, 80);
            this.iconAlert.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.iconAlert.TabIndex = 1;
            this.iconAlert.TabStop = false;
            // 
            // buttonClose
            // 
            this.buttonClose.BackColor = System.Drawing.Color.Transparent;
            this.buttonClose.Cursor = System.Windows.Forms.Cursors.Hand;
            this.buttonClose.Dock = System.Windows.Forms.DockStyle.Right;
            this.buttonClose.FlatAppearance.BorderColor = System.Drawing.Color.Red;
            this.buttonClose.FlatAppearance.BorderSize = 0;
            this.buttonClose.FlatAppearance.MouseDownBackColor = System.Drawing.Color.Red;
            this.buttonClose.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Red;
            this.buttonClose.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonClose.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonClose.IconChar = FontAwesome.Sharp.IconChar.TimesCircle;
            this.buttonClose.IconColor = System.Drawing.Color.White;
            this.buttonClose.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonClose.IconSize = 38;
            this.buttonClose.Location = new System.Drawing.Point(360, 0);
            this.buttonClose.Name = "buttonClose";
            this.buttonClose.Rotation = 0D;
            this.buttonClose.Size = new System.Drawing.Size(40, 80);
            this.buttonClose.TabIndex = 2;
            this.buttonClose.UseVisualStyleBackColor = false;
            this.buttonClose.Click += new System.EventHandler(this.buttonClose_Click);
            // 
            // labelTitleAlert
            // 
            this.labelTitleAlert.Dock = System.Windows.Forms.DockStyle.Fill;
            this.labelTitleAlert.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelTitleAlert.Location = new System.Drawing.Point(40, 0);
            this.labelTitleAlert.Name = "labelTitleAlert";
            this.labelTitleAlert.Size = new System.Drawing.Size(320, 80);
            this.labelTitleAlert.TabIndex = 3;
            this.labelTitleAlert.Text = "Bạn chỉ được nhập số";
            this.labelTitleAlert.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // timerAlert
            // 
            this.timerAlert.Tick += new System.EventHandler(this.timerAlert_Tick);
            // 
            // FormAlert
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Red;
            this.ClientSize = new System.Drawing.Size(400, 80);
            this.Controls.Add(this.labelTitleAlert);
            this.Controls.Add(this.buttonClose);
            this.Controls.Add(this.iconAlert);
            this.ForeColor = System.Drawing.Color.White;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "FormAlert";
            this.Text = "FormAlert";
            ((System.ComponentModel.ISupportInitialize)(this.iconAlert)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private FontAwesome.Sharp.IconPictureBox iconAlert;
        private FontAwesome.Sharp.IconButton buttonClose;
        private System.Windows.Forms.Label labelTitleAlert;
        private System.Windows.Forms.Timer timerAlert;
    }
}