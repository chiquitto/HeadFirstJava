package miniMusicPlayer;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMusicPlayer1 {
	public static void main(String[] args) {

		try {
			Sequencer s = MidiSystem.getSequencer();
			s.open();

			Sequence sq = new Sequence(Sequence.PPQ, 4);
			Track track = sq.createTrack();

			for (int i = 5; i < 61; i += 4) {
				track.add(makeEvent(144, 1, i, 100, i));
				track.add(makeEvent(128, 1, i, 100, i + 2));
			}

			s.setSequence(sq);
			s.setTempoInBPM(220);
			s.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MidiEvent makeEvent(int comd, int chan, int one, int two,
			int tick) {
		MidiEvent e = null;

		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			e = new MidiEvent(a, tick);
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		return e;
	}
}
