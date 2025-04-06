package midi.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

/**
 * Interface for creating MIDI note events.
 * Implementations define how NOTE_ON and NOTE_OFF events are generated.
 */
public interface MidiEventFactory {

    /**
     * Creates a NOTE_ON MIDI event at the specified tick.
     *
     * @param tick The tick position where the note starts.
     * @param note The MIDI note number.
     * @param velocity The velocity (intensity) of the note.
     * @param channel The MIDI channel.
     * @return A {@code MidiEvent} representing the NOTE_ON event.
     * @throws InvalidMidiDataException If the MIDI data is invalid.
     */
    MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;

    /**
     * Creates a NOTE_OFF MIDI event at the specified tick.
     *
     * @param tick The tick position where the note ends.
     * @param note The MIDI note number.
     * @param channel The MIDI channel.
     * @return A {@code MidiEvent} representing the NOTE_OFF event.
     * @throws InvalidMidiDataException If the MIDI data is invalid.
     */
    MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
}
