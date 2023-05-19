import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception 
    {
        // create the calculator frame
        JFrame main_frame = new JFrame("Calculator");
        main_frame.setLayout(null);

        // create the panel
        JPanel main_panel = new JPanel(null);

        // set sizes
        main_frame.setSize(400, 500);
        main_panel.setSize(400, 500);


        // add everithing in the panel and frame
        main_frame.add(main_panel);

        // make it visible
        main_frame.setVisible(true);

    }
}
