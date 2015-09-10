package Rotation;

public class RotationColonne4_6 implements IRotationGrille {
	public RotationColonne4_6(){}
	public void rotationnons(int[][] grille) {
		for(int i = 0; i < 9; ++i){
			int temp = grille[3][i];
			grille[3][i] = grille[5][i];
			grille[5][i] = temp;
		}
	}

}
