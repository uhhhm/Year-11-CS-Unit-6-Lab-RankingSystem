public class User{
    private int rank = -8;
    private int progress = 0;
    public int getRank(){
        return rank;
    }
    public int getProgress(){
        return progress;
    }
    public String toString(){
        return "User{rank=" + rank + ", progress=" + progress + '}';
    }
    public void incProgress(int n){
        if(n < -8 || n == 0 || n > 8){
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }
        if(rank == 8){
            return;
        }
        int d;
        if(n > 0 && rank < 0){
            d = n-rank-1;
        }
        else if(n < 0 && rank > 0){
            d = n-rank+1;
        }
        else{
            d = n-rank;
        }
        if(d == 0){
            progress += 3;
        }
        else if(d == -1){
            progress += 1;
        }
        else if(d > 0){
            progress += d*d*10;
        }
        while(progress >= 100){
            if(rank != -1){
                rank++;
                progress -= 100;
            }
            else{
                rank+=2;
                progress -= 100;
            }
            if(rank == 8){
                progress = 0;
                return;
            }
        }

    }
}