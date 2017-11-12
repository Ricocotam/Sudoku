package Projet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;


public class Grille {
	private int grille[][] = new int[9][9];  // Grid
	private LinkedList<Cases> casesVide = new LinkedList<Cases>();  // Empty boxes
	private int ligne[] = new int[9];  // lines
	private int colonne[] = new int[9];  // columns
	private int carre[] = new int[9];  // squares
	private ArrayList<String> listeSolutions = new ArrayList<String>();  // All solutions

	// Map to have power of 2
	private static HashMap<Integer, Integer> puissance2_entier = new  HashMap<Integer, Integer>();

	/// Using a xor allNumbers we supress all digits above the 9th bit
	/// Used later
	private static int allNumbers = 0;



	/**
	 * Convert each number of the grid into a binary representation
	 * If ith bit of grille[i][j] is 1, then the number i can be in this place
	 */
	public Grille(int[][] grille){
		if(grille.length != 9){
			System.out.println("Dimension de la grille invalide");
			return;
		}

		initAllNumbers();
		initPuissance2_Entier();

		for(int i = 0; i < grille.length; ++i){
			if(grille[i].length != 9){
				System.out.println("Dimension de la grille invalide");
				return;
			}

			for(int j = 0; j < grille[i].length; ++j){
				if(grille[i][j] == 0)
					casesVide.add(new Cases(new Coord(i, j)));

					this.grille[i][j] = toPowerTwo(grille[i][j]);

				}
		}


		majLignesColonnesCarres();
	}
	private static void initAllNumbers(){
		for(int i = 1; i <= 9; ++i)
			allNumbers |= toPowerTwo(i);
		allNumbers = ~allNumbers;
	}
	private static void initPuissance2_Entier() {
		for(int i = 1; i <= 9; ++i)
			puissance2_entier.put(toPowerTwo(i), i);
	}

	/**
	 * Start with simple method to backtracking
	 */
	public ArrayList<String> solve(){

		int temp[][] = methodeSimple();

		if(solved()){
			listeSolutions.add(toString(temp));
			return listeSolutions;
		}

		temp = methodeComplexe();
		if(solved()){
			listeSolutions.add(toString(temp));
			return listeSolutions;
		}

		backtracking();
		return listeSolutions;

	}

	/**
	 * The two following methods use the same algorithms we use as humans
	 * We compute possibilities on each box. If we only get 1 possibility
	 * We found the right number. We iterate while we can modify
	 */
	/// First method
	private int[][] methodeSimple() {
		boolean modifFaite;

		do{
			modifFaite = false;  // did we do something ?
			for(int i = 0; i < casesVide.size(); ++i){
				if(possibilitesSimple(casesVide.get(i).getCoord().getX(), casesVide.get(i).getCoord().getY())){
					modifFaite = true;

					majLignesColonnesCarres(casesVide.get(i).getCoord());
					casesVide.remove(i);
				}
			}

		}while(modifFaite);
		return grille;
	}

	/**
	 * @return : true if grille[i][j] has a unique possibility
	 */
	private boolean possibilitesSimple(int i, int j){
		// Sets all bits to 1 if not in column nor in ligne nor in square

		grille[i][j] = (~ligne[i]) ^ allNumbers;
		grille[i][j] &= (~colonne[j]) ^ allNumbers;
		grille[i][j] &= (~carre[(i / 3) + (j / 3) * 3]) ^ allNumbers;

		return isPowerTwo(grille[i][j]);
	}

	/// Second method
	private int[][] methodeComplexe() {
		// We look if find only 1 place for a number (line / column / square)
		// If yes, we set it

		boolean modifFaite;

		do{
			modifFaite = false;
			for(int i = 0; i < casesVide.size(); ++i){
				if(possibilitesComplexe(casesVide.get(i).getCoord().getX(), casesVide.get(i).getCoord().getY())){
					modifFaite = true;

					majLignesColonnesCarres(casesVide.get(i).getCoord());
					casesVide.remove(i);
				}
			}

		}while(modifFaite);

		return grille;
	}

