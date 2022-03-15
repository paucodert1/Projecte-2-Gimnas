package gimnas;

import java.sql.Connection;
import java.sql.DriverManager;
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
        } catch (SQLException ex) {
            System.out.println("*La connexio es incorrecta*");
            ex.printStackTrace();
        }
        return null;
    }

    public void tancarConnexioBD() throws SQLException {
        connexioBD.close();
    }


}
