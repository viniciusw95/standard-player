package br.com.stdplayer;

import java.io.File;
import java.util.List;

import br.com.stdplayer.controllers.FastForwardButton;
import br.com.stdplayer.controllers.MediaChooserButton;
import br.com.stdplayer.controllers.PlayButton;
import br.com.stdplayer.controllers.RewindButton;
import br.com.stdplayer.controllers.StopButton;
import br.com.stdplayer.controllers.TimeTrackerLabel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

public class Player {
        
    private MediaPlayer player;
    private PlayButton playButton;
    private FastForwardButton fastForwardButton;
    private RewindButton rewindButton;
    private GridPane grid;
    private Button chooseAudioButton;
    private SongData loadedSong;
    private StopButton stopButton;
    private TimeTrackerLabel timeTrackerLabel;
    
    public Player() {
        this.chooseAudioButton = new MediaChooserButton("Carregar música", this);        
        this.rewindButton = new RewindButton("<< Retroceder 10 segs ", this);
        this.playButton = new PlayButton("Play", this);
        this.stopButton = new StopButton("Parar", this);
        this.fastForwardButton = new FastForwardButton("Avançar 10 segs >> ", this);
        this.timeTrackerLabel = new TimeTrackerLabel("Tempo atual: ", this);
    }
    
    public void loadSong() {
        this.dispose();
        try {
            FileChooser fileDialog = new FileChooser();
            File chosenFile = fileDialog.showOpenDialog(this.grid.getScene().getWindow());
            String fileLocation = chosenFile.toString();
            System.out.println(fileLocation);
            
            this.loadedSong = new SongData(fileLocation);
            this.player = new MediaPlayer(loadedSong.getMedia());
            this.player.setOnEndOfMedia(this.player::stop);
            this.timeTrackerLabel.listen(player);
            
            System.out.println(this.player);
            System.out.println("Áudio pronto para reprodução.");
        } catch (NullPointerException ex) {
            System.out.println("Nenhum arquivo foi selecionado.");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void playOrPause() {
        try  {
            System.out.println(this.player); // TODO: remover
            
            if (this.isReadyToPlay()) {
                player.play();
                System.out.println("Música começa a ser reproduzida.");
                this.playButton.setText("Clique para pausar.. ");
            } else if (this.isPlaying()) {
                player.pause();
                System.out.println("Música acaba de ser pausada.");
                this.playButton.setText("Click para continuar reproduzindo..");
            }
        } catch (NullPointerException ex) {
            System.out.println("Não pode reproduzir/pausar: nenhuma música foi selecionada.");
        }
    }
    
    public void stop() {
        this.player.stop();
    }
    
    
    public void forward(double i) {
        player.seek(player.getCurrentTime().add(new Duration(10000)));
    }
    
    public void rewind(double i) {
        player.seek(player.getCurrentTime().subtract(new Duration(10000)));
    }
    
    public void dispose() {
        if (player != null) {
            player.stop();
            player.dispose();
            player = null;
            loadedSong = null;
        }
    }

    public boolean isPlaying() {
        return this.player.getStatus() == Status.PLAYING;
    }
    
    public boolean isReadyToPlay() {
        return player.getStatus() == Status.PAUSED || 
                player.getStatus() == Status.READY || 
                player.getStatus() == Status.STOPPED;
       
    }
    public void arrangeElements() {
        GridPane.setConstraints(this.chooseAudioButton, 0, 0);
        GridPane.setConstraints(this.rewindButton, 1, 0);
        GridPane.setConstraints(this.playButton, 2, 0);
        GridPane.setConstraints(this.stopButton, 3, 0);
        GridPane.setConstraints(this.fastForwardButton, 4, 0);
        GridPane.setConstraints(this.timeTrackerLabel, 0, 1);
    }

    public void addTo(GridPane centerGrid) {
        this.grid = centerGrid;
        centerGrid.getChildren().add(this.chooseAudioButton);
        centerGrid.getChildren().add(this.rewindButton);
        centerGrid.getChildren().add(this.playButton);
        centerGrid.getChildren().add(this.stopButton);
        centerGrid.getChildren().add(this.fastForwardButton);
        centerGrid.getChildren().add(this.timeTrackerLabel);
        
    }

    
}
