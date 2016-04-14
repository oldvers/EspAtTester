/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

/**
 *
 * @author oleksandr.kukharchuk
 */
public class Log extends javax.swing.JTextArea
{
  public void clear()
  {
    this.setText("");
  }
  
  public void printRaw(String str)
  {
    this.append(str);
  }

  public void printArray(byte[] bytes, int from, int length)
  {
    if (bytes == null)
    {
      return;
    }

    StringBuilder SB = new StringBuilder();
    int index = from;

    for (int j = 0; j < length; j++, index++)
    {
      SB.append(String.format("0x%02X, ", bytes[index] & 0xFF));

      if (j % 16 == 15)
      {
        this.append(SB.toString() + "\r\n");
        SB.delete(0, SB.length());
      }
    }
    if ((SB.toString().length() > 0) && (SB.toString().length() < (16 * 6)))
    {
      this.append(SB.toString() + "\r\n");
    }
  }

  public void printString(String string)
  {
    this.append(string + "\r\n");
  }

  public void printString(String str, Object... os)
  {
    this.append(String.format(str, os) + "\r\n");
  }
}
