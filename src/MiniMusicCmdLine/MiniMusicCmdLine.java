package MiniMusicCmdLine;
import javax.sound.midi.*;

public class MiniMusicCmdLine { // this is the first one

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Don't forget the instrument and note args");
		} else {
			System.out.println(args[0]);
			System.out.println(args[1]);
			
			int instrument = Integer.parseInt(args[0]);
			int note = Integer.parseInt(args[1]);
			
			MiniMusicCmdLine mini = new MiniMusicCmdLine();
			mini.play(instrument, note);

		}
	}

	public void play(int instrument, int note) {

		try {

			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			//MidiEvent event = null;

			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, instrument, 0);
			MidiEvent changeInstrument = new MidiEvent(first, 1);
			track.add(changeInstrument);

			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, note, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);

			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, note, 100);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);
			player.setSequence(seq);
			player.start();

			Thread.sleep(2000);
			player.close();
			System.exit(0);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	} // close play

} // close class