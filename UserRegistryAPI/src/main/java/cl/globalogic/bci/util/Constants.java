package cl.globalogic.bci.util;

public enum Constants {

	ERROR_01("El correo ya esta registrado registrado"),
	ERROR_02("El usuario ya existe"),
	ERROR_GENERIC("Error interno"),
	REGEX_EMAIL("^(.+)@(.+)$"),
	REGEX_PASSWORD("((?=.*\\d{2})(?=.*[a-z])(?=.*[A-Z])(^[a-zA-Z0-9]{1,}$))");
	
	private final String value;
	
	Constants(String value) {
		this.value = value;
	}
	public String value() {
		return this.value;
	}

}
