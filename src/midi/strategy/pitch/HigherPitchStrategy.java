package midi.strategy.pitch;

/**
 * Strategy for increasing the pitch of a MIDI note by 2 semitones.
 * Implements the {@code PitchStrategy} interface.
 */
public class HigherPitchStrategy implements PitchStrategy {

    /**
     * Modifies the pitch by increasing it by 2 semitones.
     *
     * @param note The original MIDI note to be modified.
     * @return The modified MIDI note, 2 semitones higher.
     */
    @Override
    public int modifyPitch(int note) {
        return note + 2; //raise the pitch
    }
}
