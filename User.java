import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * Write a description of class User here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class User {
    private Pouzivatel typ;
    private String username;
    private String meno;
    private String priezvisko;
    private String heslo;
    private String cisloPreukazu;
    private ArrayList<Kniha> pozicaneKnihy;
    private Random random;
    
    public User(Pouzivatel typ,String username, String meno, String priezvisko, String heslo) {
        // initialise instance variables
        this.typ = typ;
        this.username = username;
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.heslo = heslo;
        this.cisloPreukazu = generujCisloPreukazu();
        this.pozicaneKnihy = new ArrayList<Kniha>();
        
        
    }
    
    public Pouzivatel getTypPouzivatela(){
        return this.typ;
    }
   
    public String getUsername(){
        return this.username;
    }
    
    public String getCeleMeno(){
        return this.meno + this.priezvisko;
    }
    
    public String getPriezvisko(){
        return this.priezvisko;
    }
    
    public String getHeslo(){
        return this.heslo;
    }
    
    public String getCisloPreukazu(){
        return this.cisloPreukazu;
    }
    
    public String generujCisloPreukazu(){
        Random random = new Random();
        StringBuilder cisloPreukazu = new StringBuilder();
        
        for(int i = 0; i < 3; i++){
                char randomPismeno = (char) ('A' + random.nextInt(26));
                cisloPreukazu.append(randomPismeno);
            }
            cisloPreukazu.append('-');
        
        for(int i = 0; i < 4; i++){
            cisloPreukazu.append(random.nextInt(10));
        }
        
        return cisloPreukazu.toString();
        
    }
   
    
    public ArrayList<Kniha> getPozicaneKnihy(){
        return this.pozicaneKnihy;
    }
    
    public void setHeslo(String cisloPreukazu, String stareHeslo, String noveHeslo){
        if(this.heslo.equals(stareHeslo)){
            this.heslo = noveHeslo;
            System.out.println("Heslo bolo zmenene");
        } else {
            System.out.println("Heslo sa nepodarilo zmenit");
        }
  
    }
    
    public String userToString(){
        return this.meno + " " + this. priezvisko + " , " + this.username;
    }
    
    public void vypisInfoUsera(){
        System.out.println("Informácie o používateľovi");
        System.out.println("Meno: " + this.meno + " " + this.getPriezvisko());
        System.out.println("Používateľske meno: " + this.getUsername());
        System.out.println("Číslo preukazu: " + this.getCisloPreukazu());
        
    }
    
    public void pozicajKnihu(Kniha kniha){
        if(kniha.getDostupnost()){
            kniha.setDostupnost(false);
            pozicaneKnihy.add(kniha);
            System.out.println("Kniha " + kniha.getNazov() + " bola požičaná.");
        } else {
            System.out.println("Kniha " + kniha.getNazov() + "nie je dostupna.");
        }
    }
    
    public void vratKnihu(Kniha kniha){
        if(pozicaneKnihy.contains(kniha)){
            kniha.setDostupnost(true);
            pozicaneKnihy.remove(kniha);
            System.out.println("Kniha " + kniha.getNazov() + "bola úspešné vrátená.");
            
        } else {
            System.out.println("Knihu " + kniha.getNazov() + "nemáte požičanú.");
        }
        
    }
}
