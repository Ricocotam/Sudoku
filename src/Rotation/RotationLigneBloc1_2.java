package Rotation;

public class RotationLigneBloc1_2 implements IRotationGrille {

	public void rotationnons(int[][] grille) {
		int temp[] = grille[0];
		grille[0] = grille[4];
		grille[4] = temp;
		
		temp = grille[1];
		grille[1] = grille[5];
		grille[5] = temp;
		
		temp = grille[2];
		grille[2] = grille[6];
		grille[6] = temp;
	}
	public RotationLigneBloc1_2(){}
}
