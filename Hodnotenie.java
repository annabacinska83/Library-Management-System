
/**
 * Enumeration class Hodnotenie - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Hodnotenie {
    JEDNA_HVIEZDICKA(1),
    DVE_HVIEZDICKY(2),
    TRI_HVIEZDICKY(3),
    STYRI_HVIEZDICKY(4),
    PAT_HVIEZDICIEK(5);
    
    private final int hodnota;
    
    
    Hodnotenie(int hodnota){
        this.hodnota = hodnota;
    }
    
    public int getHodnota(){
        return this.hodnota;
    }
    
    }
    
    
