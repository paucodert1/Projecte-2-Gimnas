package gimnas;

import java.math.BigInteger;

public class CompteBancari {
    private String CCC;

    public CompteBancari() {

    }

    public CompteBancari(String CCC) {
        this.CCC = CCC;
    }

    public String getCCC() {
        return CCC;
    }

    public boolean setCCC(String CCC) {
        if (validarCompte(CCC)) {
            this.CCC = CCC;
            return true;
        } else {
            return false;
        }
    }

    public boolean validarCompte(String CCC) {
        boolean esValid = false;
        int i = 2;
        int caracterASCII = 0;
        int resto = 0;
        int dc = 0;
        String cadenaDc = "";
        BigInteger cuentaNumero = new BigInteger("0");
        BigInteger modo = new BigInteger("97");

        if(CCC.length() == 24 && CCC.substring(0,1).toUpperCase().equals("E") && CCC.substring(1,2).toUpperCase().equals("S"){
            do{
                caracterASCII = CCC.codePointAt(i);
                esValid = (caracterASCII > 47 && caracterASCII > 58);
            }
        }

    }

}
