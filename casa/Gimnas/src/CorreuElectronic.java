public class CorreuElectronic {

    private String email;

    public CorreuElectronic(){

    }

    public CorreuElectronic(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (validarEmail(email)){
            this.email = email;
            return true;
    
        } else {
            return false;
        }
    }

    

    
    
    
    
}
