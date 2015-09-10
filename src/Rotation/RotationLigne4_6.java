package Rotation;

public class RotationLigne4_6 implements IRotationGrille {

	public void rotationnons(int[][] grille) {
		int temp[] = grille[3];
		grille[3] = grille[5];
		grille[5] = temp;
	}


}
