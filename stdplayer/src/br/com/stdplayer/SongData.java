package br.com.stdplayer;

import java.io.File;

public class SongData extends Audio {

    public SongData(String location) {
        super(location);        
    }

    
    public SongData(File location) {
        super(location.toURI().toString());        
    }
}
