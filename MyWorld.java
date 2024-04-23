
import mayflower.*;
public class MyWorld extends World
{
    private CityMap map;

    // (0, 0) is the center of the building at (0, 0)
    // x and y are measured in pixels, and refers to the top left of the screen
    private int x;
    private int y;

    public MyWorld(){
        setBackground("images/background.png");
        map = new BetaCityMap();
        x = y = 0;
    }
    
    public void act(){
        
    }
    
    
}
