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
public class graph {
    private city[] cities;
    private connection[] connections;
    int i;
    public graph(city origin)
    {
    cities = new city[100];
    //cities[0]=origin;
    connections = new connection[100];
    i=0;
    }
    
    public void add(city c,connection conn)
    {
    cities[i]=c;
    connections[i]=conn;
    i++;
    }
    
    public city[] getcityArr()
    {
    return cities;
    }
    
    public int getlen()
    {
        return i;
    }
}
