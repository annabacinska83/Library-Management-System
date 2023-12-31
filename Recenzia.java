
/**
 * Write a description of class Recenzia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recenzia {
    
    private Hodnotenie hodnotenie;
    private String komentar;
    
    public Recenzia(Hodnotenie hodnotenie, String komentar) {
        if(this.kontrolaHodnotenia(hodnotenie) && this.kontrolaKomentaru(komentar)){
            this.hodnotenie = hodnotenie;
            this.komentar = komentar;
        } else {
            System.out.println("Recenzia nebola pridana");
        }
    }
        public Hodnotenie getHodnotenie(){
        return this.hodnotenie;
    }
    
    public String getKomentar(){
        return this.komentar;
    }
    
    public void vypisRecenzie(){
        //tu by som sa este mohla vypisat autora hodnotenia
        System.out.println("Hodnotenie od pouzivatela : " + String.format("%d",this.getHodnotenie()) + "\n" + this.getKomentar());
    }
    
    
    public boolean kontrolaHodnotenia(Hodnotenie hodnotenie){
        
        if(hodnotenie.getHodnota() > 5){
            System.out.println("Hodnotenie nemôže byť vyššie ako 10");
            return false;
        } else if (hodnotenie.getHodnota() < 1){
            System.out.println("Hodnotením nemôže byť záporné číslo");
            return false;
        } else {
            return true;
        }
        
        }
        
        public boolean kontrolaKomentaru(String komentar){
        
        if(komentar.length() > 150){
            System.out.println("Prekročili ste  maximálny povolený počet znakov 150 o " + (komentar.length() - 150) + "znakov.");
            return false;
        } else if (komentar.isEmpty()){
            System.out.println("Recenzia bola pridaná.");
            return true;
        } else 
            System.out.println("Recenzia s komentárom bola pridaná.");
            return true;
        }
        
}
