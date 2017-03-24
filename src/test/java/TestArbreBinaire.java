import Graph.*;
import bsh.EvalError;

public class TestArbreBinaire {

	public static void main(String[] args) {
		//faire 1+2*3+-4=3
		Addition racine =   new Addition(
								new Addition(
										new Constante(1),
										new Multiplication(
												new Constante(2),
												new Constante(3)
										)
								),
								new Negation(new Constante(4))
							);

		ExpressionArithmetique exp = new ExpressionArithmetique(racine);

		exp.afficherInFixe();

		try {
			System.out.println("\n calcul valeur: " + exp.calculerValeur());
		} catch (EvalError evalError) {
			evalError.printStackTrace();
		}
		System.out.println("\n calcul hauteur: " + exp.calculerHauteur());

		exp.afficherPostFixe();

		exp.afficherPreFixe();
		
		

	}

	

}
