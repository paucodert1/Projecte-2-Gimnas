package gimnas;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gimnas {
    String domicili;
    String CIF;
    ArrayList<Client> clients;
    ArrayList<Reserva> reserves;
    ArrayList<Activitat> activitats;
    

    Client c = new Client();

    public Gimnas() {
        this.clients = new ArrayList<>();
        this.reserves = new ArrayList<>();
        this.activitats = new ArrayList<>();
    }

    public void gestionarGimnas() throws SQLException {
        Scanner teclat = new Scanner(System.in);
        boolean sortir = false;

        Connexio con = new Connexio();
        Connection conexio = con.connectarBD();
        
        do {
            System.out.println("______________________________________________");
            System.out.println("|                MENU GIMNAS                 |");
            System.out.println("|             1. Gestió Client               |");
            System.out.println("|             2. Activitats                  |");
            System.out.println("|             3. Sortir                      |");
            System.out.println("|____________________________________________|");
            System.out.println("\nTRIA UNA OPCIÓ:");

            int opcio = teclat.nextInt();

            switch (opcio) {
                case 1:
                    gestioClient();
                    break;
                case 2:
                    // visualitzar activitats
                    break;
                case 3:
                    sortir = true;
                    break;
                default:
                    System.out.println("\n" + opcio + " NO ÉS UNA OPCIÓ NO VÀLIDA");
            }
        } while (!sortir);

    }

    public void gestioClient() throws SQLException {
        Scanner teclat = new Scanner(System.in);
        boolean sortir = false;

        Client c = new Client();

        do {
            System.out.println("______________________________________________");
            System.out.println("|              MENU GESTIO CLIENT            |");
            System.out.println("|                                            |");
            System.out.println("|           1. Visualitzar Clients           |");
            System.out.println("|           2. Consulta Client               |");
            System.out.println("|           3. Alta Client                   |");
            System.out.println("|           4. Modifica Client               |");
            System.out.println("|           5. Baixa Client                  |");
            System.out.println("|           6. Sortir                        |");
            System.out.println("|____________________________________________|");
            System.out.println("\nTRIA UNA OPCIÓ:");

            int opcio = teclat.nextInt();

            switch (opcio) {
                case 1:
                    c.visualitzarClients();
                    break;
                case 2:
                    c.consultarClient();
                    break;
                case 3:
                    c.altaClient();
                    break;
                case 4:
                    // c.modificarClient();
                    break;
                case 5:
                    // baixaClient();
                    break;
                case 6:
                    sortir = true;
                    break;
                default:
                    System.out.println("\n" + opcio + " NO ÉS UNA OPCIÓ NO VÀLIDA");
            }
        } while (!sortir);
    }

    // private void consultarClient() throws SQLException {
    //     Client c = new Client();

    //     c.consultaClient();
    // }

    // private void altaClient() throws SQLException {
    //     c.altaClient();
    // }

    // private void modificaClient() throws SQLException{
    //     c.modificarClient();
    // }

}
