public abstract class CityMap {
    /**
     * Gets the building at some city block
     * @param coord The coordinate of the city block to fetch
     * @return The CityBlock at the specified location, or null if this location
     * isn't owned.
     * @see CityBlock
     */
    public abstract CityBlock getBlock(CityCoordinate coord);
}
