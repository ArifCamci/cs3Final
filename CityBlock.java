import mayflower.*;

public abstract class CityBlock {
    /**
     * Gets the MayflowerImage of this block
     * @return An isometric view of this building
     */
    public abstract MayflowerImage getImage();

    /**
     * Gets the x offset of the image associated with this block
     * @return The x position of the bottom left pixel of this building
     */
    public abstract int getXOffset();

    /**
     * Gets the y offset of the image associated with this block
     * @return The y position of the bottom left pixel of this building
     */
    public abstract int getYOffset();

    /**
     * Handles various building things, this function should be called every
     * frame. Examples of things that the act function might do include:
     *
     * <ul>
     *   <li>Stepping an animation</li>
     *   <li>Giving money to the player</li>
     *   <li>Charging maintenance fees</li>
     * </ul>
     * k
     */
    public abstract void act();
    
    public abstract String getImg();
}
