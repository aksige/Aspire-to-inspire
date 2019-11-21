package DoBeDo;

import java.awt.image.BufferedImage;

public class MagicMonsters {

    private BufferedImage image;

    public MagicMonsters(BufferedImage image){
        this.image = image;
    }

    public BufferedImage grabImage(int col, int row, int width, int height){
        return image.getSubimage((col*32)-32, (row*32)-32, width, height);
    }
}
