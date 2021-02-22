

import java.util.Scanner;

public class sch { // main class
    
    public static void main(String args[]) { // main method
        
        Scanner in = new Scanner(System.in);
        
        int arr[]=new int[50]; // new array with 50 spots
        
        int count;
        
        count = in.nextInt();
        
        for(int i = 0; i < count; i++)arr[i] = in.nextInt();
        
        int FCFS[] = new int[count]; // starting count for FCFS
        
        int SJF[] = new int[count]; // starting count for SJF
        
        int time = 0; // starting time of 0
        
        float total = 0; // starting float total of 0
        
        System.out.println("using FCFS");
        
        for(int i = 0; i < count; i++) {
            
            time+=arr[i];
            
            FCFS[i] = time;
            
            total+=FCFS[i]; // total time for FCFS
        
        }
        
        System.out.println("using FCFS average time: " +total/count); // average time for FCFS
        
        for(int i = 0; i < count; i++) {
            
            System.out.println("job " +(i+1)+ ":" +FCFS[i]);
        }
        
        RoundRobin(arr,count,20); 
        
        RoundRobin(arr,count,50);
        
        int temp;
        
        int indicator = 0;
        
        for(int i = count-1; i >= 0; i--) {
            
            for (int j = 0; j < i; j++) {
                
                if(arr[j]>arr[j+1]) {
                    
                    indicator = 1;
                    
                    temp = arr[j];
                    
                    arr[j] = arr[j+1];
                    
                    arr[j+1] = temp;
                }
            }
            
            if(indicator==0) 
                break;
        }
        
        time = 0; 
        
        total = 0;
        
        System.out.println("using SJF "); 
        
        for(int i = 0; i < count; i++) {
            
            time+= arr[i];
            
            SJF[i] = time;
            
            total+= SJF[i];
            
        }
        
        System.out.println("using SJF average time: " +total/count);
        
    }
    
    static void RoundRobin(int arr[], int n, int quantum) {
        
        int RR[] = new int[n];
        
        int rem_bt[] = new int[n];
        
        float total = 0;
        
        for(int i = 0; i < n; i++)
            
            rem_bt[i] = arr[i];
        
        int t = 0;
        
        while(true) {
            
            boolean done = true;
            
            for(int i = 0; i < n; i++) {
                
                if(rem_bt[i] > 0) {
                    
                    done = false;
                    
                    if(rem_bt[i] > quantum) {
                        
                        t+=quantum;
                        
                        rem_bt[i] -= quantum;
                    }
                    
                    else {
                        
                        t = t + rem_bt[i];
                        
                        RR[i] = t;
                        
                        rem_bt[i] = 0;
                    }
                }
            }
            
            if(done==true)
                
                break;
        }
        
        System.out.println("using RoundRobin with quantum" + quantum);
        
        for(int i = 0; i < n; i++) {
            
            System.out.println("job " +(i+1)+ ":" + RR[i]);
            
            total+=RR[i];
            
            System.out.println("usingRoundRobin average time: " +total/n);
        }
    }
    
}
