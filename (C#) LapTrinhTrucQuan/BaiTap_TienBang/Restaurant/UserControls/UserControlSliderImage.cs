using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Restaurant.UserControls
{
    public partial class UserControlSliderImage : UserControl
    {
        public Label LabelTitleSlider
        {
            get { return labelTitleSlider; }
            set { labelTitleSlider = value; }
        }            
        public Label LabelSubTitleSlider
        {
            get { return labelSubTitleSlider; }
            set { labelSubTitleSlider = value; }
        }
        public PictureBox PictureBoxSlider
        {
            get { return pictureBoxSlider; }
            set { pictureBoxSlider = value; }
        }
        public UserControlSliderImage()
        {
            InitializeComponent();
        }

        private void UserControlSliderImage_Load(object sender, EventArgs e)
        {

        }
    }
}
