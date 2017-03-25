package Graph;

public abstract class OperateurBinaire  extends OperateurUnaire{

	private Noeud opD;
	private int priorite;
	
	public OperateurBinaire(String s,Noeud ng,Noeud nd){
		super(s,ng);
		opD=nd;
	}

	public OperateurBinaire(String s, Noeud n, Noeud opD, int priorite) {
		super(s, n);
		this.opD = opD;
		this.priorite = priorite;
	}

	public int getPriorite() {
		return priorite;
	}

	public Noeud getOpD(){
		return opD;
	}

}
