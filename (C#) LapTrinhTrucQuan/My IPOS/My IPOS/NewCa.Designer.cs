namespace My_IPOS
{
    partial class NewCa
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(NewCa));
            this.lbDuDau = new System.Windows.Forms.Label();
            this.tbDuDau = new System.Windows.Forms.TextBox();
            this.btBatDau = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lbDuDau
            // 
            this.lbDuDau.AutoSize = true;
            this.lbDuDau.Font = new System.Drawing.Font("Times New Roman", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbDuDau.ForeColor = System.Drawing.Color.MidnightBlue;
            this.lbDuDau.Location = new System.Drawing.Point(12, 60);
            this.lbDuDau.Name = "lbDuDau";
            this.lbDuDau.Size = new System.Drawing.Size(89, 24);
            this.lbDuDau.TabIndex = 0;
            this.lbDuDau.Text = "Dư đầu: ";
            // 
            // tbDuDau
            // 
            this.tbDuDau.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbDuDau.Location = new System.Drawing.Point(189, 49);
            this.tbDuDau.Name = "tbDuDau";
            this.tbDuDau.Size = new System.Drawing.Size(143, 35);
            this.tbDuDau.TabIndex = 1;
            this.tbDuDau.Text = "0";
            this.tbDuDau.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.tbDuDau.KeyDown += new System.Windows.Forms.KeyEventHandler(this.tbDuDau_KeyDown);
            this.tbDuDau.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.tbDuDau_KeyPress);
            // 
            // btBatDau
            // 
            this.btBatDau.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btBatDau.ForeColor = System.Drawing.Color.Black;
            this.btBatDau.Location = new System.Drawing.Point(237, 123);
            this.btBatDau.Name = "btBatDau";
            this.btBatDau.Size = new System.Drawing.Size(95, 57);
            this.btBatDau.TabIndex = 2;
            this.btBatDau.Text = "Bắt đầu";
            this.btBatDau.UseVisualStyleBackColor = true;
            this.btBatDau.Click += new System.EventHandler(this.btBatDau_Click);
            // 
            // NewCa
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(192)))));
            this.ClientSize = new System.Drawing.Size(369, 322);
            this.Controls.Add(this.btBatDau);
            this.Controls.Add(this.tbDuDau);
            this.Controls.Add(this.lbDuDau);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "NewCa";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Ca Mới";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.NewCa_FormClosed);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lbDuDau;
        private System.Windows.Forms.TextBox tbDuDau;
        private System.Windows.Forms.Button btBatDau;
    }
}