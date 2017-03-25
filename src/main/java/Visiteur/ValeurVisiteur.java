package Visiteur;

import Graph.*;

/**
 *
 * Created by jeremy on 24/03/2017.
 */
public class ValeurVisiteur extends DefautVisiteur{

    private int valeur;

    public void visiterNegation(Negation negation) {
        negation.getOpG().accept(this);
        valeur *= -1;
    }

    public void visiterAddition(Addition addition) {
        addition.getOpG().accept(this);
        int valeurOpG = valeur;
        addition.getOpD().accept(this);
        int valeurOpD = valeur;
        valeur = valeurOpG + valeurOpD;
    }

    public void visiterMultiplication(Multiplication multiplication) {
        multiplication.getOpG().accept(this);
        int valeurOpG = valeur;
        multiplication.getOpD().accept(this);
        int valeurOpD = valeur;
        valeur = valeurOpG * valeurOpD;
    }

    public void visiterConstante(Constante constante) {
        valeur = constante.getValeur();
    }

    public int getValeur() {
        return valeur;
    }
}
