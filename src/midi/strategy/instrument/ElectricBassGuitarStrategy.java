package midi.strategy.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 * Strategy for selecting the Electric Bass (fingered) instrument.
 * Implements the {@code InstrumentStrategy} interface.
 */
public class ElectricBassGuitarStrategy implements InstrumentStrategy {

    /**
     * Sends a PROGRAM_CHANGE MIDI message to set the instrument to Electric Bass (program 33).
     *
     * @param track The MIDI track to which the message will be added.
     * @param channel The MIDI channel to apply the instrument change on.
     */
    @Override
    public void playInstrument(Track track, int channel) {
        try {
            ShortMessage message = new ShortMessage();
            message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0); // Electric Bass (finger)
            track.add(new MidiEvent(message, 0));
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }
}
