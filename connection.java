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
public class connection {
    private double length;
    private String name;
    private String desName;
    public final int refrence;
    
    
    public connection(String s, double l, int r)
    {
        name = s;
        length= l;
        refrence = r;
    }
    
    public double length()
    {
        return length;
    }
    
    public int ref()
    {
        return refrence; 
    }
    
    public String Name()
    {
        return name;
    }
}
