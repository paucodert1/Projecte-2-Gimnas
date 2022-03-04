package gimnas;

import java.sql.Connection;
import java.sql.SQLException;

public class GimnasApp {

    public static void main(String[] args) throws SQLException {
        Gimnas g = new Gimnas();
        
        try {
            // connexioBD();
            g.gestionarGimnas();
        } catch (SQLException ex) {
            System.out.println("Hi ha hagut un problema amb la BD");
            ex.printStackTrace();
        } catch (Exception e) {
            System.out.println("Hi ha hagut un problema amb l'aplicació");
            e.printStackTrace();
        } 

    }

    // public static void connexioBD() throws SQLException {
    //     Connexio con = new Connexio();

    //     con.connectarBD();
    // }
}