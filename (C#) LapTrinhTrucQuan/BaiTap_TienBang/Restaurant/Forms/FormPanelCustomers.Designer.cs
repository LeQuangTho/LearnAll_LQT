namespace Restaurant.Forms
{
    partial class FormPanelCustomers
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
            this.zeroitLollipopCard1 = new Zeroit.Framework.LollipopControls.Controls.ZeroitLollipopCard();
            this.SuspendLayout();
            // 
            // zeroitLollipopCard1
            // 
            this.zeroitLollipopCard1.AllowTransparency = true;
            this.zeroitLollipopCard1.BorderRadius = 1;
            this.zeroitLollipopCard1.ButtonColor = System.Drawing.Color.FromArgb(((int)(((byte)(51)))), ((int)(((byte)(182)))), ((int)(((byte)(121)))));
            this.zeroitLollipopCard1.ContentColor = System.Drawing.Color.FromArgb(((int)(((byte)(121)))), ((int)(((byte)(144)))), ((int)(((byte)(62)))));
            this.zeroitLollipopCard1.ContentText = "Card Content is here";
            this.zeroitLollipopCard1.EmptyColor = System.Drawing.Color.FromArgb(((int)(((byte)(227)))), ((int)(((byte)(229)))), ((int)(((byte)(231)))));
            this.zeroitLollipopCard1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(51)))), ((int)(((byte)(182)))), ((int)(((byte)(121)))));
            this.zeroitLollipopCard1.Image = null;
            this.zeroitLollipopCard1.Location = new System.Drawing.Point(110, 12);
            this.zeroitLollipopCard1.LowerBorder = System.Drawing.Color.FromArgb(((int)(((byte)(218)))), ((int)(((byte)(220)))), ((int)(((byte)(223)))));
            this.zeroitLollipopCard1.LowerRectangle = System.Drawing.Color.White;
            this.zeroitLollipopCard1.Name = "zeroitLollipopCard1";
            this.zeroitLollipopCard1.OKButtonAlignment = Zeroit.Framework.LollipopControls.Controls.ZeroitLollipopCard.OKAlignment.Right;
            this.zeroitLollipopCard1.OKButtonColor = System.Drawing.Color.Gray;
            this.zeroitLollipopCard1.OKButtonRadius = 1;
            this.zeroitLollipopCard1.Size = new System.Drawing.Size(235, 299);
            this.zeroitLollipopCard1.TabIndex = 1;
            this.zeroitLollipopCard1.Text = "zeroitLollipopCard1";
            // 
            // FormPanelCustomers
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1014, 611);
            this.Controls.Add(this.zeroitLollipopCard1);
            this.Name = "FormPanelCustomers";
            this.Text = "FormPanelCustomers";
            this.ResumeLayout(false);

        }

        #endregion
        private Zeroit.Framework.LollipopControls.Controls.ZeroitLollipopCard zeroitLollipopCard1;
    }
}