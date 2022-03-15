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
            System.out.println("No conecta la base de dades");
            ex.printStackTrace();
        }

    }
}