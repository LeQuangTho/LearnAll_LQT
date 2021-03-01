using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaiTap20
{
    public partial class Form1 : Form
    {
        Form2 thayFont;

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
           
            openFileDialog1.Filter = "RichTextBox (*.rtf) |*.rtf| All file (*.*)|*.*";
            openFileDialog1.InitialDirectory = "F:\\LapTrinhTrucQuan";
            openFileDialog1.Title = "Chọn file Rick text box";
            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                richTextBox1.LoadFile(openFileDialog1.FileName,RichTextBoxStreamType.RichText);
            }   
        }

        private void button3_Click(object sender, EventArgs e)
        {
            /*thayFont = new Form2();
            thayFont.setForm(this);
            thayFont.Show();*/
            fontDialog1.ShowColor = true;
            if(fontDialog1.ShowDialog() == DialogResult.OK)
            {
                richTextBox1.SelectionFont = fontDialog1.Font;
                richTextBox1.SelectionColor = fontDialog1.Color;
            }    
        }

        /*public void doiFont()
        {
            if (thayFont.save == true)
            {
                richTextBox1.Font = thayFont.getFont();
                richTextBox1.ForeColor = thayFont.getColor();
            }
        }*/

        private void button4_Click(object sender, EventArgs e)
        {
            if(MessageBox.Show("Bạn có muốn đóng không?","Hỏi",MessageBoxButtons.YesNo) == DialogResult.Yes)
            this.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            saveFileDialog1.Filter = "RichTextBox (*.rtf) |*.rtf| All file (*.*)|*.*";

            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    richTextBox1.SaveFile(saveFileDialog1.FileName, RichTextBoxStreamType.RichText);
                }
                catch
                {
                    e.GetHashCode();
                }
                    
            }
        }
    }
}
