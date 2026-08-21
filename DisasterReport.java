public class DisasterReport {
    private String reportid;
    private String reportdateandtime;
    private String description;
    private Citizen citizen;
    private Disaster disaster;
    public DisasterReport(){}
    public DisasterReport(String reportid, String reportdateandtime, String description, Citizen citizen,Disaster disaster){
        this.reportid=reportid;
        this.reportdateandtime=reportdateandtime;
        this.description=description;
        this.citizen=citizen;
        this.disaster=disaster;
    }
    
    public void setreportid(String reportid){this.reportid=reportid;}
    public void setreportdateandtime(String reportdateandtime){this.reportdateandtime=reportdateandtime;}
    public void setdescription(String description){this.description=description;}
    public void setcitizen(Citizen citizen){this.citizen=citizen;}
    public void setdisaster( Disaster disaster){this.disaster=disaster;}

    public String getreportid(){return reportid;}
    public String getreportdateandtime(){return reportdateandtime;}
    public String getdescription(){return description;}
    public Citizen getcitizen(){return citizen;}
    public Disaster getdisaster(){return disaster;}

    public String getDisplayText(){
        String citizenDetails=citizen==null?"Not provided":citizen.getDisplayText();
        String disasterDetails=disaster==null?"Not provided":disaster.getDisplayText();
        return "DISASTER REPORT\n"
            + "Report ID: " + reportid + "\n"
            + "Date and Time: " + reportdateandtime + "\n"
            + "Description: " + description + "\n\n"
            + citizenDetails + "\n\n"
            + disasterDetails;
    }

    public void showDetails(){
         System.out.println(getDisplayText());
    }
}
