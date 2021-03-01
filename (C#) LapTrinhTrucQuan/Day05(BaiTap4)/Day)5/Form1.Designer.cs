namespace Day_5
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.tb3 = new System.Windows.Forms.TextBox();
            this.tb2 = new System.Windows.Forms.TextBox();
            this.tb1 = new System.Windows.Forms.TextBox();
            this.lb3 = new System.Windows.Forms.Label();
            this.lb2 = new System.Windows.Forms.Label();
            this.lb1 = new System.Windows.Forms.Label();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.radioChia = new System.Windows.Forms.RadioButton();
            this.radioNhan = new System.Windows.Forms.RadioButton();
            this.radioTru = new System.Windows.Forms.RadioButton();
            this.radioCong = new System.Windows.Forms.RadioButton();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.cMin = new System.Windows.Forms.CheckBox();
            this.cMax = new System.Windows.Forms.CheckBox();
            this.listBox1 = new System.Windows.Forms.ListBox();
            this.btnAdd = new System.Windows.Forms.Button();
            this.tbAdd = new System.Windows.Forms.TextBox();
            this.comboBox1 = new System.Windows.Forms.ComboBox();
            this.numberFont = new System.Windows.Forms.NumericUpDown();
            this.HSBRed = new System.Windows.Forms.HScrollBar();
            this.lbred = new System.Windows.Forms.Label();
            this.HSBGreen = new System.Windows.Forms.HScrollBar();
            this.HSBBlue = new System.Windows.Forms.HScrollBar();
            this.lbgreen = new System.Windows.Forms.Label();
            this.lbblue = new System.Windows.Forms.Label();
            this.vBlue = new System.Windows.Forms.Label();
            this.vGreen = new System.Windows.Forms.Label();
            this.vRed = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numberFont)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.tb3);
            this.groupBox1.Controls.Add(this.tb2);
            this.groupBox1.Controls.Add(this.tb1);
            this.groupBox1.Controls.Add(this.lb3);
            this.groupBox1.Controls.Add(this.lb2);
            this.groupBox1.Controls.Add(this.lb1);
            this.groupBox1.Location = new System.Drawing.Point(31, 52);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(346, 159);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            // 
            // tb3
            // 
            this.tb3.Location = new System.Drawing.Point(175, 106);
            this.tb3.Name = "tb3";
            this.tb3.Size = new System.Drawing.Size(100, 20);
            this.tb3.TabIndex = 5;
            // 
            // tb2
            // 
            this.tb2.Location = new System.Drawing.Point(175, 70);
            this.tb2.Name = "tb2";
            this.tb2.Size = new System.Drawing.Size(100, 20);
            this.tb2.TabIndex = 4;
            // 
            // tb1
            // 
            this.tb1.Location = new System.Drawing.Point(175, 24);
            this.tb1.Name = "tb1";
            this.tb1.Size = new System.Drawing.Size(100, 20);
            this.tb1.TabIndex = 3;
            // 
            // lb3
            // 
            this.lb3.AutoSize = true;
            this.lb3.Location = new System.Drawing.Point(31, 113);
            this.lb3.Name = "lb3";
            this.lb3.Size = new System.Drawing.Size(46, 13);
            this.lb3.TabIndex = 2;
            this.lb3.Text = "Kết Quả";
            // 
            // lb2
            // 
            this.lb2.AutoSize = true;
            this.lb2.Location = new System.Drawing.Point(31, 77);
            this.lb2.Name = "lb2";
            this.lb2.Size = new System.Drawing.Size(51, 13);
            this.lb2.TabIndex = 1;
            this.lb2.Text = "Nhập b =";
            // 
            // lb1
            // 
            this.lb1.AutoSize = true;
            this.lb1.Location = new System.Drawing.Point(31, 31);
            this.lb1.Name = "lb1";
            this.lb1.Size = new System.Drawing.Size(51, 13);
            this.lb1.TabIndex = 0;
            this.lb1.Text = "Nhập a =";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.radioChia);
            this.groupBox2.Controls.Add(this.radioNhan);
            this.groupBox2.Controls.Add(this.radioTru);
            this.groupBox2.Controls.Add(this.radioCong);
            this.groupBox2.Location = new System.Drawing.Point(31, 246);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(260, 148);
            this.groupBox2.TabIndex = 1;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Phép tính";
            // 
            // radioChia
            // 
            this.radioChia.AutoSize = true;
            this.radioChia.Location = new System.Drawing.Point(32, 104);
            this.radioChia.Name = "radioChia";
            this.radioChia.Size = new System.Drawing.Size(46, 17);
            this.radioChia.TabIndex = 3;
            this.radioChia.TabStop = true;
            this.radioChia.Text = "Chia";
            this.radioChia.UseVisualStyleBackColor = true;
            this.radioChia.Click += new System.EventHandler(this.radioChia_Click);
            // 
            // radioNhan
            // 
            this.radioNhan.AutoSize = true;
            this.radioNhan.Location = new System.Drawing.Point(32, 80);
            this.radioNhan.Name = "radioNhan";
            this.radioNhan.Size = new System.Drawing.Size(51, 17);
            this.radioNhan.TabIndex = 2;
            this.radioNhan.TabStop = true;
            this.radioNhan.Text = "Nhân";
            this.radioNhan.UseVisualStyleBackColor = true;
            this.radioNhan.Click += new System.EventHandler(this.radioNhan_Click);
            // 
            // radioTru
            // 
            this.radioTru.AutoSize = true;
            this.radioTru.Location = new System.Drawing.Point(32, 56);
            this.radioTru.Name = "radioTru";
            this.radioTru.Size = new System.Drawing.Size(41, 17);
            this.radioTru.TabIndex = 1;
            this.radioTru.TabStop = true;
            this.radioTru.Text = "Trừ";
            this.radioTru.UseVisualStyleBackColor = true;
            this.radioTru.Click += new System.EventHandler(this.radioTru_Click);
            // 
            // radioCong
            // 
            this.radioCong.AutoSize = true;
            this.radioCong.Location = new System.Drawing.Point(32, 32);
            this.radioCong.Name = "radioCong";
            this.radioCong.Size = new System.Drawing.Size(50, 17);
            this.radioCong.TabIndex = 0;
            this.radioCong.TabStop = true;
            this.radioCong.Text = "Cộng";
            this.radioCong.UseVisualStyleBackColor = true;
            this.radioCong.CheckedChanged += new System.EventHandler(this.radioCong_CheckedChanged);
            this.radioCong.Click += new System.EventHandler(this.radioCong_Click);
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.cMin);
            this.groupBox3.Controls.Add(this.cMax);
            this.groupBox3.Location = new System.Drawing.Point(395, 246);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(254, 148);
            this.groupBox3.TabIndex = 2;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "So Sánh";
            // 
            // cMin
            // 
            this.cMin.AutoSize = true;
            this.cMin.Location = new System.Drawing.Point(30, 93);
            this.cMin.Name = "cMin";
            this.cMin.Size = new System.Drawing.Size(52, 17);
            this.cMin.TabIndex = 1;
            this.cMin.Text = "Min =";
            this.cMin.UseVisualStyleBackColor = true;
            this.cMin.CheckedChanged += new System.EventHandler(this.cMin_CheckedChanged);
            // 
            // cMax
            // 
            this.cMax.AutoSize = true;
            this.cMax.Location = new System.Drawing.Point(30, 46);
            this.cMax.Name = "cMax";
            this.cMax.Size = new System.Drawing.Size(55, 17);
            this.cMax.TabIndex = 0;
            this.cMax.Text = "Max =";
            this.cMax.UseVisualStyleBackColor = true;
            this.cMax.Click += new System.EventHandler(this.cMax_Click);
            // 
            // listBox1
            // 
            this.listBox1.FormattingEnabled = true;
            this.listBox1.Items.AddRange(new object[] {
            "hà nội",
            "hải phòng",
            "hưng yên"});
            this.listBox1.Location = new System.Drawing.Point(391, 62);
            this.listBox1.Name = "listBox1";
            this.listBox1.Size = new System.Drawing.Size(258, 147);
            this.listBox1.TabIndex = 3;
            this.listBox1.DoubleClick += new System.EventHandler(this.listBox1_DoubleClick);
            // 
            // btnAdd
            // 
            this.btnAdd.Location = new System.Drawing.Point(668, 138);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(75, 23);
            this.btnAdd.TabIndex = 4;
            this.btnAdd.Text = "&Thêm";
            this.btnAdd.UseVisualStyleBackColor = true;
            this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
            // 
            // tbAdd
            // 
            this.tbAdd.Location = new System.Drawing.Point(669, 62);
            this.tbAdd.Name = "tbAdd";
            this.tbAdd.Size = new System.Drawing.Size(100, 20);
            this.tbAdd.TabIndex = 5;
            // 
            // comboBox1
            // 
            this.comboBox1.FormattingEnabled = true;
            this.comboBox1.Items.AddRange(new object[] {
            "Time"});
            this.comboBox1.Location = new System.Drawing.Point(668, 98);
            this.comboBox1.Name = "comboBox1";
            this.comboBox1.Size = new System.Drawing.Size(100, 21);
            this.comboBox1.TabIndex = 6;
            // 
            // numberFont
            // 
            this.numberFont.Location = new System.Drawing.Point(669, 189);
            this.numberFont.Maximum = new decimal(new int[] {
            50,
            0,
            0,
            0});
            this.numberFont.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.numberFont.Name = "numberFont";
            this.numberFont.Size = new System.Drawing.Size(100, 20);
            this.numberFont.TabIndex = 7;
            this.numberFont.Value = new decimal(new int[] {
            9,
            0,
            0,
            0});
            this.numberFont.ValueChanged += new System.EventHandler(this.numberFont_ValueChanged);
            // 
            // HSBRed
            // 
            this.HSBRed.Location = new System.Drawing.Point(105, 415);
            this.HSBRed.Maximum = 255;
            this.HSBRed.Name = "HSBRed";
            this.HSBRed.Size = new System.Drawing.Size(576, 17);
            this.HSBRed.TabIndex = 8;
            this.HSBRed.Scroll += new System.Windows.Forms.ScrollEventHandler(this.hScrollBar1_Scroll);
            // 
            // lbred
            // 
            this.lbred.AutoSize = true;
            this.lbred.ForeColor = System.Drawing.Color.Red;
            this.lbred.Location = new System.Drawing.Point(60, 415);
            this.lbred.Name = "lbred";
            this.lbred.Size = new System.Drawing.Size(30, 13);
            this.lbred.TabIndex = 9;
            this.lbred.Text = "RED";
            // 
            // HSBGreen
            // 
            this.HSBGreen.Location = new System.Drawing.Point(105, 452);
            this.HSBGreen.Maximum = 255;
            this.HSBGreen.Name = "HSBGreen";
            this.HSBGreen.Size = new System.Drawing.Size(576, 17);
            this.HSBGreen.TabIndex = 10;
            this.HSBGreen.Scroll += new System.Windows.Forms.ScrollEventHandler(this.HSBGreen_Scroll);
            // 
            // HSBBlue
            // 
            this.HSBBlue.Location = new System.Drawing.Point(106, 492);
            this.HSBBlue.Maximum = 255;
            this.HSBBlue.Name = "HSBBlue";
            this.HSBBlue.Size = new System.Drawing.Size(576, 17);
            this.HSBBlue.TabIndex = 11;
            this.HSBBlue.Scroll += new System.Windows.Forms.ScrollEventHandler(this.HSBBlue_Scroll);
            // 
            // lbgreen
            // 
            this.lbgreen.AutoSize = true;
            this.lbgreen.ForeColor = System.Drawing.Color.Green;
            this.lbgreen.Location = new System.Drawing.Point(60, 456);
            this.lbgreen.Name = "lbgreen";
            this.lbgreen.Size = new System.Drawing.Size(36, 13);
            this.lbgreen.TabIndex = 12;
            this.lbgreen.Text = "Green";
            // 
            // lbblue
            // 
            this.lbblue.AutoSize = true;
            this.lbblue.ForeColor = System.Drawing.Color.Blue;
            this.lbblue.Location = new System.Drawing.Point(60, 492);
            this.lbblue.Name = "lbblue";
            this.lbblue.Size = new System.Drawing.Size(35, 13);
            this.lbblue.TabIndex = 13;
            this.lbblue.Text = "BLUE";
            // 
            // vBlue
            // 
            this.vBlue.AutoSize = true;
            this.vBlue.ForeColor = System.Drawing.Color.Blue;
            this.vBlue.Location = new System.Drawing.Point(713, 492);
            this.vBlue.Name = "vBlue";
            this.vBlue.Size = new System.Drawing.Size(0, 13);
            this.vBlue.TabIndex = 16;
            // 
            // vGreen
            // 
            this.vGreen.AutoSize = true;
            this.vGreen.ForeColor = System.Drawing.Color.Green;
            this.vGreen.Location = new System.Drawing.Point(713, 456);
            this.vGreen.Name = "vGreen";
            this.vGreen.Size = new System.Drawing.Size(0, 13);
            this.vGreen.TabIndex = 15;
            // 
            // vRed
            // 
            this.vRed.AutoSize = true;
            this.vRed.ForeColor = System.Drawing.Color.Red;
            this.vRed.Location = new System.Drawing.Point(713, 415);
            this.vRed.Name = "vRed";
            this.vRed.Size = new System.Drawing.Size(0, 13);
            this.vRed.TabIndex = 14;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(192)))));
            this.ClientSize = new System.Drawing.Size(781, 532);
            this.Controls.Add(this.vBlue);
            this.Controls.Add(this.vGreen);
            this.Controls.Add(this.vRed);
            this.Controls.Add(this.lbblue);
            this.Controls.Add(this.lbgreen);
            this.Controls.Add(this.HSBBlue);
            this.Controls.Add(this.HSBGreen);
            this.Controls.Add(this.lbred);
            this.Controls.Add(this.HSBRed);
            this.Controls.Add(this.numberFont);
            this.Controls.Add(this.comboBox1);
            this.Controls.Add(this.tbAdd);
            this.Controls.Add(this.btnAdd);
            this.Controls.Add(this.listBox1);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numberFont)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TextBox tb3;
        private System.Windows.Forms.TextBox tb2;
        private System.Windows.Forms.TextBox tb1;
        private System.Windows.Forms.Label lb3;
        private System.Windows.Forms.Label lb2;
        private System.Windows.Forms.Label lb1;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.CheckBox cMin;
        private System.Windows.Forms.CheckBox cMax;
        private System.Windows.Forms.RadioButton radioChia;
        private System.Windows.Forms.RadioButton radioNhan;
        private System.Windows.Forms.RadioButton radioTru;
        private System.Windows.Forms.RadioButton radioCong;
        private System.Windows.Forms.ListBox listBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.TextBox tbAdd;
        private System.Windows.Forms.ComboBox comboBox1;
        private System.Windows.Forms.NumericUpDown numberFont;
        private System.Windows.Forms.HScrollBar HSBRed;
        private System.Windows.Forms.Label lbred;
        private System.Windows.Forms.HScrollBar HSBGreen;
        private System.Windows.Forms.HScrollBar HSBBlue;
        private System.Windows.Forms.Label lbgreen;
        private System.Windows.Forms.Label lbblue;
        private System.Windows.Forms.Label vBlue;
        private System.Windows.Forms.Label vGreen;
        private System.Windows.Forms.Label vRed;
    }
}

