import mayflower.*;
/**
 * extends actor, when clicked at positions of the icons the icon is selected
 * when clicked on a empty space it calls a function to place the object(not made yet)
 */
public class HUD extends Actor
{
    // instance variables - replace the example below with your own
    private String selected;
    
    
    public HUD()
    {
        MayflowerImage p = new MayflowerImage("HUD.png");
        
        setImage(p);
        
    }

    public void act(){
        int x;
        int y;
        if(Mayflower.mouseClicked(null)){
            MouseInfo m = Mayflower.getMouseInfo();
            x = m.getX();
            y = m.getY();
            
            if(x > 17 && x < 82 && y > 14 && y < 58){
                /**
                 * this should call the function to select hospital
                 */
                selected = "hospital";
                
            }
            if(x > 18 && x < 82 && y > 79 && y < 134){
                // select house
                selected = "house";
                
            }
            if(x > 18 && x < 82 && y > 155 && y < 210){
                selected = "market";
                //select store
            }
            if(x > 18 && x < 82 && y > 235 && y < 350){
                //select office
                selected = "office";
            }
            if(x > 18 && x < 82 && y > 370 && y < 426){
                //select school
                selected = "school";
            }
        }
        
        
    }
    
    public String getSelected(){
        return selected;
    }
}
