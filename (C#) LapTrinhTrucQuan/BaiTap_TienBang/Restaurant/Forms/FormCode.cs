using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using QRCoder;
using BarcodeLib;

namespace Restaurant.Forms
{
    public partial class FormCode : Form
    {
        BarcodeLib.Barcode code128;
        public FormCode()
        {
            InitializeComponent();
            code128 = new Barcode();
        }

        private void FormCode_Load(object sender, EventArgs e)
        {
            Image barcode = code128.Encode(BarcodeLib.TYPE.CODE128, textBarCode.Text, Color.FromArgb(102, 120, 201), Color.FromArgb(237, 241, 246), pictureBoxBarCode.Width, pictureBoxBarCode.Height);
            pictureBoxBarCode.Image = barcode;
            QRCodeGenerator qrGenerator = new QRCodeGenerator();
            QRCode qrCode = new QRCode(qrGenerator.CreateQrCode(textQRCode.Text, QRCodeGenerator.ECCLevel.Q));
            //QRCodeGenerator.ECCLevel.Q là mức chịu lỗi 25%; .L là 7%; .M là 15% và .H là trên 25%
            pictureBoxQRCode.Image = qrCode.GetGraphic(1, Color.FromArgb(102, 120, 201), Color.FromArgb(237, 241, 246), false);
            qrGenerator.Dispose();
            qrCode.Dispose();
        }

        private void checkQRCode_CheckedChanged(object sender, EventArgs e)
        {
            if (textQRCode.Enabled == false)
            {
                textQRCode.Enabled = true;
            }
            else textQRCode.Enabled = false;
        }

        private void checkBarCode_CheckedChanged(object sender, EventArgs e)
        {
            if (textBarCode.Enabled == false)
            {
                textBarCode.Enabled = true;
            }
            else textBarCode.Enabled = false;
        }

        private void buttonTry_Click(object sender, EventArgs e)
        {
            FormCode_Load(sender, e);
        }

        private void buttonChange_Click(object sender, EventArgs e)
        {

        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
