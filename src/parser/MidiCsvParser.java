package parser;

import java.io.*;
import java.util.*;
import javax.sound.midi.ShortMessage;

import midi.MidiEventData;

/**
 * A utility class for parsing a CSV file containing MIDI event data.
 * This class reads the CSV file and converts each line into a {@code MidiEventData} object,
 * which holds the details of a MIDI event.
 */
public class MidiCsvParser {
    
    /**
     * Parses a CSV file containing MIDI event data and converts it into a list of {@code MidiEventData} objects.
     *
     * @param filePath The path to the CSV file to be parsed.
     * @return A list of {@code MidiEventData} objects representing the MIDI events in the CSV file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static List<MidiEventData> parseCsv(String filePath) throws IOException {
        
        List<MidiEventData> events = new ArrayList<MidiEventData>(); // Create the list to hold the events
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        
        // Read each line from the CSV file
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) { // Skip empty lines
                continue;
            }
            
            String[] parts = line.split(","); // Split the line into parts based on commas
            if (parts.length != 6) {
                continue; // Ensure the line contains all necessary event parts
            }
            
            // Parse the values from the CSV line
            int tick = Integer.parseInt(parts[0].trim());
            String noteType = parts[1].trim();
            int channel = Integer.parseInt(parts[2].trim());
            int note = Integer.parseInt(parts[3].trim());
            int velocity = Integer.parseInt(parts[4].trim());
            int instrument = Integer.parseInt(parts[5].trim());
            
            // Determine whether the event is a note-on or note-off event
            int noteOnOff;
            if (noteType.equalsIgnoreCase("Note_on_c")) {
                noteOnOff = ShortMessage.NOTE_ON;
            } else if (noteType.equalsIgnoreCase("Note_off_c")) {
                noteOnOff = ShortMessage.NOTE_OFF;
            } else {
                continue; // Skip lines that don't have a valid note type
            }
            
            // Create the MidiEventData object and add it to the list of events
            MidiEventData data = new MidiEventData(tick, velocity, note, channel, instrument, noteOnOff);
            events.add(data);
        }
        
        reader.close(); // Close the reader after processing the file
        return events; // Return the list of MIDI events
    }
}
