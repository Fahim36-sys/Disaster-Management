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

    public void showDetails(){
         System.out.println("ReportId:"+reportid);
         System.out.println("Reportdataandtime:"+reportdateandtime);
         System.out.println("Description:"+description);
         System.out.println("Citizen:"+citizen);
          System.out.println("Disaster:"+disaster);
    }
}
