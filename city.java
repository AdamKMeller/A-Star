/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproj;

/**
 *
 * @author Adam_hpx360
 */
public class city {
    private double longitude;
    private double latitude;
    private String name;
    
    //for the connections
    private int counter;
    private connection[] cArr;
    
    public city(String s, double l1, double l2)
    {
        name = s;
        longitude= l1;
        latitude = l2;
        counter=0;
        cArr = new connection[10];
    }
    
    public double longitude()
    {
        return longitude;
    }
    
    public double latitude()
    {
        return latitude;
    }
    
    public String name()
    {
        return name;
    }
            
      
    
    //connections
    public void addC(connection c)
    {
        cArr[counter]=c;
        counter++;
    }
    
    public connection[] getC()
    {
        return cArr;
    }
    
    public int getCount()
    {
        return counter;
    }
    
    public boolean equals(city a)
    {
        if(a.name().equals(this.name))
            return true;
        else 
            return false;
    }
}
