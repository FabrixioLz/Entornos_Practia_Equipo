package modelo;

public class Usuario {
	private String user;
	public enum Roll{TRABAJADOR, GERENTE}
	private Roll roll;
	private String pass;
	
	public Usuario(String user, Roll roll, String pass) {
		this.user = user;
		this.roll = roll;
		this.pass = pass;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Roll getRoll() {
		return roll;
	}

	public void setRoll(Roll roll) {
		this.roll = roll;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
