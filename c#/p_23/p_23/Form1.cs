using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using System.Diagnostics;

using Microsoft.Office.Interop.PowerPoint;
using PowerPoint = Microsoft.Office.Interop.PowerPoint;
using System.Runtime.InteropServices;

namespace p_23
{
    public partial class Form1 : Form
    {
        PowerPoint.Application objApp;
        PowerPoint.Presentations objPresSet;
        PowerPoint._Presentation objPres;
        PowerPoint.SlideShowSettings objSSS;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
        Button[] bt = new Button[5];
        string pz;
        public void pusk(object sender, EventArgs e)
        {
            string name = (sender as Button).Name;
            string o = Environment.CurrentDirectory;
            Process.Start(o+"/"+pz+"/"+name+".exe");
        }
        private void button1_Click(object sender, EventArgs e)
        {
            for(int i=0; i<bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz= (sender as Button).Text;
            int kol_f= Convert.ToInt32( new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f-1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString( i+1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz+"/"+"zad.rtf");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button3_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button4_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button5_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button6_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button7_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button12_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 4; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button8_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button9_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button10_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button11_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 3; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button13_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button14_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button15_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button16_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 4; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button17_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button18_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button19_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 2; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button20_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < bt.Length; i++)
            {
                Controls.Remove(bt[i]);
            }
            pz = (sender as Button).Text;
            int kol_f = Convert.ToInt32(new DirectoryInfo(pz).GetFiles().Length.ToString());
            for (int i = 0; i < kol_f - 1; i++)
            {
                bt[i] = new Button();
                bt[i].Name = Convert.ToString(i + 1);
                bt[i].Text = bt[i].Name;
                bt[i].Location = new System.Drawing.Point(670, 30 * (i + 1));
                Controls.Add(bt[i]);
                bt[i].Click += new EventHandler(pusk);
            }
            richTextBox1.LoadFile(pz + "/" + "zad.rtf");
        }

        private void button22_Click(object sender, EventArgs e)
        {
            objApp = new PowerPoint.Application();
            objPresSet = objApp.Presentations;
            string dom = Convert.ToString(Environment.CurrentDirectory);
            MessageBox.Show(dom);
            objPres = objPresSet.Open(dom+@"/24/prez.pptx");
            objSSS = objPres.SlideShowSettings;
            objSSS.StartingSlide = 1;
            objSSS.EndingSlide = 3;
            objSSS.Run();
        }
    }
}
