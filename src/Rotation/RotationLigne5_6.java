package Rotation;

public class RotationLigne5_6 implements IRotationGrille {

	public void rotationnons(int[][] grille) {
		int temp[] = grille[4];
		grille[4] = grille[5];
		grille[5] = temp;

	}
	public RotationLigne5_6(){}
}
