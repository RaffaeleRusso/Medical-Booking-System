package Control;



import DAO.CittadinoRegistratoDAO;
import Exception.DaoExc;

public class GestoreAutenticazione {
	
	public static GestoreAutenticazione gAut = null;

	protected GestoreAutenticazione() {
		
	}

	public static GestoreAutenticazione getInstance() { 
		
		if (gAut == null) 
			gAut = new GestoreAutenticazione(); 

		return gAut; 
	}
	
	public String login(String Username, String Password) {
		
		CittadinoRegistratoDAO crDAO = new CittadinoRegistratoDAO();
		
		try {
			
			String CodiceFiscale = new String(crDAO.readCF(Username, Password));
			return CodiceFiscale;
			
		} catch (DaoExc e) {
			
			return new String("");
		}	
	}
}
