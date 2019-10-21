package algorithm.programmers.hash;

import java.util.ArrayList;
import java.util.List;

public class Album {

	private String genre;

	private int totalPlay = 0;

	private List<Music> musicList = new ArrayList<>();

	Album(String genre) {
		this.genre = genre;
	}

	public int totalPlay() {
		return totalPlay;
	}

	public List<Integer> getTopMusicList() {
		musicList.sort((o1, o2) -> {
			if (o1.play() == o2.play()) {
				return o1.idx() - o2.idx();
			}
			return o2.play() - o1.play();
		});
		List<Integer> topMusicList = new ArrayList<>();
		for (Music music : musicList.subList(0, musicList.size() > 2 ? 2 : musicList.size())) {
			topMusicList.add(music.idx());
		}
		return topMusicList;
	}

	public Album addPlay(int play) {
		totalPlay += play;
		return this;
	}

	public Album addMusic(Music music) {
		totalPlay += music.play();
		musicList.add(music);
		return this;
	}
}