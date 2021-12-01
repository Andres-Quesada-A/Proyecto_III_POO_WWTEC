/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sonido;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class SClip {
    private Clip audioClip;
    private AudioInputStream audioStream;

    //clip method
    public SClip(String path) {
        //create an AudioInputStream from a given sound file
        File audioFile = new File(path);
        try {
            audioStream = AudioSystem.getAudioInputStream(audioFile);
        }
        catch (UnsupportedAudioFileException | IOException e) {
            System.out.println("Fallo");
        }

        //acquire audio format and create a DataLine.Info object
        AudioFormat format = audioStream.getFormat();
        var info = new DataLine.Info(Clip.class, format);

        //obtain the Clip
        try {
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
        }
        catch (LineUnavailableException | IOException e) {
            System.out.println("Falló al obtener el clip");
        }
    }

    public void play() {
        new Thread( () -> {
            audioClip.setFramePosition(0);
            audioClip.start();
        }){}.start();
    }

    public void loop() {
        new Thread( () -> {
            audioClip.setFramePosition(0);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        }){}.start();
    }

    public void stop() {
        audioClip.stop();
    }
    
}
