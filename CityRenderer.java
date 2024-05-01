import mayflower.*;
import java.util.*;

/**
 * extends actor, draws a city and calls the city's "Act" class given some width
 * and height
 */
public class CityRenderer
{
    /**
     * The x coordinate in pixels of our view
     */
    private int x;

    /**
     * The y coordinate in pixels of our view
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
    private HashMap<String, ActorStock> actors;
    
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
            System.out.println(stock.size());
            if (used >= stock.size()) {
                Actor newActor = new StaticActor(image);
                world.addObject(newActor, x, y);
                stock.add(newActor);
            }
            stock.get(used++).setLocation(x, y);
            //stock.get(used++).setLocation(0, 0);
        }
        
        void finishRender() {
            for (int i = used; i < stock.size(); ++i) {
                stock.get(i).setLocation(width, height);
            }
            used = 0;
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
        //MouseInfo info = Mayflower.getMouseInfo();
        //CityCoordinate newCoord = screenToCity(new ScreenCoordinate(info.getX(), info.getY()));
        //ScreenCoordinate origCoord = cityToScreen(newCoord);
        //System.out.printf("(%d %d) => (%d %d) => (%d %d)\n", info.getX(), info.getY(), newCoord.x, newCoord.y, origCoord.x, origCoord.y);
        //this.x = info.getX();
        //this.y = info.getY();
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                CityCoordinate coord = screenToCity(new ScreenCoordinate(x, y));
                if (seenBlocks.contains(coord)) {
                    continue;
                }
                seenBlocks.add(coord);
                //System.out.printf("Rendering city block at (%d %d)\n", coord.x, coord.y);
                ScreenCoordinate realScreenPos = cityToScreen(coord);
                CityBlock block = map.getBlock(coord);
                
                if (block == null) {
                    continue;
                }
                copyImage(block, realScreenPos.x - block.getXOffset(), realScreenPos.y - block.getYOffset());
            }
        }
        for (ActorStock i: actors.values()) {
            i.finishRender();
        }
    }

    public CityCoordinate screenToCity(ScreenCoordinate coord) {
        double rx, ry;
        int lx, ly;
        rx = ry = 0;
        lx = coord.x - width/2 + this.x;
        ly = coord.y - height/2 + this.y;
        rx += lx / 522.0;
        ry -= lx / 522.0;
        rx -= ly / 278.0;
        ry -= ly / 278.0;
        return new CityCoordinate((int) Math.floor(rx), (int) Math.floor(ry));
    }

    public ScreenCoordinate cityToScreen(CityCoordinate coord) {
        int rx, ry;
        rx = width/2;
        ry = height/2;
        rx += coord.x * 261;
        ry -= coord.x * 139;
        rx -= coord.y * 261;
        ry -= coord.y * 139;
        return new ScreenCoordinate(rx - this.x, ry - 139 - this.y);
    }

    /** Copies an image to the buffer
      *
      * @param image the image to copy
      * @param mapX The x value of bottom left pixel on the map to place the image on
      * @param mapY The y value of bottom left pixel on the map to place the image on
      * @param iX The bottom left pixel on the image to place the image on
      * @param iY The bottom left pixel on the image to place the image on
     */
    void copyImage(CityBlock block, int x, int y) {
        MayflowerImage image = block.getImage();
        String path = block.getImg();
        if (path == null) {
            return;
        }
        if (!actors.containsKey(path)) {
            actors.put(path, new ActorStock(world, image, width, height));
        }
        actors.get(path).placeActor(x, y);
    }
}
