package midi.strategy.pitch;

/**
 * Interface for defining pitch modification strategies.
 * Each strategy modifies the pitch of a MIDI note.
 */
public interface PitchStrategy {

    /**
     * Modifies the pitch of the given MIDI note.
     *
     * @param note The original MIDI note to be modified.
     * @return The modified MIDI note.
     */
    int modifyPitch(int note);
}
