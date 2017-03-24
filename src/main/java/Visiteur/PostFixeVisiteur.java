package Visiteur;

import Graph.*;

/**
 *
 * Created by jeremy on 22/03/2017.
 */
public class PostFixeVisiteur extends DefautVisiteur {

    public void visiterOperateurUnaire(OperateurUnaire operateurUnaire) {
        operateurUnaire.getOpG().accept(this);
        System.out.print(operateurUnaire.getOp());
    }

    public void visiterOperateurBinaire(OperateurBinaire operateurBinaire) {
        operateurBinaire.getOpG().accept(this);
        operateurBinaire.getOpD().accept(this);
        System.out.print(operateurBinaire.getOp());
    }
}
