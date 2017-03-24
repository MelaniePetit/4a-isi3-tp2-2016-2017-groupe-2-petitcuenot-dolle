package Visiteur;

import Graph.*;

/**
 * Created by jeremy on 22/03/2017.
 */
public class DefautVisiteur implements Visiteur{
    public void visiterNegation(Negation negation) {
        visiterOperateurUnaire(negation);
    }

    public void visiterAddition(Addition addition) {
        visiterOperateurBinaire(addition);
    }

    public void visiterMultiplication(Multiplication multiplication) {
        visiterOperateurBinaire(multiplication);
    }

    public void visiterConstante(Constante constante) {
        System.out.print(constante.getValeur());
    }

    public void visiterOperateurUnaire(OperateurUnaire operateurUnaire) {

    }

    public void visiterOperateurBinaire(OperateurBinaire operateurBinaire) {

    }

}
