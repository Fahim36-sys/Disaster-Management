public class ResponseTeam implements IResponseTeam{
    private String teamid;
    private String teamname;
    private String numberOfteammembers;
    private Responder[] responders;
    private TeamLeader leader;
    public ResponseTeam(){}
    public ResponseTeam(String teamid, String teamname, String numberOfteammembers, Responder[] responders, TeamLeader leader){
        this.teamid=teamid;
        this.teamname=teamname;
        this.numberOfteammembers=numberOfteammembers;
        this.responders=responders;
        this.leader=leader;
    }
    public void setteamid(String teamid){this.teamid=teamid;}
    public void setteamname(String teamname){this.teamname=teamname;}
    public void setnumberOfTeammembers(String numberOfteammembers){this.numberOfteammembers=numberOfteammembers;}
    public void setResponders(Responder[] responders){this.responders=responders;}
    public void setLeader(TeamLeader leader){this.leader=leader;}

    public String getteamid(){return teamid;}
    public String getteamname(){return teamname;}
    public String getnumberOfTeamMembers(){return numberOfteammembers;}
    public Responder[] getResponders(){return responders;}
    public TeamLeader getLeader(){return leader;}
    public void assignResponder(Responder responder){
        for(int i=0;i<responders.length;i++){
            if(responders[i]==null){
                responders[i]=responder;
                break;
            }
        }
    }
    public void removeResponder(String responderid){
        for(int i=0;i<responders.length;i++){
            if(responders[i]!=null&&responders[i].getresponderid().equals(responderid)){
                responders[i]=null;
                break;
            }
        }
    }
    public void searchResponders(){
        for(int i=0;i<responders.length;i++){
            if(responders[i]!=null){
                responders[i].showResponderDetails();
            }
        }
    }
    public void showDetails(){
        System.out.println("Team Leader Details:");
        leader.showLeaderID();
        System.out.println("Team ID:" +teamid);
        System.out.println("Team Name:" +teamname);
        System.out.println("Number Of Team Members:" +numberOfteammembers);
    }
}