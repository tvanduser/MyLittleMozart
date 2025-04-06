package main;

import javax.sound.midi.*;

import midi.MidiEventData;
import midi.factory.MidiEventFactory;
import midi.factory.StandardMidiEventFactoryAbstract;
import midi.strategy.instrument.*;
import parser.MidiCsvParser;
import java.util.List;
import midi.strategy.pitch.*;

public class Main {

    public static void main(String[] args) {
        try {
            // Parse the CSV file to get a list of MidiEventData
            List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./src/resources/mystery_song.csv");

            // Create a new MIDI sequence and track
            Sequence sequence = new Sequence(Sequence.PPQ, 384);
            Track track = sequence.createTrack();

            // Choose a MIDI event factory dynamically (Standard, Legato, or Staccato)
            StandardMidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
            
            MidiEventFactory factory = factoryAbstract.createFactory();

            
            //play instruments / choose instrument to play and what track. 
            InstrumentStrategy pianoStrategy = new AcousticGrandPianoStrategy();
            InstrumentStrategy trumpetStrategy = new TrumpetStrategy();
            InstrumentStrategy bassStrategy = new ElectricBassGuitarStrategy();
           
            pianoStrategy.playInstrument(track, 0);  
            trumpetStrategy.playInstrument(track, 1);
            bassStrategy.playInstrument(track, 2);    


            
            //choose pitch 
            PitchStrategy pitchStrategy = new HigherPitchStrategy();
            //PitchStrategy pitchStrategy = new LowerPitchStrategy();

            

            // Iterate through the MIDI events and apply the pitch modification
            for (MidiEventData event : midiEvents) {
                // Modify the note pitch based on the selected strategy
                int modifiedNote = pitchStrategy.modifyPitch(event.getNote());

                // Create and add the MIDI events to the track
                if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
                    track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(), event.getChannel()));
                } else {
                    track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
                }
            }

            // Create a Sequencer to play the sequence
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();

            // Wait for the sequence to finish playing
            while (sequencer.isRunning() || sequencer.isOpen()) {
                Thread.sleep(100);
            }

            // Close the sequencer after playing the sequence
            Thread.sleep(500);
            sequencer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
