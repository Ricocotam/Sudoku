package Projet;

import java.util.ArrayList;

import Rotation.Rotationons;


public class Sudoku {

	private static int base[][] =
		{{5,3,4,6,7,8,9,1,2,},
		 {6,7,2,1,9,5,3,4,8,},
		 {1,9,8,3,4,2,5,6,7,},
		 {8,5,9,7,6,1,4,2,3,},
		 {4,2,6,8,5,3,7,9,1,},
		 {7,1,3,9,2,4,8,5,6,},
		 {9,6,1,5,3,7,2,8,4,},
		 {2,8,7,4,1,9,6,3,5,},
		 {3,4,5,2,8,6,1,7,9,}};


	// Generate a grid from "base" using rotations
	// We know we'll get only 1 solution (if we keep enough numbers)
	public static Grille generer(int nbCasesPleines){
		int grilleTemp[][] = new int[9][9];
		for(int i = 0; i < 9; ++i)
			for(int j = 0; j < 9; ++j)
				grilleTemp[i][j] = base[i][j];

		nbCasesPleines = 81 - nbCasesPleines + 1;
		for(int i = 0; i < nbCasesPleines; ++i)
			Rotationons.rotationRandom(grilleTemp);

		for(int i = 0; i < nbCasesPleines; ++i){
			boolean fait = false;
			do{
				int indice = (int)(Math.random() * 81);
				if(grilleTemp[indice / 9][indice % 9] != 0){
					grilleTemp[indice / 9][indice % 9] = 0;
					fait = true;
				}
			}while(!fait);
		}

		return new Grille(grilleTemp);

	}

	public static void test(){

// Another grid
//		int grille[][] = {{1,0,0,0,0,7,0,9,0,},
//						{0,3,0,0,2,0,0,0,8,},
//						{0,0,9,6,0,0,5,0,0,},
//						{0,0,5,3,0,0,9,0,0,},
//						{0,1,0,0,8,0,0,0,2,},
//						{6,0,0,0,0,4,0,0,0,},
//						{3,0,0,0,0,0,0,1,0,},
//						{0,4,0,0,0,0,0,0,7,},
//						{0,0,7,0,0,0,3,0,0,}};
		// 0 means empty
		int grille[][] =
			   {
			    {0,0,0,0,0,0,0,0,0},
			    {0,0,0,0,0,3,0,8,5},
			    {0,0,1,0,2,0,0,0,0},
			    {0,0,0,5,0,7,0,0,0},
			    {0,0,4,0,0,0,1,0,0},
			    {0,9,0,0,0,0,0,0,0},
			    {5,0,0,0,0,0,0,7,3},
			    {0,0,2,0,1,0,0,0,0},
			    {0,0,0,0,4,0,0,0,9}
			   };


		Grille test = new Grille(grille);
		ArrayList<String> temp = test.solve();
		System.out.println(test);
	}

	public static void main(String[] args){
		long temps = System.currentTimeMillis();

		Sudoku.test();


		temps = (System.currentTimeMillis() - temps);
		System.out.println(temps);


	}
}
