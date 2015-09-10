package Rotation;

public class RotationLigne8_9 implements IRotationGrille {

	public void rotationnons(int[][] grille) {
		int temp[] = grille[7];
		grille[7] = grille[8];
		grille[8] = temp;
	}
	public RotationLigne8_9(){}
}
