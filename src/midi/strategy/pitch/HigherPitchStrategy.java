package midi.strategy.pitch;

public class HigherPitchStrategy implements PictchStrategy {

	@Override
	public int modifyPitch(int note) {
		return note + 2;
	}
}
