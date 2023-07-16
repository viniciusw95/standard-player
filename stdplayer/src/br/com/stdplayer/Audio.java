package br.com.stdplayer;

import java.io.File;
import java.net.URI;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public abstract class Audio {
    
    private File location;
    private Media audioFile;
    
    public Audio(String location) {
        this.location = new File(location);
        this.audioFile = new Media(this.location.toURI().toString());
    }
    
    public Media getMedia() {
        return audioFile;
    }
}
