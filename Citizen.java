public class Citizen extends Person{
    private String citizenID;
    private String reportType;
    public Citizen(){}
    public Citizen(String citizenID,String reportType,String name,String phone){
        super(name,phone);
        this.citizenID=citizenID;
        this.reportType=reportType;
    }
    public String getCitizenID(){return citizenID;}
    public void setCitizenID(String citizenID){
        this.citizenID=citizenID;
    }
    public String getReportType(){return reportType;}
    public void setReportType(String reportType){this.reportType=reportType;}
    public void showCitizenDetails(){
        System.out.println(getDisplayText());
    }
    public String getDisplayText(){
        return "Citizen Information\n"
            + "  Citizen ID: " + citizenID + "\n"
            + "  Name: " + getname() + "\n"
            + "  Phone: " + getphone() + "\n"
            + "  Report Type: " + reportType;
    }
    public void display(){
       showCitizenDetails();
   }
}
