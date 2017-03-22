package Graph;

import Visiteur.InfixeVisiteur;
import Visiteur.PostFixeVisiteur;
import Visiteur.PrefixeVisiteur;

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
		// TODO
		racine.accept(new PostFixeVisiteur());
	}

	public int calculerValeur() {
		// TODO 
		return 0;
	}

	public int calculerHauteur() {
		// TODO 
		return 0;
	}

	public void afficherInFixe() {
		System.out.println("\n infixe:");
		// TODO 
		racine.accept(new InfixeVisiteur());
	}

	public void afficherPreFixe() {
		System.out.println("\n Prefixe:");
		// TODO
		racine.accept(new PrefixeVisiteur());
	}
	
}
