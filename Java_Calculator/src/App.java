import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;

public class App 
{   
    static JTextField T, t;
    static Bttn bksp, del, rais, prc, div, per, pl_min, pnt, eq, minus, plus;
    static Bttn zero, one, two, three, four, five, six, seven, eight, nine;
    String last, current, op, symb;
    Boolean flag = false;
    double num1, num2;


    public void createNewOutput() 
    {
        if (current.length() > 0) 
        {
            String bfcm = current.split("\\.")[0];
            String afcm = current.split("\\.")[1];
            if (afcm.equals("0")) 
            {
                current = bfcm;
            }
        }
    }

    public void bksp()
    {
        if (current.length() > 0)
        {
            current = current.substring(0, current.length() - 1);
        }
    }

    public void clr()
    {
        last = "";
        current = "";
        op = "";
    }

    public void updOutput(Boolean is_op_eq)
    {   
        current = current.replace("null", "");
        if(current.contains("-"))
        {
            String t;
            t = current.replace("-", "") + " ";
            t = t.replace(" ", "-");
            T.setText(t);
        }
        else
        {
            T.setText(current);
        }
        current = current.replace("Math Error!", "");
        /*String expr = "";
        if (is_op_eq)
        {
            expr = num2+ symb + num1;
        }
        else if(op != "" && current == "")
        {
            expr = op + last;
        }
        else
        {
            expr = current + op + last;
        }
        expr = expr.replace("null", "");
        if(expr.contains("-"))
        {   
            if(num1 < 0 && num2<0)
            {
                String T;
                T = expr.replace("-", "");
                T = "(" + T + ")-";
                t.setText(T);
            }
            else
            {
                String T;
                T = expr.replace("-", "") + " ";
                T = T.replace(" ", "-");
                t.setText(T);
            }
        }
        else
        {
            t.setText(expr);
        }*/
    }

    public void appndOutput(String n)
    {   
        if(flag)
        {
            current = current.replace("0", n);
            flag = false;
        }
        else if (n.equals(".") && current.contains("."))
        {
            return;
        }
        else if (n.equals("."))
        {
            current += ".0";
            flag = true;
            
        }
        else if (n != "")
        {   
            current += n;
            flag = false;
        }

    }

    public void setop(String newOp)
    {
        if (current.isEmpty())
        {
            op = newOp;
            return;
        }
        try
        {
            if (!last.isEmpty())
            {
                eval();
            }
        }
        catch(Exception NullPointerException)
        {
            
        }
        

        op = newOp;
        last = current;
        current = "";
    }

    public void neg()
    {
        
            current =   "-"+ current;
        
    }
    
