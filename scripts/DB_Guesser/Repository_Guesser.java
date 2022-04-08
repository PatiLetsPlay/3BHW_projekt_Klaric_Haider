package DB_Guesser;
import Models.*;
import java.sql.*;

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
}
