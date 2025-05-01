package modelo;

public class Usuario {
	private int idUsuario;
	private String user;
	public enum Roll{TRABAJADOR, GERENTE}
	private Roll roll;
	private String pass;
	
	public Usuario(int idUsuario, String user, Roll roll, String pass) {
		this.idUsuario = idUsuario;
		this.user = user;
		this.roll = roll;
		this.pass = pass;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
