using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing.Drawing2D;
using System.Drawing;
using System.Windows.Forms;
using XanderUI;

namespace Restaurant.CustomControls
{
    class RadiusCircleProgressBar: XUICircleProgressBar
    {
        public Color BorderColor { get; set; } = Color.FromArgb(45, 48, 70);
        public float BorderWidth { get; set; } = 5f;
        public int BorderRadiusTopLeft { get; set; } = 50;
        public int BorderRadiusTopRight { get; set; } = 50;
        public int BorderRadiusBottomRight { get; set; } = 50;
        public int BorderRadiusBottomLeft { get; set; } = 50;

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
            RectangleF Rect = new RectangleF(0, 0, this.Width, this.Height);
            using (GraphicsPath GraphPath = getRoundPath(Rect, BorderRadiusTopLeft, BorderRadiusTopRight, BorderRadiusBottomRight, BorderRadiusBottomLeft))
            {
                this.Region = new Region(GraphPath);
                using (Pen pen = new Pen(this.BorderColor, BorderWidth))
                {
                    pen.Alignment = PenAlignment.Inset;
                    e.Graphics.DrawPath(pen, GraphPath);
                }
            }
        }
    }
}
