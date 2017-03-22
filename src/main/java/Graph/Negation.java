package Graph;

import Visiteur.Visiteur;

public class Negation extends OperateurUnaire{
	public Negation(Noeud n) {
		super("-", n);
	}

	public void accept(Visiteur visiteur) {
		visiteur.visiterNegation(this);
	}
}
