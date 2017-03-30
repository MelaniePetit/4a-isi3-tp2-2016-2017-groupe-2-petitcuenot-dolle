# ISI 3 TP N°2 : Arbre et Design Pattern visiteur.visiteur
Antoine Caron, Victor Lequay, Laëtitia Matignon

>Le rapport est à saisir dans le ficher [RAPPORT.md](RAPPORT.md) en utilisant le [formalisme MarkDown](https://guides.github.com/features/mastering-markdown/)

On souhaite développer un ensemble de classes permettant d’effectuer des opérations (évaluation, affichage selon différents parcours, ...) sur des expressions arithmétiques. 
On se restreindra ici aux opérations habituelles de l’arithmétique sur les entiers à savoir l’addition, la multiplication, la soustraction et l’inverse du signe. 
Une expression arithmétique que l’on considérera par exemple sera 1 + 2 × 3 + (−4).

Les constituants de l’expression peuvent être : 
* des opérateurs binaires comme +et × 
* des opérateurs unaires comme −
* des constantes qui sont des entiers.

Pour représenter une expression arithmétique, on peut utiliser un arbre binaire (arbre dont chaque noeud a un maximum de deux fils). 
Par exemple, l’expression arithmétique 1 + 2 × 3 + (−4) peut être représentée par l’arbre de la figure 1.

![expression](images/0001.jpg)

On souhaite appliquer un ensemble d’opérations sur tous les éléments d’une expression arithmétique. Les implémentations de chaque opération seront spécifiques à chaque élément. 
Pour réaliser cela, on va utiliser le *design pattern visiteur.visiteur*. 
Ce pattern va permettre d’encapsuler les différentes opérations de traitement en dehors des classes spécifiques aux éléments et ainsi d’apporter de la souplesse pour l’ajout de nouvelles opérations.

![diagramme classe](images/diagclasseb.png)

#### Question 1

Complétez le diagramme de classe proposé de sorte à pouvoir appliquer le patron de conception *visiteur.visiteur*. 
En particulier, une interface **visiteur.visiteur** permettra de visiter tous les éléments de l’arbre.

#### Question 2

Complétez ce code avec les modifications proposés à la question précédente.

L’objectif est maintenant de définir différents Visiteurs. **Vous ne devez normalement plus toucher au code de l’arbre binaire.**
Les noeuds d’un arbre binaire peuvent être parcourus de différentes façons :
* Le parcours infixe parcourt d’abord la partie à gauche du noeud, le noeud lui-même et ensuite la partie à droite du noeud. Le parcours infixe de notre exemple
donne : 1+2×3+(−4)
* Le parcours préfixe parcourt d’abord le noeud lui-même, ensuite la partie gauche
du noeud et ensuite sa partie droite. Le parcours préfixe de notre exemple donne : + +1×2 3−4
* Le parcours postfixe parcourt d’abord la partie gauche d’un noeud, ensuite la
partie droite du noeud et le noeud est scruté en dernier. Le parcours postfixe de notre exemple donne : 123 × +4 − +

#### Question 3

Définissez, implémentez et testez un visiteur.visiteur pour afficher une expression en notation postfixe. 
Ce type de notation permet de se passer de parenthèses.

#### Question 4

Définissez, implémentez et testez un visiteur.visiteur pour calculer la valeur d’une expression arithmétique.

La hauteur d’un arbre est la plus grande distance entre la racine de l’arbre et chacune de ses feuilles. 
Ainsi, la hauteur de 2+x est 2 et celle de 7×(2+x) est 3.

#### Question 5 

Définissez, implémentez et testez un visiteur.visiteur pour calculer la hauteur de l’arbre d’une expression.

#### Question 6 

Définissez, implémentez et testez un visiteur.visiteur pour afficher une expression en notation infixe. 
Il sera ici nécessaire d’utiliser des parenthèses si la priorité d’un nœud (en fait, celle de l’opérateur associé à ce nœud) est plus faible que la priorité du père de ce nœud (par exemple 7×(2+x)). 
Le code de l’arbre binaire pourra être modifié pour cette question.
