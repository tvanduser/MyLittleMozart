package main;

import javax.sound.midi.*;

import midi.MidiEventData;
import parser.MidiCsvParser;

import java.util.List;


public class Main {

	public static void main(String[] args) {
		try {
            // Parse the MIDI CSV file
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("C:\\Users\\78tmo\\Documents\\code\\spring25\\OOPS\\OopsHW_3\\MyLittleMozart\\src\\resources\\mystery_song.csv");

            // Print each event
            for (MidiEventData event : midiEvents) {
                System.out.println(event);
            }
        } catch (Exception e) {
            System.err.println("Error while parsing CSV: " + e.getMessage());
            e.printStackTrace();
        }

	}

}
