package Visiteur;

import Graph.*;

/**
 *
 * Created by jeremy on 22/03/2017.
 */
public class InfixeVisiteur extends DefautVisiteur {

    public void visiterOperateurUnaire(OperateurUnaire operateurUnaire) {
        operateurUnaire.getOpG().accept(this);
        System.out.println(operateurUnaire.getOp());
    }

    public void visiterOperateurBinaire(OperateurBinaire operateurBinaire) {
        operateurBinaire.getOpG().accept(this);
        System.out.println(operateurBinaire.getOp());
        operateurBinaire.getOpD().accept(this);
    }
}
