package Visiteur;

import Graph.*;

/**
 *
 * Created by jeremy on 24/03/2017.
 */
public class ValeurVisiteur extends DefautVisiteur{
    private StringBuilder stringBuilder = new StringBuilder();

    public void visiterNegation(Negation negation) {
        stringBuilder.append("(-");
        negation.getOpG().accept(this);
        stringBuilder.append(")");
    }

    public void visiterAddition(Addition addition) {
        Noeud opG = addition.getOpG();
        Noeud opD = addition.getOpD();
        opG.accept(this);
        stringBuilder.append("+");
        opD.accept(this);
    }

    public void visiterMultiplication(Multiplication multiplication) {
        Noeud opG = multiplication.getOpG();
        Noeud opD = multiplication.getOpD();
        opG.accept(this);
        stringBuilder.append("*");
        opD.accept(this);
    }

    public void visiterConstante(Constante constante) {
        stringBuilder.append(constante.getValeur());
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }
}
