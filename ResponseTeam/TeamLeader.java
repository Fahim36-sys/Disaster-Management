package ResponseTeam;
public class TeamLeader{
    //team leader has many response team
    private String teamLeaderID;
    private Person person;
    public TeamLeader(){}
    public TeamLeader(String teamLeaderID){
        this.teamLeaderID=teamLeaderID;
    }
    public void setLeaderID(String teamLeaderID){
        this.teamLeaderID=teamLeaderID;
    }
    public void setPerson(Person person){
        this.person=person;
    }
    public String getLeaderID(){return teamLeaderID;}
    public Person getPerson(){return person;}
    public void showLeaderID(){
        System.out.println("Team ID: "+teamLeaderID);
        person.showPersonDetails();
    }
}
