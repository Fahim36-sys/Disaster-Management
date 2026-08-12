public class TeamLeader{
    //team leader has many response team
    private String teamLeaderID;
    private Person person;
    private ResponseTeam responseTeam;
    public TeamLeader(){}
    public TeamLeader(String teamLeaderID, Person person, ResponseTeam responseTeam){
        this.teamLeaderID=teamLeaderID;
        this.person=person;
        this.responseTeam=responseTeam;
    }
    public void setLeaderID(String teamLeaderID){
        this.teamLeaderID=teamLeaderID;
    }
    public void setPerson(Person person){
        this.person=person;
    }
    public void setResponseTeam(ResponseTeam responseTeam){
        this.responseTeam=responseTeam;
    }
    public String getLeaderID(){return teamLeaderID;}
    public Person getPerson(){return person;}
    public ResponseTeam getResponseTeam(){return responseTeam;}
    public void showLeaderID(){
        System.out.println("Team Leader ID: "+teamLeaderID);
        person.showPersonDetails();
        responseTeam.showDetails();
    }
}
