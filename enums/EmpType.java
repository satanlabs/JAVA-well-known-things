public enum EmpType {
	
	PERMANENT(100, "Permanent"),
	INTERN(101, "Intern"),
	CONTRACT(102, "Contract");
	
	private final int value;

	private final String typePhrase;


	EmpType(int value, String typePhrase) {
		this.value = value;
		this.typePhrase = typePhrase;
	}

	public int value() {
		return this.value;
	}

	public String getTypePhrase() {
		return this.typePhrase;
	}
}
