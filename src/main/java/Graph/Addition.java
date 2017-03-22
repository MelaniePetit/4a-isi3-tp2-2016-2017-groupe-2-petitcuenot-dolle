package Graph;

import Visiteur.Visiteur;

public class Addition extends OperateurBinaire{
	public Addition(Noeud ng, Noeud nd) {
		super("+", ng, nd);
	}


	public void accept(Visiteur visiteur) {
		visiteur.visiterAddition(this);
	}
}
