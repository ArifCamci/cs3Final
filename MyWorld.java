
import mayflower.*;
public class MyWorld extends World
{
    private CityRenderer renderer;

    public MyWorld(){
        setBackground("images/background.png");
        renderer = new CityRenderer(this, new BetaCityMap(), 800, 600, -100, -100);
        addObject(new HUD(), 0, 0);
    }
    
    public void act(){
        renderer.act();
    }
    
    
}
