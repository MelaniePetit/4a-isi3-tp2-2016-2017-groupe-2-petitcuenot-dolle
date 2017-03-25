package Graph;

import Visiteur.*;

public class ExpressionArithmetique {
	private Noeud racine;
	
	public ExpressionArithmetique(Noeud racine){
		this.racine = racine;
	}

	public Noeud getRacine() {
		return racine;
	}

	public void afficherPostFixe() {
		System.out.println("\n postfixe:");
		racine.accept(new PostFixeVisiteur());
	}

	public int calculerValeur() {
		ValeurVisiteur valeurVisiteur = new ValeurVisiteur();
		racine.accept(valeurVisiteur);
		return valeurVisiteur.getValeur();
	}

	public int calculerHauteur() {
		HauteurVisiteur hauteurVisiteur = new HauteurVisiteur();
		racine.accept(hauteurVisiteur);
		return hauteurVisiteur.getHauteurMax();
	}

	public void afficherInFixe() {
		System.out.println("\n infixe:");
		racine.accept(new InfixeVisiteur());
	}

	public void afficherPreFixe() {
		System.out.println("\n Prefixe:");
		racine.accept(new PrefixeVisiteur());
	}
	
}
