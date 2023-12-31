import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DatabazaKnih databazaKnih = new DatabazaKnih();
        SpravcaUserov spravcaUserov = new SpravcaUserov();
        
        
        
        while(true){
            
            System.out.println("    Vitajte v mojej knižnici, vyberte možnosť:  ");
            System.out.println("  ______________________________________________");
            System.out.println("  | 1 | Prihlásenie                            |");
            System.out.println("  |___|________________________________________|");
            System.out.println("  | 2 | Registrácia                            |");
            System.out.println("  |___|________________________________________|");
            System.out.println("  | X | Koniec                                 |");
            System.out.println("  |___|________________________________________|");
        
            char volba = sc.next().charAt(0);
            switch(volba){
                case '1' : 
                    User prihlasenyUser = spravcaUserov.prihlasPouzivatela();
                    if (prihlasenyUser != null && prihlasenyUser.getTypPouzivatela() == Pouzivatel.ZAKAZNIK) {
                        vypisMenuPrePouzivatela(prihlasenyUser,databazaKnih);
                    }
                    if(prihlasenyUser == null){
                        break;
                    }
                    
                    //dalsie akcie
                    break;
                case '2' : 
                    spravcaUserov.registrujPouzivatela();
                    break;
                default : 
                    // tu este pridaj meno usera
                    sc.close();
                    System.out.println("  ______________________________________________");
                    System.out.println("  | DOVIDENIA! Tešíme sa na ďalšiu návštevu !! |");
                    System.out.println("  |____________________________________________|");
                    System.exit(0);
                    break;
            }
        }
    }
    
    
    public static void vypisMenuPrePouzivatela(User user,DatabazaKnih databazaKnih){
        Scanner sc = new Scanner(System.in);
        System.out.println("    Vitajte" + user.getUsername() + " , vyberte možnosť:  ");
            System.out.println("  ______________________________________________");
            System.out.println("  | 1 | Profil používateľa                     |");
            System.out.println("  |___|________________________________________|");
            System.out.println("  | 2 | Požičané knihy                         |");
            System.out.println("  |___|________________________________________|");
            System.out.println("  | 3 | Katalóg kníh                           |");
            System.out.println("  |___|________________________________________|");
            System.out.println("  | X | Odhlásiť sa                            |");
            System.out.println("  |___|________________________________________|");
            
            
            char volba = sc.next().charAt(0);
            switch(volba){
                case '1' :
                    user.vypisInfoUsera();
                    break;
                case '2' :
                    
                    break;
                case '3' :
                    databazaKnih.vypisDostupnychKnih();
                    break;
                default :
                    break;
            }
        }
            
    
    }

