using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FontAwesome.Sharp;
using System.Drawing.Drawing2D;
using System.Drawing;
using System.Windows.Forms;

namespace Restaurant.CustomControls
{
    class RadiusPanel : Panel
    {

        private Color borderColor = Color.Red;
        private float borderWidth = 5f;
        private int borderRadius = 40;
        public Color BorderColor
        {
            get { return borderColor; }
            set { borderColor = value; }
        }
        public float BorderWidth
        {
            get { return borderWidth; }
            set { borderWidth = value; }
        }
        public int BorderRadius
        {
            get { return borderRadius; }
            set { borderRadius = value; }
        }

        GraphicsPath getRoundPath(RectangleF rect, int radius)
        {
            float r = radius / 2f;
            GraphicsPath graphicsPath = new GraphicsPath();
            graphicsPath.AddArc(rect.X, rect.Y, radius, radius, 180, 90);
            graphicsPath.AddLine(rect.X + r, rect.Y, rect.Width - r, rect.Y);
            graphicsPath.AddArc(rect.X + rect.Width - radius, rect.Y, radius, radius, 270, 90);
            graphicsPath.AddLine(rect.Width, rect.Y + r, rect.Width, rect.Height - r);
            graphicsPath.AddArc(rect.X + rect.Width - radius,
                             rect.Y + rect.Height - radius, radius, radius, 0, 90);
            graphicsPath.AddLine(rect.Width - r, rect.Height, rect.X + r, rect.Height);
            graphicsPath.AddArc(rect.X, rect.Y + rect.Height - radius, radius, radius, 90, 90);
            graphicsPath.AddLine(rect.X, rect.Height - r, rect.X, rect.Y + r);
            graphicsPath.CloseFigure();
            return graphicsPath;
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);
            RectangleF Rect = new RectangleF(0, 0, this.Width, this.Height);
            using (GraphicsPath GraphPath = getRoundPath(Rect, borderRadius))
            {
                this.Region = new Region(GraphPath);
                using (Pen pen = new Pen(this.BorderColor, borderWidth))
                {
                    pen.Alignment = PenAlignment.Inset;
                    e.Graphics.DrawPath(pen, GraphPath);
                }
            }
        }
    }
}
