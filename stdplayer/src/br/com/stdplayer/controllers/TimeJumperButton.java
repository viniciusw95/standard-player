package br.com.stdplayer.controllers;

import br.com.stdplayer.Player;
import br.com.stdplayer.interfaces.TimeJumper;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;

public abstract class TimeJumperButton extends Button implements TimeJumper {

    private Player player;
    public abstract void moveCurrentTime(Player player);
    
    public TimeJumperButton(String text, Player player2) {
        super(text);
        this.player = player2;
        this.setOnAction(x -> {this.moveCurrentTime(player);});
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }
    
    
    
}
