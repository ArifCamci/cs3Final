import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import mayflower.*;

public class money
{
    //current money
    private int currentMoney;
    //money that is going to be gained every game day
    private int moneyGained;
    public static String disclamer = "";
    private int lastMoney;
    private CityMap map;
    /**
     * Constructor for objects of class money
     */
    public money(int m, int g, CityMap mm)
    {
        currentMoney = m;
        moneyGained = g;
        map = mm;
        lastMoney = g;
    }
    
    public int CalcMoney(){
        Set<CityCoordinate> keys = map.getCoordinates();
        ArrayList<String> image = new ArrayList<String>();
        ArrayList<String> images = new ArrayList<String>();
        int[] things = new int[5];
        images.add("images/grass.png");
        images.add("images/house.png");
        images.add("images/office.png");
        images.add("images/school.png");
        images.add("images/hospital.png");
        images.add("images/market.png");
        disclamer = "";
        int place;
        int add = 0;
        for(CityCoordinate key : keys){
            image.add(map.getBlock(key).getImg());
        }
        
        for(String x : image){
             place = images.indexOf(x);
             if(place == 1){ 
                 add += 10;
                 things[0]++;
                }
             if(place == 2){
                 add += 30;
                 things[1]++;
                }
             if(place == 3){ 
                 add += 20;
                 things[2]++;
                }
             if(place == 4){ 
                 add += 15;
                 things[3]++;
                }
             if(place == 5){ 
                 add += 25;
                 things[4]++;
                }
        }
        
        while(things[0] >= 5){
            if(things[1] < 1){
                add -= 10;
                disclamer += "not enough offices!";
                things[1]--;
            }
            if(things[2] < 1){
                add -= 10;
                disclamer += " not enough schools!";
                things[2]--;
            }
            if(things[3] < 1){
                add -= 10;
                disclamer += " not enough hospitals!";
                things[3]--;
            }
            if(things[4] < 1){
                add -= 10;
                disclamer += " not enough markets!";
                things[4]--;
            }
            things[0] -= 5;
        }
        
        if(add > 0)
        moneyGained += add;
        int diff = moneyGained - lastMoney;
        lastMoney = moneyGained;
        return diff;
        
        
    }
    
    public int getMoneyGained(){return moneyGained;}
    public int getMoney(){return currentMoney;}
    
    public void subtract(int x){
        currentMoney -= x;
    }
    public void add(int x){
        currentMoney += x;
    }
    public String getDisclamer(){return disclamer;}
    
    
}
