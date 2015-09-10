package Rotation;

public class RotationLigneBloc1_3 implements IRotationGrille {

	public void rotationnons(int[][] grille) {
		int temp[] = grille[0];
		grille[0] = grille[6];
		grille[6] = temp;
		
		temp = grille[1];
		grille[1] = grille[7];
		grille[7] = temp;
		
		temp = grille[2];
		grille[2] = grille[8];
		grille[8] = temp;
	}
	public RotationLigneBloc1_3(){}
}
