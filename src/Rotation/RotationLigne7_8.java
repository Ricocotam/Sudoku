package Rotation;

public class RotationLigne7_8 implements IRotationGrille {

	public void rotationnons(int[][] grille) {
		int temp[] = grille[6];
		grille[6] = grille[7];
		grille[7] = temp;
	}
	public RotationLigne7_8(){}
}
