public class Person{
    private String personid;
    private String name;
    private String phone;
    public Person(){}
    public Person(String personid, String name, String phone){
        this.personid=personid;
        this.name=name;
        this.phone=phone;
    }
    public void setpersonid(String personid){this.personid=personid;}
    public void setname(String name){this.name=name;}
    public void setphone(String phone){this.phone=phone;}
    public String getpersonid(){return personid;}
    public String getname(){return name;}
    public String getphone(){return phone;}
     
     public void showDetails(){
        System.out.println("Personid: "+personid);
        System.out.println("Name: "+name);
        System.out.println("Phone: "+phone);
     }
     
}
