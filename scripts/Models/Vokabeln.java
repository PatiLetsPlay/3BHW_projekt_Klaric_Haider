package Models;

public class Vokabeln {
    private int _id;
    private String _germanWord;
    private String _englishWord;

    public int getId(){
        return this._id;
    }
    public void setId(int id){
        if(id > 0){
            this._id = id;
        }
    }
    public String getGermanWord(){
        return this._germanWord;
    }
    public void setGermanWord(String germanWord){
        this._germanWord = germanWord;
    }
    public String getEnglishWord(){
        return this._englishWord;
    }
    public void setEnglishWord(String englishWord){
        this._englishWord = englishWord;
    }

    public Vokabeln(){
        this(0,"","");
    }
    public Vokabeln(int id, String germanWord, String englishWord){
        this.setId(id);
        this.setGermanWord(germanWord);
        this.setEnglishWord(englishWord);
    }

    @Override
    public String toString(){
        return "\n"+ this._id +" "+ this._germanWord +" "+ this._englishWord;
    }
}
