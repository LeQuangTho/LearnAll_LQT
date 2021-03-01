namespace AppThuHai
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
            this.lb1 = new System.Windows.Forms.Label();
            this.lb2 = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.lb3 = new System.Windows.Forms.Label();
            this.btn1 = new System.Windows.Forms.Button();
            this.btn2 = new System.Windows.Forms.Button();
            this.btn3 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lb1
            // 
            this.lb1.AutoSize = true;
            this.lb1.Location = new System.Drawing.Point(53, 48);
            this.lb1.Name = "lb1";
            this.lb1.Size = new System.Drawing.Size(67, 13);
            this.lb1.TabIndex = 0;
            this.lb1.Text = "Nhập Tháng";
            // 
            // lb2
            // 
            this.lb2.AutoSize = true;
            this.lb2.Location = new System.Drawing.Point(53, 117);
            this.lb2.Name = "lb2";
            this.lb2.Size = new System.Drawing.Size(58, 13);
            this.lb2.TabIndex = 1;
            this.lb2.Text = "Nhập Năm";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(205, 48);
            this.textBox1.MaxLength = 2;
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(176, 20);
            this.textBox1.TabIndex = 2;
            this.textBox1.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.textBox1_KeyPress);
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(205, 110);
            this.textBox2.MaxLength = 4;
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(176, 20);
            this.textBox2.TabIndex = 3;
            // 
            // lb3
            // 
            this.lb3.AutoSize = true;
            this.lb3.ForeColor = System.Drawing.Color.Red;
            this.lb3.Location = new System.Drawing.Point(84, 184);
            this.lb3.Name = "lb3";
            this.lb3.Size = new System.Drawing.Size(0, 13);
            this.lb3.TabIndex = 4;
            // 
            // btn1
            // 
            this.btn1.Location = new System.Drawing.Point(56, 238);
            this.btn1.Name = "btn1";
            this.btn1.Size = new System.Drawing.Size(93, 41);
            this.btn1.TabIndex = 5;
            this.btn1.Text = "&Kết Quả";
            this.btn1.UseVisualStyleBackColor = true;
            this.btn1.Click += new System.EventHandler(this.btn1_Click);
            // 
            // btn2
            // 
            this.btn2.Location = new System.Drawing.Point(205, 238);
            this.btn2.Name = "btn2";
            this.btn2.Size = new System.Drawing.Size(89, 41);
            this.btn2.TabIndex = 6;
            this.btn2.Text = "&Làm mới";
            this.btn2.UseVisualStyleBackColor = true;
            this.btn2.Click += new System.EventHandler(this.btn2_Click);
            // 
            // btn3
            // 
            this.btn3.Location = new System.Drawing.Point(368, 238);
            this.btn3.Name = "btn3";
            this.btn3.Size = new System.Drawing.Size(94, 41);
            this.btn3.TabIndex = 7;
            this.btn3.Text = "&Thoát";
            this.btn3.UseVisualStyleBackColor = true;
            this.btn3.Click += new System.EventHandler(this.btn3_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Yellow;
            this.ClientSize = new System.Drawing.Size(615, 321);
            this.Controls.Add(this.btn3);
            this.Controls.Add(this.btn2);
            this.Controls.Add(this.btn1);
            this.Controls.Add(this.lb3);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.lb2);
            this.Controls.Add(this.lb1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lb1;
        private System.Windows.Forms.Label lb2;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.Label lb3;
        private System.Windows.Forms.Button btn1;
        private System.Windows.Forms.Button btn2;
        private System.Windows.Forms.Button btn3;
    }
}

