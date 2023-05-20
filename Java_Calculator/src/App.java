import java.awt.*;
import javax.swing.*;


public class App {
    public static void main(String[] args) throws Exception 
    {   
        // Font definition
        Font SansSerifBold = new Font("SansSerif", Font.BOLD, 30);

        // create the calculator frame
        JFrame main_frame = new JFrame("Calculator");
        main_frame.setLayout(null);

        // create the panel
        JPanel main_panel = new JPanel(null);

        //  create figures buttons
        Bttn zero   = new Bttn("0", 100, 450, 80, 60, Color.darkGray, Color.white, SansSerifBold);
        Bttn one    = new Bttn("1", 10 , 380, 80, 60, Color.darkGray, Color.white, SansSerifBold);
        Bttn two    = new Bttn("2", 100, 380, 80, 60, Color.darkGray, Color.white, SansSerifBold);
        Bttn three  = new Bttn("3", 190, 380, 80, 60, Color.darkGray, Color.white, SansSerifBold);
        Bttn four   = new Bttn("4", 10 , 310, 80, 60, Color.darkGray, Color.white, SansSerifBold);
        Bttn five   = new Bttn("5", 100, 310, 80, 60, Color.darkGray, Color.white, SansSerifBold);
        Bttn six    = new Bttn("6", 190, 310, 80, 60, Color.darkGray, Color.white, SansSerifBold);
        Bttn seven  = new Bttn("7", 10 , 240, 80, 60, Color.darkGray, Color.white, SansSerifBold);
        Bttn eight  = new Bttn("8", 100, 240, 80, 60, Color.darkGray, Color.white, SansSerifBold);
        Bttn nine   = new Bttn("9", 190, 240, 80, 60, Color.darkGray, Color.white, SansSerifBold);

        // create operators buttons
        Bttn eq     = new Bttn("=" , 280, 450, 80, 60, Color.green   , Color.white, SansSerifBold);
        Bttn pl_min = new Bttn("±" , 10 , 450, 80, 60, Color.darkGray, Color.white, SansSerifBold);
        Bttn comma  = new Bttn("," , 190, 450, 80, 60, Color.darkGray, Color.white, SansSerifBold);
        Bttn plus   = new Bttn("+" , 280, 380, 80, 60, Color.darkGray, Color.green, SansSerifBold);
        Bttn minus  = new Bttn("-" , 280, 310, 80, 60, Color.darkGray, Color.green, SansSerifBold);
        Bttn per    = new Bttn("×" , 280, 240, 80, 60, Color.darkGray, Color.green, SansSerifBold);
        Bttn div    = new Bttn("÷" , 280, 170, 80, 60, Color.darkGray, Color.green, SansSerifBold);
        Bttn prc    = new Bttn("%" , 190, 170, 80, 60, Color.darkGray, Color.green, SansSerifBold);
        Bttn brks   = new Bttn("()", 100, 170, 80, 60, Color.darkGray, Color.green, SansSerifBold);
        Bttn del    = new Bttn("C" , 10 , 170, 80, 60, Color.darkGray, Color.red  , SansSerifBold);

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
        main_panel.add(comma);
        main_panel.add(prc);
        main_panel.add(brks);
        main_panel.add(del);


        // make it visible
        main_frame.setVisible(true);

    }
}
