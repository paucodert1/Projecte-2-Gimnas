import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexio {

    private Connection con;

    static Connection connexioBD = null;

    static void connectarBD (){

        String servidor="jdbc:mysql://localhost:3306/";
        String bbdd="gimnas";
        String user="root";
        String password="Fat/3232";

        try {
            connexioBD = DriverManager.getConnection(servidor + bbdd, user, password);
            // System.out.println();
        } catch (SQLException ex){
            System.out.println("No s' ha pogut connectar amb la base de dades");
            ex.printStackTrace();
        }

    } 

    public void desconnectarBD() throws SQLException{
        connexioBD.close();
    }
    
}



