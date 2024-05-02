// TODO: Replace this with an actual implementation of a CityMap

import mayflower.*;
import java.util.HashMap;
import java.util.Set;

public class BetaCityMap extends CityMap {
    private static HashMap<CityCoordinate, CityBlock> map;
    private static HashMap<String, CityBlock> cache;
    
    public BetaCityMap(){
        map = new HashMap<>();
        cache = new HashMap<>();
        cache.put("hospital", new StaticCityBlock("images/hospital.png", 169, 65));
        cache.put("house",    new StaticCityBlock("images/house.png",    169, 65));
        cache.put("market",   new StaticCityBlock("images/market.png",   169, 65));
        cache.put("office",   new StaticCityBlock("images/office.png",   169, 65));
        cache.put("school",   new StaticCityBlock("images/school.png",   169, 65));
        cache.put("grass",    new StaticCityBlock("images/grass.png",    169, 65));
    }
    
    public CityBlock getBlock(CityCoordinate c) {
        if (map.containsKey(c)) {
            return map.get(c);
        }
        return cache.get("grass");
    }
    
    public void addBlock(CityCoordinate c, CityBlock b){
        map.put(c, b);
    }
    
    public void placeBuilding(CityCoordinate c, String b) {
        if (!cache.containsKey(b)) {
            return;
        }
        addBlock(c, cache.get(b));
    }
    
    public int size(){
        return map.size();
    }
    
    public Set getCoordinates(){
        return map.keySet();
    }
    
}
