package br.com.stdplayer.interfaces;

import br.com.stdplayer.Player;
import javafx.scene.media.MediaPlayer;

public interface TimeJumper extends PlayerComponent {
    public void moveCurrentTime(Player player);    
}
