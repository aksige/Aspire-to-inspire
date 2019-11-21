package DoBeDo;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Crate extends GameObject{

    private BufferedImage crate_image;

    public Crate(int x, int y, ID id, MagicMonsters mm) {

        super(x, y, id, mm);

        crate_image = mm.grabImage(6,2,32,32);
    }

    public void tick() {


    }

    public void render(Graphics g) {
//        g.setColor(Color.cyan);
//        g.fillRect(x, y, 32, 32);

        g.drawImage(crate_image, x, y, null);

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32,32);
    }
}
