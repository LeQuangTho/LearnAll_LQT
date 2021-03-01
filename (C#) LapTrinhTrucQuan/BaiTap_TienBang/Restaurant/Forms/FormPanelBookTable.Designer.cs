namespace Restaurant.Forms
{
    partial class FormPanelBookTable
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
            this.panelBookTable = new System.Windows.Forms.Panel();
            this.panel1 = new System.Windows.Forms.Panel();
            this.xuiFlatTab1 = new XanderUI.XUIFlatTab();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.panelBookTable.SuspendLayout();
            this.panel1.SuspendLayout();
            this.xuiFlatTab1.SuspendLayout();
            this.SuspendLayout();
            // 
            // panelBookTable
            // 
            this.panelBookTable.Controls.Add(this.panel1);
            this.panelBookTable.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panelBookTable.Location = new System.Drawing.Point(0, 0);
            this.panelBookTable.Name = "panelBookTable";
            this.panelBookTable.Size = new System.Drawing.Size(1014, 611);
            this.panelBookTable.TabIndex = 0;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.xuiFlatTab1);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(450, 611);
            this.panel1.TabIndex = 0;
            // 
            // xuiFlatTab1
            // 
            this.xuiFlatTab1.ActiveHeaderColor = System.Drawing.Color.DodgerBlue;
            this.xuiFlatTab1.ActiveTextColor = System.Drawing.Color.White;
            this.xuiFlatTab1.BorderColor = System.Drawing.Color.DodgerBlue;
            this.xuiFlatTab1.Controls.Add(this.tabPage1);
            this.xuiFlatTab1.Controls.Add(this.tabPage2);
            this.xuiFlatTab1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.xuiFlatTab1.HeaderBackgroundColor = System.Drawing.Color.White;
            this.xuiFlatTab1.InActiveHeaderColor = System.Drawing.Color.RoyalBlue;
            this.xuiFlatTab1.InActiveTextColor = System.Drawing.Color.White;
            this.xuiFlatTab1.ItemSize = new System.Drawing.Size(240, 16);
            this.xuiFlatTab1.Location = new System.Drawing.Point(0, 0);
            this.xuiFlatTab1.Name = "xuiFlatTab1";
            this.xuiFlatTab1.OnlyTopLine = true;
            this.xuiFlatTab1.PageColor = System.Drawing.Color.White;
            this.xuiFlatTab1.SelectedIndex = 0;
            this.xuiFlatTab1.Size = new System.Drawing.Size(450, 611);
            this.xuiFlatTab1.TabIndex = 0;
            // 
            // tabPage1
            // 
            this.tabPage1.BackColor = System.Drawing.Color.White;
            this.tabPage1.Location = new System.Drawing.Point(4, 20);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(442, 587);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "tabPage1";
            // 
            // tabPage2
            // 
            this.tabPage2.BackColor = System.Drawing.Color.White;
            this.tabPage2.Location = new System.Drawing.Point(4, 20);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(442, 587);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "tabPage2";
            // 
            // FormPanelBookTable
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1014, 611);
            this.Controls.Add(this.panelBookTable);
            this.Name = "FormPanelBookTable";
            this.Text = "FormPanelBookTable";
            this.panelBookTable.ResumeLayout(false);
            this.panel1.ResumeLayout(false);
            this.xuiFlatTab1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panelBookTable;
        private System.Windows.Forms.Panel panel1;
        private XanderUI.XUIFlatTab xuiFlatTab1;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
    }
}