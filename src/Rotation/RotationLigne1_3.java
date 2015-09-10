package Rotation;

public class RotationLigne1_3 implements IRotationGrille{

	public void rotationnons(int[][] grille) {
		int temp[] = grille[0];
		grille[0] = grille[2];
		grille[2] = temp;
	}
	public RotationLigne1_3(){}
}
