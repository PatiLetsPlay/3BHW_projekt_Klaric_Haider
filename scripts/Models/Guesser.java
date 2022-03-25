package Models;

public class Guesser extends Person{

    private int _score;

    public int getScore(){ return this._score; }
    public void setScore(int score){ this._score = score; }

    public Guesser(){
        this(0,"","", 0);
    }
    public Guesser(int id, String firstname, String lastname, int score){
        super(id, firstname,lastname);
        this.setScore(score);
    }

    @Override
    public String toString(){
        return super.toString() + "Score: " + getScore() + " \n";
    }
}
