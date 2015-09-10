package Rotation;

public class RotationLigneBloc2_3 implements IRotationGrille {

	public void rotationnons(int[][] grille) {
		int temp[] = grille[4];
		grille[4] = grille[6];
		grille[6] = temp;
		
		temp = grille[5];
		grille[5] = grille[7];
		grille[7] = temp;
		
		temp = grille[6];
		grille[6] = grille[8];
		grille[8] = temp;
	}
	public RotationLigneBloc2_3(){}
	
}
