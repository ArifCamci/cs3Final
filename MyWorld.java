
import mayflower.*;
public class MyWorld extends World
{
    private CityRenderer renderer;

    public MyWorld(){
        setBackground("images/background.png");
        money x = new money(10, 1);
        System.out.println(x.CalcMoney());
    }
    
    public void act(){
        
    }
    
    
}
