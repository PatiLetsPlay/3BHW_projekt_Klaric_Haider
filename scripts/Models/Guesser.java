package Models;

public class Guesser extends Person{

    private  String _password;
    private int _score;

    public int getScore(){ return this._score; }
    public void setScore(int score){ this._score = score; }

    public String getPassword(){return this._password;}
    public void setPassword(String password) {
        if (password != null) {
            this._password = password;
        }
    }

    public Guesser(){
        this(0,"","", "", 0);
    }
    public Guesser(int id, String firstname, String lastname, String password, int score){
        super(id, firstname,lastname);
        this.setPassword(password);
        this.setScore(score);
    }

    @Override
    public String toString(){
        return super.toString() + "Password: " + getPassword() + "Score: " + getScore() + " \n";
    }
}
