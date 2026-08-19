public class ResponseTeam{
    private String teamid;
    private String teamname;
    private String numberOfteammembers;
    private Responder[] responders;
    public ResponseTeam(){}
    public ResponseTeam(String teamid, String teamname, String numberOfteammembers, Responder[] responders){
        this.teamid=teamid;
        this.teamname=teamname;
        this.numberOfteammembers=numberOfteammembers;
        this.responders=responders;
    }
    public void setteamid(String teamid){this.teamid=teamid;}
    public void setteamname(String teamname){this.teamname=teamname;}
    public void setnumberOfTeammembers(String numberOfteammembers){this.numberOfteammembers=numberOfteammembers;}
    public void setResponders(Responder[] responders){this.responders=responders;}

    public String getteamid(){return teamid;}
    public String getteamname(){return teamname;}
    public String getnumberOfTeamMembers(){return numberOfteammembers;}
    public Responder[] getResponders(){return responders;}

    public void showDetails(){
        System.out.println("Team ID:" +teamid);
        System.out.println("Team Name:" +teamname);
        System.out.println("Number Of Team Members:" +numberOfteammembers);
    }
}