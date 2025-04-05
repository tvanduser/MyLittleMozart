package midi.strategy.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class ElectriBassGuitarStrategy implements InstrumentStrategy{

	@Override
	public void playInstrument(Track track, int channel) {
		try {
			ShortMessage message = new ShortMessage();
			message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0);
			track.add(new MidiEvent(message, 0));
		} 
		catch(InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}
	
}
