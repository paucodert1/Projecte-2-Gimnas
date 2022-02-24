import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import java.sql.SQLException;

public class Client {

    private String DNI;
    private String condiciofisica;
    private String nom;
    private String cognom1;
    private String telefon;
    private String cognom2;
    private String CCC;
    private String email;
    private boolean comunicacio;
    private String datanaixement;
    private String domicili;

    public void consultarClient() throws SQLException{
        Scanner teclat = new Scanner(System.in);

        System.out.println("**CONSULTEM LE DADES DE EL CLIENT**");
        System.out.println("Introdueix el DNI de el client que vols consultar");

        String dni = teclat.next();

        Client cl1 = consultaClientBD(dni);

        if(cl1 !=null){
            System.out.println(cl1);
        } else {
            System.out.println("\n * EL CLIENT NO EXISTEIX");
        }
    }

    private Client consultaClientBD(String DNI) throws SQLException{
      Connexio con = new Connexio();
      
      con.connectarBD();

      String consulta = "SELECT * FROM clients WHERE dni =?";
      PreparedStatement sentencia = Connexio.connexioBD.prepareStatement(consulta);

      sentencia.setString(1, DNI);

      ResultSet rs = sentencia.executeQuery();

      if (rs.next()){
          this.DNI= rs.getString("dni");
          this.nom= rs.getString("nom");
          this.cognom1= rs.getString("cognom1");
          this.cognom2= rs.getString("cognom2");
          this.datanaixement = rs.getString("datanaixement");
          this.email= rs.getString("email");
          this.domicili= rs.getString("domicili");
          this.telefon= rs.getString("telefon");
          this.condiciofisica= rs.getString("condiciofisica");
          this.CCC rs.getString("ccc");

          System.out.println("_______________________________________");
          System.out.println("| DNI: " + DNI);
          System.out.print("| Nom: " + nom + " ");
          System.out.println(cognom1 + " " + cognom2);
          System.out.println("|  Data de naixement: " + datanaixement);
          System.out.println("|  Email: " + email);
          System.out.println("|  Domicili: " + domicili);
          System.out.println("|  Telefon: " + telefon);
          System.out.println("|  Condicio Fisica: " + condiciofisica);
          System.out.println("|  CCC: " + CCC);
          System.out.println("|_________________________________________");

          return this;

      }

      con.desconnectarBD();
      return null;

    } 

    public void altaClient(){

        Scanner teclatsScanner = new Scanner(System.in);
        Connexio con = new Connexio();

        System.out.println("Donar de alta a un client");

        DNI dniobj = new DNI();
        boolean dniCorrecte()= false;
        String dni;

        do{
            System.out.println("Introdueix el DNI de el client que vols donar de alta: ");
            dni = teclat.next();
        } while (!dniobj.valdarDni(dni));

        // System.out.println("Dni: ");
        // String dni = teclatsScanner.nextLine();

        // System.out.println("Nom: ");
        // String nom = teclatsScanner.nextLine();

        // System.out.println("Cognom1: ");
        // String cognom1 = teclatsScanner.nextLine();

        // System.out.println("Cognom2: ");
        // String cognom2 = teclatsScanner.nextLine();

        // System.out.println("Data de naixement: ");
        // String datanaixement = teclatsScanner.nextLine();

        // System.out.println("Edat: ");
        // Int edat = teclatsScanner.nextInt();

        // System.out.println("STOCK: ");
        // String stock = teclatsScanner.nextLine();

        // System.out.println("Codi_porta: ");
        // String codi_porta = teclatsScanner.nextLine();

        // String consulta = "INSERT INTO clients (DNI,NOM,COGNOM1,COGNOM2,DATANAIXEMENT,EDAT,EMAIL,DOMICILI,TELEFON,CONDICIOFISICA) VALUES (?,?,?,?,?,?,?,?)";

        // ConnexioDB CDBA = new ConnexioDB();

        // PreparedStatement sentencia = CDBA.connexioBD();.prepareStatement(consulta);

        // sentencia.setString(1, dni);
        // sentencia.setString(2, nom);
        // sentencia.setString(3, cognom1);
        // sentencia.setString(4, cognom2);
        // sentencia.setString(5, datanaixement);
        // sentencia.setInt(6, edat);
        // sentencia.setString(7, email);
        // sentencia.setString(8, domicili);
        // sentencia.setString(9, telefon);
        // sentencia.setString(10, condiciofisica);
        // if (sentencia.executeUpdate() !=0){
        //     System.out.println("Producte donat d' alta");

        // }else{
        //     System.out.println("Error al donar d' alta el producte");
        // }

    }


    
    





}
