package Rotation;

public class RotationLigne7_9 implements IRotationGrille {

	public void rotationnons(int[][] grille) {
		int temp[] = grille[6];
		grille[6] = grille[8];
		grille[8] = temp;
	}
	public RotationLigne7_9(){}
}
