import mayflower.*;
import java.util.*;

/**
 * extends actor, draws a city and calls the city's "Act" class given some width
 * and height
 */
public class CityRenderer
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
    
    /**
     * The width of the buffer on screen
     */
    private int width;
    /**
     * The height of the buffer on screen
     */
    private int height;

    /** The map that gets rendered */
    private CityMap map;
    
    /** The world to render to */
    private World world;
    
    /** The actor stock to draw from */
    private HashMap<MayflowerImage, ActorStock> actors;
    
    private class ActorStock {
        private ArrayList<Actor> stock;
        private int used;
        private MayflowerImage image;
        private World world;
        private int width;
        private int height;
        private class StaticActor extends Actor {
            StaticActor(MayflowerImage img) {
                setImage(img);
            }
            public void act() { }
        }
        ActorStock(World w, MayflowerImage img, int ww, int hh) {
            world = w;
            image = img;
            width = ww;
            height = hh;
            used = 0;
            stock = new ArrayList<>();
        }
        
        void placeActor(int x, int y) {
            if (used < stock.size()) {
                stock.get(used++).setLocation(x, y);
            }
            else {
                Actor newActor = new StaticActor(image);
                world.addObject(newActor, x, y);
                stock.add(newActor);
                ++used;
            }
        }
        
        void finishRender() {
            for (int i = used; i < stock.size(); ++i) {
                stock.get(i).setLocation(width, height);
            }
        }
    }

    /** CityRenderer constructor

      @param map The map to render
      @param width The width of the rendered city
      @param height The height of the rendered city
      @param xPosition The x position on screen of the city
      @param yPosition The y position on screen of the city
     */
    public CityRenderer(World w, CityMap map, int width, int height, int xPosition, int yPosition)
    {
        this.world = w;
        this.map = map;
        this.x = xPosition;
        this.y = yPosition;
        this.width = width;
        this.height = height;
        this.actors = new HashMap<>();
    }

    public void act(){
        HashSet<CityCoordinate> seenBlocks = new HashSet<>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
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
        if (!actors.containsKey(image)) {
            actors.put(image, new ActorStock(world, image, width, height));
        }
        // Location of the top left pixel of the map
        int tly = mapY - iY;
        int tlx = mapX - iX;
        actors.get(image).placeActor(tlx, tly);
    }
}
