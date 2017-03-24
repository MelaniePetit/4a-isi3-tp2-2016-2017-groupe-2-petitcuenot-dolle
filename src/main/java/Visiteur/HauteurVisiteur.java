package Visiteur;

import Graph.Addition;
import Graph.Constante;
import Graph.Multiplication;
import Graph.Negation;

/**
 * Created by jeremy on 24/03/2017.
 */
public class HauteurVisiteur extends DefautVisiteur {

    private int hauteur = 0;
    private int hauteurMax = 0;

    public void visiterNegation(Negation negation) {
        hauteur ++;
        negation.getOpG().accept(this);
        hauteur --;
    }

    public void visiterAddition(Addition addition) {
        hauteur ++;
        addition.getOpG().accept(this);
        addition.getOpD().accept(this);
        hauteur --;
    }

    public void visiterMultiplication(Multiplication multiplication) {
        hauteur++;
        multiplication.getOpG().accept(this);
        multiplication.getOpD().accept(this);
        hauteur --;
    }

    public void visiterConstante(Constante constante) {
        hauteur++;
        if (hauteurMax<hauteur)
            hauteurMax = hauteur;
        hauteur--;
    }

    public int getHauteurMax() {
        return hauteurMax;
    }
}
