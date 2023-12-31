import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * DatabazaKnih 
 * @author AnnaBacinska
 * @version 02.12.2023
 */
public class DatabazaKnih {
    private ArrayList<Kniha> zoznamKnih;
    private boolean nacitanieKnih;

    
    public DatabazaKnih() {
        this.zoznamKnih = new ArrayList<>();
        this.nacitanieKnih = false;
    }

   
    public ArrayList<Kniha> getZoznamKnih() {
        return zoznamKnih;
    }

    
    private void nacitajKnihyZoSuboru() {
    String cestaKSuboru = "C:/Users/annab/Desktop/UNIZA/Inf1/projekt/projekt2.0/Kniznica_Projekt/ZoznamKnih.txt";
    try (BufferedReader br = new BufferedReader(new FileReader(cestaKSuboru))) {
        String riadok;
        while ((riadok = br.readLine()) != null) {
            if (!riadok.isEmpty()) {
                String[] polia = riadok.split(",");
                if (polia.length == 4) {
                    String autor = polia[0].trim();
                    String nazov = polia[1].trim();
                    int rokVydania = Integer.parseInt(polia[2].trim());
                    String isbn = polia[3].trim();
                    Kniha kniha = new Kniha(nazov, autor, rokVydania, isbn);
                    zoznamKnih.add(kniha);
                } else {
                    System.out.println("Invalid line format: " + riadok);
                }
            }
        }
    } catch (IOException | NumberFormatException e) {
        System.err.println("Error reading from the file: " + e.getMessage());
    }
}


   
    public void zapisDoSuboru() {
        String cestaKSuboru = "C:/Users/annab/Desktop/UNIZA/Inf1/projekt/projekt2.0/Kniznica_Projekt/ZoznamKnih.txt";
        
        Kniha novaKniha = zapisKnihyZterminalu(); 

        boolean duplicitaKnihy = zoznamKnih.stream().anyMatch(kniha -> kniha.getIsbn().equals(novaKniha.getIsbn()));

        if (!duplicitaKnihy) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(cestaKSuboru, true))) {
                bw.write(novaKniha.upravText());
                bw.newLine();
            } catch (IOException e) {
                System.err.println("Error " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Kniha už existuje v súbore.");
        }
    }

    
    public void vypisVsetkychKnih() {
        

        ArrayList<Kniha> knihy = getZoznamKnih();
 
        if (!nacitanieKnih) {
            nacitajKnihyZoSuboru();
            nacitanieKnih = true;
        }
        if (knihy.isEmpty()) {
            System.out.println("Zoznam kníh je prázdny.");
            return;
        }

        for (Kniha kniha : zoznamKnih) {
            kniha.vypisInfoKnihy();
        }
    }
    
    public void vypisDostupnychKnih() {
    
        ArrayList<Kniha> knihy = getZoznamKnih();
    
        if (!nacitanieKnih) {
            nacitajKnihyZoSuboru();
            nacitanieKnih = true;
        }
        if (knihy.isEmpty()) {
            System.out.println("Zoznam kníh je prázdny.");
            return;
        }
    
        int index = 1; // Inicializujeme index na 1
    
        for (Kniha kniha : zoznamKnih) {
            if (kniha.getDostupnost()) {
                System.out.print(index + ". "); // Vypíšeme index pred informáciami o knihe
                kniha.vypisInfoKnihy();
                index++; // Inkrementujeme index
            }
        }
    }

    
    
    public void pridajNovuKnihu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadajte pocet knih, ktore chcete pridat: ");
        int pocet = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < pocet; i++) {
        Kniha novaKniha = zapisKnihyZterminalu(); 
        zoznamKnih.add(novaKniha);
        System.out.println("Kniha bola pridana zo zoznamu.");
        }

        sc.close();
    }
     public void odstranKnihu(){}
    
    public boolean jeKnihaVDatabaze( ){
        //toto mi nefunguje 
       System.out.print("Zadajte informacie o hladanej knihe: ");
       Kniha hladanaKniha = zapisKnihyZterminalu();
       
       return this.zoznamKnih.contains(hladanaKniha);
    }
    
    public void zrusDatabazu(){
        //najskor vymazem Arraylist 
        this.zoznamKnih.clear();
        // a potom musim vymazat obsah suboru
        
        
    }
    public Kniha zapisKnihyZterminalu(){
         Scanner sc = new Scanner(System.in);
         
         System.out.print("Zadajte autora: ");
         String autor = sc.nextLine();
         System.out.print("Zadajte názov: ");
         String nazov = sc.nextLine();
         System.out.print("Zadajte rok: ");
         int rok = sc.nextInt();
         sc.nextLine();
         System.out.print("Zadajte isbn: ");
         String isbn = sc.nextLine();
         
        return new Kniha(autor, nazov, rok, isbn);
    }
    
}

    