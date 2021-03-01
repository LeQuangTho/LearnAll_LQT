using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using BaiKiemTraThu.Models;
using Excel = Microsoft.Office.Interop.Excel;

namespace BaiKiemTraThu
{
    public partial class Form2 : Form
    {
        DataBase data = new DataBase();
        public Form2()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = data.dataReaderTable("Select * from CongViec");
        }

        private void Form2_Load(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Excel.Application exApp = new Excel.Application();
            Excel.Workbook exBook = exApp.Workbooks.Add(Excel.XlWBATemplate.xlWBATWorksheet); 
            Excel.Worksheet exSheet = (Excel.Worksheet)exBook.Worksheets[1];
            Excel.Range tenTruong = (Excel.Range)exSheet.Cells[1, 1]; //Đưa con trỏ vào ô A1
            tenTruong.Font.Size = 11; //Đặt cỡ chữ là 10

            tenTruong.Font.Name = "Times new roman"; //Chọn font Times new roman

            tenTruong.Font.Bold = true; //Định dạng kiểu font chữ là in đậm

            tenTruong.Font.Color = Color.Blue;  //Màu xanh da trời hoặc
            exSheet.Range["A1"].Font.Color = Color.Blue;
            tenTruong.ColumnWidth = 7;              
            exSheet.Range["D1:F1"].Merge(true);     //Nhóm cột C tới E tại hàng 8 thành 1 hàng
            exSheet.Range["D2:F2"].Merge(true);
            exSheet.Range["D3:F3"].Merge(true);
            exSheet.Range["D4:F4"].Merge(true);
            for (int i = 1; i <= 10; i++)
                exSheet.Range["C" + i + ":E" + i].HorizontalAlignment = Microsoft.Office.Interop.Excel.XlHAlign.xlHAlignCenter;
            //exSheet.get_Range("A7").Value = "STT";

            exSheet.Range["D1:F1"].Font.Bold = true;
            exSheet.Range["D1:F1"].Value = "BLABLA";
            exSheet.Range["D2:F2"].Value = "HÓA ĐƠN THANH TOÁN";
            exSheet.Range["D3:F3"].Value = "Đc: 60 HỒ TÙNG MẬU - HÀ NỘI";
            exSheet.Range["D3:F3"].Value = "0973***208";


            try
            {
                exBook.Activate();
                dlgSaveFile.ShowDialog();
                exBook.SaveAs(dlgSaveFile.FileName.ToString());
                exApp.Quit();
            }
            catch { }
        }
    }
}
