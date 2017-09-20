
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
	private Clip clip;
	private FloatControl volume;
	public Sound() {
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Rain.class.getResource("/sound/rain_low.wav")));
			volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(-6);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void stop() {
		clip.stop();
	}
	public void start() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public void setVolume(int vol) {
		clip.flush(); //causes short stutter but grants real-time volume adjusting 
		volume.setValue(-6+vol/4);
	}
	public boolean isRunning() {
		return clip.isRunning();
	}
}
