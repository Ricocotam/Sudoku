package Rotation;

public class RotationColonne2_3 implements IRotationGrille {
	public RotationColonne2_3(){}
	
	public void rotationnons(int[][] grille) {
		for(int i = 0; i < 9; ++i){
			int temp = grille[1][i];
			grille[1][i] = grille[2][i];
			grille[2][i] = temp;
		}
	}

}
