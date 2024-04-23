// TODO: Replace this with an actual implementation of a CityMap

import mayflower.*;

public class BetaCityMap extends CityMap {
    public CityBlock getBlock(int x, int y) {
        if (x < 0 || x >= 2 || y < 0 || y >= 2) {
            return null;
        }
        return new StaticCityBlock("images/office.png", 0, 120);
    }
    
    
}
