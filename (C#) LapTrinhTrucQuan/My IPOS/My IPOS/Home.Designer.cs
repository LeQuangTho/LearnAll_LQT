namespace My_IPOS
{
    partial class Home
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Home));
            this.panel1 = new System.Windows.Forms.Panel();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.btnTakeAway = new DevComponents.DotNetBar.ButtonX();
            this.btnDangXuat = new DevComponents.DotNetBar.ButtonX();
            this.btnKhoaSo = new DevComponents.DotNetBar.ButtonX();
            this.btnSuaMenu = new DevComponents.DotNetBar.ButtonX();
            this.panel1.SuspendLayout();
            this.tableLayoutPanel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(192)))));
            this.panel1.Controls.Add(this.tableLayoutPanel1);
            resources.ApplyResources(this.panel1, "panel1");
            this.panel1.Name = "panel1";
            // 
            // tableLayoutPanel1
            // 
            resources.ApplyResources(this.tableLayoutPanel1, "tableLayoutPanel1");
            this.tableLayoutPanel1.Controls.Add(this.btnTakeAway, 0, 0);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            // 
            // btnTakeAway
            // 
            this.btnTakeAway.AccessibleRole = System.Windows.Forms.AccessibleRole.PushButton;
            this.btnTakeAway.ColorTable = DevComponents.DotNetBar.eButtonColor.Office2007WithBackground;
            resources.ApplyResources(this.btnTakeAway, "btnTakeAway");
            this.btnTakeAway.Name = "btnTakeAway";
            this.btnTakeAway.Click += new System.EventHandler(this.btnTakeAway_Click_1);
            // 
            // btnDangXuat
            // 
            this.btnDangXuat.AccessibleRole = System.Windows.Forms.AccessibleRole.PushButton;
            this.btnDangXuat.BackColor = System.Drawing.Color.Transparent;
            this.btnDangXuat.ColorTable = DevComponents.DotNetBar.eButtonColor.Magenta;
            this.btnDangXuat.Image = ((System.Drawing.Image)(resources.GetObject("btnDangXuat.Image")));
            this.btnDangXuat.ImageFixedSize = new System.Drawing.Size(32, 32);
            this.btnDangXuat.ImagePosition = DevComponents.DotNetBar.eImagePosition.Top;
            resources.ApplyResources(this.btnDangXuat, "btnDangXuat");
            this.btnDangXuat.Name = "btnDangXuat";
            this.btnDangXuat.Click += new System.EventHandler(this.btnDangXuat_Click);
            // 
            // btnKhoaSo
            // 
            this.btnKhoaSo.AccessibleRole = System.Windows.Forms.AccessibleRole.PushButton;
            this.btnKhoaSo.BackColor = System.Drawing.Color.Transparent;
            this.btnKhoaSo.ColorTable = DevComponents.DotNetBar.eButtonColor.Magenta;
            this.btnKhoaSo.Image = ((System.Drawing.Image)(resources.GetObject("btnKhoaSo.Image")));
            this.btnKhoaSo.ImageFixedSize = new System.Drawing.Size(32, 32);
            this.btnKhoaSo.ImagePosition = DevComponents.DotNetBar.eImagePosition.Top;
            resources.ApplyResources(this.btnKhoaSo, "btnKhoaSo");
            this.btnKhoaSo.Name = "btnKhoaSo";
            this.btnKhoaSo.Click += new System.EventHandler(this.btnKhoaSo_Click);
            // 
            // btnSuaMenu
            // 
            this.btnSuaMenu.AccessibleRole = System.Windows.Forms.AccessibleRole.PushButton;
            this.btnSuaMenu.BackColor = System.Drawing.Color.Transparent;
            this.btnSuaMenu.ColorTable = DevComponents.DotNetBar.eButtonColor.Magenta;
            this.btnSuaMenu.Image = ((System.Drawing.Image)(resources.GetObject("btnSuaMenu.Image")));
            this.btnSuaMenu.ImageFixedSize = new System.Drawing.Size(32, 32);
            this.btnSuaMenu.ImagePosition = DevComponents.DotNetBar.eImagePosition.Top;
            resources.ApplyResources(this.btnSuaMenu, "btnSuaMenu");
            this.btnSuaMenu.Name = "btnSuaMenu";
            this.btnSuaMenu.Click += new System.EventHandler(this.btnSuaMenu_Click);
            // 
            // Home
            // 
            resources.ApplyResources(this, "$this");
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoValidate = System.Windows.Forms.AutoValidate.EnablePreventFocusChange;
            this.Controls.Add(this.btnSuaMenu);
            this.Controls.Add(this.btnKhoaSo);
            this.Controls.Add(this.btnDangXuat);
            this.Controls.Add(this.panel1);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Home";
            this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Show;
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Home_FormClosed);
            this.Load += new System.EventHandler(this.Home_Load);
            this.panel1.ResumeLayout(false);
            this.tableLayoutPanel1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private DevComponents.DotNetBar.ButtonX btnTakeAway;
        private DevComponents.DotNetBar.ButtonX btnDangXuat;
        private DevComponents.DotNetBar.ButtonX btnKhoaSo;
        private DevComponents.DotNetBar.ButtonX btnSuaMenu;
    }
}