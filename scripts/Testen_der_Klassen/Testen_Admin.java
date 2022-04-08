package Testen_der_Klassen;

import DB_Admin.IRepository_Admin;
import DB_Admin.Repository_Admin;
import Models.Admin;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Testen_Admin {

    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        IRepository_Admin repAdmin = null;
        Admin admin = inputNewAdmin();



        try {
            repAdmin = new Repository_Admin();
            repAdmin.open();


            System.out.println("\n\nAdmin einfügen\n");
            if (repAdmin.insertAdmin(admin)){
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

    public static Admin inputNewAdmin(){
        Admin a = new Admin();
        Random random = new Random();
        String platzhalter;
        int randomUserCode = random.nextInt(8999) + 1000;

        System.out.print("\nFirstname: ");
        a.setFirstname(reader.nextLine());
        System.out.print("\nLastname: ");
        a.setLastname(reader.nextLine());
        System.out.printf("\n Your UserCode is '%d' pls wright it down \n", randomUserCode);
        a.setUserCode(randomUserCode);

        System.out.print("Press 'Enter' if you understood");
        platzhalter = reader.nextLine();

        return a;
    }
}
