import mayflower.*;
import java.util.HashMap;
/**
 * extends actor, when clicked at positions of the icons the icon is selected
 * when clicked on a empty space it calls a function to place the object(not made yet)
 */
public class HUD extends Actor
{
    // instance variables - replace the example below with your own
    private static String selected;
    private CityRenderer renderer;
    private CityMap map;
    private money money;
    private HashMap<String, Integer> costs;
    
    public HUD(CityRenderer r, CityMap m, money mm)
    {
        MayflowerImage p = new MayflowerImage("images/HUD.png");
        renderer = r;
        map = m;
        money = mm;
        costs = new HashMap<>();
        costs.put("hospital", 300);
        costs.put("house",    30);
        costs.put("market",   100);
        costs.put("office",   150);
        costs.put("school",   150);
        
        setImage(p);
        
    }

    public void act(){
        int x;
        int y;
        if(Mayflower.mouseClicked(null)){
            MouseInfo m = Mayflower.getMouseInfo();
            x = m.getX();
            y = m.getY();
            
            if(x > 18 && x < 82 && y > 14 && y < 58){
                // select hospital
                selected = "hospital";
            }
            if(x > 18 && x < 82 && y > 79 && y < 134){
                // select house
                selected = "house";
            }
            if(x > 18 && x < 82 && y > 155 && y < 210){
                //select store
                selected = "market";
            }
            if(x > 18 && x < 82 && y > 235 && y < 350){
                //select office
                selected = "office";
            }
            if(x > 18 && x < 82 && y > 370 && y < 426){
                //select school
                selected = "school";
            }
            if(x > 18 && x < 82 && y > 452 && y < 502){
                money.addLoan(100, 10, 15);
            }
            if (selected != null && x > 100) {
                CityCoordinate cityCoordinate = renderer.screenToCity(new ScreenCoordinate(x, y));
                boolean canAfford = false;
                if (costs.containsKey(selected)) {
                    int cost = costs.get(selected);
                    if (money.getMoney() >= cost) {
                        money.subtract(cost);
                        canAfford = true;
                    }
                }
                if (canAfford) {
                    map.placeBuilding(cityCoordinate, selected);
                    //selected = null;
                }
            }
        }
        
        
    }
    
    public String getSelected(){
        return selected;
    }
}
