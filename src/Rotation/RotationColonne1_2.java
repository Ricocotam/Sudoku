package Rotation;

public class RotationColonne1_2 implements IRotationGrille {
	
	public RotationColonne1_2(){}
	
	
	public void rotationnons(int[][] grille) {
		for(int i = 0; i < 9; ++i){
			int temp = grille[0][i];
			grille[0][i] = grille[1][i];
			grille[1][i] = temp;
		}
	}

}
