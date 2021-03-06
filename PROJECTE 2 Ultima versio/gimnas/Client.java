package gimnas;

import java.util.Scanner;

import javax.management.Query;
import javax.management.RuntimeErrorException;

import com.mysql.cj.protocol.Resultset;

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
    }

    public Client(String dni) {
        this.dni = new Dni();
        this.email = new CorreuElectronic();
        this.telefon = new Telefon();
        this.CCC = new CompteBancari();
        this.datanaixement = LocalDate.now();
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

    public void setSexe(String sexe) {
        this.sexe = sexe;
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

    public void setNumReserves(int numReserves) {
        this.numReserves = numReserves;
    }

    /**
     * Aquest m???tode calcula del client i la assigna a l'atribut edat
     * 
     * @param ara Data actual que conseguim amb la classe LocalDate
     *            return void No retorna un resultat sino que el guarda a la edat.
     **/
    private void calcularEdad() {
        LocalDate ara = LocalDate.now();
        this.edat = Period.between(this.datanaixement, ara).getYears();
    }

    public void consultarClient() throws SQLException {
        Scanner teclat = new Scanner(System.in);

        System.out.println("*** CONSULTAR LES DADES D'UN CLIENT ***");
        System.out.println("Introdueix el DNI del client que vols consultar: ");

        String dni = teclat.next();

        Client cl1 = consultaClientBD(dni);

        if (cl1 == null) {
            System.out.println("\n*ERROR: El client amb dni: " + dni + " no existeix a la base de dades.");
        } else {
            System.out.println(cl1);
        }

    }

    private Client consultaClientBD(String dni) throws SQLException {
        Connexio con = new Connexio();
        Connection conexio = con.connectarBD();

        String consulta = "SELECT * FROM clients WHERE dni = ?";
        PreparedStatement sentencia = conexio.prepareStatement(consulta);

        sentencia.setString(1, dni);

        ResultSet rs = sentencia.executeQuery();

        if (rs.next()) {
            Client cli = new Client();
            cargarDadesSentenciaClient(rs);

            System.out.println("______________________________________________");
            System.out.println("|   DNI: " + this.dni.getDni());
            System.out.print("|   Nom: " + nom + " ");
            System.out.println(cognom1 + " " + cognom2);
            System.out.println("|   Data de naixement: " + datanaixement);
            System.out.println("|   Email: " + this.email.getEmail());
            System.out.println("|   Tel??fon: " + this.telefon.getTelefon());
            System.out.println("|   Condici?? f??sica: " + condicioFisica);
            System.out.println("|   Compte bancari: " + this.CCC.getCCC());
            System.out.println("|_____________________________________________");

            // clients.add(cli);
        }

        con.tancarConnexioBD();
        // return clients;
        return null;
    }

    public void altaClient() throws SQLException {
        Scanner teclat = new Scanner(System.in);

        System.out.println("\n*Donar d'alta un client*");

        String dni;
        Dni dniobj = new Dni();
        // boolean dniCorrecte() = false;
        // String dni;
        do {
            System.out.println("\nIntrodueix el DNI del client que vols donar d'alta: ");
            dni = teclat.next();

        } while (!dniobj.validarDni(dni));
        // fiquem el dni en l'objecte DNI
        dniobj.setDni(dni);

        // UN COP VALIDAT EL DNI L'ASSIGNEM AL ATRIBUT DNI DEL OBJECTE CLIENT
        setDni(dniobj);

        if (consultaClientBD(dniobj.getDni()) != null) {
            System.out.println("\nEl client amb aquest DNI ja existeix");
        } else {
            System.out.println("\nNom: ");
            this.nom = teclat.next();

            System.out.println("\nPrimer cognom: ");
            this.cognom1 = teclat.next();

            System.out.println("\nSegon cognom: ");
            this.cognom2 = teclat.next();

            System.out.println("\nSexe (M, H): ");
            this.sexe = teclat.next();

            System.out.println("\nCondici?? f??sica: ");
            this.condicioFisica = teclat.next();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            boolean dataCorrecta;

            do {
                dataCorrecta = true;
                System.out.println("\nIntrodueix data de naixement en format correcte(yyyy-MM-dd)");
                try {
                    this.datanaixement = LocalDate.parse(teclat.next(), formatter);
                } catch (Exception ex) {
                    dataCorrecta = false;
                }
            } while (!dataCorrecta);

            Telefon telefon = new Telefon();
            do {
                System.out.println("\nIntrodueixi el numero de tel??fon");
            } while (!telefon.setTelefon(teclat.next()));
            setTelefon(telefon);

            CorreuElectronic email = new CorreuElectronic();
            do {
                System.out.println("\nIntrodueixi el correu electr??nic");
            } while (!email.setEmail(teclat.next()));
            setEmail(email);

            CompteBancari CCC = new CompteBancari();
            do {
                System.out.println("\nIntrodueixi el compte bancari");
            } while (!CCC.setCCC(teclat.next()));
            setCCC(CCC);

            altaClientBD();

            System.out.println("El client ha sigut donat d'alta: " + this);

            // con.tancarConnexioBD();
        }

        // con.tancarConnexioBD();
    }

    private void altaClientBD() throws SQLException {
        Connexio con = new Connexio();
        Connection conexio = con.connectarBD();

        String consulta = "INSERT INTO Clients (DNI, nom, cognom1, cognom2, sexe, datanaixement, email, telefon, condiciofisica, ccc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement sentencia = conexio.prepareStatement(consulta);
            cargarDadesClientSentencia(sentencia);
            sentencia.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("**ERROR AL DONAR D'ALTA EL CLIENT AMB DNI: " + this.dni.getDni());

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
        sentencia.setString(8, this.telefon.getTelefon());
        sentencia.setString(9, this.condicioFisica);
        sentencia.setString(10, this.CCC.getCCC());
    }

    public void cargarDadesSentenciaClient(ResultSet rs) throws SQLException {
        this.setDni(new Dni(rs.getString("dni")));
        this.setNom(rs.getString("nom"));
        this.setCognom1(rs.getString("cognom1"));
        this.setCognom2(rs.getString("cognom2"));
        this.setSexe(rs.getString("sexe"));
        this.setDatanaixement(rs.getDate("datanaixement").toLocalDate());
        calcularEdad();
        this.setEmail(new CorreuElectronic(rs.getString("email")));
        this.setTelefon(new Telefon(rs.getString("telefon")));
        this.setCondicioFisica(rs.getString("condicioFisica"));
        this.setCCC(new CompteBancari(rs.getString("CCC")));

        calcularEdad();

    }

    public void visualitzarClients() throws SQLException {
        Scanner teclat = new Scanner(System.in);
        boolean sortir = false;
        System.out.println("Visualitzar tots els clients");
        do {
            System.out.println("\nSELECCIONA EL CRITERI DE ORDENACI??\n");
            System.out.println("1. Ordenats per cognoms");
            System.out.println("2. Ordenats per edat del client i visualitzant l'edat");
            System.out.println("3. Ordenats per m??s reserves fetes fins el moment actual");
            System.out.println("4. Sortir");
            System.out.println("\nTRIA UNA OPCI??:");

            while (!teclat.hasNextInt()) {
                System.out.println("El valor no ??s valid. Introdueixi un numero enter.");
                teclat.next();
            }

            int opcio = teclat.nextInt();
            Client cli = new Client();

            switch (opcio) {
                case 1:
                    this.clients = cli.ordenarCognom();
                    mostrarClients();
                    break;
                case 2:
                    this.clients = cli.ordenarEdat();
                    mostrarClients();
                    break;
                case 3:
                    this.clients = cli.ordenarReserves();
                    // mostrarClients();
                    break;
                case 4:
                    sortir = true;
                    break;
                default:
                    System.out.println("\n" + opcio + " NO ??S UNA OPCI?? NO V??LIDA");
            }
        } while (!sortir);
    }

    public ArrayList<Client> ordenarCognom() throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();

        Connexio con = new Connexio();
        Connection conexio = con.connectarBD();

        String consulta = "SELECT * FROM clients ORDER BY cognom1, cognom2, nom;";
        PreparedStatement ps = conexio.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();

        System.out.println("Llista de tots els clients ordenats per cognom: \n");

        while (rs.next()) {
            Client cli = new Client();
            cli.cargarDadesSentenciaClient(rs);
            // System.out.print("DNI: " + rs.getString("dni") + " ");
            // System.out.print("Nom: " + rs.getString("nom") + " ");
            // System.out.print("Cognoms: " + rs.getString("cognom1") + " " +
            // rs.getString("cognom2") + " ");
            // System.out.print("Telefon: " + rs.getInt("telefon") + " ");
            // System.out.print("Condici?? f??sica: " + rs.getString("condiciofisica") + "
            // \n");
            clients.add(cli);
        }

        con.tancarConnexioBD();
        return clients;
    }

    public ArrayList<Client> ordenarEdat() throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        Connexio con = new Connexio();
        Connection conexio = con.connectarBD();

        String consulta = "SELECT * FROM Clients ORDER BY datanaixement, cognom1, cognom2, nom ASC;";
        PreparedStatement ps = conexio.prepareStatement(consulta);

        ResultSet rs = ps.executeQuery();

        System.out.println("Llista de tots els clients ordenats per edat\n");

        while (rs.next()) {
            Client cli = new Client();
            cli.cargarDadesSentenciaClient(rs);

            clients.add(cli);
        }
        con.tancarConnexioBD();
        return clients;
    }

    public ArrayList<Client> ordenarReserves() throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        Connexio con = new Connexio();
        Connection conexio = con.connectarBD();

        String consulta = "SELECT count(*) as num_reserves, C.* FROM realitzacio R, Clients C WHERE R.data is not null AND R.DNI=C.DNI GROUP BY DNI order by count(*) desc, DNI;";
        PreparedStatement ps = conexio.prepareStatement(consulta);

        ResultSet rs = ps.executeQuery();

        System.out.println("Llista de tots els clients ordenats per numero de reserves totals: \n");

        while (rs.next()) {
            Client cli = new Client();
            cli.cargarDadesSentenciaClient(rs);

            cli.setNumReserves(rs.getInt("num_reserves"));
            System.out.print("\nDNI: " + rs.getString("C.DNI") + " ");
            System.out.print("Nom: " + rs.getString("nom") + " ");
            System.out.print("Cognom: " + rs.getString("cognom1") + " ");
            System.out.print("Numero de reserves: " + rs.getString("num_reserves") +
                    "\n");

            clients.add(cli);
        }
        con.tancarConnexioBD();
        return clients;

    }

    public void mostrarClients() {
        if (clients.isEmpty()) {
            System.out.println("No hi ha clients per visualitzar.");
        } else {
            for (Client client : clients) {
                System.out.println(client);
            }
        }

    }

    public void menuActDia() throws SQLException {
        Scanner teclat = new Scanner(System.in);
        boolean sortir = false;

        Connexio con = new Connexio();
        Connection conexio = con.connectarBD();

        do {
            System.out.println("______________________________________________");
            System.out.println("|     Introdueixi el dia de la setmana       |");
            System.out.println("|                                            |");
            System.out.println("|             1. Dilluns                     |");
            System.out.println("|             2. Dimarts                     |");
            System.out.println("|             3. Dimecres                    |");
            System.out.println("|             4. Dijous                      |");
            System.out.println("|             5. Divendres                   |");
            System.out.println("|             6. Sortir                      |");
            System.out.println("|____________________________________________|");
            System.out.println("\nTRIA UNA OPCI??:");

            int opcio = teclat.nextInt();

            switch (opcio) {
                case 1:
                    mostrarActivitatDelDia(opcio);
                    break;
                case 2:
                    mostrarActivitatDelDia(opcio);
                    break;
                case 3:
                    mostrarActivitatDelDia(opcio);
                    break;
                case 4:
                    mostrarActivitatDelDia(opcio);
                    break;
                case 5:
                    mostrarActivitatDelDia(opcio);
                    break;
                case 6:
                    sortir = true;
                    break;
                default:
                    System.out.println("\n" + opcio + " NO ??S UNA OPCI?? NO V??LIDA. Introdueixi un numero del 1 al 5");
            }
        } while (!sortir);

    }

    public void mostrarActivitatDelDia(int opcio) throws SQLException {
        Scanner teclat = new Scanner(System.in);

        Connexio con = new Connexio();
        Connection conexio = con.connectarBD();

        String consulta = "SELECT A.*, count(R.id_act) as num_reserves FROM Realitzacio R, Activitat A WHERE R.id_act=A.id_act AND R.data is not null GROUP BY R.id_act ORDER BY count(R.id_act) DESC;";
                PreparedStatement ps = conexio.prepareStatement(consulta);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id_act = rs.getInt("A.id_act");
            String nom = rs.getString("A.nom");
            double aforament = rs.getInt("S.aforament");
            double Percentatge = (aforament/40)*100;
            int inscripcions=rs.getInt("num_reserves");
            System.out.println("\n NOM: " + nom + " ID ACTIVITAT: " + id_act + "    PERCENTATGE D'AFORAMENT DISPONIBLE: " + Percentatge + "%" + " PERSONES INSCRITES: " + inscripcions);
        }
    }

    @Override
    public String toString() {
        return "[nom=" + nom + " " + cognom1 + " " + cognom2 + ", dni=" + this.dni.getDni() + ", edat="
                + edat + ", email=" + this.email.getEmail() + ", telefon=" + this.telefon.getTelefon()
                + "]\n";
    }

    // static void modificarClient() throws SQLException {
    // Scanner teclat = new Scanner(System.in);
    // System.out.println("__________________________________________");
    // System.out.println(" MODIFICAR DADES CLIENT ");
    // System.out.println("");

    // System.out.println("\nIntrodueixi el DNI del client a modificar");
    // String dni = teclat.nextLine();

    // System.out.println("\nNou tel??fon: ");
    // String telefon = teclat.nextLine();

    // System.out.println("\nCondici?? f??sica: ");
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
