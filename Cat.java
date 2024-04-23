import mayflower.*;

public class Cat extends Actor
{
    
    public Cat()
    {
        setImage("images/grass.png");
    }
    public void act(){
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        if(Mayflower.isKeyDown (Keyboard.KEY_RIGHT) && x < 700){
            setLocation(x + 1, y);
        }
        if(Mayflower.isKeyDown (Keyboard.KEY_LEFT )&& x > 0){
            setLocation(x - 1, y);
        }
        if(Mayflower.isKeyDown (Keyboard.KEY_UP) && y > 0 ){
            setLocation(x, y - 1);
        }
        if(Mayflower.isKeyDown (Keyboard.KEY_DOWN)&& y < 500){
            setLocation(x, y + 1);
        }
    }
    
}
