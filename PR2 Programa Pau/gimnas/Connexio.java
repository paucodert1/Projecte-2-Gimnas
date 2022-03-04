package gimnas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connexio {

    private Connection con;

    static Connection connexioBD = null;

    static Connection connectarBD() throws SQLException {
        String servidor = "jdbc:mysql://localhost:3306/";
        String bbdd = "gimnas";
        String user = "root";
        String password = "Fat/3232";
        try {
            connexioBD = DriverManager.getConnection(servidor + bbdd, user, password);
            return connexioBD;
            // System.out.println("*Connexio amb la base de dades amb èxit*");
        } catch (SQLException ex) {
            System.out.println("*No s'ha pogut conectar amb la base de dades*");
            ex.printStackTrace();
        }
        return null;
    }

    public void tancarConnexioBD() throws SQLException {
        connexioBD.close();
    }

}
