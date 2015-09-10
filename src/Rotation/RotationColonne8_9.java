package Rotation;

public class RotationColonne8_9 implements IRotationGrille {

	public void rotationnons(int[][] grille) {
		for(int i = 0; i < 9; ++i){
			int temp = grille[7][i];
			grille[7][i] = grille[8][i];
			grille[8][i] = temp;
		}
	}
	public RotationColonne8_9(){}
}
