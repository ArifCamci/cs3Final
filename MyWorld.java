
import mayflower.*;
public class MyWorld extends World
{
    private CityRenderer renderer;
    private HUD hud;

    public MyWorld(){
        setBackground("images/background.png");
        renderer = new CityRenderer(this, new BetaCityMap(), 800, 600, -100, 100);
        hud = new HUD();
    }
    
    public void act(){
        renderer.act();
        //hack to prevent the map from drawing over the hud
        addObject(hud, 0, 0);
    }
    
    
}
