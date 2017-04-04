package visiteurs;

import graphes.*;

/**
 * Created by jeremy on 22/03/2017.
 */
public interface Visiteur {

    void visiterNegation(Negation negation);

    void visiterAddition(Addition addition);

    void visiterMultiplication(Multiplication multiplication);

    void visiterConstante(Constante constante);

}
