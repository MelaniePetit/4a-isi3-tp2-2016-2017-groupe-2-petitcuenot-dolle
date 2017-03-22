package Visiteur;

import Graph.*;

/**
 * Created by jeremy on 22/03/2017.
 */
public interface Visiteur {

    void visiterNegation(Negation negation);

    void visiterAddition(Addition addition);

    void visiterMultiplication(Multiplication multiplication);

    void visiterConstante(Constante constante);

    void visiterOperateurUnaire(OperateurUnaire operateurUnaire);

    void visiterOperateurBinaire(OperateurBinaire operateurBinaire);
}
