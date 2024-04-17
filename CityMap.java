public abstract class CityMap {
    /**
     * Gets the building at some city block
     * @param x The x position of the city block. On the isometric view, bottom
     * left is lower and top right is higher.
     * @param y The y position of the city block. On the isometric view, bottom
     * right is lower and top left is higher.
     * @return The CityBlock at the specified location, or null if this location
     * isn't owned.
     * @see CityBlock
     */
    public abstract CityBlock getBlock(int x, int y);
}