    private class BttnListn implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JButton bttn = (JButton) e.getSource();
            Boolean is_op_eq = false;
            if (bttn == plus)
            {
                setop(plus.getText());
            }
            else if (bttn == minus)
            {
                setop(minus.getText());
            }
            else if (bttn == per)
            {
                setop(per.getText());
            }
            else if (bttn == div)
            {
                setop(div.getText());
            }
            else if (bttn == rais)
            {
                setop("^");
            }
            else if (bttn == prc)
            {
                setop(prc.getText());
            }
            else if (bttn == pl_min)
            {
                neg();
            }
            else if (bttn == bksp)
            {
                bksp();
            }
            else if (bttn == del)
            {
                clr();
            }
            else if (bttn == eq)
            {
                eval();
                is_op_eq = true;
            }
            else 
            {
                appndOutput(bttn.getText());
            }
            updOutput(is_op_eq);
        }
    }



    public void eval()
    {
        if (last.length() < 1 || current.length() < 1)
        {
            return;
        }
        double result = 0.0;
        num1 = Double.parseDouble(last);
        num2 = Double.parseDouble(current);
        symb = op;
        switch (op)
        {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "×":
                result = num1 * num2;
                break;
            case "÷":
                if(num2 == 0)
                {
                    clr();
                    current = "Math Error!";
                    return;
                }
                else
                {
                    result = num1 / num2;
                }
                break;
            case "^":
                result = Math.pow(num1, num2);
                break;
            case "%":
                result = (num2/100)*num1;
            default:
            
                break;
        }

        current = String.valueOf(result);
        op = null;
        last = "";
        createNewOutput();
    }


    public static void main(String[] args) throws Exception 
    {   
        App newApp = new App();
        BttnListn Listener = newApp.new BttnListn();

        Icon img = new ImageIcon("C:/Users/Matteo/Desktop/ /Java Projects/Java_Calculator/Java_Calculator/Java_Calculator/src/bksp.png");

        // Font definition
        Font SansSerifBold_num    = new Font("SansSerif", Font.BOLD , 30);
        Font SansSerifBold_op     = new Font("SansSerif", Font.PLAIN, 30);
        Font SansSerifBold_expr   = new Font("SansSerif", Font.BOLD, 18);


        // create the calculator frame
        JFrame main_frame = new JFrame("Calculator");
        main_frame.setLayout(null);

        // create the panel
        JPanel main_panel = new JPanel(null);

        // create the text field
        T = new JTextField(30);
        T.setBounds(5, 30, 355, 50);
        T.setBackground(Color.black);
        T.setForeground(Color.white);
        T.setBorder(null);
        T.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        T.setFont(SansSerifBold_num);

        // create text field expression handler
        t = new JTextField(30);
        t.setBounds(5, 80, 355, 30);
        t.setBackground(Color.black);
        t.setForeground(Color.white);
        t.setBorder(null);
        t.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        t.setFont(SansSerifBold_expr);

        //  create figures buttons
        zero   = new Bttn("0" , 100, 450, 80, 60, Color.darkGray, Color.white, SansSerifBold_num, null, Listener);
        one    = new Bttn("1" , 10 , 380, 80, 60, Color.darkGray, Color.white, SansSerifBold_num, null, Listener);
        two    = new Bttn("2" , 100, 380, 80, 60, Color.darkGray, Color.white, SansSerifBold_num, null, Listener);
        three  = new Bttn("3" , 190, 380, 80, 60, Color.darkGray, Color.white, SansSerifBold_num, null, Listener);
        four   = new Bttn("4" , 10 , 310, 80, 60, Color.darkGray, Color.white, SansSerifBold_num, null, Listener);
        five   = new Bttn("5" , 100, 310, 80, 60, Color.darkGray, Color.white, SansSerifBold_num, null, Listener);
        six    = new Bttn("6" , 190, 310, 80, 60, Color.darkGray, Color.white, SansSerifBold_num, null, Listener);
        seven  = new Bttn("7" , 10 , 240, 80, 60, Color.darkGray, Color.white, SansSerifBold_num, null, Listener);
        eight  = new Bttn("8" , 100, 240, 80, 60, Color.darkGray, Color.white, SansSerifBold_num, null, Listener);
        nine   = new Bttn("9" , 190, 240, 80, 60, Color.darkGray, Color.white, SansSerifBold_num, null, Listener);

        // create operators buttons
        bksp   = new Bttn(""  , 296, 116, 45, 29, Color.black   , Color.black, SansSerifBold_op, img     , Listener);
        del    = new Bttn("C" , 10 , 170, 80, 60, Color.darkGray, Color.red  , SansSerifBold_op, null, Listener);
        rais   = new Bttn("xⁿ", 100, 170, 80, 60, Color.darkGray, Color.green, SansSerifBold_op, null, Listener);
        prc    = new Bttn("%" , 190, 170, 80, 60, Color.darkGray, Color.green, SansSerifBold_op, null, Listener);
        div    = new Bttn("÷" , 280, 170, 80, 60, Color.darkGray, Color.green, SansSerifBold_op, null, Listener);
        per    = new Bttn("×" , 280, 240, 80, 60, Color.darkGray, Color.green, SansSerifBold_op, null, Listener);
        pl_min = new Bttn("±" , 10 , 450, 80, 60, Color.darkGray, Color.white, SansSerifBold_op, null, Listener);
        pnt    = new Bttn("." , 190, 450, 80, 60, Color.darkGray, Color.white, SansSerifBold_op, null, Listener);
        eq     = new Bttn("=" , 280, 450, 80, 60, Color.green   , Color.white, SansSerifBold_op, null, Listener);
        minus  = new Bttn("-" , 280, 310, 80, 60, Color.darkGray, Color.green, SansSerifBold_op, null, Listener);
        plus   = new Bttn("+" , 280, 380, 80, 60, Color.darkGray, Color.green, SansSerifBold_op, null, Listener);
    
        
        // line for aesthetics
        JPanel line = new JPanel(null);
        line.setBounds(10, 155, 350, 1);
        line.setBackground(Color.lightGray);

        // set sizes
        main_frame.setSize(385, 560);
        main_panel.setSize(385, 560);

        // set panel color background
        main_panel.setBackground(Color.black);
        
        // add everithing in the panel and frame
        main_frame.add(main_panel);
        main_panel.add(T);
        main_panel.add(t);
        main_panel.add(line);
        main_panel.add(zero);
        main_panel.add(one);
        main_panel.add(two);
        main_panel.add(three);
        main_panel.add(four);
        main_panel.add(five);
        main_panel.add(six);
        main_panel.add(seven);
        main_panel.add(eight);
        main_panel.add(nine);
        main_panel.add(plus);
        main_panel.add(minus);
        main_panel.add(per);
        main_panel.add(div);
        main_panel.add(eq);
        main_panel.add(pl_min);
        main_panel.add(pnt);
        main_panel.add(prc);
        main_panel.add(rais);
        main_panel.add(del);
        main_panel.add(bksp);



        // make it visible
        main_frame.setVisible(true);

    }
}
