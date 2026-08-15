public class TeamLeader extends Person{
    private String teamLeaderID;
    public TeamLeader(){}
    public TeamLeader(String name,String phone,String teamLeaderID){
        super(name,phone); // Call the constructor of the abstract class Person
        this.teamLeaderID=teamLeaderID;
    }
    public void setLeaderID(String teamLeaderID){
        this.teamLeaderID=teamLeaderID;
    }
    public String getLeaderID(){return teamLeaderID;}
    public void showLeaderID(){
        System.out.println("Team Leader ID: "+teamLeaderID);
        super.showPersonDetails();
    }
    @Override
    public void displayDetails(){
        showLeaderID();
    }
}
