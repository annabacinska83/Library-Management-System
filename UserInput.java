import java.util.Scanner;
/**
 * Write a description of class UserInput here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UserInput {
    /**
     * Constructor for objects of class UserInput
     */
    public UserInput() {
        // initialise instance variables
    }
    
    public Pouzivatel zadajTypPouzivatela(Scanner sc) {
        System.out.println("Zadajte typ používateľa\n1-POUŽÍVATEĽ- \n2-KNIHOVNÍK");
        int volbaTypu = sc.nextInt();
        sc.nextLine();

        switch (volbaTypu) {
            case 1:
                return Pouzivatel.ZAKAZNIK;
            case 2:
                return Pouzivatel.KNIHOVNIK;
            default:
                System.out.println("Neplatná voľba. Používateľ bol nastavený na zakaznika");
                return Pouzivatel.ZAKAZNIK;
            }
   
  
    }  
    
    public String zadajUsername(Scanner sc){
        String username;
        do{
            System.out.println("Zadajte používateľske meno :");
            username = sc.next();
        } while (!kontrolaInputu(username));
        return username;
    }
    
    public String zadajMeno(Scanner sc){
        String meno;
        do{
            System.out.println("Zadajte meno používateľa :");
            meno = sc.next();
        } while (!kontrolaInputu(meno));
        return meno;
    }
    
    public String zadajPriezvisko(Scanner sc){
        String priezvisko;
        do{
            System.out.println("Zadajte priezisko použivateľa:");
            priezvisko = sc.next();
        } while (!kontrolaInputu(priezvisko));
        return priezvisko;
    }
    
    public String zadajHeslo(Scanner sc){
        String heslo;
        do{
            System.out.println("Zadajte heslo:");
            heslo = sc.next();
        } while (!kontrolaHesla(heslo));
        return heslo;
    }
    
    public boolean kontrolaInputu(String username){
        return true;
    }
    
    public boolean kontrolaHesla(String heslo){
        return true;
    }
    
    
    
    
    
    
    






}