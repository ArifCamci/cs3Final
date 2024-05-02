
import mayflower.*;
public class MyMayflower extends Mayflower
{
    public MyMayflower(){
        super("screen", 800, 600);
    }
    public void init(){
        Mayflower.setFullScreen(false);
        World w = new MyWorld();
        Mayflower.setWorld(w);
        
    }
    
}
