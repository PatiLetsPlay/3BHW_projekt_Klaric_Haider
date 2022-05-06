package DB_Admin;
import Models.Admin;

import java.sql.*;

public class Repository_Admin implements  IRepository_Admin{
    private String url      = "jdbc:mysql://localhost/vokabeln_abfragen";

    private String user     = "root";
    private String password = "Paluten-7";

    private Connection _connection;

    public Repository_Admin() throws ClassNotFoundException {
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
        if((this._connection != null) && (!this._connection.isClosed())){
            this._connection.close();
        }
    }

    @Override
    public boolean insertAdmin(Admin admin) throws SQLException{
        PreparedStatement pStmt = this._connection.prepareStatement("insert into vokabelabfrage_admin values(null, ?, ?, ?)");

        pStmt.setString(1, admin.getFirstname());
        pStmt.setString(2, admin.getLastname());
        pStmt.setInt(3, admin.getUserCode());


        return pStmt.executeUpdate() == 1;
    }

    @Override
    public Admin getAdminByUsercode(int usercode) throws SQLException {
        //SQL-Statement erzeugen - SELECT
        PreparedStatement pStmt = this._connection.prepareStatement("select * from vokabelabfrage_admin where usercode = ?");

        //Platzhalter (?) belegen
        pStmt.setInt(1, usercode);

        //SQL-Statement an den MySQL-Server senden
        //SELECT-Abfragen immer mit executeQuery() an den Server senden
        ResultSet result = pStmt.executeQuery();

        if(result.next()){
            //leere Adresse erzeugen...
            Admin a = new Admin();
            //... und mit den Daten aus der DB_Tabelle belegen
            a.setId(result.getInt("id"));
            a.setFirstname(result.getString("firstname"));
            a.setLastname(result.getString("lastname"));
            a.setUserCode(result.getInt("usercode"));

            return a;
        }else{
            return null;
        }
    }
}
