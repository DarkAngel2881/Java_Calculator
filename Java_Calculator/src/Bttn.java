//import javax.swing.*;
import java.awt.*;

public class Bttn extends Button
{   
    public Bttn(String t, int x, int y, int w, int h, Color c, Color tc, Font f)
    {
        setLabel(t);
        setBounds(x, y, w, h);
        setBackground(c);
        setForeground(tc);
        setFocusable(false);
        setFont(f);
    }
}
