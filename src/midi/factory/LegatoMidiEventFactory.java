package midi.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * A factory that creates MIDI note events with a legato style (extended duration).
 * Implements the {@code MidiEventFactory} interface.
 */
public class LegatoMidiEventFactory implements MidiEventFactory {

    /**
     * Creates a NOTE_ON MIDI event at the given tick with specified note, velocity, and channel.
     *
     * @param tick The tick position where the event occurs.
     * @param note The MIDI note number.
     * @param velocity The velocity (intensity) of the note.
     * @param channel The MIDI channel.
     * @return A {@code MidiEvent} representing the NOTE_ON event.
     * @throws InvalidMidiDataException If the MIDI message is invalid.
     */
    @Override
    public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
        return new MidiEvent(message, tick);
    }

    /**
     * Creates a NOTE_OFF MIDI event for legato style by delaying the tick by 80 units.
     *
     * @param tick The original tick when the note would end.
     * @param note The MIDI note number.
     * @param channel The MIDI channel.
     * @return A {@code MidiEvent} representing the NOTE_OFF event.
     * @throws InvalidMidiDataException If the MIDI message is invalid.
     */
    @Override
    public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
        // Legato: Increase the duration by 80 ticks
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
        return new MidiEvent(message, tick + 80);
    }
}
