package main.model.sound;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class bgSound implements Soundmanager {
    private Clip backgroundClip;
    private FloatControl volumeControl;
    private boolean isPlaying = false;
    private final String soundPath = "/assets/sound/bgsound.wav";

    public bgSound() {
        initSound();
    }

    private void initSound() {
        try {
            URL soundUrl = getClass().getResource(soundPath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundUrl);
            backgroundClip = AudioSystem.getClip();
            backgroundClip.open(audioIn);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void play() {
        if (backgroundClip != null && !isPlaying) {
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
            isPlaying = true;
        }
    }

    @Override
    public void pause() {
        if (backgroundClip != null && isPlaying) {
            backgroundClip.stop();
            isPlaying = false;
        }
    }

    @Override
    public void stop() {
        if (backgroundClip != null) {
            backgroundClip.stop();
            backgroundClip.setFramePosition(0);
            isPlaying = false;
        }
    }

    @Override
    public void restart() {
        stop();
        play();
    }

    @Override
    public void resume() {
        if (backgroundClip != null && !isPlaying) {
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
            isPlaying = true;
        }
    }
}