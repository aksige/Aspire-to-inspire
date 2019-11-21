package DoBeDo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {

    private Handler handler;

    public Bullet(int x, int y, ID id, Handler handler, int mx, int my, MagicMonsters mm) {
        super(x, y, id, mm);
        this.handler = handler;

        velX = (mx - x) / 10;
        velY = (my - y) / 10;
    }

    public void tick() {
        x += velX;
        y += velY;

        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Block){
                if(getBounds().intersects(tempObject.getBounds())){
                    handler.removeObject(this);
                }
            }
        }

    }

    public void render(Graphics g) {
        g.setColor(Color.PINK);
        g.fillRect(x, y, 8, 8);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 8,8);
    }
}
