package br.com.stdplayer.controllers;

import br.com.stdplayer.Player;
import javafx.scene.control.Button;

public class MediaChooserButton extends Button {

    public MediaChooserButton(String string, Player player) {
        super(string);
        this.setOnAction(x -> {player.loadSong();});
    }

}
