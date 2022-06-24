package Entity;

public class ImpiegatoAccettazione {
	
	private int IdImpiegato;
	private String Nome;
	private String Cognome;
	private String Username;
	private String Password;

	public ImpiegatoAccettazione(int idImpiegato, String nome, String cognome, String username, String password) {
		
		super();
		IdImpiegato = idImpiegato;
		Nome = nome;
		Cognome = cognome;
		Username = username;
		Password = password;
		
	}
	
	public int getIdImpiegato() {
		
		return IdImpiegato;
		
	}

	public void setIdImpiegato(int idImpiegato) {
		
		IdImpiegato = idImpiegato;
		
	}

	public String getNome() {
		
		return Nome;
		
	}

	public void setNome(String nome) {
		
		Nome = nome;
		
	}

	public String getCognome() {
		
		return Cognome;
		
	}

	public void setCognome(String cognome) {
		
		Cognome = cognome;
		
	}

	public String getUsername() {
		
		return Username;
		
	}

	public void setUsername(String username) {
		
		Username = username;
		
	}

	public void setPassword(String password) {
		
		Password = password;
		
	}
}