	private boolean possibilitesComplexe(int x, int y) {
		/*
		 * Thanks to lmghs who help me with this
		 * Here is the thread (french) :
		 * http://zestedesavoir.com/forums/sujet/1394/operation-binaire/
		 *
		 * Ri = (R(i-1) | INPUT[i]) & ~Mi
		 * Mi = M(i-1) | (R(i-1) & INPUT[i])
		*/

		int r0 = 0, m0 = 0, r1, m1;

		// Columns
		for(int i = 0; i < 9; ++i){
			m1 = m0 | (r0 & grille[i][y]);
			r1 = (r0 | grille[i][y]) & ~m1;
			r0 = r1;
			m0 = m1;
		}
		r0 = r0 & ~ligne[x] & ~colonne[y] & ~carre[(x / 3) + (y / 3) * 3];
		if(isPowerTwo(r0)){
			grille[x][y] = r0;
			return true;
		}

		// Lines
		m0 = 0;
		r0 = 0;
		for(int j = 0; j < 9; ++j){
			m1 = m0 | (r0 & grille[x][j]);
			r1 = (r0 | grille[x][j]) & ~m1;
			r0 = r1;
			m0 = m1;
		}
		r0 = r0 & ~ligne[x] & ~colonne[y] & ~carre[(x / 3) + (y / 3) * 3];
		if(isPowerTwo(r0)){
			grille[x][y] = r0;
			return true;
		}

		// Squares
		m0 = 0;
		r0 = 0;
		for(int i = (x / 3) * 3; i < ((x / 3) + 1) * 3; ++i){
			for(int j = (y / 3) * 3; j < ((y / 3) + 1) * 3; ++j){
				m1 = m0 | (r0 & grille[i][j]);
				r1 = (r0 | grille[i][j]) & ~m1;
				r0 = r1;
				m0 = m1;
			}
		}
		r0 = r0 & ~ligne[x] & ~colonne[y] & ~carre[(x / 3) + (y / 3) * 3];
		if(isPowerTwo(r0)){
			grille[x][y] = r0;
			return true;
		}

		return false;
	}


	// If "human" methods aren't enough, use backtracking
	private void backtracking() {
		for(Cases c : casesVide)
			c.calculNbPossibilite(grille);
		Collections.sort(casesVide);
		backTrackIt(0);

		return ;
	}

	private boolean backTrackIt(int i) {

		if(i == casesVide.size()){
			return true;
		}

		int x = casesVide.get(i).getCoord().getX();
		int y = casesVide.get(i).getCoord().getY();

		if(puissance2_entier.containsKey(grille[x][y])){
			return backTrackIt(i + 1);

		}

		int before = grille[x][y];

		for(int k = 1; k <= 9; ++k){

			// Numbers are representings as bit activation
			// We have to go back to actual integers
			int temp = toPowerTwo(k);
			if(absentSurLigne(temp, x) && absentSurColonne(temp, y) && absentSurBloc(temp, x, y)){
				grille[x][y] = temp;

				majLignesColonnesCarres(new Coord(x, y));

				if(backTrackIt(i + 1))
					return true;

				supprLignesColonnesCarres(new Coord(x, y));
				grille[x][y] = before;


			}

		}

		 supprLignesColonnesCarres(new Coord(x, y));
		 grille[x][y] = before;

		return false;
	}



	private boolean absentSurBloc(int k, int x, int y) {
		return (k & carre[(x / 3) + (y / 3) * 3]) == 0;
	}
	private boolean absentSurColonne(int k, int y) {
		return (k & colonne[y]) == 0;
	}
	private boolean absentSurLigne(int k, int x) {
		return (k & ligne[x]) == 0;
	}

	private void majLignesColonnesCarres() {

		for(int i = 0; i < 9; ++i)
			for(int j = 0; j < 9; ++j){
				majLignesColonnesCarres(new Coord(i, j));
			}
	}
	private void majLignesColonnesCarres(Coord coord){
		int i = coord.getX();
		int j = coord.getY();

		ligne[i] |= isPowerTwo(grille[i][j]) ? grille[i][j]:0;
		colonne[j] |= isPowerTwo(grille[i][j]) ? grille[i][j]:0;
		carre[(i / 3) + (j / 3) * 3] |= isPowerTwo(grille[i][j]) ? grille[i][j]:0;
	}
	private void supprLignesColonnesCarres(Coord coord) {
		int i = coord.getX(),
			j = coord.getY();

		ligne[i] = isPowerTwo(grille[i][j]) ? ligne[i]^grille[i][j] : ligne[i];
		colonne[j] ^= isPowerTwo(grille[i][j]) ? colonne[j]^grille[i][j] : colonne[j];
		carre[(i / 3) + (j / 3) * 3] ^= isPowerTwo(grille[i][j]) ? carre[(i / 3) + (j / 3) * 3]^grille[i][j] : carre[(i / 3) + (j / 3) * 3];

	}


	public  static boolean isPowerTwo(int n) {
		return (n != 0) && ((n & (n - 1)) == 0);
	}

	private static int toPowerTwo(int i) {
		return (i == 0) ? 0 : 1 << (i-1);
	}

	private boolean solved() {
		return casesVide.isEmpty();
	}

	@Override
	public String toString() {
		return toString(grille);
	}

	public static String toString(int[][] grille){
		String temp = new String();

		initPuissance2_Entier();

		for(int i = 0; i < 9; ++i){
			if(i % 3 == 0)
				temp += "+---+---+---+\n";

			for(int j = 0; j < 9; ++j){
				if(j % 3 == 0)
					temp += "|";
				temp += isPowerTwo(grille[i][j]) ? puissance2_entier.get(grille[i][j]) : 0;
			}
			temp += "|\n";
		}
		temp += "+---+---+---+\n";

		return temp;
	}


}
