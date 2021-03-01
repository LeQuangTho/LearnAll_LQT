namespace Restaurant.UserControls
{
    partial class UserControlOrderedFood
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

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.labelNameFood = new System.Windows.Forms.Label();
            this.labelPrice = new System.Windows.Forms.Label();
            this.labelSum = new System.Windows.Forms.Label();
            this.buttonIncrease = new FontAwesome.Sharp.IconButton();
            this.buttonReduce = new FontAwesome.Sharp.IconButton();
            this.buttonDelete = new FontAwesome.Sharp.IconButton();
            this.toolTip = new Zeroit.Framework.Tooltip.ZeroitTetraToolTip();
            this.textNumber = new Zeroit.Framework.Metro.ZeroitMetroTextbox();
            this.SuspendLayout();
            // 
            // labelNameFood
            // 
            this.labelNameFood.Dock = System.Windows.Forms.DockStyle.Left;
            this.labelNameFood.Location = new System.Drawing.Point(0, 0);
            this.labelNameFood.Name = "labelNameFood";
            this.labelNameFood.Size = new System.Drawing.Size(125, 40);
            this.labelNameFood.TabIndex = 0;
            this.labelNameFood.Text = "Sườn xào chua ngọt";
            this.labelNameFood.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // labelPrice
            // 
            this.labelPrice.Dock = System.Windows.Forms.DockStyle.Left;
            this.labelPrice.Location = new System.Drawing.Point(125, 0);
            this.labelPrice.Name = "labelPrice";
            this.labelPrice.Size = new System.Drawing.Size(65, 40);
            this.labelPrice.TabIndex = 1;
            this.labelPrice.Text = "100000";
            this.labelPrice.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // labelSum
            // 
            this.labelSum.Dock = System.Windows.Forms.DockStyle.Left;
            this.labelSum.Location = new System.Drawing.Point(236, 0);
            this.labelSum.Name = "labelSum";
            this.labelSum.Size = new System.Drawing.Size(75, 40);
            this.labelSum.TabIndex = 3;
            this.labelSum.Text = "100000";
            this.labelSum.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // buttonIncrease
            // 
            this.buttonIncrease.Dock = System.Windows.Forms.DockStyle.Left;
            this.buttonIncrease.FlatAppearance.BorderSize = 0;
            this.buttonIncrease.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonIncrease.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonIncrease.IconChar = FontAwesome.Sharp.IconChar.Plus;
            this.buttonIncrease.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonIncrease.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonIncrease.IconSize = 26;
            this.buttonIncrease.Location = new System.Drawing.Point(311, 0);
            this.buttonIncrease.Name = "buttonIncrease";
            this.buttonIncrease.Rotation = 0D;
            this.buttonIncrease.Size = new System.Drawing.Size(26, 40);
            this.buttonIncrease.TabIndex = 4;
            this.buttonIncrease.UseVisualStyleBackColor = true;
            // 
            // buttonReduce
            // 
            this.buttonReduce.Dock = System.Windows.Forms.DockStyle.Left;
            this.buttonReduce.FlatAppearance.BorderSize = 0;
            this.buttonReduce.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonReduce.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonReduce.IconChar = FontAwesome.Sharp.IconChar.Minus;
            this.buttonReduce.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonReduce.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonReduce.IconSize = 26;
            this.buttonReduce.Location = new System.Drawing.Point(337, 0);
            this.buttonReduce.Name = "buttonReduce";
            this.buttonReduce.Rotation = 0D;
            this.buttonReduce.Size = new System.Drawing.Size(26, 40);
            this.buttonReduce.TabIndex = 5;
            this.buttonReduce.UseVisualStyleBackColor = true;
            // 
            // buttonDelete
            // 
            this.buttonDelete.Dock = System.Windows.Forms.DockStyle.Left;
            this.buttonDelete.FlatAppearance.BorderSize = 0;
            this.buttonDelete.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonDelete.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.buttonDelete.IconChar = FontAwesome.Sharp.IconChar.TrashAlt;
            this.buttonDelete.IconColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.buttonDelete.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.buttonDelete.IconSize = 26;
            this.buttonDelete.Location = new System.Drawing.Point(363, 0);
            this.buttonDelete.Name = "buttonDelete";
            this.buttonDelete.Rotation = 0D;
            this.buttonDelete.Size = new System.Drawing.Size(26, 40);
            this.buttonDelete.TabIndex = 6;
            this.buttonDelete.UseVisualStyleBackColor = true;
            // 
            // toolTip
            // 
            this.toolTip.AnimationSpeed = 0;
            this.toolTip.AutoClose = 5000;
            this.toolTip.EnableAutoClose = false;
            this.toolTip.Location = Zeroit.Framework.Tooltip.ToolTipLocation.CustomClient;
            this.toolTip.ShowShadow = false;
            // 
            // textNumber
            // 
            this.textNumber.AutoStyle = false;
            this.textNumber.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.textNumber.Border = 0;
            this.textNumber.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(251)))));
            this.textNumber.DefaultColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(251)))));
            this.textNumber.DisabledColor = System.Drawing.Color.FromArgb(((int)(((byte)(35)))), ((int)(((byte)(35)))), ((int)(((byte)(35)))));
            this.textNumber.Dock = System.Windows.Forms.DockStyle.Left;
            this.textNumber.Font = new System.Drawing.Font("Segoe UI", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.textNumber.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.textNumber.HideSelection = false;
            this.textNumber.HoverColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(251)))));
            this.textNumber.Location = new System.Drawing.Point(190, 0);
            this.textNumber.MaxLength = 2;
            this.textNumber.Name = "textNumber";
            this.textNumber.PasswordChar = '\0';
            this.textNumber.Size = new System.Drawing.Size(46, 40);
            this.textNumber.Style = Zeroit.Framework.Metro.Design.Style.Custom;
            this.textNumber.TabIndex = 2;
            this.textNumber.Text = "1";
            this.textNumber.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.textNumber.KeyPress += new Zeroit.Framework.Metro.ZeroitMetroTextbox.KeyPressEventHandler(this.textNumber_KeyPress);
            // 
            // UserControlOrderedFood
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(251)))));
            this.Controls.Add(this.buttonDelete);
            this.Controls.Add(this.buttonReduce);
            this.Controls.Add(this.buttonIncrease);
            this.Controls.Add(this.labelSum);
            this.Controls.Add(this.textNumber);
            this.Controls.Add(this.labelPrice);
            this.Controls.Add(this.labelNameFood);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.Name = "UserControlOrderedFood";
            this.Size = new System.Drawing.Size(390, 40);
            this.Load += new System.EventHandler(this.UserControlOrderedFood_Load);
            this.ResumeLayout(false);

        }

        #endregion
        public System.Windows.Forms.Label labelNameFood;
        public System.Windows.Forms.Label labelPrice;
        public System.Windows.Forms.Label labelSum;
        public FontAwesome.Sharp.IconButton buttonIncrease;
        public FontAwesome.Sharp.IconButton buttonReduce;
        public FontAwesome.Sharp.IconButton buttonDelete;
        public Zeroit.Framework.Tooltip.ZeroitTetraToolTip toolTip;
        public Zeroit.Framework.Metro.ZeroitMetroTextbox textNumber;
    }
}
