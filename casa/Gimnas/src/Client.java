import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

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
    private LocalDate datanaixement;
    private String domicili;
    private int edat;

    

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getCondiciofisica() {
        return condiciofisica;
    }

    public void setCondiciofisica(String condiciofisica) {
        this.condiciofisica = condiciofisica;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public String getCCC() {
        return CCC;
    }

    public void setCCC(String cCC) {
        CCC = cCC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isComunicacio() {
        return comunicacio;
    }

    public void setComunicacio(boolean comunicacio) {
        this.comunicacio = comunicacio;
    }

    public LocalDate getDatanaixement() {
        return datanaixement;
    }

    public void setDatanaixement(LocalDate datanaixement) {
        this.datanaixement = datanaixement;
    }

    public String getDomicili() {
        return domicili;
    }

    public void setDomicili(String domicili) {
        this.domicili = domicili;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    private void calcularEdad (){
        LocalDate ara = LocalDate.now();
        this.edat = Period.between(this.datanaixement, ara).getYears();
    }

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
          this.CCC = rs.getString("ccc");

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
            dni = teclatsScanner.next();
        } while (!dniobj.valdarDni(dni));

    }

    private void cargarDatosDeSentenciaEnClient (ResultSet rs){
        this.setDni(new DNI(rs.getString("dni")));
        this.nom=new nom(rs.getString("nom"));
        this.setNom(rs.getString("nom"));
        this.setCognom1(rs.getString("cognom1"));
        this.setCognom2(rs.getString("cognom2"));
        this.email=new CorreuElectronic(rs.getString("email"));
        this.setCCC(new CompteBancari(rs.getString("telefon")));
    }




    
    





}
