namespace Restaurant.Forms
{
    partial class FormPanelBill
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
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle2 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle3 = new System.Windows.Forms.DataGridViewCellStyle();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormPanelBill));
            this.tabBill = new XanderUI.XUIFlatTab();
            this.tabHDBan = new System.Windows.Forms.TabPage();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.panel1 = new System.Windows.Forms.Panel();
            this.panelBillPreview = new System.Windows.Forms.Panel();
            this.tabHDNhap = new System.Windows.Forms.TabPage();
            this.printDocument = new System.Drawing.Printing.PrintDocument();
            this.printDialog = new System.Windows.Forms.PrintDialog();
            this.printPreviewDialog = new System.Windows.Forms.PrintPreviewDialog();
            this.tabBill.SuspendLayout();
            this.tabHDBan.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // tabBill
            // 
            this.tabBill.ActiveHeaderColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.tabBill.ActiveTextColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.tabBill.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.tabBill.Controls.Add(this.tabHDBan);
            this.tabBill.Controls.Add(this.tabHDNhap);
            this.tabBill.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tabBill.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold);
            this.tabBill.HeaderBackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.tabBill.HotTrack = true;
            this.tabBill.InActiveHeaderColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.tabBill.InActiveTextColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.tabBill.ItemSize = new System.Drawing.Size(120, 16);
            this.tabBill.Location = new System.Drawing.Point(0, 0);
            this.tabBill.Multiline = true;
            this.tabBill.Name = "tabBill";
            this.tabBill.OnlyTopLine = true;
            this.tabBill.PageColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.tabBill.SelectedIndex = 0;
            this.tabBill.ShowToolTips = true;
            this.tabBill.Size = new System.Drawing.Size(1014, 611);
            this.tabBill.SizeMode = System.Windows.Forms.TabSizeMode.Fixed;
            this.tabBill.TabIndex = 0;
            // 
            // tabHDBan
            // 
            this.tabHDBan.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.tabHDBan.Controls.Add(this.dataGridView1);
            this.tabHDBan.Controls.Add(this.panel1);
            this.tabHDBan.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tabHDBan.Location = new System.Drawing.Point(4, 20);
            this.tabHDBan.Name = "tabHDBan";
            this.tabHDBan.Padding = new System.Windows.Forms.Padding(3);
            this.tabHDBan.Size = new System.Drawing.Size(1006, 587);
            this.tabHDBan.TabIndex = 0;
            this.tabHDBan.Text = "Hóa đơn bán";
            this.tabHDBan.ToolTipText = "Hóa đơn bán";
            // 
            // dataGridView1
            // 
            dataGridViewCellStyle1.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle1.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle1.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle1.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle1.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle1.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle1.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dataGridView1.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle1;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewCellStyle2.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle2.BackColor = System.Drawing.SystemColors.Window;
            dataGridViewCellStyle2.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            dataGridViewCellStyle2.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle2.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle2.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
            this.dataGridView1.DefaultCellStyle = dataGridViewCellStyle2;
            this.dataGridView1.Location = new System.Drawing.Point(389, 184);
            this.dataGridView1.Name = "dataGridView1";
            dataGridViewCellStyle3.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle3.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle3.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle3.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle3.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle3.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle3.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dataGridView1.RowHeadersDefaultCellStyle = dataGridViewCellStyle3;
            this.dataGridView1.Size = new System.Drawing.Size(609, 270);
            this.dataGridView1.TabIndex = 1;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.panelBillPreview);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel1.Location = new System.Drawing.Point(3, 3);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(380, 581);
            this.panel1.TabIndex = 0;
            // 
            // panelBillPreview
            // 
            this.panelBillPreview.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panelBillPreview.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panelBillPreview.Location = new System.Drawing.Point(0, 0);
            this.panelBillPreview.Name = "panelBillPreview";
            this.panelBillPreview.Size = new System.Drawing.Size(380, 581);
            this.panelBillPreview.TabIndex = 1;
            // 
            // tabHDNhap
            // 
            this.tabHDNhap.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.tabHDNhap.Location = new System.Drawing.Point(4, 20);
            this.tabHDNhap.Name = "tabHDNhap";
            this.tabHDNhap.Padding = new System.Windows.Forms.Padding(3);
            this.tabHDNhap.Size = new System.Drawing.Size(1006, 587);
            this.tabHDNhap.TabIndex = 1;
            this.tabHDNhap.Text = "Hóa đơn nhập";
            this.tabHDNhap.ToolTipText = "Hóa đơn nhập";
            // 
            // printDialog
            // 
            this.printDialog.Document = this.printDocument;
            this.printDialog.UseEXDialog = true;
            // 
            // printPreviewDialog
            // 
            this.printPreviewDialog.AutoScrollMargin = new System.Drawing.Size(0, 0);
            this.printPreviewDialog.AutoScrollMinSize = new System.Drawing.Size(0, 0);
            this.printPreviewDialog.ClientSize = new System.Drawing.Size(400, 300);
            this.printPreviewDialog.Document = this.printDocument;
            this.printPreviewDialog.Enabled = true;
            this.printPreviewDialog.Icon = ((System.Drawing.Icon)(resources.GetObject("printPreviewDialog.Icon")));
            this.printPreviewDialog.Name = "printPreviewDialog";
            this.printPreviewDialog.Visible = false;
            // 
            // FormPanelBill
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.ClientSize = new System.Drawing.Size(1014, 611);
            this.Controls.Add(this.tabBill);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.Name = "FormPanelBill";
            this.Text = "FormPanelBill";
            this.Load += new System.EventHandler(this.FormPanelBill_Load);
            this.tabBill.ResumeLayout(false);
            this.tabHDBan.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.panel1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.TabPage tabHDBan;
        private System.Windows.Forms.TabPage tabHDNhap;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panelBillPreview;
        private System.Windows.Forms.PrintDialog printDialog;
        private System.Drawing.Printing.PrintDocument printDocument;
        private System.Windows.Forms.PrintPreviewDialog printPreviewDialog;
        public XanderUI.XUIFlatTab tabBill;
        private System.Windows.Forms.DataGridView dataGridView1;
    }
}