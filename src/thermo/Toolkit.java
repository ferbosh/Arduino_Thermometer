package thermo;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Toolkit {

    public static Font getNewRegisteredFont(String path, int sytle, int size){
        Font font = null;

        try {
            font = Font.createFont(0, Toolkit.class.getResourceAsStream(path));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
        } catch (IOException | FontFormatException var3) {
            Logger.getLogger(Toolkit.class.getName()).log(Level.SEVERE, null, var3);
        }

        return font.deriveFont(sytle, size);
    }
}
