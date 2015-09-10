package Rotation;

public class RotationColonne7_8 implements IRotationGrille {

	public void rotationnons(int[][] grille) {
		for(int i = 0; i < 9; ++i){
			int temp = grille[6][i];
			grille[6][i] = grille[7][i];
			grille[7][i] = temp;
		}
	}
	public RotationColonne7_8(){}
}
