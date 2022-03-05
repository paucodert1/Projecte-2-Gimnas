package gimnas;

public class Telefon {

    private String telefon;

    public Telefon(String telefon) {
        if (validarMobil(telefon)) {
            this.telefon = telefon;
        }
    }

    public Telefon() {
    }

    public String getTelefon() {
        return telefon;
    }

    public boolean setTelefon(String telefon){
        if (validarMobil(telefon)){
            this.telefon = telefon;
            return true;
        } else {
            System.out.println("**ERROR: Numero de telèfon incorrecte");
            return false;
        }
    }

    private boolean validarMobil(String telefon) {
        if (telefon.length() != 9) {
            System.out.println("El telefon ha de tenir 9 digits");
            return false;
        } else {
            for(int i=0; i<telefon.length(); i++){
                if(!(telefon.charAt(i)>='0' && telefon.charAt(i)<='9')) {
                    System.out.println("Tots els digits han de ser numèrics");
                    return false;
                }
            }
        } 
        return true;
    }

}
