package parser;

import java.io.*;
import java.util.*;
import javax.sound.midi.ShortMessage;


import midi.MidiEventData;

public class MidiCsvParser {
	
	public static List<MidiEventData> parseCsv(String filePath) throws IOException{
		
		List<MidiEventData> events = new ArrayList<MidiEventData>(); //create the list that the events will be held in
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line; 
		
		while((line = reader.readLine()) != null) {
			if(line.trim().isEmpty()) { //make sure there is something on the line
				continue;
			}
			
			String[] parts = line.split(","); //split the lines up based on the , to get the different parts 
			if(parts.length != 6) {
				continue; //making sure that the line contains all of the necessary event parts
			}
			
			int tick = Integer.parseInt(parts[0].trim());
			String noteType = parts[1].trim();
			int channel = Integer.parseInt(parts[2].trim());
			int note = Integer.parseInt(parts[3].trim());
			int velocity = Integer.parseInt(parts[4].trim());
			int instrument = Integer.parseInt(parts[5].trim());
			
			int noteOnOff;
			if(noteType.equalsIgnoreCase("Note_on_c")) {
				noteOnOff = ShortMessage.NOTE_ON;
			}
			else if(noteType.equalsIgnoreCase("Note_off_c")) {
				noteOnOff = ShortMessage.NOTE_OFF;
			}
			else {
				continue; // the note type isn't one of the two options
			}
			
			//create the event and add it to the list of midi events
			MidiEventData data = new MidiEventData(tick, velocity, note, channel, instrument, noteOnOff);
			events.add(data);
		}
		
		
		reader.close();
		return events; //return the list of midi events
	}
	
}
