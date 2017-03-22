package Graph;

import Visiteur.Visiteur;

public class Multiplication extends OperateurBinaire{

	public Multiplication( Noeud ng, Noeud nd) {
		super("*", ng, nd);
	}


	public void accept(Visiteur visiteur) {
		visiteur.visiterMultiplication(this);
	}
}
