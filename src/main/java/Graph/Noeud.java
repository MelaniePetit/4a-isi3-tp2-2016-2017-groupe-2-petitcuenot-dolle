package Graph;

import Visiteur.Visiteur;

public interface Noeud {
    abstract void accept(Visiteur visiteur);
}
