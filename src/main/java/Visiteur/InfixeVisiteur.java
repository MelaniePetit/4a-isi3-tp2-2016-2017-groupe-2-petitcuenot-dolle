package Visiteur;

import Graph.*;

/**
 *
 * Created by jeremy on 22/03/2017.
 */
public class InfixeVisiteur extends DefautVisiteur {

    public void visiterNegation(Negation negation) {
        System.out.print("(-");
        negation.getOpG().accept(this);
        System.out.print(")");
    }

    public void visiterAddition(Addition addition) {
        Noeud opG = addition.getOpG();
        Noeud opD = addition.getOpD();
        opG.accept(this);
        System.out.print("+");
        opD.accept(this);
    }

    public void visiterMultiplication(Multiplication multiplication) {
        Noeud opG = multiplication.getOpG();
        Noeud opD = multiplication.getOpD();
        System.out.print("(");
        opG.accept(this);
        System.out.print("*");
        opD.accept(this);
        System.out.print(")");
    }

    public void visiterConstante(Constante constante) {
        System.out.print(constante.getValeur());
    }
}
