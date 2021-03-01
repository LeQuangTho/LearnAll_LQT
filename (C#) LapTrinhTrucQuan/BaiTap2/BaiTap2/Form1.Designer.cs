namespace BaiTap2
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
            this.lbA = new System.Windows.Forms.Label();
            this.lbB = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.btnKQ = new System.Windows.Forms.Button();
            this.btnLL = new System.Windows.Forms.Button();
            this.btnT = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lbA
            // 
            this.lbA.AutoSize = true;
            this.lbA.Location = new System.Drawing.Point(51, 53);
            this.lbA.Name = "lbA";
            this.lbA.Size = new System.Drawing.Size(45, 13);
            this.lbA.TabIndex = 0;
            this.lbA.Text = "Nhập a:";
            // 
            // lbB
            // 
            this.lbB.AutoSize = true;
            this.lbB.Location = new System.Drawing.Point(51, 107);
            this.lbB.Name = "lbB";
            this.lbB.Size = new System.Drawing.Size(45, 13);
            this.lbB.TabIndex = 1;
            this.lbB.Text = "Nhập b:";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(128, 46);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(173, 20);
            this.textBox1.TabIndex = 2;
            this.textBox1.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.textBox1_KeyPress);
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(128, 100);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(173, 20);
            this.textBox2.TabIndex = 3;
            this.textBox2.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.textBox1_KeyPress);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.ForeColor = System.Drawing.Color.Red;
            this.label3.Location = new System.Drawing.Point(51, 164);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(0, 13);
            this.label3.TabIndex = 4;
            this.label3.UseMnemonic = false;
            // 
            // btnKQ
            // 
            this.btnKQ.Location = new System.Drawing.Point(51, 202);
            this.btnKQ.Name = "btnKQ";
            this.btnKQ.Size = new System.Drawing.Size(75, 40);
            this.btnKQ.TabIndex = 5;
            this.btnKQ.Text = "Tính Tổng";
            this.btnKQ.UseVisualStyleBackColor = true;
            this.btnKQ.Click += new System.EventHandler(this.btnKQ_Click);
            // 
            // btnLL
            // 
            this.btnLL.Location = new System.Drawing.Point(226, 202);
            this.btnLL.Name = "btnLL";
            this.btnLL.Size = new System.Drawing.Size(75, 40);
            this.btnLL.TabIndex = 6;
            this.btnLL.Text = "Làm Lại";
            this.btnLL.UseVisualStyleBackColor = true;
            this.btnLL.Click += new System.EventHandler(this.btnLL_Click);
            // 
            // btnT
            // 
            this.btnT.Location = new System.Drawing.Point(395, 202);
            this.btnT.Name = "btnT";
            this.btnT.Size = new System.Drawing.Size(75, 40);
            this.btnT.TabIndex = 7;
            this.btnT.Text = "Thoát";
            this.btnT.UseVisualStyleBackColor = true;
            this.btnT.Click += new System.EventHandler(this.btnT_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.ClientSize = new System.Drawing.Size(541, 281);
            this.Controls.Add(this.btnT);
            this.Controls.Add(this.btnLL);
            this.Controls.Add(this.btnKQ);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.lbB);
            this.Controls.Add(this.lbA);
            this.Name = "Form1";
            this.Text = "Bài Tập 2";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lbA;
        private System.Windows.Forms.Label lbB;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button btnKQ;
        private System.Windows.Forms.Button btnLL;
        private System.Windows.Forms.Button btnT;
    }
}

