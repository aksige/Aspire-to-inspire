package DoBeDo;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AtI extends GameObject {

    Handler handler;
    Game game;

    private BufferedImage[] atl_image = new BufferedImage[3];

    Animation anim;

    public AtI(int x, int y, ID id, Handler handler, Game game, MagicMonsters mm) {
        super(x, y, id, mm);
        this.handler = handler;
        this.game = game;

        atl_image[0] = mm.grabImage(1,1,32,48);
        atl_image[1] = mm.grabImage(2,1,32,48);
        atl_image[2] = mm.grabImage(3,1,32,48);

        anim = new Animation(3, atl_image[0], atl_image[1], atl_image[2]);
    }

    public void tick() {
        x += velX;
        y += velY;

        collision();

        //Перемещение
       if(handler.isUp()) velY = -3;
        else if(!handler.isDown()) velY = 0;

        if(handler.isDown()) velY = 3;
        else if(!handler.isUp()) velY = 0;

        if(handler.isRight()) velX = 3;
        else if(!handler.isLeft()) velX = 0;

        if(handler.isLeft()) velX = -3;
        else if(!handler.isRight()) velX = 0;

        anim.runAnimation();

    }

    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){

           GameObject tempObject =  handler.object.get(i);

           if(tempObject.getId() == ID.Block){

               if(getBounds().intersects(tempObject.getBounds())){
                   x += velX * -1;
                   y += velY * -1;
               }

           }
           if(tempObject.getId() == ID.Crate){

                if(getBounds().intersects(tempObject.getBounds())){
                   game.ammo += 10;
                   handler.removeObject(tempObject);
                }

            }
            if(tempObject.getId() == ID.Enemy){

                if(getBounds().intersects(tempObject.getBounds())){
                    game.hp--;
                }

            }

        }

    }

    public void render(Graphics g) {
//        g.setColor(Color.green);
//        g.fillRect(x, y,32,48);

        if(velX == 0 && velY == 0)
        g.drawImage(atl_image[0], x, y, null);
        else
            anim.drawAnimation(g,x,y,0);

    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, 32,48);
    }
}
