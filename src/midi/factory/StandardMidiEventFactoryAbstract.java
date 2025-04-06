package midi.factory;

/**
 * Concrete implementation of {@code MidiEventFactoryAbstract} that produces a {@code StandardMidiEventFactory}.
 */
public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

    /**
     * Creates and returns an instance of {@code StandardMidiEventFactory}.
     *
     * @return A new {@code StandardMidiEventFactory} instance.
     */
    @Override
    public MidiEventFactory createFactory() {
        return new StandardMidiEventFactory();
    }
}
