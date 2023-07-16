package br.com.stdplayer.controllers;

import br.com.stdplayer.Player;
import br.com.stdplayer.interfaces.TimeJumper;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class FastForwardButton extends TimeJumperButton {

    public FastForwardButton(String text, Player player) {
        super(text, player);
    }

    @Override
    public void moveCurrentTime(Player player) {
        player.forward((double) 10_000);
    }

    
    
}
