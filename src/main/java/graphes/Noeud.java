package graphes;

import visiteurs.Visiteur;

public interface Noeud {
    abstract void accept(Visiteur visiteur);
}
