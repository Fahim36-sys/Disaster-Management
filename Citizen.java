public class Citizen{
    private Person person;
    private String citizenID;
    private String address;
    private String reportType;
    public Citizen(){}
    public Citizen(String citizenID,String address,String reportType){
        this.citizenID=citizenID;
        this.address=address;
        this.reportType=reportType;
    }
    public void setPerson(Person person){this.person=person;}
    public Person getPerson(){return person;}
    public String getCitizenID(){return citizenID;}
    public void setCitizenID(String citizenID){
        this.citizenID=citizenID;
    }
    public String getAddress(){return address;}
    public void setAddress(String address){this.address=address;}
    public String getReportType(){return reportType;}
    public void setReportType(String reportType){this.reportType=reportType;}
    public void showCitizenDetails(){
        System.out.println("CitizenID: "+citizenID);
        System.out.println("Address: "+address);
        System.out.println("ReportType: "+reportType);
        person.showPersonDetails();
    }
}
