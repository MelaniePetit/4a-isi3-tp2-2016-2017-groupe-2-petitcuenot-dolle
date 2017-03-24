package Graph;

import Visiteur.*;
import bsh.EvalError;
import bsh.Interpreter;

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

	public int calculerValeur() throws EvalError {
		ValeurVisiteur valeurVisiteur = new ValeurVisiteur();
		racine.accept(valeurVisiteur);
		return Integer.parseInt(String.valueOf(new Interpreter().eval(valeurVisiteur.getStringBuilder().toString())));
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
