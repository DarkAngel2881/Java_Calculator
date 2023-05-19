import java.awt.Button;

import javax.swing.*;


public class App {
    public static void main(String[] args) throws Exception 
    {
        // create the calculator frame
        JFrame main_frame = new JFrame("Calculator");
        main_frame.setLayout(null);

        // create the panel
        JPanel main_panel = new JPanel(null);

        //  create buttons
        Bttn zero   = new Bttn("0", 100, 350, 80, 60);
        Bttn one    = new Bttn("1", 10 , 280, 80, 60);
        Bttn two    = new Bttn("2", 100, 280, 80, 60);
        Bttn three  = new Bttn("3", 190, 280, 80, 60);
        Bttn four   = new Bttn("4", 10 , 210, 80, 60);
        Bttn five   = new Bttn("5", 100, 210, 80, 60);
        Bttn six    = new Bttn("6", 190, 210, 80, 60);
        Bttn seven  = new Bttn("7", 10 , 140, 80, 60);
        Bttn eight  = new Bttn("8", 100, 140, 80, 60);
        Bttn nine   = new Bttn("9", 190, 140, 80, 60);

        // set sizes
        main_frame.setSize(395, 470);
        main_panel.setSize(395, 470);
        
        // add everithing in the panel and frame
        main_frame.add(main_panel);
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

        // make it visible
        main_frame.setVisible(true);

    }
}
