import java.util.Set;

public abstract class CityMap {
    /**
     * Gets the building at some city block
     * @param coord The coordinate of the city block to fetch
     * @return The CityBlock at the specified location, or null if this location
     * isn't owned.
     * @see CityBlock
     */
    public abstract CityBlock getBlock(CityCoordinate coord);
    
    /**
     * Places a building down by block
     * @param c The coordinate to place the building at
     * @param b The block to place
     */
    public abstract void addBlock(CityCoordinate c, CityBlock b);
    
    /**
     * Places a building down by name
     * @param c The coordinate to place the building at
     * @param b The name of the building to place
     */
    public abstract void placeBuilding(CityCoordinate c, String b);
    
    public abstract Set<CityCoordinate> getCoordinates();
}
