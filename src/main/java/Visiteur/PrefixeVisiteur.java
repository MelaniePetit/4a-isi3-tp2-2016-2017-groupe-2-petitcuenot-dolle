package Visiteur;

import Graph.*;

/**
 *
 * Created by jeremy on 22/03/2017.
 */
public class PrefixeVisiteur extends DefautVisiteur {

    public void visiterOperateurUnaire(OperateurUnaire operateurUnaire) {
        System.out.println(operateurUnaire.getOp());
        operateurUnaire.getOpG().accept(this);
    }

    public void visiterOperateurBinaire(OperateurBinaire operateurBinaire) {
        System.out.println(operateurBinaire.getOp());
        operateurBinaire.getOpG().accept(this);
        operateurBinaire.getOpD().accept(this);
    }
}
