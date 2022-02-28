public class CompteBancari {

    private String CCC;
    private String IBAN;
    private int entitat;
    private int oficina;
    private int dc;
    private int numeroCompte;

    public String getCCC() {
        return CCC;
    }

    public CompteBancari(){

    }

    public CompteBancari(String cCC) {
        CCC = cCC;
    }

    public boolean setCCC(String CCC){
        if (validarCompteIBAN(CCC)){
            this.CCC=CCC;
            return true;
        } else {
            return true;
        }
    }

    
    
 
    
    
}


