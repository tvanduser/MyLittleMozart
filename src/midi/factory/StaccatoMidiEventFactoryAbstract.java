package midi.factory;

/**
 * Concrete implementation of {@code MidiEventFactoryAbstract} that produces a {@code StaccatoMidiEventFactory}.
 */
public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

    /**
     * Creates and returns an instance of {@code StaccatoMidiEventFactory}.
     *
     * @return A new {@code StaccatoMidiEventFactory} instance.
     */
    @Override
    public MidiEventFactory createFactory() {
        return new StaccatoMidiEventFactory();
    }
}
