package Models;

import java.time.LocalDate;

public class Admin extends Person{
    private int _usercode;

    public int getUserCode(){ return this._usercode; }
    public void setUserCode(int usercode){ this._usercode = usercode; }

    public Admin(){
        this(0,"","", 0000);
    }
    public Admin(int id, String firstname, String lastname, int usercode){
        super(id,firstname,lastname);
        this.setUserCode(usercode);
    }

    @Override
    public String toString(){
        return super.toString() + "UserCode: " + getUserCode() + " \n";
    }
}
