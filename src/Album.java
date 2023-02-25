import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;
    private static List<Song> allAvailableSongs=new ArrayList<>();
    private static int count;

    // Constructor
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new ArrayList<>();
    }



    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    public static List<Song> getAllAvailableSongs() {
        return allAvailableSongs;
    }

    public static void setAllAvailableSongs(List<Song> allAvailableSongs) {
        Album.allAvailableSongs = allAvailableSongs;
    }
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Album.count = count;
    }



    // Function to find song
    boolean findSong(String title, String artist){
        for(Song song:songs){
            if(song.getTitle().equals(title)){
                if(song.getArtist().equals(artist)) return true;
            }
        }
        return false;
    }

    // Function to add Song in Album
    String addSongToAlbum(String title, double duration, String artist){
        if(!findSong(title, artist)){
            Song s=new Song(title, duration, artist);
            count++;   // counting the songs
            allAvailableSongs.add(s);   // adding current song in the allAvailable songs list
            songs.add(s);    // adding song to the current album
            return "Song successfully added to the album";
        }
        return "Song already Exist!";
    }

    // Function to add song in the Playlist
    String addSongToPlaylistFromAlbum(String title, String artist, List<Song> playlist){
//        if(findSong(title, artist)){
//            for(Song s:songs){
//                if(s.getTitle().equals(title)){
//                    if(s.getArtist().equals(artist)) {
//                        playlist.add(s);
//                        return "Song is added to Your Playlist";
//                    }
//                }
//            }
//        }

        for(Song s:songs){
            if(s.getTitle().equals(title)){
                if(s.getArtist().equals(artist)) {
                    playlist.add(s);
                    return "Song is added to Your Playlist";
                }
            }
        }
        return "Song not Present in Album!";
    }

    // When we are adding a Particular no. Song from an Album to Playlist
    String addSongToPlaylistFromAlbum(int trackNo, List<Song> playlist){
        int index=trackNo-1;  // finding index of the song in album
        if(index>=0 && index<this.songs.size()){
            playlist.add(this.songs.get(index));
            return "Song is added to Your Playlist";
        }
        return "Invalid Position of the Song!";
    }

    // when adding song using Song's Title & Artist Name from all available songs' list to playlist
    String addSongToPlaylistFromAllAvailableSongs(String title, String artist, List<Song> playlist){
        for(Song s:allAvailableSongs){
            if(s.getTitle().equals(title)){
                if(s.getArtist().equals(artist)){
                    playlist.add(s);
                    return "Song is added to Your Playlist";
                }
            }
        }
        return "Song Not Present!";
    }

    // when adding Particular index No. song from all available songs' list to playlist
    String addSongToPlaylistFromAllAvailableSongs(int trackNo, List<Song> playlist){
        int index=trackNo-1;
        if(index>=0 && index<this.allAvailableSongs.size()){
            playlist.add(this.allAvailableSongs.get(index));
            return "Song is added to Your Playlist";
        }
        return "Invalid Position of the Song!";
    }

    // To get all available songs
    void printAllAvailableSongs(){
        for(Song s:allAvailableSongs) {
//            System.out.print(s.getTitle() +" ");
//            System.out.print(s.getArtist());
//            System.out.println();

            System.out.println(s); // It is Overridden in Song Class. So instead of Song object's address
                                  // it will print the title, duration and artist of a song object
        }
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
