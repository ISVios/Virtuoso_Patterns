package i.svoboda.programm.virtuosopatterns.bnf;

public class BNFException extends Exception{

	private static final long serialVersionUID = 1L;
	private final int posStart;
	private final int posEnd;
	private final int type;
	private final String error;

	public BNFException(int posStart, int posEnd, int type, String error) {

		this.posStart = posStart;
		this.posEnd = posEnd;
		this.type = type;
		this.error = error;

	}

	public int getStartPos() {
		return posStart;
	}

	public int getEndPos() {
		return posEnd;
	}

	public int getType() {
		return type;
	}

	public String getErorr() {
		return error;
	}
	

}
