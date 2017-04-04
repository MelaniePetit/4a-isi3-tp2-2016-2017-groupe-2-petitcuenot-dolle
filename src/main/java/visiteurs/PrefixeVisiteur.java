package visiteurs;

import graphes.*;

/**
 *
 * Created by jeremy on 22/03/2017.
 */
public class PrefixeVisiteur extends DefautVisiteur {

    public void visiterOperateurUnaire(OperateurUnaire operateurUnaire) {
        System.out.print(operateurUnaire.getOp());
        operateurUnaire.getOpG().accept(this);
    }

    public void visiterOperateurBinaire(OperateurBinaire operateurBinaire) {
        System.out.print(operateurBinaire.getOp());
        operateurBinaire.getOpG().accept(this);
        operateurBinaire.getOpD().accept(this);
    }
}
