
public class Interests {
	
	LinkedSortedList lsl;
	
	public Interests() {
		this.lsl = new LinkedSortedList();
	}
	
	public void agregarInteres(String elemento) {
		lsl.add(elemento);
	}
	
	public void imprimirIntereses() {
		lsl.printing();
	}
	

	public static void main(String[] args) {
		Interests interests = new Interests();
		interests.agregarInteres("3");
		interests.agregarInteres("2");
		interests.agregarInteres("4");
		interests.agregarInteres("6");
		interests.agregarInteres("1");
		interests.agregarInteres("2.5");
		interests.imprimirIntereses();
	}

}
