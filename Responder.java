public class Responder extends Person{
    private String responderid;
    private String specialization;
    private String availabilitystatus;
    public Responder(){}
    public Responder(String responderid,String specialization,String availabilitystatus,String name, String phone){
        super(name,phone);
        this.responderid=responderid;
        this.specialization=specialization;
        this.availabilitystatus=availabilitystatus;
    }
  public void setresponderid(String responderid){this.responderid=responderid;}
  public void setspecialization(String specialization){this.specialization=specialization;}
  public void setavailabilitystatus(String availabilitystatus){this.availabilitystatus=availabilitystatus;}

  public String getresponderid(){return responderid;}
  public String getspecialization(){return specialization;}
  public String getavailabilitystatus(){return availabilitystatus;}
  public void showResponderDetails(){
    super.showPersonDetails();
    System.out.println("Responder ID: "+responderid);
    System.out.println("Specialization: "+specialization);
    System.out.println("Availability Status: "+availabilitystatus);
  }
  public void display(){
    showResponderDetails();
  }
}