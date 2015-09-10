package Projet;

public class Cases implements Comparable<Cases>{
	
	private Coord c;
	private int nbPossibilite;
	
	public Cases(Coord coord) {
		c = coord;
	}
	
	public Coord getCoord(){
		return c;
	}
	
	public void calculNbPossibilite(int grille[][]){
		nbPossibilite = 0;
		int temp = grille[c.getX()][c.getY()];
		
		for(int i = 0; i < 9; ++i){
			if(temp % 2 == 1)
				++nbPossibilite;
			temp = (temp >> 1);
		}
	}

	public int compareTo(Cases c) {
		Integer temp1 = new Integer(nbPossibilite),
				temp2 = new Integer(c.nbPossibilite);
		return temp1.compareTo(temp2);
	}

	@Override
	public String toString() {
		return c.toString();
	}
}
