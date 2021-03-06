package gimnas;

public class CorreuElectronic {
    private String email;
    //private String usuari;
    // private String organitzacio;
    // private String domini;

    public CorreuElectronic(){

    }

    public CorreuElectronic(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public boolean setEmail(String email){
        if(validarEmail(email)){
            this.email = email;
            return true;
        } else{
            return false;
        }
    }

    private boolean validarEmail(String email){
        boolean emailCorrecte = true;
        int posprimerarroba = email.indexOf('@');
        int posultimaarroba = email.lastIndexOf('@');

        if(posprimerarroba == -1){
            return false;
        } else{
            if(posprimerarroba != posultimaarroba){
                return false;
            } else{
                String local = email.substring(0, posprimerarroba);
                String domExt = email.substring(posprimerarroba + 1, email.length());
            }
        }
        return emailCorrecte;
    }

}
