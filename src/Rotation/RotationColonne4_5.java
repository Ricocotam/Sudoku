package Rotation;

public class RotationColonne4_5 implements IRotationGrille {
	public RotationColonne4_5(){}
	public void rotationnons(int[][] grille) {
		for(int i = 0; i < 9; ++i){
			int temp = grille[3][i];
			grille[3][i] = grille[4][i];
			grille[4][i] = temp;
		}
	}

}
