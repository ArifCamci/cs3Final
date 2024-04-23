
import mayflower.*;
public class grass extends CityBlock
{
    
    private MayflowerImage p;
    /**
     * Constructor for objects of class grass
     */
    public grass()
    {
        p = new MayflowerImage("grass.png");
        
        //setImage(p);
    }
    public MayflowerImage getImage(){
        return p;
        
    }
    public int getXOffset(){
        //return getX();
        return 0;
    }
    public int getYOffset(){
        //return getY();
        return 0;
    }

    public void act(){
        if(Mayflower.mouseClicked(this)){
            
        }
    }
}
