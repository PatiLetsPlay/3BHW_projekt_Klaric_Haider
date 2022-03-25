import Models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vokabeln_Abfragen_Main {
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        loginAll();
    }
    public static void loginAll(){
        char WerLogtSichEin;


        System.out.println("Login Menü: ");
        System.out.println("a ... Admin login");
        System.out.println("g ... Guesser login");
        System.out.println("s ... stop Programm");
        System.out.print("Ur Option: ");
        WerLogtSichEin = reader.next().toLowerCase().charAt(0);
        System.out.println("");

        switch(WerLogtSichEin){

            case 'a': loginAdmin();break;
            case 'g': System.out.println("Logged in as Guesser"); break;
            case 's': System.out.println("Stopped Programm"); break;
            default: System.out.println("Error Login"); break;
        }
    }
    public static void loginAdmin(){
        List<Person> admins = new ArrayList<Person>();
        char newAdmin_OR_oldAdmin;

        System.out.println("Login or Register:");
        System.out.println("l ... login");
        System.out.println("r ... register");
        System.out.println("b ... back");
        System.out.println("Ur Option: ");
        newAdmin_OR_oldAdmin = reader.next().toLowerCase().charAt(0);
        System.out.println("");

        switch(newAdmin_OR_oldAdmin){
            case 'l': System.out.println("Login: "); break;
            case 'r': System.out.println("Register: "); Person adminSelber = inputNewAdmin(); admins.add(adminSelber); break;
            case 'b': System.out.println("Going back"); loginAll(); break;
            default: System.out.println("Error cannot login or register"); break;
        }

        //Alle Admins ausgeben vllt alls auswahl machen
        Person admin1 = new Admin(1, "Patrick", "Klaric",2911);
        admins.add(admin1);
        Person admin2 = new Admin(2, "Felix", "Haider", 1234);
        admins.add(admin2);

        for (Person a : admins) {
            System.out.println(a);
        }
    }
    public static Admin inputNewAdmin(){
        Admin a = new Admin();

        System.out.print("\nId: ");
        a.setId(reader.nextInt());
        reader = new Scanner(System.in);
        System.out.print("\nFirstname: ");
        a.setFirstname(reader.nextLine());
        System.out.print("\nLastname: ");
        a.setLastname(reader.nextLine());
        System.out.print("\nUserCode: ");
        a.setUserCode(reader.nextInt());

        return a;
    }
}
