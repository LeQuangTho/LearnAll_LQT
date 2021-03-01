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
    public partial class UserControlBillHeader : UserControl
    {
        public string QRCodeText { get; set; } = "Restaurant";
        public UserControlBillHeader()
        {
            InitializeComponent();
        }

        public void UserControlBillTitle_Load(object sender, EventArgs e)
        {
            QRCodeGenerator qrGenerator = new QRCodeGenerator();
            QRCode qrCode = new QRCode(qrGenerator.CreateQrCode(QRCodeText, QRCodeGenerator.ECCLevel.Q));
            //QRCodeGenerator.ECCLevel.Q là mức chịu lỗi 25%; .L là 7%; .M là 15% và .H là trên 25%
            pictureBoxQRCode.Image = qrCode.GetGraphic(4, Color.FromArgb(102, 120, 201), Color.FromArgb(237, 241, 246), false);
            qrGenerator.Dispose();
            qrCode.Dispose();
        }
    }
}
