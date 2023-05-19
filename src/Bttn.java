import javax.swing.*;
import java.awt.*;

public class Bttn extends Button
{   
    public Bttn(String t, int x, int y, int w, int h)
    {
        setLabel(t);
        setBounds(x, y, w, h);
    }
}