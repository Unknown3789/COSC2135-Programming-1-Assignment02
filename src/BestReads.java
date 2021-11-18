public class BestReads {
	//Declared classes for OOP.
	private BackEnd backEnd;
	private FrontEndConsole uiConsole;
	//Constructors
	public BestReads() {
		//Initialised classes for OOP. 
		this.backEnd = new BackEnd();
		this.uiConsole = new FrontEndConsole(this.backEnd);
	}// main Method, where your program will be called from.
	public static void main(String[] args) throws Exception {
		BestReads app = new BestReads();
	}
}