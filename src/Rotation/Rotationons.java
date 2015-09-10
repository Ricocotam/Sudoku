package Rotation;

import java.util.ArrayList;

public class Rotationons {
	
	private static boolean initialise = false;
	private static ArrayList<IRotationGrille> types = new ArrayList<IRotationGrille>();
	
	
	public static void rotationRandom(int grille[][]){
		if(!initialise)
			initialiserTypes();
		
		types.get((int)(Math.random() * /*24*/ 18 )).rotationnons(grille);
	}


	private static void initialiserTypes() {
		types.add(new RotationColonne1_2());
		types.add(new RotationColonne1_3());
		types.add(new RotationColonne2_3());
		types.add(new RotationColonne4_5());
		types.add(new RotationColonne4_6());
		types.add(new RotationColonne5_6());
		types.add(new RotationColonne7_8());
		types.add(new RotationColonne7_9());
		types.add(new RotationColonne8_9());
		types.add(new RotationLigne1_2());
		types.add(new RotationLigne1_3());
		types.add(new RotationLigne2_3());
		types.add(new RotationLigne4_5());
		types.add(new RotationLigne4_6());
		types.add(new RotationLigne5_6());
		types.add(new RotationLigne7_8());
		types.add(new RotationLigne7_9());
		types.add(new RotationLigne8_9());
		//types.add(new RotationLigneBloc1_2());
		//types.add(new RotationLigneBloc1_3());
		//types.add(new RotationLigneBloc2_3());
		//types.add(new RotationColonneBloc1_2());
		//types.add(new RotationColonneBloc1_3());
		//types.add(new RotationColonneBloc2_3());
		initialise = true;
	}
}
