package graphes;

import visiteurs.Visiteur;

public class Addition extends OperateurBinaire{
	public Addition(Noeud ng, Noeud nd) {
		super("+", ng, nd,1);
	}


	public void accept(Visiteur visiteur) {
		visiteur.visiterAddition(this);
	}
}
