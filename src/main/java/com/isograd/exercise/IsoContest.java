/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise;
import java.util.*;

public class IsoContest {
public static void main( String[] argv ) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        String[] limits = sc.nextLine().split(" ");
        float fromLat = Float.parseFloat(limits[0]);
        float fromLng = Float.parseFloat(limits[1]);
        float toLat = Float.parseFloat(limits[2]);
        float toLng = Float.parseFloat(limits[3]);
        IsoContestBase.localEcho("Read rectangle: " + fromLat + " " + fromLng + " " + toLat + " " + toLng );
        
        int nbPersonTotal = Integer.parseInt(sc.nextLine());
        IsoContestBase.localEcho("Nb person to test :" + nbPersonTotal);
        int nbPerson = 0;
        int i=0;
        while(sc.hasNextLine()) {  
        	String[] pos = sc.nextLine().split(" ");
			float lat =Float.parseFloat(pos[0]);
			float lng = Float.parseFloat(pos[1]);
			IsoContestBase.localEcho("Person to test" + i++ + " position :" + lat + " " + lng);
			if (lat >= fromLat && lat <= toLat && lng >= fromLng && lng <= toLng) nbPerson++;
        }
        System.out.println(nbPerson);

    }
}