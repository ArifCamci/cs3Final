// TODO: Replace this with an actual implementation of a CityMap

import mayflower.*;
import java.util.HashMap;
import java.util.Set;

public class BetaCityMap extends CityMap {
    private static HashMap<CityCoordinate, CityBlock> map = new HashMap<CityCoordinate, CityBlock>();
    
    
    
    public BetaCityMap(){
        map.put(new CityCoordinate(1, 1), new StaticCityBlock("images/market.png", 0, 120));
    }
    
    public CityBlock getBlock(CityCoordinate c) {
        if (c.x < 0 || c.x >= 2 || c.y < 0 || c.y >= 2) {
            return null;
        }
        return new StaticCityBlock("images/grass.png", 0, 120);
    }
    
    public void addBlock(CityCoordinate c, CityBlock b){
        map.put(c, b);
    }
    
    public int size(){
        return map.size();
    }
    
    public CityBlock get(CityCoordinate c){
        return map.get(c);
    }
    
    public Set getCoordinates(){
        return map.keySet();
    }
    
    
}
