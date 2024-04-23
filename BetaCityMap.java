// TODO: Replace this with an actual implementation of a CityMap

import mayflower.*;

public class BetaCityMap extends CityMap {
    public CityBlock getBlock(CityCoordinate c) {
        if (c.x < 0 || c.x >= 2 || c.y < 0 || c.y >= 2) {
            return null;
        }
        return new StaticCityBlock("images/office.png", 0, 120);
    }
    
    
}
