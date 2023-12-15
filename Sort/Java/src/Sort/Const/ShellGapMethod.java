package Sort.Const;

public enum ShellGapMethod {
	SHELL(0, "Shell, 1959"),	
	FRANK_LAZARUS(1, "Frank & Lazarus, 1960"),
	HIBBARD(2, "Hibbard, 1963"),
	PAPERNOV_STASEVICH(3, "Papernov & Stasevich, 1965"),
	SEDGEWICK(4, "Sedgewick, 1982"),
	KNUTH(5, "Knuth, 1973"),
	;
	
	private int id;
	private String name;
	
	ShellGapMethod(final int id, final String name) {
		this.id = id;
		this.name = name;
	}

	public int getInt() {
		return id;
	}

	public String toStr() {
		return name;
	}

	public static ShellGapMethod valueOf(final int id) {
		for (ShellGapMethod m : values()) {
			if (m.getInt() == id) {
				return m;
			}
		}
		return SHELL;
	}
}
