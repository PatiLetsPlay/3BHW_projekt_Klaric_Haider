

//PErson id aus constructor und in admin die id einfügen damit es funktioniert

package Models;

public abstract class Person {
    private int _id;
    private String _firstname;
    private String _lastname;

    public int getId(){
        return this._id;
    }
    public void setId(int id){
        if(id > 0){
            this._id = id;
        }
    }
    public String getFirstname(){
        return this._firstname;
    }
    public void setFirstname(String firstname){
        this._firstname = firstname;
    }
    public String getLastname(){
        return this._lastname;
    }
    public void setLastname(String lastname){
        this._lastname=lastname;
    }


    public Person(){
        this(0,"","");
    }
    public Person(int id, String firstname, String lastname){
        this.setId(id);
        this.setFirstname(firstname);
        this.setLastname(lastname);
    }

    @Override
    public String toString(){
        return " Firstname: "+ this.getFirstname() +" Lastname: "+ this.getLastname() +" ";
    }
}

