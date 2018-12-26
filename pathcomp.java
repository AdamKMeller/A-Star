/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproj;
import java.util.*;
/**
 *
 * @author Adam_hpx360
 */
public class pathcomp implements Comparator<path> {
    public int compare(path a, path b)
    {
        path alpha =  a;
        path beta =  b;
        if( (alpha.distance()+estimateD(alpha.retCity(),alpha.retD())*.7) >  (beta.distance()+(estimateD(beta.retCity(),beta.retD())*.7))  )
            return -1;
        
        if( (alpha.distance()+estimateD(alpha.retCity(),alpha.retD())*7.) ==  (beta.distance()+(estimateD(beta.retCity(),beta.retD()))*.7) )
            return 0;
        
        else
            return 1;
    }
    
    private double estimateD(city A, city B)
    {
        double lat1= A.latitude();
        double lat2= B.latitude();
        double lon1 = A.longitude();
        double lon2 = B.longitude();
        
        double R = 3959; // In miles
    
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
 
        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }
}
