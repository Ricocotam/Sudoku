package Rotation;

public class RotationLigne4_5 implements IRotationGrille {

	public void rotationnons(int[][] grille) {
		int temp[] = grille[3];
		grille[3] = grille[4];
		grille[4] = temp;
	}
	public RotationLigne4_5(){}
}
