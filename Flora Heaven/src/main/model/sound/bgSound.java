package main.model.sound;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class bgSound implements Soundmanager {
    private Clip backgroundClip;
    private FloatControl volumeControl;
    private boolean isPlaying = false;
    private final String SOUNDPATH = "/assets/sound/bgsound.wav";

    public bgSound() {
        initSound();
    }

    private void initSound() {
        try {
            URL soundUrl = getClass().getResource(SOUNDPATH);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundUrl);
            backgroundClip = AudioSystem.getClip();
            backgroundClip.open(audioIn);

            // กำหนด volumeControl
            volumeControl = (FloatControl) backgroundClip.getControl(FloatControl.Type.MASTER_GAIN);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // เพิ่มเมธอดสำหรับลดเสียง
    public void decreaseVolume(float decibels) {
        if (volumeControl != null) {
            float current = volumeControl.getValue();
            float newVolume = current - decibels;

            // ตรวจสอบไม่ให้ต่ำกว่าค่าต่ำสุด
            if (newVolume < volumeControl.getMinimum()) {
                newVolume = volumeControl.getMinimum();
            }

            volumeControl.setValue(newVolume);
        }
    }

    // เพิ่มเมธอดสำหรับตั้งค่าระดับเสียงโดยตรง (เป็น dB)
    public void setVolume(float decibels) {
        if (volumeControl != null) {
            // ตรวจสอบไม่ให้เกินช่วงที่กำหนด
            if (decibels < volumeControl.getMinimum()) {
                decibels = volumeControl.getMinimum();
            } else if (decibels > volumeControl.getMaximum()) {
                decibels = volumeControl.getMaximum();
            }

            volumeControl.setValue(decibels);
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