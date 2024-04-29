import mayflower.*;

/**
 * Static city blocks are city blocks that don't actually do anything other than
 * look pretty.
 */
public class StaticCityBlock extends CityBlock {
    private MayflowerImage[] images;
    private int frameNumber;
    private int xOffset, yOffset;
    private String img;
    private HUD hud = new HUD();
    public MayflowerImage getImage() {
        return images[frameNumber];
    }

    public int getXOffset() {
        return xOffset;
    }

    public int getYOffset() {
        return yOffset;
    }
    
    

    /** Creates a new static StaticCityBlock.
     *
     * @param imagePath The image file to use for this block
     * @param x The x value of the bottom left pixel of this building
     * @param y The y value of the bottom left pixel of this building
     */
    public StaticCityBlock(String imagePath, int x, int y) {
        images = new MayflowerImage[1];
        images[0] = new MayflowerImage(imagePath);
        frameNumber = 0;
        img = imagePath;
    }

    /** Creates a new animated StaticCityBlock.
     *
     * @param imagePath The image file to use for this block. This parameter is
     * passed through String.format() with a single integer argument that goes
     * from 0 to frameCount-1, inclusive. This may look like
     * "images/office%d.png"
     * @param frameCount The number of frames in this animation
     * @param x The x value of the bottom left pixel of this building
     * @param y The y value of the bottom left pixel of this building
     */
    public StaticCityBlock(String imagePath, int frameCount, int x, int y) {
        images = new MayflowerImage[frameCount];
        for (int i = 0; i < frameCount; i++) {
            images[i] = new MayflowerImage(String.format(imagePath, frameCount));
        }
        frameNumber = 0;
    }
    

    public void act() {
        frameNumber = (frameNumber+1) % images.length;
        if(Mayflower.mouseClicked(this)){
            this.setImage(hud.getSelected());
        }
        
        
    }
    
    public void setImage(String im){
        images[0] = new MayflowerImage(im);
    }
    
    public String getImg(){
        return img;
    }
}
