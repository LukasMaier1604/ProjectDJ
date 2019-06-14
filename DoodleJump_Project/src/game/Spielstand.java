package game;

public class Spielstand implements Comparable{
	
	private String playername;
	private int punktzahl;

	public Spielstand(String name, int score) {
		playername = name;
		punktzahl = score;
	}
	
	public int getpunktzahl() {
		return punktzahl;
	}

	@Override
	public int compareTo(Object o) {
		Spielstand s = (Spielstand) o;
		return punktzahl > s.getpunktzahl() ? 1 : 0;
	}
}
