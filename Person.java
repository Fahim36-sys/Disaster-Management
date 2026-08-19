public abstract class Person{
    private String name;
    private String phone;
    public Person(){}
    public Person(String name,String phone){
        this.name=name;
        this.phone=phone;
    }
    public void setname(String name){this.name=name;}
    public void setphone(String phone){this.phone=phone;}
    public String getname(){return name;}
    public String getphone(){return phone;}
     
     public void showPersonDetails(){
        System.out.println("Name: "+name);
        System.out.println("Phone: "+phone);
     }
    public abstract void display();
}
