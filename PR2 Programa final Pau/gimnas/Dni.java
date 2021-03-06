package gimnas;

public class Dni {

    String dni;
    int numero;
    char lletra;

    public Dni() {
    }

    public Dni(String dni) {
        if (setDni(dni)) {
            this.dni = dni;
        } else {
            this.dni = "incorrecte";
        }
    }

    public String getDni() {
        return dni;
    }

    public boolean setDni(String dni) {
        if (validarDni(dni)) {
            this.dni = dni;
            return true;
        } else {
            System.out.println("DNI incorrecte");
            return false;
        }
    }


    public boolean validarDni(String dni) {

        char lletraMajuscula;

        if (dni.length() != 9) return false;

        char ultimaPos = dni.charAt(8);

        if (!(Character.isLetter(ultimaPos))) return false;

        lletraMajuscula = Character.toUpperCase(ultimaPos);

        String dniNum=dni.substring(0,8);

        if(soloNumeros(dniNum)) return false;
        if(!(calcularLletraDNI(dniNum) == lletraMajuscula)) return false;

        return true;
    }

    private boolean soloNumeros(String numero){
        for (int i=0; i<numero.length()-1; i++){
            if (!Character.isDigit(numero.charAt(i))){

                    System.out.println("\nLes primeres 8 xifres han de ser numèriques");
                    return false;
            }

        }
        return false;
    }


    private char calcularLletraDNI(String dniNum) {
        char[] asignacionLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = 0;
        char miLetra = ' ';

        resto = Integer.parseInt(dniNum) % 23;

        miLetra = asignacionLetra[resto];

        return miLetra;
    }
    

    
}
