public class DamageAssesment{
    public double estimateddamagecost;
    public int affectedpeople;
    public  DamageAssesment(){}
    public DamageAssesment(double estimateddamagecost, int affectedpeople){
        this.estimateddamagecost=estimateddamagecost;
        this.affectedpeople=affectedpeople;
    } 
    public void setestimateddamagecost(double estimateddamagecost){this.estimateddamagecost=estimateddamagecost;}
    public void setaffectedpeople(int affectedpeople){this.affectedpeople=affectedpeople;}
    
    public double estimateddamagecost(){return estimateddamagecost;}
    public int affectedpeople(){return affectedpeople;}

    public void showDmgDetails(){
         System.out.println("EstimatedDamageCost:"+estimateddamagecost);
          System.out.println("AffectedPeople:"+affectedpeople);
    }
}