package midi.strategy.instrument;

import javax.sound.midi.Track;

/**
 * Interface for defining different instrument strategies.
 * Each strategy handles the specific MIDI message to set an instrument on a given track.
 */
public interface InstrumentStrategy {

    /**
     * Method to play the instrument by sending the appropriate MIDI program change message.
     *
     * @param track The MIDI track to which the instrument change will be applied.
     * @param channel The MIDI channel for the instrument change.
     */
    void playInstrument(Track track, int channel);
}
