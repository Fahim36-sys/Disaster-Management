public class Disaster {
    private String disasterID,type,severity;
    private ResponseTeam responseTeam;
    public Disaster(){}
    public Disaster(String disasterID,String type,String severity,ResponseTeam responseTeam){
        this.disasterID=disasterID;
        this.type=type;
        this.severity=severity;
        this.responseTeam=responseTeam;
    }
    public void setDisasterID(String disasterID){this.disasterID=disasterID;}
    public void setType(String type){this.type=type;}
    public void setSeverity(String severity){this.severity=severity;}
    public void setResponseTeam(ResponseTeam responseTeam){this.responseTeam=responseTeam;}
    public String getDisasterID(){return disasterID;}
    public String getType(){return type;}
    public String getSeverity(){return severity;}
    public ResponseTeam getResponseTeam(){return responseTeam;}
    public String getDisplayText(){
        String teamName=responseTeam==null?"Not found":responseTeam.getteamname();
        return "Disaster Information\n"
            + "  Disaster ID: "+disasterID+"\n"
            + "  Type: " +type+"\n"
            + "  Severity: " +severity+"\n"
            + "  Response Team: " +teamName;
    }
    public void showDisasterInfo(){
        System.out.println(getDisplayText());
    }
}
