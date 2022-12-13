import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class gui_calci implements ActionListener {
    Frame f;
    Panel p2;
    TextField tf;
    String num1="";
    String operation="";
    String num2="";
  public gui_calci(){
         f = new Frame("calculator");
        f.setSize(300,400);
        f.setLayout(new BorderLayout());
         tf = new TextField();

      p2 = new Panel();
        p2.setLayout(new GridLayout(4,4));
      Button button[] = new Button[10];
      for(int i=0;i<10;i++)
      {
          button[i] = new Button(String.valueOf(9-i));
          p2.add(button[i]);
          button[i].addActionListener(this);
      }
      Button clr=new Button("C");
        p2.add(clr);
        clr.addActionListener(this);
//
        Button operationerator[] = new Button[5];
        operationerator[0]=new Button("/");
        operationerator[1]=new Button("*");
        operationerator[2]=new Button("-");
        operationerator[3]=new Button("+");
        operationerator[4]=new Button("=");
        for(int i=0;i<4;i++)
        {
            p2.add(operationerator[i]);
            operationerator[i].addActionListener(this);
        }
        p2.add(operationerator[4]);
        operationerator[4].addActionListener(this);

        f.add(tf,BorderLayout.NORTH);
        f.add(p2,BorderLayout.CENTER);
        
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String value = e.getActionCommand();
        char ch = value.charAt(0);
//        --------------------------------------------------

        if(ch>='0' && ch<='9')
        {

            if (operation.equals("") && !num1.equals(""))
                num1 = "";
            else if(!operation.equals(""))
                num1 = num1 + value;
            else
                num2 = num2 + value;
            tf.setText(num1+operation+num2);
        }

//        ----------------------------------------------------
        else if(ch=='C')
        {
            num1 = operation = num2 = "";
            tf.setText("");
        }
//        ------------------------------------------------------
        else if (ch =='=')
        {
            if(!num1.equals("") && !num2.equals(""))
            {

                double temp;
                double n1=Double.parseDouble(num1);
                double n2=Double.parseDouble(num2);
                if(n2==0 && operation.equals("/"))
                {
                    tf.setText("infinity");
                }
                else {
                    if (operation.equals("+"))
                        temp = n1 + n2;
                    else if (operation.equals("-"))
                        temp = n1 - n2;
                    else if (operation.equals("/"))
                        temp = n1 / n2;
                    else
                        temp = n1 * n2;
                    tf.setText("" + temp);

                    num1 = Double.toString(temp);
                    operation = num2 = "";
                }
            }
            else
            {
                tf.setText("invalid operation");
            }
        }
//        -------------------------------------------------------------------
        else
        {
            if (operation.equals("")||num2.equals(""))
            {
                operation = value;
            }
            else
            {
                double temp;
                double n1=Double.parseDouble(num1);
                double n2=Double.parseDouble(num2);
                if(n2==0 && operation.equals("/"))
                {
                    tf.setText("infinity");
                    num1 = operation = num2 = "";
                }
                else
                {
                    if (operation.equals("+"))
                        temp = n1 + n2;
                    else if (operation.equals("-"))
                        temp = n1 - n2;
                    else if (operation.equals("/"))
                        temp = n1/n2;
                    else
                        temp = n1*n2;
//                    num1 = "";
                    num1 = Double.toString(temp);
                    operation = value;
                    num2 = "";
                }
            }
            tf.setText(num1+operation+num2);
        }

    }

    public static void main(String[] args) {
        gui_calci gc = new gui_calci();

    }
}