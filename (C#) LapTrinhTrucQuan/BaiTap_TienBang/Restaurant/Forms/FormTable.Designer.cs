namespace Restaurant.Forms
{
    partial class FormTable
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
            System.Drawing.Drawing2D.GraphicsPath graphicsPath1 = new System.Drawing.Drawing2D.GraphicsPath();
            System.Drawing.Drawing2D.GraphicsPath graphicsPath2 = new System.Drawing.Drawing2D.GraphicsPath();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormTable));
            this.panel1 = new System.Windows.Forms.Panel();
            this.tabTable = new XanderUI.XUIFlatTab();
            this.panel2 = new System.Windows.Forms.Panel();
            this.buttonChangeTable = new Restaurant.CustomControls.RadiusMaterialRaisedButton();
            this.buttonChooseTable = new Restaurant.CustomControls.RadiusMaterialRaisedButton();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.tabTable);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(400, 509);
            this.panel1.TabIndex = 0;
            // 
            // tabTable
            // 
            this.tabTable.ActiveHeaderColor = System.Drawing.Color.DodgerBlue;
            this.tabTable.ActiveTextColor = System.Drawing.Color.White;
            this.tabTable.BorderColor = System.Drawing.Color.DodgerBlue;
            this.tabTable.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tabTable.HeaderBackgroundColor = System.Drawing.Color.White;
            this.tabTable.InActiveHeaderColor = System.Drawing.Color.RoyalBlue;
            this.tabTable.InActiveTextColor = System.Drawing.Color.White;
            this.tabTable.ItemSize = new System.Drawing.Size(240, 16);
            this.tabTable.Location = new System.Drawing.Point(0, 0);
            this.tabTable.Name = "tabTable";
            this.tabTable.OnlyTopLine = true;
            this.tabTable.PageColor = System.Drawing.Color.White;
            this.tabTable.SelectedIndex = 0;
            this.tabTable.Size = new System.Drawing.Size(400, 509);
            this.tabTable.TabIndex = 0;
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.buttonChangeTable);
            this.panel2.Controls.Add(this.buttonChooseTable);
            this.panel2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel2.Location = new System.Drawing.Point(0, 509);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(400, 102);
            this.panel2.TabIndex = 1;
            // 
            // buttonChangeTable
            // 
            this.buttonChangeTable.BorderColor = System.Drawing.Color.Transparent;
            this.buttonChangeTable.BorderRadius = 40;
            this.buttonChangeTable.BorderWidth = 0F;
            this.buttonChangeTable.Depth = 0;
            this.buttonChangeTable.Elevation = 5;
            this.buttonChangeTable.FlatAppearance.BorderSize = 0;
            this.buttonChangeTable.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonChangeTable.Location = new System.Drawing.Point(204, 3);
            this.buttonChangeTable.MouseState = Zeroit.Framework.MaterialWinforms.MouseState.HOVER;
            this.buttonChangeTable.Name = "buttonChangeTable";
            this.buttonChangeTable.Primary = true;
            graphicsPath1.FillMode = System.Drawing.Drawing2D.FillMode.Alternate;
            this.buttonChangeTable.ShadowBorder = graphicsPath1;
            this.buttonChangeTable.Size = new System.Drawing.Size(184, 93);
            this.buttonChangeTable.TabIndex = 1;
            this.buttonChangeTable.Text = "Đổi Bàn";
            this.buttonChangeTable.UseVisualStyleBackColor = true;
            this.buttonChangeTable.Click += new System.EventHandler(this.buttonChangeTable_Click);
            // 
            // buttonChooseTable
            // 
            this.buttonChooseTable.BorderColor = System.Drawing.Color.Transparent;
            this.buttonChooseTable.BorderRadius = 40;
            this.buttonChooseTable.BorderWidth = 0F;
            this.buttonChooseTable.Depth = 0;
            this.buttonChooseTable.Elevation = 5;
            this.buttonChooseTable.FlatAppearance.BorderSize = 0;
            this.buttonChooseTable.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonChooseTable.Location = new System.Drawing.Point(3, 3);
            this.buttonChooseTable.MouseState = Zeroit.Framework.MaterialWinforms.MouseState.HOVER;
            this.buttonChooseTable.Name = "buttonChooseTable";
            this.buttonChooseTable.Primary = true;
            graphicsPath2.FillMode = System.Drawing.Drawing2D.FillMode.Alternate;
            this.buttonChooseTable.ShadowBorder = graphicsPath2;
            this.buttonChooseTable.Size = new System.Drawing.Size(195, 93);
            this.buttonChooseTable.TabIndex = 0;
            this.buttonChooseTable.Text = "Chọn Bàn";
            this.buttonChooseTable.UseVisualStyleBackColor = true;
            this.buttonChooseTable.Click += new System.EventHandler(this.buttonChooseTable_Click);
            // 
            // FormTable
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(400, 611);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "FormTable";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Chọn Bàn";
            this.Load += new System.EventHandler(this.FormTable_Load);
            this.panel1.ResumeLayout(false);
            this.panel2.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
        private XanderUI.XUIFlatTab tabTable;
        private CustomControls.RadiusMaterialRaisedButton buttonChangeTable;
        private CustomControls.RadiusMaterialRaisedButton buttonChooseTable;
    }
}