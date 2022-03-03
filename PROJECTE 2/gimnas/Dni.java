package gimnas;

public class Dni {

    String dni;
    int numero;
    char lletra;

    public Dni(){
    }

    public Dni(String dni){
        if(setDni(dni)){
            this.dni=dni;
        } else{
            this.dni="incorrecte";
        }
    }

    public String getDni(){
        return dni;
    }

    public boolean setDni(String dni){
        if (validarDni(dni)){
            this.dni = dni;
            return true;
        } else {
            System.out.println("**ERROR: DNI incorrecte");
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
        if(! (calcularLletraDNI(dniNum) == lletraMajuscula)) return false;

        return true;
    }

    private boolean soloNumeros(String numero){
        for (int i=0; i<numero.length()-1; i++){
            //caracterNum = (int)dni.charAt(i);
            //if (caracterNum < 48 || caracterNum > 57){
            //if (Character.isDigit)

            if (!Character.isDigit(numero.charAt(i))){
                //if (numero.charAt(i) < '0' || numero.charAt(i) > '9'){
                    System.out.println("\nLes primeres 8 xifres han de ser numèriques");
                    return false;
            }

        }
        return true;
    }


    private char calcularLletraDNI(String dniNum) {
        char[] asignacionLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = 0;
        char miLetra = ' ';

        // pasar miNumero a integer para poder aplicar la operacion de enteros % (resto)
        //resto = miDni % 23;
        resto = Integer.parseInt(dniNum) % 23;

        miLetra = asignacionLetra[resto];

        return miLetra;
    }




















    // public boolean validacioDNI(String dni) {
    // this.dni = dni;
    // validar(dni);
    // soloNumeros();
    // letraDNI();
    // }

    // public boolean validar(String dni) {

    // String letraMayuscula = ""; // Guardaremos la letra introducida en formato
    // mayúscula

    // // Aquí excluimos cadenas distintas a 9 caracteres que debe tener un dni y
    // // también si el último caracter no es una letra
    // if (dni.length() != 9 || Character.isLetter(this.dni.charAt(8)) == false) {
    // boolean llargada=false;
    // System.out.println(llargada);
    // }

    // // Al superar la primera restricción, la letra la pasamos a mayúscula
    // letraMayuscula = (this.dni.substring(8)).toUpperCase();

    // // Por último validamos que sólo tengo 8 dígitos entre los 8 primeros
    // caracteres
    // // y que la letra introducida es igual a la de la ecuación
    // // Llamamos a los métodos privados de la clase soloNumeros() y letraDNI()

    // if (soloNumeros(dni) == true && letraDNI(dni).equals(letraMayuscula)) {
    // return true;
    // } else {
    // return false;
    // }
    // }

    // public boolean soloNumeros(String dni) {

    // int i, j = 0;
    // String numero = ""; // Es el número que se comprueba uno a uno por si hay
    // alguna letra entre los 8
    // // primeros dígitos
    // String miDNI = ""; // Guardamos en una cadena los números para después
    // calcular la letra
    // String[] unoNueve = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    // for (i = 0; i < this.dni.length() - 1; i++) {
    // numero = this.dni.substring(i, i + 1);

    // for (j = 0; j < unoNueve.length; j++) {
    // if (numero.equals(unoNueve[j])) {
    // miDNI += unoNueve[j];
    // }
    // }
    // }

    // if (miDNI.length() != 8) {
    // return false;
    // } else {
    // return true;
    // }
    // }

    // public String letraDNI(String dni) {
    // // El método es privado porque lo voy a usar internamente en esta clase, no
    // se
    // // necesita fuera de ella

    // // pasar miNumero a integer
    // int miDNI = Integer.parseInt(this.dni.substring(0, 8));
    // int resto = 0;
    // String miLetra = "";
    // String[] asignacionLetra = { "T", "R", "W", "A", "G", "M", "Y", "F", "P",
    // "D", "X", "B", "N", "J", "Z", "S",
    // "Q", "V", "H", "L", "C", "K", "E" };

    // resto = miDNI % 23;

    // miLetra = asignacionLetra[resto];

    // return miLetra;
    // }

}
