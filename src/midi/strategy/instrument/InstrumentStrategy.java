package midi.strategy.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public interface InstrumentStrategy {
	void playInstrument(Track track, int channel);
}
