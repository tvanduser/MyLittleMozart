package midi.factory;

/**
 * Concrete implementation of {@code MidiEventFactoryAbstract} that produces a {@code LegatoMidiEventFactory}.
 */
public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

    /**
     * Creates and returns an instance of {@code LegatoMidiEventFactory}.
     *
     * @return A new {@code LegatoMidiEventFactory} instance.
     */
    @Override
    public MidiEventFactory createFactory() {
        return new LegatoMidiEventFactory();
    }
}
