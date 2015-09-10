package Rotation;

public class RotationLigne2_3 implements IRotationGrille{

	public void rotationnons(int[][] grille) {
		int temp[] = grille[1];
		grille[1] = grille[2];
		grille[2] = temp;
	}
	public RotationLigne2_3(){}
}
