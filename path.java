/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproj;

import java.util.Comparator;

/**
 *
 * @author Adam_hpx360
 */
public class path {
private connection[] connects;
private city current;
private city from;
private city finalD;
private double traveled;
private int connects_length;
//private graph gre;
private city[] pCities;
private connection[] pConn;

public path(city arrive, connection via, double d, city destination, city[] tempC, connection[] tempConn)
{
    connects = arrive.getC();
    current = arrive;
    traveled = d;
    connects_length=arrive.getCount();
    finalD=destination;
    pCities = new city[tempC.length+1];
    pConn = new connection[tempConn.length+1];
    for(int i=0;i<tempC.length;i++)
    {
        pCities[i]=tempC[i];
    }
    pCities[tempC.length]=arrive;
    
    for(int i=0;i<tempConn.length;i++)
    {
        pConn[i]=tempConn[i];
    }
    pConn[tempConn.length]=via;
}
 
public connection[] getC()
{
    return connects;
}

public int len()
{
    return connects_length;
}
 
public city retCity()
{
    return current;
}

public city retD()
{
    return finalD;
}

public double distance()
{
    return traveled;
}

public city[] getArrCity()
{
    return pCities;
}

public connection[] getArrConn()
{
    return pConn;
}

}
