using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;
namespace WindowsFormsApplication1
{
public partial class Form2 : Form
{
string ln;
string fn;
static string gr;
double ex;
double cw;
List<Student> student_list = new List<Student>();
public Form2()
{
InitializeComponent();
}
private void Form2_Load(object sender, EventArgs e)
{
checkBox1.Checked = false;
string[] group = {"РФ-425", "РФ-426", "РФ-427", "РФ-428" , "РФ-429"};
comboBox1.SelectedIndexChanged += comboBox1_SelectedIndexChanged;
comboBox1.DataSource = group;
comboBox1.SelectedIndex = 0;
exam.KeyPress += exam_KeyPress;
coursework.KeyPress += exam_KeyPress;
exam.TextChanged += mark_TextChanged;
coursework.TextChanged += mark_TextChanged;
}
static void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
{
ComboBox comboBox = (ComboBox)sender;
gr = comboBox.SelectedItem.ToString();
}
private void button1_Click(object sender, EventArgs e)
{
OpenFileDialog openPicture = new OpenFileDialog();
openPicture.Filter = "JPG|*.jpg;*.jpeg|PNG|*.png";
if (openPicture.ShowDialog() == DialogResult.OK)
{
pictureBox1.Image = Image.FromFile(openPicture.FileName);
pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
}
}
private void exam_KeyPress(object sender, KeyPressEventArgs e)
{
// ввод в texBox только цифр и ','
char ch = e.KeyChar;
if (!Char.IsDigit(ch) && ch != ',')
{
e.Handled = true;
}
}
private void button2_Click(object sender, EventArgs e)
{
// проверка сразу всех TextBox на заполнение
// foreach (Control ctrl in this.Controls)
// {
// if (ctrl.GetType() == typeof(TextBox))
// if ((String)ctrl.Text == "") MessageBox.Show("Всё пропало!");
// }
// проверка TextBox на заполнение по одному
if (lastname.Text != String.Empty)
{
ln = lastname.Text;
}
else
{
MessageBox.Show("Заполните поле Фамилия");
lastname.Focus();
return;
}
if (firstname.Text != String.Empty)
{
fn = firstname.Text;
}
else
{
firstname.Focus();
MessageBox.Show("Заполните поле Имя");
return;
}
if (exam.Text != String.Empty)
{
ex = Convert.ToDouble(exam.Text.Replace(',', '.'));
}
else
{
exam.Focus();
MessageBox.Show("Заполните поле Экзамен");
return;
}
if (coursework.Text != String.Empty)
{
cw = Convert.ToDouble(coursework.Text.Replace(',', '.'));
}
else
{
coursework.Focus();
MessageBox.Show("Заполните поле Курсовая работа");
return;
}
Student s = new Student(ln, fn, gr, ex, cw);
MessageBox.Show(s.Info());
}
private void checkBox1_CheckedChanged(object sender, EventArgs e)
{