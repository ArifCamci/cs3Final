
import mayflower.*;
public class MyWorld extends World
{
    private CityRenderer renderer;
    private HUD hud;
    private CityMap map;
    private money m;
    private int frameNumber;

    public MyWorld(){
        setBackground("images/background.png");
        map = new BetaCityMap();
        renderer = new CityRenderer(this, map, 800, 600, -100, 100);
        hud = new HUD(renderer, map);
        m = new money(0, 10, map);
        frameNumber = 0;
    }
    
    public void act(){
        if (Mayflower.isKeyDown(Keyboard.KEY_UP)    || Mayflower.isKeyDown(Keyboard.KEY_W)) {
            renderer.setY(renderer.getY() - 5);
        }
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) || Mayflower.isKeyDown(Keyboard.KEY_D)) {
            renderer.setX(renderer.getX() + 5);
        }
        if (Mayflower.isKeyDown(Keyboard.KEY_DOWN)  || Mayflower.isKeyDown(Keyboard.KEY_S)) {
            renderer.setY(renderer.getY() + 5);
        }
        if (Mayflower.isKeyDown(Keyboard.KEY_LEFT)  || Mayflower.isKeyDown(Keyboard.KEY_A)) {
            renderer.setX(renderer.getX() - 5);
        }
        renderer.act();
        //hack to prevent the map from drawing over the hud
        addObject(hud, 0, 0);
        if (frameNumber % 30 == 0) {
            int dm = m.CalcMoney();
            m.add(dm);
            System.out.printf("Your current money is: %d\n", m.getMoney());
        }
        ++frameNumber;
    }
    
    
}
