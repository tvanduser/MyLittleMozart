package midi.factory;

import javax.sound.midi.ShortMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.InvalidMidiDataException;

public interface MidiEventFactoryAbstract {
	MidiEventFactory createFactory();
}
