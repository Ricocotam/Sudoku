package Rotation;

public class RotationLigne1_2 implements IRotationGrille{

	public void rotationnons(int[][] grille) {
		int temp[] = grille[0];
		grille[0] = grille[1];
		grille[1] = temp;
	}
	public RotationLigne1_2(){}
}
