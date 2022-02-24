public class DNI {

    private String dni;
    private int numero;
    private char lletra;

    public boolean setDni(String dni){
        if(valdarDni(dni)){
            this.dni = dni;
            return true;
        } else {
            System.out.println("ERROR: DNI INCORECTE");
            return false;
        }
    }

    public boolean valdarDni(String dni){

        char lletraMajuscula;
    
        if(dni.length() != 9) return false;

        char ultimaPos = dni.charAt(8);

        if(!(Character.isLetter(ultimaPos))) return false;

        lletraMajuscula = Character.toUpperCase(ultimaPos);

    }
    
    
}
