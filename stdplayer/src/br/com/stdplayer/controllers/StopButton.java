package br.com.stdplayer.controllers;

import br.com.stdplayer.Player;
import br.com.stdplayer.interfaces.Reprodutor;
import javafx.scene.control.Button;

public class StopButton extends Button implements Reprodutor {
    
    public StopButton(String text, Player player) {
        super(text);
        this.setOnAction(x -> {player.stop();});
    }
}
