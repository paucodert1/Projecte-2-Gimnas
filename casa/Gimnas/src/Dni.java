public class Dni {

    private String dni;
    // private int numero;
    // private char lletra;

    public class Dni(){

    }

    public Dni (String dni){
        if (setDni(dni)this.dni=dni;
        else this.dni="incorrecte";
    }

    public String getDni() {
        return dni;
    }

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
        return false;

    }

    public DNI(String dni) {
        this.dni = dni;
    }

    
    
    
}
