package csc320.assignment.pkg3;

public class CSC320Assignment3 {
    public static void main(String[] args) {
        //Arrival & Departure times for original set of trains
        int[] arrivals1 = {900, 915, 1030, 1045};
        int[] departures1 = {930, 1300, 1100, 1145};
        
        //Arrival & Departure times for set of trains with additional 4
        int[] arrivals2 = {900, 915, 1030, 1045, 1115, 1200, 1230, 1315};
        int[] departures2 = {930, 1300, 1100, 1145, 1400, 1245, 1330, 1415};
        
        //Methods to determine # of needed platforms
        platforms(arrivals1, departures1);
        platforms(arrivals2, departures2);
    }
    
    public static void platforms(int[] arrivals, int[] departures){
        //Times have to be sorted so we know when trains arrive and depart in order
        arrivals = sort(arrivals); //Sort in ascending order
        departures = sort(departures); //Sort in ascending order
        
        int i = 0, j = 0, platforms = 0, max = 0;
        //Continues until we have no more trains left to arrive since we won't need more platforms after that
        while(i < arrivals.length){
            if(arrivals[i] < departures[j]){ //If the arrival time is before, add a platfomr
                platforms++;
                if(platforms > max) //checks if the needed platforms is more than we previously recorded
                    max = platforms;
                i++; //Move to next arrival time
            }
            else{
                platforms--; //Need one less since a train left, opening a spot
                j++; //move to next departure time
            }
        }
        
        System.out.println("You will need " + max + " platforms to handle these times");
    }
    
    //Basic bubble sorting algorithm
    public static int[] sort(int[] a){
        for(int i = a.length-1; i > 0; i--){
            for(int j = 1; j <= i; j++){
                if(a[j-1] > a[j]){
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }        
        return a;
    }
    
}
