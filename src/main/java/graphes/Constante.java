package graphes;

import visiteurs.Visiteur;

public class Constante implements Noeud{
	private int valeur;
	public Constante(int v){
		valeur = v;
	}
	public int getValeur(){return valeur;}


	public void accept(Visiteur visiteur) {
		visiteur.visiterConstante(this);
	}
}
