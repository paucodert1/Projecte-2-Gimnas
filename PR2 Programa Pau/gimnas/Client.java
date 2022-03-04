package gimnas;

import java.util.Scanner;

import javax.management.Query;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Client {

    private Dni dni;
    private String nom;
    private String cognom1;
    private String cognom2;
    private LocalDate datanaixement;
    private int edat;
    private CorreuElectronic email;
    private String condicioFisica;
    private String sexe;

    private Telefon telefon;
    private CompteBancari CCC;

    private int numReserves;

    private ArrayList<Client> clients;
    
    public Client() {
        this.dni = new Dni();
        this.email = new CorreuElectronic();
        this.telefon = new Telefon();
        this.CCC = new CompteBancari();
        this.datanaixement = LocalDate.now();
        // this.domicili = domicili;
    }

    public Client(String dni) {
        this.dni = new Dni();
        this.email = new CorreuElectronic();
        this.telefon = new Telefon();
        this.CCC = new CompteBancari();
        this.datanaixement = LocalDate.now();
        // this.domicili = domicili;
    }

    public void setDni(Dni dni) {
        this.dni = dni;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public void setDatanaixement(LocalDate datanaixement) {
        this.datanaixement = datanaixement;
    }

    public void setEmail(CorreuElectronic email) {
        this.email = email;
    }

    public void setCondicioFisica(String condicioFisica) {
        this.condicioFisica = condicioFisica;
    }

    public void setTelefon(Telefon telefon) {
        this.telefon = telefon;
    }

    public void setCCC(CompteBancari cCC) {
        CCC = cCC;
    }

    // public void setDomicili(String domicili) {
    //     // this.domicili = domicili;
    // }


    private void calcularEdad(){
        LocalDate ara = LocalDate.now();
        this.edat = Period.between(this.datanaixement, ara).getYears();
    }


    public void consultarClient() throws SQLException {
        Scanner teclat = new Scanner(System.in);

        System.out.println("*** CONSULTAR LES DADES D'UN CLIENT ***");
        System.out.println("Introdueix el DNI del client que vols consultar: ");

        String dni = teclat.next();

        Client cl1 = consultaClientBD(dni);

        if (cl1 != null) {
            System.out.println(cl1);
        } else {
            System.out.println("\n*ERROR: El client amb dni: " + dni + " no existeix a la base de dades.");
        }

    }

    private Client consultaClientBD(String dni) throws SQLException {

        Connexio con = new Connexio();
        Connection conexio= con.connectarBD();

        String consulta = "SELECT * FROM clients WHERE dni = ?";
        PreparedStatement sentencia = conexio.prepareStatement(consulta);

        sentencia.setString(1, dni);

        ResultSet rs = sentencia.executeQuery();

        if (rs.next()) {
            Client cli = new Client();
            cargarDadesSentenciaClient(rs);
            // this.dni = rs.getString("dni");
            // this.nom = rs.getString("nom");
            // this.cognom1 = rs.getString("cognom1");
            // this.cognom2 = rs.getString("cognom2");
            // this.datanaixement = rs.getDate("datanaixement").toLocalDate();
            // this.email = rs.getString("email");
            // this.domicili = rs.getString("domicili");
            // this.telefon = rs.getString("telefon");
            // this.condicioFisica = rs.getString("condiciofisica");
            // this.CCC = rs.getString("ccc");

            System.out.println("______________________________________________");
            System.out.println("|   DNI: " + dni);
            System.out.print("|   Nom: " + nom + " ");
            System.out.println(cognom1 + " " + cognom2);
            System.out.println("|   Data de naixement: " + datanaixement);
            System.out.println("|   Email: " + email);
            // System.out.println("|   Domicili: " + domicili);
            System.out.println("|   Telèfon: " + telefon);
            System.out.println("|   Condició física: " + condicioFisica);
            System.out.println("|   Compte bancari: " + CCC);
            System.out.println("|_____________________________________________");

            clients.add(cli);
        }

        con.tancarConnexioBD();
        return null;
    }

    public void altaClient() throws SQLException {
        Scanner teclat = new Scanner(System.in);
        Connexio con = new Connexio();

        con.connectarBD();

        System.out.println("*Donar d'alta un client*");

        String dni;
        Dni dniobj = new Dni();
        // boolean dniCorrecte() = false;
        // String dni;
        do {
            System.out.println("Introdueix el DNI del client que vols donar d'alta: ");
            dni = teclat.next();

        } while (!dniobj.validarDni(dni));
        // fiquem el dni en l' objecte dni
        dniobj.setDni(dni);

        // un cop validat el dni,l' assignem a l' atribut dni del objecte Client
        setDni(dniobj);

        // un cop validat el format i la lletra del dni,assignem el dni al client
        // this.dni=dniobj
        if (consultaClientBD(dniobj.getDni()) != null) {
            System.out.println("El client amb aquest DNI ja existeix");
        } else {
            // el client no existeix, solicitem dades i donem d'alta a la bdd

            System.out.println("Introdueix el Nom: ");
            this.nom = teclat.next();

            System.out.println("Introdueix el Primer cognom: ");
            this.cognom1= teclat.next();

            System.out.println("Introdueix el Segon cognom: ");
            this.cognom2 = teclat.next();

            System.out.println("Introdueix el Sexe: ");
            this.sexe = teclat.next();

            //***************** VALIDAR DATA ******************

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            boolean dataCorrecta;
            
            do{
                dataCorrecta=true;
                System.out.println("Introdueix DATA NAIXEMENT en format correcte (YYYY-MM-DD)");
                try{
                    this.datanaixement=LocalDate.parse(teclat.next(),formatter);
                }catch (Exception ex){
                    dataCorrecta=false;
                }
                }while (!dataCorrecta);
            
            // telefon

            Telefon tel = new Telefon();
            do{
                System.out.println("\nIntrodueix el telefon");
            } while(!telefon.setTelefon(teclat.next()));
            // insertem l' objecte Telefon al
            setTelefon(telefon);

            // email

            CorreuElectronic email = new CorreuElectronic();
            do{
                System.out.println("\nIntrodueix el email");
            } while (!email.setEmail(teclat.next()));
            setEmail(email);

            // CCC 
            
            CompteBancari CCC = new CompteBancari();
            do{
                System.out.println("\n Introdueix el compte bancari");
            } while (!CCC.setCCC(teclat.next()));
            setCCC(CCC);

            System.out.println("Condició física: ");
            this.condicioFisica = teclat.next();

            String clientinsert = "INSERT INTO Clients (DNI, nom, cognom1, cognom2, sexe, datanaixement, email, telefon, condiciofisica, CCC) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement sentencia = Connexio.connexioBD.prepareStatement(clientinsert);

            try {
                cargarDadesClientSentencia(sentencia);
            } catch (Exception ex) {
                throw new RuntimeException("No s'ha pogut agregar el client amb dni:\n" + this.dni.getDni(), ex);
            }

            con.tancarConnexioBD();
        }



        //

        // if (sentencia.executeUpdate() != 0) {
        // System.out.println("Client donat d'alta: " + nom + " " + cognom1);
        // } else {
        // System.out.println("***Error al donar d'alta el client " + nom + " " +
        // cognom1 + "***");
        // }

        // con.tancarConnexioBD();
    }

    public void altaClientBD() throws SQLException{
        Connexio con = new Connexio();
        Connection conexio= con.connectarBD();

        String consulta= "INSERT INTO Clients VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try{
            PreparedStatement ps = conexio.prepareStatement(consulta);
            cargarDadesClientSentencia(ps);
            ps.executeUpdate();

        } catch (Exception ex){
            System.out.println(("Alta de client incorrecta" + this));
            ex.printStackTrace();
        }
    }

    public void cargarDadesClientSentencia(PreparedStatement sentencia) throws SQLException {
        sentencia.setString(1, this.dni.getDni());
        sentencia.setString(2, this.nom);
        sentencia.setString(3, this.cognom1);
        sentencia.setString(4, this.cognom2);
        sentencia.setString(5, this.sexe);
        sentencia.setString(6, datanaixement.toString());
        sentencia.setString(7, this.email.getEmail());
        // sentencia.setString(6, this.domicili);
        sentencia.setString(8, this.telefon.getTelefon());
        sentencia.setString(9, this.condicioFisica);
        sentencia.setString(10, this.CCC.getCCC());
    }

    public void cargarDadesSentenciaClient(ResultSet rs) throws SQLException {
        this.setDni(new Dni(rs.getString("dni")));
        this.setNom(rs.getString("nom"));
        this.setCognom1(rs.getString("cognom1"));
        this.setCognom2(rs.getString("cognom2"));
        this.setDatanaixement(rs.getDate("datanaixement").toLocalDate());
        this.setEmail(new CorreuElectronic(rs.getString("email")));
        // this.email = (new CorreuElectronic(rs.getString("email")));
        // this.setDomicili(rs.getString("domicili"));
        this.setTelefon(new Telefon(rs.getString("telefon")));
        this.setCondicioFisica(rs.getString("condicioFisica"));
        this.setCCC(new CompteBancari(rs.getString("CCC")));

        calcularEdad();

    }

    // public ArrayList<Client> getClientsOrdenatsCognoms() throws SQLException{
    // ArrayList<Client> clients = new ArrayList<>();
    // Connexio con = new Connexio();

    // con.connectarBD();
    // }

    public void visualitzarClients() throws SQLException {
        Scanner teclat = new Scanner(System.in);
        boolean sortir = false;
        System.out.println("Visualitzar tots els clients");
        do {
            System.out.println("\nSELECCIONA EL CRITERI DE ORDENACIÓ\n");
            System.out.println("1. Ordenats per cognoms");
            System.out.println("2. Ordenats per edat del client i visualitzant l'edat");
            System.out.println("3. Ordenats per més reserves fetes fins el moment actual");
            System.out.println("4. Sortir");
            System.out.println("\nTRIA UNA OPCIÓ:");

            int opcio = teclat.nextInt();

            switch (opcio) {
                case 1:
                    ordenarCognom();
                    break;
                case 2:
                    // ordenarEdat();
                    break;
                case 3:
                    ordenarReserves();
                    break;
                case 4:
                    sortir = true;
                    break;
                default:
                    System.out.println("\n" + opcio + " NO ÉS UNA OPCIÓ NO VÀLIDA");
            }
        } while (!sortir);
    }

    public void ordenarCognom() throws SQLException {
        Connexio con = new Connexio();

        con.connectarBD();

        String consulta = "SELECT * FROM clients ORDER BY cognom1, cognom2;";
        PreparedStatement ps = Connexio.connexioBD.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();

        System.out.println("Llista de tots els clients ordenats per cognom: ");

        while (rs.next()) {
            System.out.print("DNI: " + rs.getString("dni") + " ");
            System.out.print("Nom: " + rs.getString("nom") + " ");
            System.out.print("Cognoms: " + rs.getString("cognom1") + " " + rs.getString("cognom2") + " ");
            System.out.print("Telefon: " + rs.getInt("telefon") + " ");
            System.out.print("Condició física: " + rs.getString("condiciofisica") + " \n");
        }

        con.tancarConnexioBD();
    }

    public void ordenarReserves() throws SQLException{
        Connexio con = new Connexio();
        Connection conexio = con.connectarBD();

        String consulta = "SELECT count(*) as num_reserves, R.dni , C.nom, C.cognom1 FROM realitzacio R, Clients C WHERE R.data is not null AND R.DNI=C.DNI GROUP BY DNI order by count(*) desc,DNI;";
        PreparedStatement ps = conexio.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();

        System.out.println("Enseya els client amb el numero de reserves totals: ");

        try{
            while (rs.next()){
                System.out.print("\nDNI: " + rs.getString("R.dni") + " ");
                System.out.print("Nom: " + rs.getString("nom") + " ");
                System.out.print("Cognoms: " + rs.getString("cognom1") + " ");
                System.out.print("Num reserves: " + rs.getString("num_reserves") + " ");
            }
        } catch (Exception ex){
            System.out.println("No s' ha pogut mostrar");
            ex.printStackTrace();
        }
    }























    // static void modificarClient() throws SQLException {
    // Scanner teclat = new Scanner(System.in);
    // System.out.println("__________________________________________");
    // System.out.println(" MODIFICAR DADES CLIENT ");
    // System.out.println("");

    // System.out.println("\nIntrodueixi el DNI del client a modificar");
    // String dni = teclat.nextLine();

    // System.out.println("\nNou telèfon: ");
    // String telefon = teclat.nextLine();

    // System.out.println("\nCondició física: ");
    // String condiciofisica = teclat.nextLine();

    // String modifica = "UPDATE clients SET telefon = ?, condiciofisica= ? WHERE
    // dni = ?";
    // PreparedStatement sentencia = null;

    // try {
    // sentencia = Connexio.connexioBD.prepareStatement(modifica);
    // sentencia.setString(3, dni);
    // sentencia.setString(1, telefon);
    // sentencia.setString(2, condiciofisica);
    // sentencia.executeUpdate();
    // System.out.println("\nS'han modificat correctament les dades del client amb
    // DNI: " + dni);
    // } catch (SQLException sqle) {
    // sqle.printStackTrace();
    // System.out.println("\n*Hi ha hagut un error al modificar les dades del
    // client: " + dni);
    // } finally {
    // if (sentencia != null)
    // try {
    // sentencia.close();
    // } catch (SQLException sqle) {
    // sqle.printStackTrace();
    // }
    // }
    // }

}
