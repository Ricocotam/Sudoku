package Rotation;

public class RotationColonne1_3 implements IRotationGrille {
	
	public RotationColonne1_3(){}
	
	public void rotationnons(int[][] grille) {
		for(int i = 0; i < 9; ++i){
			int temp = grille[0][i];
			grille[0][i] = grille[2][i];
			grille[2][i] = temp;
		}
	}

}
