package midi;

/**
 * Represents a MIDI event, storing the event's data such as tick position, velocity, note, channel, and instrument.
 */
public class MidiEventData {
    
    private int startEndTick, velocity, note, channel, noteOnOff;
    private int instrument;

    /**
     * Constructs a @code MidiEventData object with the specified parameters.
     * 
     * @param startEndTick The tick position of the event in the MIDI sequence.
     * @param velocity The intensity of the note.
     * @param note The MIDI note number representing the musical note.
     * @param channel The MIDI channel for the event.
     * @param instrument The instrument number for the event.
     * @param noteOnOff A flag indicating whether the note is being turned on (1) or off (0).
     */
    public MidiEventData(int startEndTick, int velocity, int note, int channel, int instrument, int noteOnOff) {
        this.startEndTick = startEndTick;
        this.velocity = velocity;
        this.note = note;
        this.channel = channel;
        this.instrument = instrument;
        this.noteOnOff = noteOnOff;
    }

    /**
     * Returns the tick position of the event in the MIDI sequence.
     * 
     * @return The tick position.
     */
    public int getStartEndTick() {
        return startEndTick;
    }

    /**
     * Sets the tick position of the event in the MIDI sequence.
     * 
     * @param startEndTick The tick position to set.
     */
    public void setStartEndTick(int startEndTick) {
        this.startEndTick = startEndTick;
    }

    /**
     * Returns the velocity (intensity) of the note.
     * 
     * @return The velocity.
     */
    public int getVelocity() {
        return velocity;
    }

    /**
     * Sets the velocity (intensity) of the note.
     * 
     * @param velocity The velocity to set.
     */
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    /**
     * Returns the MIDI note number representing the musical note.
     * 
     * @return The note number.
     */
    public int getNote() {
        return note;
    }

    /**
     * Sets the MIDI note number representing the musical note.
     * 
     * @param note The note number to set.
     */
    public void setNote(int note) {
        this.note = note;
    }

    /**
     * Returns the MIDI channel for the event.
     * 
     * @return The channel number.
     */
    public int getChannel() {
        return channel;
    }

    /**
     * Sets the MIDI channel for the event.
     * 
     * @param channel The channel to set.
     */
    public void setChannel(int channel) {
        this.channel = channel;
    }

    /**
     * Returns the flag indicating whether the note is being turned on (1) or off (0).
     * 
     * @return The note on/off flag.
     */
    public int getNoteOnOff() {
        return noteOnOff;
    }

    /**
     * Sets the flag indicating whether the note is being turned on (1) or off (0).
     * 
     * @param noteOnOff The note on/off flag to set.
     */
    public void setNoteOnOff(int noteOnOff) {
        this.noteOnOff = noteOnOff;
    }

    /**
     * Returns the instrument number for the event.
     * 
     * @return The instrument number.
     */
    public int getInstrument() {
        return instrument;
    }

    /**
     * Sets the instrument number for the event.
     * 
     * @param instrument The instrument number to set.
     */
    public void setInstrument(int instrument) {
        this.instrument = instrument;
    }

    /**
     * Returns a string representation of the {@code MidiEventData} object, including all fields: 
     * startEndTick, velocity, note, channel, noteOnOff, and instrument.
     * 
     * @return A string representation of the MIDI event data.
     */
    @Override
    public String toString() {
        return "MidiEventData [startEndTick=" + startEndTick + ", velocity=" + velocity + ", note=" + note
                + ", channel=" + channel + ", noteOnOff=" + noteOnOff + ", instrument=" + instrument + "]";
    }
}
