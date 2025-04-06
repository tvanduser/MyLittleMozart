package midi.factory;
/**
 * 
 * 
 * function that returns a new {@MidiEventFactory} 
 * 
 */
public interface MidiEventFactoryAbstract {
	
	/**
	 * create and return a new instance of {@MidiEventFactory}
	 * @return new {@MidiEventFactory} instance
	 */
	MidiEventFactory createFactory();
}
