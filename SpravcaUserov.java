import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class SpravcaUserov here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpravcaUserov {
    private ArrayList<User> zoznamUserov;
    private UserInput userInput;
    private User prihlasenyUser;
    
    public SpravcaUserov() {
        this.zoznamUserov = new ArrayList <User>();
        this.userInput = new UserInput();
        this.prihlasenyUser = null;
        
    }
    
    public void registrujPouzivatela(){
        System.out.println(" ____________________________________________");
        System.out.println(" |                REGISTRÁCIA                |");
        System.out.println(" |___________________________________________|");
        Scanner sc = new Scanner(System.in);
        
       
        Pouzivatel typ = userInput.zadajTypPouzivatela(sc);
        String meno = userInput.zadajMeno(sc);
        String priezvisko = userInput.zadajPriezvisko(sc);
        String username = userInput.zadajUsername(sc);
        String heslo = userInput.zadajHeslo(sc);
        
        System.out.println("Debug: Typ: " + typ + ", Meno: " + meno + ", Priezvisko: " + priezvisko +
                       ", Username: " + username + ", Heslo: " + heslo);
        
        User novyUser = new User(typ, username, meno, priezvisko, heslo);
        this.zoznamUserov.add(novyUser);
        System.out.println("|Používateľ bol registrovaný, môžete sa prihlásiť. |");
        System.out.println("Debug: Users in the list: " + zoznamUserov.size());
        
        return;
    }
    
    
    public User prihlasPouzivatela() {
        System.out.println(" ____________________________________________");
        System.out.println(" |                PRIHLÁSENIE                |");
        System.out.println(" |___________________________________________|");
        Scanner sc = new Scanner(System.in);
        String username = userInput.zadajUsername(sc);
        String heslo = userInput.zadajHeslo(sc);
    
        // Call the overPrihlasenie method and assign the result to prihlasenyUser
        this.prihlasenyUser = overPrihlasenie(username, heslo);
    
        if (prihlasenyUser != null) {
            System.out.println("|        Úspešné prihlásenie.               |");
            return prihlasenyUser;
        } else {
            System.out.println("|        Neplatné prihlasovacie údaje.");   
        }
    
        return null;
    }
    
    public User overPrihlasenie(String username, String heslo) {
        
        for (User user : zoznamUserov) {
            System.out.println("Debug: Stored username: " + user.getUsername() + ", Entered username: " + username);
            System.out.println("Debug: Stored password: " + user.getHeslo() + ", Entered password: " + heslo);
        
            if (user.getUsername().equals(username) && user.getHeslo().equals(heslo)) {
                return user;
            }
        }
        
            
        
        for (User user : zoznamUserov) {
            if (user.getUsername().trim().equals(username.trim()) && user.getHeslo().equals(heslo)) {
                return user;
            }

        }
        return null; // Return null if no user is found with the given username and password
    }


         
    public boolean jePrihlaseny(){
        return this.prihlasenyUser != null && this.zoznamUserov.contains(prihlasenyUser);
        
    }
    
    
    
   
}
       

    
    

