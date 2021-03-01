using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FontAwesome.Sharp;
using System.Drawing.Drawing2D;
using System.Drawing;
using System.Diagnostics;
using System.Windows.Forms;

namespace Restaurant.CustomControls
{
    class AnimatedRadiusIconButton : IconButton
    {
        public Color BorderColor { get; set; } = Color.Transparent;
        public float BorderWidth { get; set; } = 0f;
        public int BorderRadiusTopLeft { get; set; } = 10;
        public int BorderRadiusTopRight { get; set; } = 10;
        public int BorderRadiusBottomRight { get; set; } = 10;
        public int BorderRadiusBottomLeft { get; set; } = 10;
        public Color ForeColorHover { get; set; } = Color.FromArgb(100, 100, 100);
        Stopwatch sw = new Stopwatch();
        Timer Animation { get; set; } = new Timer();
        Timer AnimationBack { get; set; } = new Timer();
        public int AnimationInterval { get; set; } = 1;
        public string CustomButtonText { get; set; } = "HOVER HERE";
        public Color BackHoverColor { get; set; } = Color.Purple;
        public Color TextHoverColor { get; set; } = Color.White;
        public int BackgroundSpeed { get; set; } = 40;
        public double SmoothCorrectionFactor { get; set; } = 1.5F;
        public bool UseSmoothSpeedIncrement { get; set; } = true;
        private int incremental_x = 1;
        private bool DrawString = false;
        public AnimatedRadiusIconButton()
        {
            this.SetStyle(System.Windows.Forms.ControlStyles.UserPaint |
                System.Windows.Forms.ControlStyles.AllPaintingInWmPaint |
                System.Windows.Forms.ControlStyles.OptimizedDoubleBuffer, true);
            Animation.Interval = AnimationInterval;
            AnimationBack.Interval = AnimationInterval;
            Animation.Tick += ButtonAnimation;
            AnimationBack.Tick += ButtonAnimationBack;
            this.FlatStyle = FlatStyle.Flat;
            this.FlatAppearance.BorderSize = 0;
            this.BackColor = Color.FromArgb(240, 240, 240);
            this.ForeColor = Color.FromArgb(100, 100, 100);
        }

        private void ButtonAnimationBack(object sender, EventArgs e)
        {
            if (UseSmoothSpeedIncrement)
            {
                incremental_x -= Convert.ToInt32(BackgroundSpeed * sw.Elapsed.TotalSeconds * SmoothCorrectionFactor);
            }
            else
            {
                incremental_x -= BackgroundSpeed;
            }
            if (incremental_x <= 0)
            {
                AnimationBack.Stop();
                incremental_x = 1;
            }
            this.Invalidate();
        }

        private void ButtonAnimation(object sender, EventArgs e)
        {
            if (UseSmoothSpeedIncrement)
            {
                incremental_x += Convert.ToInt32(BackgroundSpeed * sw.Elapsed.TotalSeconds * SmoothCorrectionFactor);
            }
            else
            {
                incremental_x += BackgroundSpeed;
            }
            if (incremental_x > this.Width * 3)
            {
                Animation.Stop();
            }
            this.Invalidate();
        }

        GraphicsPath getRoundPath(RectangleF rect, int radiusTopLeft, int radiusTopRight, int radiusBottomRight, int radiusBottomLeft)
        {
            float rTL = radiusTopLeft / 2f;
            float rTR = radiusTopRight / 2f;
            float rBR = radiusBottomRight / 2f;
            float rBL = radiusBottomLeft / 2f;
            GraphicsPath graphicsPath = new GraphicsPath();
            graphicsPath.AddArc(rect.X, rect.Y, radiusTopLeft, radiusTopLeft, 180, 90);
            graphicsPath.AddLine(rect.X + rTL, rect.Y, rect.Width - rTL, rect.Y);
            graphicsPath.AddArc(rect.X + rect.Width - radiusTopRight, rect.Y, radiusTopRight, radiusTopRight, 270, 90);
            graphicsPath.AddLine(rect.Width, rect.Y + rTR, rect.Width, rect.Height - rTR);
            graphicsPath.AddArc(rect.X + rect.Width - radiusBottomRight,
                             rect.Y + rect.Height - radiusBottomRight, radiusBottomRight, radiusBottomRight, 0, 90);
            graphicsPath.AddLine(rect.Width - rBR, rect.Height, rect.X + rBR, rect.Height);
            graphicsPath.AddArc(rect.X, rect.Y + rect.Height - radiusBottomLeft, radiusBottomLeft, radiusBottomLeft, 90, 90);
            graphicsPath.AddLine(rect.X, rect.Height - rBL, rect.X, rect.Y + rBL);
            graphicsPath.CloseFigure();
            return graphicsPath;
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);
            var g = e.Graphics;
            g.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.HighQuality;
            if (incremental_x != 1)
            {
                Rectangle r = new Rectangle(new Point(0 - incremental_x / 2, 0 - incremental_x / 2), new Size(incremental_x, this.Height + incremental_x));
                g.FillPie(new SolidBrush(BackHoverColor), r, 0, 360);
            }
            StringFormat sf = new StringFormat();
            sf.LineAlignment = StringAlignment.Center;
            sf.Alignment = StringAlignment.Center;
            SolidBrush TextColor;
            if (DrawString)
                TextColor = new SolidBrush(TextHoverColor);
            else
                TextColor = new SolidBrush(this.ForeColorHover);
            g.DrawString(CustomButtonText, this.Font, TextColor, new Rectangle(new Point(0, 0), new Size(this.Width, this.Height)), sf);
            RectangleF Rect = new RectangleF(0, 0, this.Width, this.Height);
            using (GraphicsPath GraphPath = getRoundPath(Rect, BorderRadiusTopLeft, BorderRadiusTopRight, BorderRadiusBottomRight, BorderRadiusBottomLeft))
            {
                this.Region = new Region(GraphPath);
                using (Pen pen = new Pen(this.BorderColor, BorderWidth))
                {
                    pen.Alignment = PenAlignment.Inset;
                    g.DrawPath(pen, GraphPath);
                }
            }
        }

        protected override void OnMouseEnter(EventArgs e)
        {
            base.OnMouseEnter(e);
            DrawString = true;
            AnimationBack.Stop();
            Animation.Start();
            sw.Reset();
            sw.Stop();
            sw.Start();
        }

        protected override void OnMouseLeave(EventArgs e)
        {
            base.OnMouseLeave(e);
            DrawString = false;
            Animation.Stop();
            AnimationBack.Start();
            sw.Reset();
            sw.Stop();
            sw.Start();
        }
    }
}
