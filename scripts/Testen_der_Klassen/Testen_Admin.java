package Testen_der_Klassen;

import DB_Admin.IRepository_Admin;
import DB_Admin.Repository_Admin;
import Models.Admin;

import java.sql.SQLException;
import java.util.Scanner;

public class Testen_Admin {

    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        IRepository_Admin repAdmin = null;
        Admin admin1 = new Admin(8, "Patrick", "Klaric", 9921);
        Admin admin2 = new Admin(7, "Felix", "Haider", 5122);

        try {
            repAdmin = new Repository_Admin();
            repAdmin.open();


            System.out.println("\n\nAdmin 1 einfügen\n");
            if (repAdmin.insertAdmin(admin1)){
                System.out.println("Admin wurde hinzugefügt");
            }else{
                System.out.println("Admin wurde nicht hinzugefügt");
            }

            System.out.println("\n\nAdmin2 einfügen\n");
            if (repAdmin.insertAdmin(admin2)){
                System.out.println("Admin wurde hinzugefügt");
            }else{
                System.out.println("Admin wurde nicht hinzugefügt");
            }



        } catch (ClassNotFoundException e) {
            System.out.println("MySQL-Treiber konnte nicht geladen werden!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Datenbankfehler!");
        } finally {
            try {
                repAdmin.close();
            } catch (SQLException e) {
                System.out.println("DB-Verbindung konnte nicht beendet werden");
            }
        }

    }
}
