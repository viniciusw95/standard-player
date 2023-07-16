package br.com.stdplayer.controllers;

import br.com.stdplayer.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class TimeTrackerLabel extends Label {
    
    public TimeTrackerLabel(String text, Player player) {
        super(text);
    }
    
    public TimeTrackerLabel(String text, MediaPlayer player) {
    }
    
    public void listen(MediaPlayer player) {
        TimeTrackerLabel myRef = this;
        
        player.currentTimeProperty().addListener(new ChangeListener<Duration>() {

            @Override
            public void changed(ObservableValue<? extends Duration> observable,
                    Duration oldValue, Duration newValue) {
                myRef.setText(Integer.toString((int) newValue.toSeconds()));
            }}        
           );
    }
}
