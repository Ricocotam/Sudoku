package Rotation;

public class RotationColonne5_6 implements IRotationGrille {

	public void rotationnons(int[][] grille) {
		for(int i = 0; i < 9; ++i){
			int temp = grille[4][i];
			grille[4][i] = grille[5][i];
			grille[5][i] = temp;
		}
	}
	public RotationColonne5_6(){}
}
