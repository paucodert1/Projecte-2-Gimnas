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
        boolean esValido = false;
		int i = 2;
		int caracterASCII = 0; 
		int resto = 0;
		int dc = 0;
		String cadenaDc = "";
		BigInteger cuentaNumero = new BigInteger("0"); 
		BigInteger modo = new BigInteger("97");

		if(CCC.length() == 24 && CCC.substring(0,1).toUpperCase().equals("E") 
			&& CCC.substring(1,2).toUpperCase().equals("S")) {

			do {
				caracterASCII = CCC.codePointAt(i);
				esValido = (caracterASCII > 47 && caracterASCII < 58);
				i++;
			}
			while(i < CCC.length() && esValido); 
		
		
			if(esValido) {
				cuentaNumero = new BigInteger(CCC.substring(4,24) + "142800");
				resto = cuentaNumero.mod(modo).intValue();
				dc = 98 - resto;
				cadenaDc = String.valueOf(dc);
			}	
			
			if(dc < 10) {
				cadenaDc = "0" + cadenaDc;
			} 

			if(CCC.substring(2,4).equals(cadenaDc)) {
				esValido = true;
			} else {
				esValido = false;
			}
		}

		return esValido;
	}
}
