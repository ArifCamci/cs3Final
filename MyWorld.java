
import mayflower.*;
public class MyWorld extends World
{
    private CityRenderer renderer;
    private HUD hud;
    private CityMap map;

    public MyWorld(){
        setBackground("images/background.png");
        map = new BetaCityMap();
        renderer = new CityRenderer(this, map, 800, 600, -100, 100);
        hud = new HUD(renderer, map);
    }
    
    public void act(){
        renderer.act();
        //hack to prevent the map from drawing over the hud
        addObject(hud, 0, 0);
    }
    
    
}
