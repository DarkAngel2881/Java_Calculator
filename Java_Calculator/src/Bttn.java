import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bttn extends JButton
{   
    private JTextField T;
    public Bttn(String t, int x, int y, int w, int h, Color c, Color tc, Font f, Icon img, JTextField txt, ActionListener BttnListenr)
    {
        
        setText(t);
        setBounds(x, y, w, h);
        setBackground(c);
        setForeground(tc);
        setFocusable(false);
        setFont(f);
        setIcon(img);
        setBorder(null);
        T = txt;
        addActionListener(BttnListenr);
    }

    

    
}
