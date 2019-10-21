package algorithm.programmers.hash;

public class Music {

	private int idx;

	private int play;

	Music(int idx, int play) {
		this.idx = idx;
		this.play = play;
	}

	public int play() {
		return play;
	}

	public int idx() {
		return idx;
	}
}
