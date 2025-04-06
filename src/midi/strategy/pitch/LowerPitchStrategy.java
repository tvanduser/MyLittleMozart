package midi.strategy.pitch;

/**
 * Strategy for decreasing the pitch of a MIDI note by 2 semitones.
 * Implements the {@code PitchStrategy} interface.
 */
public class LowerPitchStrategy implements PitchStrategy {

    /**
     * Modifies the pitch by decreasing it by 2 semitones.
     *
     * @param note The original MIDI note to be modified.
     * @return The modified MIDI note, 2 semitones lower.
     */
    @Override
    public int modifyPitch(int note) {
        return note - 2; // Lower the pitch
    }
}
