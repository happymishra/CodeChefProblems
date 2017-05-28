/* 
You are given n activities with their start and finish times. Select 
the maximum number of activities that can be performed by a single person, 
assuming that a person can only work on a single activity at a time.

 Example:
 Consider the following 6 activities. 
      start[]  =  {1, 3, 0, 5, 8, 5};
      finish[] =  {2, 4, 6, 7, 9, 9};
 The maximum set of activities that can be executed 
 by a single person is {0, 1, 3, 4}
*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ActivitySelectionProblem {

    public static void main(String[] args) {
        
        int activitiyStartTime[] = {3, 0, 5, 1, 5, 8},
             activityFinishTime[] = {4, 6, 9, 2, 7, 9};
       
        Activity activities[] = new Activity[activityFinishTime.length];
        
        activities = createActivitiesArray(activitiyStartTime, activityFinishTime);
        Arrays.sort(activities);
        
        getSelectedActivities(activities);
        
        
    }
    
    private static Activity[] createActivitiesArray(int[] startTime, int[] finishTIme){
        int numberOfActivities = startTime.length;
           Activity activites[] = new Activity[numberOfActivities];
        
        for(int i = 0; i < numberOfActivities; i++){
            Activity activity = new Activity(startTime[i], finishTIme[i]);
            activites[i] = activity;
        }
        
        return activites;
    }
    
   private static void getSelectedActivities(Activity[] activities){
       int i = 0;
       System.out.println("Selected Activities");
       System.out.println("Job with start time " + activities[i].startTime + 
               " and finish time " + activities[i].finishTime);
       
       for (int j = 1; j < activities.length; j++){
           if(activities[j].startTime >= activities[i].finishTime){
               System.out.println("Job with start time " + activities[j].startTime + 
               " and finish time " + activities[j].finishTime);
               i = j;
           }
       }
   }
}
