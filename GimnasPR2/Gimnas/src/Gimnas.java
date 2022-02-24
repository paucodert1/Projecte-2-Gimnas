import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gimnas {

    private String nom;
    private String CIF;
    private String Telefon;

    ArrayList <Client> clients;

    public void gestionarGimnas() throws SQLException{

          // Variables

          Scanner teclatsScanner = new Scanner(System.in);
          boolean sortir=false;
  
          // MENU
  
          do{
  
          System.out.println(" ________________MENU PRINCIPAL ________________");
          System.out.println("|                                               |");
          System.out.println("|             1.- Gestionar client              |");
          System.out.println("|             2.- Visualitzar Client            |");
          System.out.println("|             3.- Visualitzar activitats        |");
          System.out.println("|             4.- Fitxer de activitat i         |");
          System.out.println("|             5.- Sortir                        |");
          System.out.println("|_______________________________________________|");
          System.out.println("\nTRIA UNA OPCIÓ: ");
  
          int opcio = teclatsScanner.nextInt();

          switch(opcio){
  
              case 1:
                menuGestioClients();
              break;
      
              case 2:
                 //  visualitzarClients();
              break;
  
              case 3:
                 //  visualitzarActivitats();
              break;
  
              case 4:
                 //  activitatReservesFetes();
              break;
      
              case 5:
              sortir=true;
              break;
      
              default:
              System.out.println("Opcio no valida");
            }

              System.out.println(("opcio: ") + opcio);

        }while (!sortir);

    }

    public void menuGestioClients () throws SQLException{

        boolean sortir=false;
        Scanner teclatsScanner = new Scanner(System.in);

        Client c = new Client();

        System.out.println(" ________________MENU PRINCIPAL ________________ ");
        System.out.println("|             Escull una opcio:                 |");
        System.out.println("|             1.- Consulta client               |");
        System.out.println("|             2.- Alta client                   |");
        System.out.println("|             3.- Baixa de client               |");
        System.out.println("|             4.- Modificar client              |");
        System.out.println("|             5.- Sortir                        |");
        System.out.println("|_______________________________________________|");
        System.out.println("\nTRIA UNA OPCIÓ: ");

        int opcio = teclatsScanner.nextInt();

        switch(opcio){

            case 1:
                c.consultarClient();
            break;
    
            case 2:
                // altaClient();
            break;
    
            case 3:
                // baixaCLient();
            break;

            case 4:
                // modificarClient();
            break;

            case 5:
                // ConsultarProductes();
            break;

            case 6:
            sortir=true;
            default:
            System.out.println("Opcio no valida");
            }

    }

    // CONSULTAR CLIENT
    
    private void consultaClient(){
        // demanar el dni

        // Client c = new Client();

        // c.consultarClient;


    }

}
