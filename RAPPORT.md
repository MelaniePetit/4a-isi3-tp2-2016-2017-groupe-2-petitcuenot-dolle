**DOLLE Jérémy**

**PETITCUENOT Mélanie**

# Rapport TP2

## Question 1

_Design Pattern Iterator :_


![uml](images/question1.png)


## Question 2

Les packages Graph et Visiteur ont été créés pour mieux organiser le code. Dans le package Graph se trouve les classes
relatives aux opérations et aux valeurs des noeuds.
    
Dans chaque classe du package Graph, la méthode _accept(Visiteur visiteur)_ a été implémentée.

_Exemple avec la classe Addition :_

	public void accept(Visiteur visiteur) {
		visiteur.visiterAddition(this);
	}

Nous avons créer la classe _DefautVisiteur_ qui implémente les méthodes communes aux classes InfixeVisiteur, PostFixeVisiteur,
et PrefixeVisiteur

    public class DefautVisiteur implements Visiteur{
        public void visiterNegation(Negation negation) {
            visiterOperateurUnaire(negation);
        }
    
        public void visiterAddition(Addition addition) {
            visiterOperateurBinaire(addition);
        }
    
        public void visiterMultiplication(Multiplication multiplication) {
            visiterOperateurBinaire(multiplication);
        }
    
        public void visiterConstante(Constante constante) {
            System.out.println(constante.getValeur());
        }
    
        public void visiterOperateurUnaire(OperateurUnaire operateurUnaire) {
    
        }
    
        public void visiterOperateurBinaire(OperateurBinaire operateurBinaire) {
    
        }
    }

Alors, il ne reste plus qu'à implementer les méthodes _visiterOperateurUnaire(OperateurUnaire operateurUnaire)_ et 
_visiterOperateurBinaire(OperateurBinaire operateurBinaire)_ dans les trois classes précédemment citées.

_InfixeVisiteur :_

    public void visiterOperateurUnaire(OperateurUnaire operateurUnaire) {
        operateurUnaire.getOpG().accept(this);
        System.out.println(operateurUnaire.getOp());
    }

    public void visiterOperateurBinaire(OperateurBinaire operateurBinaire) {
        operateurBinaire.getOpG().accept(this);
        System.out.println(operateurBinaire.getOp());
        operateurBinaire.getOpD().accept(this);
    }

_PostFixeVisiteur :_


    public void visiterOperateurUnaire(OperateurUnaire operateurUnaire) {
        operateurUnaire.getOpG().accept(this);
        System.out.println(operateurUnaire.getOp());
    }

    public void visiterOperateurBinaire(OperateurBinaire operateurBinaire) {
        operateurBinaire.getOpG().accept(this);
        operateurBinaire.getOpD().accept(this);
        System.out.println(operateurBinaire.getOp());
    }

_PrefixeVisiteur :_
    
    public void visiterOperateurUnaire(OperateurUnaire operateurUnaire) {
        System.out.println(operateurUnaire.getOp());
        operateurUnaire.getOpG().accept(this);
    }

    public void visiterOperateurBinaire(OperateurBinaire operateurBinaire) {
        System.out.println(operateurBinaire.getOp());
        operateurBinaire.getOpG().accept(this);
        operateurBinaire.getOpD().accept(this);
    }

## Question 3

Le détail des méthodes a été explicité dans les question précédentes. On rajoute seuelement le code suivant 
dans la classe _ExpressionArithmétique_ afin de lancer le processus et d'obtenir le résultat. 

	public void afficherPostFixe() {
		System.out.println("\n postfixe:");
		racine.accept(new PostFixeVisiteur());
	}

## Question 4

Pour calculer l'expression arithmétique, on crée une nouvelle classe _ValeurVisiteur_ qui va se charger du calcul.

    public class ValeurVisiteur implements Visiteur{

        private int valeur;
    
        public void visiterNegation(Negation negation) {
            negation.getOpG().accept(this);
            valeur *= -1;
        }
    
        public void visiterAddition(Addition addition) {
            addition.getOpG().accept(this);
            int valeurOpG = valeur;
            addition.getOpD().accept(this);
            int valeurOpD = valeur;
            valeur = valeurOpG + valeurOpD;
        }
    
        public void visiterMultiplication(Multiplication multiplication) {
            multiplication.getOpG().accept(this);
            int valeurOpG = valeur;
            multiplication.getOpD().accept(this);
            int valeurOpD = valeur;
            valeur = valeurOpG * valeurOpD;
        }
    
        public void visiterConstante(Constante constante) {
            valeur = constante.getValeur();
        }
    
        public int getValeur() {
            return valeur;
        }
    }

Nous avons décidé que cette classe serait implémentée par l'interface _Visiteur_. Pour ce faire, nous avons dû modifier quelque
peu notre uml ainsi que notre interface :

![uml4](images/uml-4.png)

    public interface Visiteur {

        void visiterNegation(Negation negation);
    
        void visiterAddition(Addition addition);
    
        void visiterMultiplication(Multiplication multiplication);
    
        void visiterConstante(Constante constante);

    }

## Question 5

Pour calculer la hauteur de l'arbre, nous avons créé une nouvelle classe _HauteurVisiteur_ qui est implémentée
par l'interface _Visiteur_.

    public class HauteurVisiteur implements Visiteur {
    
        private int hauteur = 0;
        private int hauteurMax = 0;
    
        public void visiterNegation(Negation negation) {
            hauteur ++;
            negation.getOpG().accept(this);
            hauteur --;
        }
    
        public void visiterAddition(Addition addition) {
            hauteur ++;
            addition.getOpG().accept(this);
            addition.getOpD().accept(this);
            hauteur --;
        }
    
        public void visiterMultiplication(Multiplication multiplication) {
            hauteur++;
            multiplication.getOpG().accept(this);
            multiplication.getOpD().accept(this);
            hauteur --;
        }
    
        public void visiterConstante(Constante constante) {
            hauteur++;
            if (hauteurMax<hauteur)
                hauteurMax = hauteur;
            hauteur--;
        }
    
        public int getHauteurMax() {
            return hauteurMax;
        }
    }
    
Ainsi la partie Visiteur de notre uml a la forme suivante :

![uml5](images/uml-5.png)
   

## Question 6

Tout d'abord, on rajoute  la notion de priorité dans la classe _OperateurBinaire_. Alors, ses classes filles héritent aussi
de cette notion. Ainsi, l'addition possède maintenant une priorité de 1 tandis que la multiplication une priorité de 2.

On crée un deuxième constructeur dans la classe _OperateurBinaire_ :

       public OperateurBinaire(String s, Noeud n, Noeud opD, int priorite) {
       		super(s, n);
       		this.opD = opD;
       		this.priorite = priorite;
       	}

On modifie les constructeurs des classes _Addition_ et _Multiplication_
       
       public Addition(Noeud ng, Noeud nd) {
            super("+", ng, nd,1);
       }
    
        
       public Multiplication( Noeud ng, Noeud nd) {
            super("*", ng, nd,2);
       }
       
Enfin, on redéfinie les méthodes de la classe _Infixe_ pour qu'elle prenne en compte les règles de priorités
et ajoute les parenthèses quand cela est nécessaire.

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
    
Ainsi la partie Visiteur finale de notre uml a la forme suivante :

![uml6](images/uml-6.png)