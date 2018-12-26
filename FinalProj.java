/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproj;

import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Adam_hpx360
 */
public class FinalProj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //Read part
         int numCities = StdIn.readInt();

	city[] cities = new city[numCities];

	for (int i = 0; i < numCities; i++) {
            String citytemp;
            double longitude;
            double latitude;
            citytemp = StdIn.readString();
            longitude = StdIn.readDouble();
            latitude = StdIn.readDouble();
            //System.out.println(citytemp + ":" + longitude + "," + latitude);
            cities[i] = new city(citytemp,longitude,latitude);
        }
        
        String[] names = new String[numCities];
        for(int i = 0; i < numCities; i++)
        {
            names[i]=cities[i].name();
        }
        
        
        
        String tempName;
        Double tempLen;
        int tempRef;
        String tempDes;
        for(int i = 0; i < numCities; i++)
        {
            String tempS = StdIn.readString();
            int j = StdIn.readInt();
            for(int k = 0; k < j; k++)
            {
                tempDes = StdIn.readString();
                tempRef = binarySearch(names,tempDes);
                tempLen = StdIn.readDouble();
                tempName = StdIn.readString();
                //System.out.println(tempName+" Len:"+tempLen+" Ref:"+tempRef);
                connection c = new connection(tempName,tempLen,tempRef);
                cities[i].addC(c);
            }
            
        }
        
        Scanner sc = new Scanner(System.in); 
        
        
        //A* 
        
        System.out.print("Enter origin and destination: ");
        String origin;
        String destination;
        origin = sc.next();
        destination = sc.next();
        city orig = cities[binarySearch(names,origin)];
        city dest = cities[binarySearch(names,destination)];
        
        Comparator<path> comp = new pathcomp();
        graph grap = new graph(orig);
        path[] searched = new path[1000];
        connection temp = new connection("to be deleted",0,0);
        
        connection[] tco = new connection[1];
        city[] tc = {orig};        
        int serC = 0;
        MaxPQ mpq = new MaxPQ(100,comp);
        path nxtp = new path(orig,temp,0,dest,tc,tco);
        path lstp = null;
        mpq.insert(nxtp);
        //searched[serC] = nxtp;
        //serC++;
        boolean escape=false;
        int firsttime = -1;
        boolean Csearched;
        boolean Psearched;
        while(!mpq.isEmpty()&&escape==false)
        {
            nxtp = (path) mpq.delMax();
            //System.out.println(nxtp.retCity().name());
            //check if on dest
            if(nxtp.retCity().equals(dest))
                {
                //System.out.println(dest.name());
                lstp=nxtp;
                escape=true;
                break;
                }
            
            //add path to serached
            searched[serC]=nxtp;
            serC++;
            
            
            //printing
            //System.out.println(nxtp.retCity().name());
            
            
            connection[] tmpconn = nxtp.getC();
            for(int i=0;i<nxtp.len();i++)
            {
                Csearched = false;
                for(int j=0;j<serC;j++)
                {
                    if(cities[tmpconn[i].ref()].equals(searched[j].retCity()))
                    {
                        //System.out.println("entered");
                    Csearched = true;
                    }
                }
                if(Csearched==false)
                {
                    //grap=nxtp.getG();
                    mpq.insert(new path(cities[tmpconn[i].ref()],tmpconn[i],tmpconn[i].length()+nxtp.distance(),dest,nxtp.getArrCity(),nxtp.getArrConn()));
                    
                }
                    
            }
        }
        
        //System.out.println("Solution: ");
      
        System.out.println("Route: " + (int) nxtp.distance());
        city[] citiesTrav = nxtp.getArrCity();
        connection[] connTrav = nxtp.getArrConn();
        for(int i=1;i<nxtp.getArrCity().length-1;i++)
            System.out.println(citiesTrav[i].name() + " " + citiesTrav[i+1].name() + " " + connTrav[i+1].Name());
    }
    
    public static double estimateD(city A, city B)
    {
        double lat1= A.latitude();
        double lat2= B.latitude();
        double lon1 = A.longitude();
        double lon2 = B.longitude();
        
        double R = 3959; // In kilometers
    
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
 
        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }
    
    
    
    public static int binarySearch(String[] a, String x) {
    int low = 0;
    int high = a.length - 1;
    int mid;

    while (low <= high) {
        mid = (low + high) / 2;

        if (a[mid].compareTo(x) < 0) {
            low = mid + 1;
        } else if (a[mid].compareTo(x) > 0) {
            high = mid - 1;
        } else {
            return mid;
        }
    }

    return -1;
}
}


//        
//        System.out.println("");
//        queP=nxtp.getQ();
//        path tempCfP;
//        while(!queP.isEmpty())
//        {
//            System.out.println("In loop");
//            tempCfP=(path)queP.dequeue();
//            System.out.println(tempCfP.retCity().name());
//        }
//  

//            if(nxtp.retCity().equals(orig))
//                System.out.println(nxtp.retCity().name());
//            else if(nxtp.retCity().equals(lstp.retCity()))
//                System.out.print("");
//            else
//                System.out.println(lstp.retCity().name() + " " + nxtp.retCity().name());