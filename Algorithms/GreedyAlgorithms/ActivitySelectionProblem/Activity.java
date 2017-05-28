class Activity implements Comparable<Activity>{
    int startTime,
        finishTime;    
    Activity(int startTime, int finishTime){
        this.startTime = startTime;
        this.finishTime = finishTime;
    }  

    @Override
    public int compareTo(Activity activityObj){
        return this.finishTime - (activityObj.finishTime);
    }
}
