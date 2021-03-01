namespace BaiTap1
{
    partial class BaiTap1
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
            this.btnKQ = new System.Windows.Forms.Button();
            this.btnLL = new System.Windows.Forms.Button();
            this.btnT = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lb1
            // 
            this.lb1.AutoSize = true;
            this.lb1.Location = new System.Drawing.Point(46, 39);
            this.lb1.Name = "lb1";
            this.lb1.Size = new System.Drawing.Size(70, 13);
            this.lb1.TabIndex = 0;
            this.lb1.Text = "Nhập Tháng:";
            // 
            // lb2
            // 
            this.lb2.AutoSize = true;
            this.lb2.Location = new System.Drawing.Point(49, 95);
            this.lb2.Name = "lb2";
            this.lb2.Size = new System.Drawing.Size(61, 13);
            this.lb2.TabIndex = 1;
            this.lb2.Text = "Nhập Năm:";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(136, 39);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 20);
            this.textBox1.TabIndex = 2;
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(136, 95);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(100, 20);
            this.textBox2.TabIndex = 3;
            // 
            // lb3
            // 
            this.lb3.AutoSize = true;
            this.lb3.Location = new System.Drawing.Point(49, 158);
            this.lb3.Name = "lb3";
            this.lb3.Size = new System.Drawing.Size(0, 13);
            this.lb3.TabIndex = 4;
            // 
            // btnKQ
            // 
            this.btnKQ.Location = new System.Drawing.Point(52, 210);
            this.btnKQ.Name = "btnKQ";
            this.btnKQ.Size = new System.Drawing.Size(75, 36);
            this.btnKQ.TabIndex = 5;
            this.btnKQ.Text = "Kết Quả";
            this.btnKQ.UseVisualStyleBackColor = true;
            this.btnKQ.Click += new System.EventHandler(this.btnKQ_Click);
            // 
            // btnLL
            // 
            this.btnLL.Location = new System.Drawing.Point(214, 210);
            this.btnLL.Name = "btnLL";
            this.btnLL.Size = new System.Drawing.Size(75, 36);
            this.btnLL.TabIndex = 6;
            this.btnLL.Text = "Làm Lại";
            this.btnLL.UseVisualStyleBackColor = true;
            this.btnLL.Click += new System.EventHandler(this.btnLL_Click);
            // 
            // btnT
            // 
            this.btnT.Location = new System.Drawing.Point(375, 210);
            this.btnT.Name = "btnT";
            this.btnT.Size = new System.Drawing.Size(75, 36);
            this.btnT.TabIndex = 7;
            this.btnT.Text = "Thoát";
            this.btnT.UseVisualStyleBackColor = true;
            this.btnT.Click += new System.EventHandler(this.btnT_Click);
            // 
            // BaiTap1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(128)))));
            this.ClientSize = new System.Drawing.Size(548, 285);
            this.Controls.Add(this.btnT);
            this.Controls.Add(this.btnLL);
            this.Controls.Add(this.btnKQ);
            this.Controls.Add(this.lb3);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.lb2);
            this.Controls.Add(this.lb1);
            this.Name = "BaiTap1";
            this.Text = "Bài Tập 1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lb1;
        private System.Windows.Forms.Label lb2;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.Label lb3;
        private System.Windows.Forms.Button btnKQ;
        private System.Windows.Forms.Button btnLL;
        private System.Windows.Forms.Button btnT;
    }
}

