import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Kniha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kniha {
    private String nazov;
    private String autor;
    private int rokVydania;
    private String isbn;
    private boolean dostupnost;
    private ArrayList<Recenzia> zoznamRecenzii;
    
    public Kniha(String nazov, String autor, int rokVydania, String isbn) {
        this.nazov = nazov;
        this.autor = autor;
        this.rokVydania = rokVydania;
        this.isbn = isbn;
        this.zoznamRecenzii = new ArrayList<Recenzia>();
        this.dostupnost = true;
    }
    
    public String getNazov() {
        return this.nazov;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getRokVydania() {
        return this.rokVydania;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public boolean getDostupnost() {
        return this.dostupnost;
    }
    
    public void setDostupnost(boolean novaDostupnost){
        this.dostupnost = novaDostupnost; 
    }
    
    public void vypisInfoKnihy(){
        System.out.println("\n..........................");
        System.out.println("Názov: " + this.getNazov());
        System.out.println("Autor: " + this.getAutor());
        System.out.println("Rok vydania: " + this.getRokVydania());
        System.out.println("ISBN: "+ this.getIsbn());
        System.out.println("..........................\n");
        if(!this.zoznamRecenzii.isEmpty() && this.zoznamRecenzii != null){
        System.out.println("Priemerne hodnotenie : " + String.format("%.2f", this.getPriemerneHodnotenie()));
        }
    }
    
    public boolean pridajRecenziu(){
        if(this.zoznamRecenzii == null){
            System.out.println("Zoznam recenzii neexistuje"); 
            return false;
        }else { 
            System.out.println("Pridanie recenzie");
            System.out.println("Zadajte počet hviezdičiek");
            System.out.println("1 : * ");
            System.out.println("2 : **"); 
            System.out.println("3 : ***"); 
            System.out.println("4 : **** ");
            
            Scanner sc = new Scanner(System.in);
            int hodnotenie = sc.nextInt();
            sc.nextLine();
            
            Hodnotenie hodnotenieKnihy;
            
            switch(hodnotenie) {
                case 1 :
                    hodnotenieKnihy = Hodnotenie.JEDNA_HVIEZDICKA;
                    break;
                case 2 :
                    hodnotenieKnihy = Hodnotenie.DVE_HVIEZDICKY;
                    break;
                case 3 :
                    hodnotenieKnihy = Hodnotenie.TRI_HVIEZDICKY;
                    break;
                case 4 :
                    hodnotenieKnihy = Hodnotenie.STYRI_HVIEZDICKY;
                    break;
                case 5 :
                    hodnotenieKnihy = Hodnotenie.PAT_HVIEZDICIEK;
                    break;
                default:
                    System.out.println("Neplatný výber");
                    return false;
            }
            
            System.out.println("Zadajte komentár k recenzii. Ak si neprajate zanechať komentár, stlačte ENTER");
            String komentar = sc.nextLine();
            
            this.zoznamRecenzii.add(new Recenzia(hodnotenieKnihy,komentar));
            return true;
        }
        
    }
    
    public void vypisVsetkychRecenzii(){
        //opytaj sa ze ako si praje recenzie zoradit
        
        
         if(this.zoznamRecenzii == null){
            System.out.println("Zoznam recenzii neexistuje"); 
            return;
        } else if (this.zoznamRecenzii.isEmpty()){
            System.out.println("Zoznam recenzii je prazdny");
        } else{
            for(Recenzia recenzia : zoznamRecenzii) {
                recenzia.vypisRecenzie();
            }
        }
    }
    
    public String upravText(){
        return String.format("%s,%s,%d,%s",this.autor, this.nazov,this.rokVydania,this.isbn);
    }
    
    
    
    
    //metoda na zoradenie recenzii podla hodnotenie vzostupne, zostupne 
    
    public float getPriemerneHodnotenie(){
        if(this.zoznamRecenzii == null){
            System.out.println("Zoznam recenzii neexistuje"); 
            return 0.0f;
        } else if (this.zoznamRecenzii.isEmpty()){
            System.out.println("Zoznam recenzii je prazdny");
            return 0.0f;
        } else{
            float celkom = 0.0f;
            for(Recenzia recenzia : zoznamRecenzii) {
                celkom += recenzia.getHodnotenie().getHodnota();
            }
            float priemer = celkom / (this.zoznamRecenzii.size());
            return priemer;
        } 
        
    }
    
}

    
    
    
    
    
