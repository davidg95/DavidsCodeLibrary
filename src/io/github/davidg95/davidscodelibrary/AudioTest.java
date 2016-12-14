/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author David
 */
public class AudioTest {
    
    public AudioTest(){
        
    }
    
    public void start() throws LineUnavailableException{
        byte[] buf = new byte[1];
        int val = 30000;
        AudioFormat af = new AudioFormat((float) 44100, 8, 2, true, false);
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open();
        sdl.start();
        for (int i = 0; i < 1000 * (float) 44100 / 1000; i++) {
            double angle = i / ((float) val / 440) * 2.0 * Math.PI;
            buf[0] = (byte) (Math.sin(angle) * 100);
            sdl.write(buf, 0, 1);
        }
        sdl.drain();
        sdl.stop();
    }
}
