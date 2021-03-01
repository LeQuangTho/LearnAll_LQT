namespace BaiTap09
{
    partial class Form1
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
            this.f1 = new System.Windows.Forms.RadioButton();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.f4 = new System.Windows.Forms.RadioButton();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.h4 = new System.Windows.Forms.CheckBox();
            this.h3 = new System.Windows.Forms.CheckBox();
            this.h2 = new System.Windows.Forms.CheckBox();
            this.h1 = new System.Windows.Forms.CheckBox();
            this.GroupBox4 = new System.Windows.Forms.GroupBox();
            this.m4 = new System.Windows.Forms.RadioButton();
            this.m3 = new System.Windows.Forms.RadioButton();
            this.m2 = new System.Windows.Forms.RadioButton();
            this.m1 = new System.Windows.Forms.RadioButton();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.GroupBox4.SuspendLayout();
            this.SuspendLayout();
            // 
            // f1
            // 
            this.f1.AutoSize = true;
            this.f1.Font = new System.Drawing.Font("VNTime", 8.249999F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.f1.Location = new System.Drawing.Point(32, 30);
            this.f1.Name = "f1";
            this.f1.Size = new System.Drawing.Size(63, 18);
            this.f1.TabIndex = 0;
            this.f1.TabStop = true;
            this.f1.Text = "VnTime";
            this.f1.UseVisualStyleBackColor = true;
            this.f1.CheckedChanged += new System.EventHandler(this.f1_CheckedChanged);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.f4);
            this.groupBox1.Controls.Add(this.f1);
            this.groupBox1.Location = new System.Drawing.Point(28, 81);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(163, 208);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Kiểu Font";
            // 
            // f4
            // 
            this.f4.AutoSize = true;
            this.f4.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.f4.Location = new System.Drawing.Point(32, 75);
            this.f4.Name = "f4";
            this.f4.Size = new System.Drawing.Size(63, 17);
            this.f4.TabIndex = 3;
            this.f4.TabStop = true;
            this.f4.Text = "Tahoma";
            this.f4.UseVisualStyleBackColor = true;
            this.f4.CheckedChanged += new System.EventHandler(this.f4_CheckedChanged);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.h4);
            this.groupBox2.Controls.Add(this.h3);
            this.groupBox2.Controls.Add(this.h2);
            this.groupBox2.Controls.Add(this.h1);
            this.groupBox2.Location = new System.Drawing.Point(257, 81);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(166, 208);
            this.groupBox2.TabIndex = 2;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Hiệu Ứng";
            // 
            // h4
            // 
            this.h4.AutoSize = true;
            this.h4.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.h4.Location = new System.Drawing.Point(16, 157);
            this.h4.Name = "h4";
            this.h4.Size = new System.Drawing.Size(71, 17);
            this.h4.TabIndex = 3;
            this.h4.Text = "Underline";
            this.h4.UseVisualStyleBackColor = true;
            this.h4.CheckedChanged += new System.EventHandler(this.h4_CheckedChanged);
            // 
            // h3
            // 
            this.h3.AutoSize = true;
            this.h3.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Strikeout, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.h3.Location = new System.Drawing.Point(16, 112);
            this.h3.Name = "h3";
            this.h3.Size = new System.Drawing.Size(68, 17);
            this.h3.TabIndex = 2;
            this.h3.Text = "Strikeout";
            this.h3.UseVisualStyleBackColor = true;
            this.h3.CheckedChanged += new System.EventHandler(this.h3_CheckedChanged);
            // 
            // h2
            // 
            this.h2.AutoSize = true;
            this.h2.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.h2.Location = new System.Drawing.Point(16, 76);
            this.h2.Name = "h2";
            this.h2.Size = new System.Drawing.Size(48, 17);
            this.h2.TabIndex = 1;
            this.h2.Text = "Italic";
            this.h2.UseVisualStyleBackColor = true;
            this.h2.CheckedChanged += new System.EventHandler(this.h2_CheckedChanged);
            // 
            // h1
            // 
            this.h1.AutoSize = true;
            this.h1.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.h1.Location = new System.Drawing.Point(16, 30);
            this.h1.Name = "h1";
            this.h1.Size = new System.Drawing.Size(51, 17);
            this.h1.TabIndex = 0;
            this.h1.Text = "Bold";
            this.h1.UseVisualStyleBackColor = true;
            this.h1.CheckedChanged += new System.EventHandler(this.h1_CheckedChanged);
            // 
            // GroupBox4
            // 
            this.GroupBox4.Controls.Add(this.m4);
            this.GroupBox4.Controls.Add(this.m3);
            this.GroupBox4.Controls.Add(this.m2);
            this.GroupBox4.Controls.Add(this.m1);
            this.GroupBox4.Location = new System.Drawing.Point(490, 81);
            this.GroupBox4.Name = "GroupBox4";
            this.GroupBox4.Size = new System.Drawing.Size(163, 208);
            this.GroupBox4.TabIndex = 4;
            this.GroupBox4.TabStop = false;
            this.GroupBox4.Text = "Màu chữ";
            // 
            // m4
            // 
            this.m4.AutoSize = true;
            this.m4.ForeColor = System.Drawing.Color.Purple;
            this.m4.Location = new System.Drawing.Point(32, 157);
            this.m4.Name = "m4";
            this.m4.Size = new System.Drawing.Size(44, 17);
            this.m4.TabIndex = 3;
            this.m4.TabStop = true;
            this.m4.Text = "Tím";
            this.m4.UseVisualStyleBackColor = true;
            this.m4.CheckedChanged += new System.EventHandler(this.m4_CheckedChanged);
            // 
            // m3
            // 
            this.m3.AutoSize = true;
            this.m3.ForeColor = System.Drawing.Color.Lime;
            this.m3.Location = new System.Drawing.Point(32, 112);
            this.m3.Name = "m3";
            this.m3.Size = new System.Drawing.Size(58, 17);
            this.m3.TabIndex = 2;
            this.m3.TabStop = true;
            this.m3.Text = "Lá Cây";
            this.m3.UseVisualStyleBackColor = true;
            this.m3.CheckedChanged += new System.EventHandler(this.m3_CheckedChanged);
            // 
            // m2
            // 
            this.m2.AutoSize = true;
            this.m2.ForeColor = System.Drawing.Color.Red;
            this.m2.Location = new System.Drawing.Point(32, 76);
            this.m2.Name = "m2";
            this.m2.Size = new System.Drawing.Size(39, 17);
            this.m2.TabIndex = 1;
            this.m2.TabStop = true;
            this.m2.Text = "Đỏ";
            this.m2.UseVisualStyleBackColor = true;
            this.m2.CheckedChanged += new System.EventHandler(this.m2_CheckedChanged);
            // 
            // m1
            // 
            this.m1.AutoSize = true;
            this.m1.ForeColor = System.Drawing.Color.Blue;
            this.m1.Location = new System.Drawing.Point(32, 30);
            this.m1.Name = "m1";
            this.m1.Size = new System.Drawing.Size(50, 17);
            this.m1.TabIndex = 0;
            this.m1.TabStop = true;
            this.m1.Text = "Xanh";
            this.m1.UseVisualStyleBackColor = true;
            this.m1.CheckedChanged += new System.EventHandler(this.m1_CheckedChanged);
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(79, 30);
            this.textBox1.Multiline = true;
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(501, 31);
            this.textBox1.TabIndex = 5;
            this.textBox1.Text = "Microsoft visual C#";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(665, 374);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.GroupBox4);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.GroupBox4.ResumeLayout(false);
            this.GroupBox4.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.RadioButton f1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.RadioButton f4;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.CheckBox h4;
        private System.Windows.Forms.CheckBox h3;
        private System.Windows.Forms.CheckBox h2;
        private System.Windows.Forms.CheckBox h1;
        private System.Windows.Forms.GroupBox GroupBox4;
        private System.Windows.Forms.RadioButton m4;
        private System.Windows.Forms.RadioButton m3;
        private System.Windows.Forms.RadioButton m2;
        private System.Windows.Forms.RadioButton m1;
        private System.Windows.Forms.TextBox textBox1;
    }
}

