package DB_Guesser;
import Models.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository_Guesser implements  IRepository_Guesser {

    private String url = "jdbc:mysql://localhost/vokabeln_abfragen";

    private String user = "root";
    private String password = "Paluten-7";

    private Connection _connection;

    public Repository_Guesser() throws ClassNotFoundException {
        //im ctor wird der Datenbanktreiber für mysql geladen
        //      erst nach dem Laden des DB-Treibers kann auf die DB zugegriffen werden
        Class<?> c = Class.forName("com.mysql.cj.jdbc.Driver");
        if (c != null) {
            //System.out.println("MySQL-Treiber wurde geladen!");
        }
    }


    @Override
    public void open() throws SQLException {
        //Die Methode open() stellt eine Verbindung
        this._connection = DriverManager.getConnection(url, user, password);
    }

    @Override
    public void close() throws SQLException {
        //falls die Verbindung (_connection) erzeugt wurde (!= null) UND
        //      die Verbindung nicht geschlossen ist (!isClosed()) ...
        if ((this._connection != null) && (!this._connection.isClosed())) {
            this._connection.close();
        }
    }

    @Override
    public boolean insertGuesser(Guesser guesser) throws SQLException {
        PreparedStatement pStmt = this._connection.prepareStatement("insert into vokabelabfrage_guesser values(null, ?, ?, ?)");

        pStmt.setString(1, guesser.getFirstname());
        pStmt.setString(2, guesser.getLastname());
        pStmt.setInt(3, guesser.getScore());


        return pStmt.executeUpdate() == 1;
    }

    @Override
    public List<Guesser> getScoreFromPlayerFnLn(String firstname, String lastname) throws SQLException {
        List<Guesser> guesser = new ArrayList<Guesser>();
        //SQL-Statement erzeugen - SELECT
        PreparedStatement pStmt = this._connection.prepareStatement("select * from vokabelabfrage_guesser where firstname LIKE ? and lastname LIKE ? order by score desc");

        //Platzhalter (?) belegen
        pStmt.setString(1, firstname);
        pStmt.setString(2, lastname);


        //SQL-Statement an den MySQL-Server senden
        //SELECT-Abfragen immer mit executeQuery() an den Server senden
        ResultSet result = pStmt.executeQuery();

        Guesser g;
        while(result.next()){
            //leere Adresse erzeugen...
            g = new Guesser();
            //... und mit den Daten aus der DB_Tabelle belegen
            g.setId(result.getInt("id"));
            g.setFirstname(result.getString("firstname"));
            g.setLastname(result.getString("lastname"));
            g.setScore(result.getInt("score"));

            guesser.add(g);
        }
        if(guesser.size() > 0){
            return guesser;
        }else{
            return null;
        }
    }

    @Override
    public List<Guesser> getScoreFromAll() throws SQLException {
        List<Guesser> guesser = new ArrayList<Guesser>();
        //SQL-Statement erzeugen - SELECT
        PreparedStatement pStmt = this._connection.prepareStatement("select * from vokabelabfrage_guesser order by score desc");


        //SQL-Statement an den MySQL-Server senden
        //SELECT-Abfragen immer mit executeQuery() an den Server senden
        ResultSet result = pStmt.executeQuery();

        Guesser g;
        while(result.next()){
            //leere Adresse erzeugen...
            g = new Guesser();
            //... und mit den Daten aus der DB_Tabelle belegen
            g.setId(result.getInt("id"));
            g.setFirstname(result.getString("firstname"));
            g.setLastname(result.getString("lastname"));
            g.setScore(result.getInt("score"));

            guesser.add(g);
        }
        if(guesser.size() > 0){
            return guesser;
        }else{
            return null;
        }
    }
}
