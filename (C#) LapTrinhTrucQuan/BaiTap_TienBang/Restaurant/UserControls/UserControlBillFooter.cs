using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using BarcodeLib;
using QRCoder;

namespace Restaurant.UserControls
{
    public partial class UserControlBillFooter : UserControl
    {
        BarcodeLib.Barcode code128;
        public string BarcodeText {get;set;} = "8934602001078";
        public UserControlBillFooter()
        {
            InitializeComponent();
            code128 = new Barcode();
        }

        private void UserControlBillFooter_Load(object sender, EventArgs e)
        {
            Image barcode = code128.Encode(BarcodeLib.TYPE.CODE128, BarcodeText,Color.FromArgb(102, 120, 201),Color.FromArgb(237, 241, 246),pictureBoxBarCode.Width,pictureBoxBarCode.Height);
            pictureBoxBarCode.Image = barcode;

        }

        private void pictureBoxBarCode_Click(object sender, EventArgs e)
        {

        }
    }
}
