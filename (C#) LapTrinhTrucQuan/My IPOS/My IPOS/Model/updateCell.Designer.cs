namespace My_IPOS.Model
{
    partial class edit
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
            this.tbSua = new Guna.UI.WinForms.GunaTextBox();
            this.btnOK = new Guna.UI.WinForms.GunaGradientButton();
            this.SuspendLayout();
            // 
            // tbSua
            // 
            this.tbSua.BaseColor = System.Drawing.Color.White;
            this.tbSua.BorderColor = System.Drawing.Color.Silver;
            this.tbSua.Cursor = System.Windows.Forms.Cursors.IBeam;
            this.tbSua.FocusedBaseColor = System.Drawing.Color.White;
            this.tbSua.FocusedBorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(88)))), ((int)(((byte)(255)))));
            this.tbSua.FocusedForeColor = System.Drawing.SystemColors.ControlText;
            this.tbSua.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.tbSua.Location = new System.Drawing.Point(42, 21);
            this.tbSua.Name = "tbSua";
            this.tbSua.PasswordChar = '\0';
            this.tbSua.SelectedText = "";
            this.tbSua.Size = new System.Drawing.Size(160, 30);
            this.tbSua.TabIndex = 0;
            this.tbSua.KeyDown += new System.Windows.Forms.KeyEventHandler(this.tbSua_KeyDown);
            // 
            // btnOK
            // 
            this.btnOK.AnimationHoverSpeed = 0.07F;
            this.btnOK.AnimationSpeed = 0.03F;
            this.btnOK.BaseColor1 = System.Drawing.Color.SlateBlue;
            this.btnOK.BaseColor2 = System.Drawing.Color.Fuchsia;
            this.btnOK.BorderColor = System.Drawing.Color.Black;
            this.btnOK.DialogResult = System.Windows.Forms.DialogResult.None;
            this.btnOK.FocusedColor = System.Drawing.Color.Empty;
            this.btnOK.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btnOK.ForeColor = System.Drawing.Color.White;
            this.btnOK.Image = null;
            this.btnOK.ImageSize = new System.Drawing.Size(20, 20);
            this.btnOK.Location = new System.Drawing.Point(79, 77);
            this.btnOK.Name = "btnOK";
            this.btnOK.OnHoverBaseColor1 = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(145)))), ((int)(((byte)(221)))));
            this.btnOK.OnHoverBaseColor2 = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(85)))), ((int)(((byte)(255)))));
            this.btnOK.OnHoverBorderColor = System.Drawing.Color.Black;
            this.btnOK.OnHoverForeColor = System.Drawing.Color.SaddleBrown;
            this.btnOK.OnHoverImage = null;
            this.btnOK.OnPressedColor = System.Drawing.Color.Black;
            this.btnOK.Size = new System.Drawing.Size(94, 27);
            this.btnOK.TabIndex = 1;
            this.btnOK.Text = "ok";
            this.btnOK.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.btnOK.Click += new System.EventHandler(this.btnOK_Click);
            // 
            // edit
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(243, 124);
            this.Controls.Add(this.btnOK);
            this.Controls.Add(this.tbSua);
            this.Name = "edit";
            this.ShowIcon = false;
            this.ResumeLayout(false);

        }

        #endregion

        private Guna.UI.WinForms.GunaTextBox tbSua;
        private Guna.UI.WinForms.GunaGradientButton btnOK;
    }
}