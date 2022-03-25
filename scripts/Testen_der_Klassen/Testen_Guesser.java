package Testen_der_Klassen;

import DB_Guesser.IRepository_Guesser;
import DB_Guesser.Repository_Guesser;
import Models.Guesser;

import java.sql.SQLException;
import java.util.Scanner;

public class Testen_Guesser {
    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        IRepository_Guesser repGuesser = null;
        Guesser guesser1 = new Guesser(6, "Patrick", "Klaric", 9);
        Guesser guesser2 = new Guesser(6, "Felix", "Haider", 5);

        try {
            repGuesser = new Repository_Guesser();
            repGuesser.open();


            System.out.println("\n\nguesser 1 einfügen\n");
            if (repGuesser.insertGuesser(guesser1)){
                System.out.println("Guesser wurde hinzugefügt");
            }else{
                System.out.println("Guesser wurde nicht hinzugefügt");
            }

            System.out.println("\n\nGuesser2 einfügen\n");
            if (repGuesser.insertGuesser(guesser2)){
                System.out.println("Guesser wurde hinzugefügt");
            }else{
                System.out.println("Guesser wurde nicht hinzugefügt");
            }



        } catch (ClassNotFoundException e) {
            System.out.println("MySQL-Treiber konnte nicht geladen werden!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Datenbankfehler!");
        } finally {
            try {
                repGuesser.close();
            } catch (SQLException e) {
                System.out.println("DB-Verbindung konnte nicht beendet werden");
            }
        }

    }
}
