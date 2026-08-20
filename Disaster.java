public class Disaster {
    private String disasterID,type,severity;
    public Disaster(){}
    public Disaster(String disasterID,String type,String severity){
        this.disasterID=disasterID;
        this.type=type;
        this.severity=severity;
    }
    public void setDisasterID(String disasterID){this.disasterID=disasterID;}
    public void setType(String type){this.type=type;}
    public void setSeverity(String severity){this.severity=severity;}
    public String getDisasterID(){return disasterID;}
    public String getType(){return type;}
    public String getSeverity(){return severity;}
    public void showDisasterInfo(){
        System.out.println("Disaster ID: "+disasterID);
        System.out.println("Disaster Type: "+type);
        System.out.println("Disaster Severity: "+severity);
    }
}
