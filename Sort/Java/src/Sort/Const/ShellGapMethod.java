package Sort.Const;

import Sort.ShellGapMethodFunc.*;

public enum ShellGapMethod {
	SHELL(0, "Shell, 1959", new Shell() ),	
	FRANK_LAZARUS(1, "Frank & Lazarus, 1960", new FrankLazarus() ),
	HIBBARD(2, "Hibbard, 1963", new Hibbard() ),
	PAPERNOV_STASEVICH(3, "Papernov & Stasevich, 1965", new PaprrnovStasevich() ),
	SEDGEWICK(4, "Sedgewick, 1982", new Sedgewick() ),
	KNUTH(5, "Knuth, 1973", new Knuth() ),
	PRATT(6, "Pratt, 1971", new Pratt() ),
	;
	
	private int id;
	private String name;
	ShellGapMethodFunc method;
	
	ShellGapMethod(final int id, final String name, ShellGapMethodFunc method) {
		this.id = id;
		this.name = name;
		this.method = method;
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
	
	public int init(final int length) {
		return method.init(length);
	}
	
	public int next() {
		return method.next();
	}
}
