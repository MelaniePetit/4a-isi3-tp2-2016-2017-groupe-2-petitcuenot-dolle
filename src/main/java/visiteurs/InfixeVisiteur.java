package visiteurs;

import graphes.Negation;
import graphes.OperateurBinaire;

/**
 *
 * Created by jeremy on 22/03/2017.
 */
public class InfixeVisiteur extends DefautVisiteur{

    private int priorite = 1;

    public void visiterNegation(Negation negation) {
        System.out.print("(-");
        negation.getOpG().accept(this);
        System.out.print(")");
    }

    public void visiterOperateurBinaire(OperateurBinaire operateurBinaire) {
        if (operateurBinaire.getPriorite()>=priorite) {
            priorite = operateurBinaire.getPriorite();
            operateurBinaire.getOpG().accept(this);
            System.out.print(operateurBinaire.getOp());
            operateurBinaire.getOpD().accept(this);
        }
        else {
            System.out.print("(");
            operateurBinaire.getOpG().accept(this);
            System.out.print(operateurBinaire.getOp());
            operateurBinaire.getOpD().accept(this);
            System.out.print(")");
        }
    }
}
