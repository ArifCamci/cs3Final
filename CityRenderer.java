import mayflower.*;
import java.util.*;

/**
 * extends actor, draws a city and calls the city's "Act" class given some width
 * and height
 */
public class CityRenderer extends Actor
{
    /**
     * The x coordinate in pixels of the top left of the screen, (0, 0) is the
     * center of the building at (0, 0)
     */
    private int x;

    /**
     * The y coordinate in pixels of the top left of the screen, (0, 0) is the
     * center of the building at (0, 0)
     */
    private int y;

    /** A private buffer for drawing buildings */
    private MayflowerImage buffer;

    /** The map that gets rendered */
    private CityMap map;

    /** CityRenderer constructor

      @param map The map to render
      @param width The width of the rendered city
      @param height The height of the rendered city
      @param xPosition The x position on screen of the city
      @param yPosition The y position on screen of the city
     */
    public CityRenderer(CityMap map, int width, int height, int xPosition, int yPosition)
    {
        buffer = new MayflowerImage(width, height);
        this.setImage(buffer);
        this.setLocation(xPosition, yPosition);
        this.map = map;
    }

    public void act(){
        HashSet<CityCoordinate> seenBlocks = new HashSet<>();
        for (int y = 0; y < buffer.getHeight(); y++) {
            for (int x = 0; x < buffer.getWidth(); x++) {
                CityCoordinate coord = screenToCity(new ScreenCoordinate(x, y));
                if (seenBlocks.contains(coord)) {
                    continue;
                }
                seenBlocks.add(coord);

                ScreenCoordinate realScreenPos = cityToScreen(coord);
                CityBlock block = map.getBlock(coord);
                if (block == null) {
                    continue;
                }
                MayflowerImage image = block.getImage();
                copyImage(image, coord.x, coord.y, x, y);
            }
        }
        this.setImage(buffer);
    }

    public CityCoordinate screenToCity(ScreenCoordinate coord) {
        int rx, ry;
        rx = ry = 0;
        rx += coord.x;
        ry -= coord.x;
        rx += coord.y;
        ry += coord.y;
        return new CityCoordinate(rx / 100, ry / 100);
    }

    public ScreenCoordinate cityToScreen(CityCoordinate coord) {
        int rx, ry;
        rx = ry = 0;
        rx += coord.x;
        ry += coord.x;
        rx -= coord.y;
        ry += coord.y;
        return new ScreenCoordinate(rx * 100, ry * 100);
    }

    /** Copies an image to the buffer
      *
      * @param image the image to copy
      * @param mapX The x value of bottom left pixel on the map to place the image on
      * @param mapY The y value of bottom left pixel on the map to place the image on
      * @param iX The bottom left pixel on the image to place the image on
      * @param iY The bottom left pixel on the image to place the image on
     */
    void copyImage(MayflowerImage image, int mapX, int mapY, int iX, int iY) {
        // Location of the top left pixel of the map
        int tly = mapY - iY;
        int tlx = mapX - iX;
        for (int i = Math.max(0, -tly); i < Math.min(image.getHeight(), buffer.getHeight()); i++) {
            for (int j = Math.max(0, -tlx); j < Math.min(image.getWidth(), buffer.getWidth()); j++) {
                int iy = tly + i;
                int ix = tlx + j;
                buffer.setColorAt(ix, iy, image.getColorAt(j, i));
            }
        }
    }
}
