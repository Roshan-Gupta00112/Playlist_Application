import java.util.*;

public class Main {
    static List<Album> allAvailableAlbums=new ArrayList<>();
    public static void main(String[] args) {

        Album album1=new Album("Bhajan", "Singer1");
        allAvailableAlbums.add(album1);
        album1.addSongToAlbum("song1", 3.6, "singer1");
        album1.addSongToAlbum("song2", 5.3, "singer1");
        album1.addSongToAlbum("song3", 7.4, "singer1");
        album1.addSongToAlbum("song4", 4.2, "singer1");
        album1.addSongToAlbum("song5", 5.5, "singer1");

        // The same Album when sung by 2nd(or Different) Artist
        Album album2=new Album("Bhajan", "Singer2");
        allAvailableAlbums.add(album2);
        album2.addSongToAlbum("song1", 3.6, "singer2");
        album2.addSongToAlbum("song2", 5.3, "singer2");
        album2.addSongToAlbum("song3", 7.4, "singer2");
        album2.addSongToAlbum("song4", 4.2, "singer2");
        album2.addSongToAlbum("song5", 5.5, "singer2");

        // Another(or the 2nd) Album of First Artist
        Album album3=new Album("Love", "Singer1");
        allAvailableAlbums.add(album3);
        album3.addSongToAlbum("song6", 3.6, "singer1");
        album3.addSongToAlbum("song7", 5.3, "singer1");
        album3.addSongToAlbum("song8", 7.4, "singer1");
        album3.addSongToAlbum("song9", 4.2, "singer1");
        album3.addSongToAlbum("song10", 5.5, "singer1");

        // New Album of New(or 3rd) Artist
        Album album4=new Album("Peace", "Singer3");
        allAvailableAlbums.add(album4);
        album4.addSongToAlbum("song1", 3.6, "singer3");
        album4.addSongToAlbum("song2", 5.3, "singer3");
        album4.addSongToAlbum("song3", 7.4, "singer3");
        album4.addSongToAlbum("song4", 4.2, "singer3");
        album4.addSongToAlbum("song5", 5.5, "singer3");



        // Create Own Playlist
        List<Song> myPlaylist=new LinkedList<>();


        // Adding Song to myPlaylist from Album1
        // adding song to myPlaylist using song title and artist name
        System.out.println(album1.addSongToPlaylistFromAlbum("song1", "singer1", myPlaylist));
        // adding song to myPlaylist using trackNo and artist name
        System.out.println(album1.addSongToPlaylistFromAlbum(2, myPlaylist));
        // adding song from all available songs to myPlaylist using Title and Artist Name
        System.out.println(album1.addSongToPlaylistFromAllAvailableSongs("song3", "singer1", myPlaylist));
        // adding song from all available songs to myPlaylist using Track No
        System.out.println(album1.addSongToPlaylistFromAllAvailableSongs(4, myPlaylist));

        System.out.println();
        System.out.println();



        // Adding Song to myPlaylist from Album2
        // adding song to myPlaylist using song title and artist name
        System.out.println(album2.addSongToPlaylistFromAlbum("song1", "singer2", myPlaylist));
        // adding song to myPlaylist using trackNo and artist name
        System.out.println(album2.addSongToPlaylistFromAlbum(2, myPlaylist));
        // adding song from all available songs to myPlaylist using Title and Artist Name
        System.out.println(album2.addSongToPlaylistFromAllAvailableSongs("song3", "singer2", myPlaylist));
        // adding song from all available songs to myPlaylist using Track No
        System.out.println(album2.addSongToPlaylistFromAllAvailableSongs(4, myPlaylist));

        System.out.println();
        System.out.println();



        // Adding Song to myPlaylist from Album3
        // adding song to myPlaylist using song title and artist name
        System.out.println(album3.addSongToPlaylistFromAlbum("song1", "singer1", myPlaylist));
        // adding song to myPlaylist using trackNo and artist name
        System.out.println(album3.addSongToPlaylistFromAlbum(2, myPlaylist));
        // adding song from all available songs to myPlaylist using Title and Artist Name
        System.out.println(album3.addSongToPlaylistFromAllAvailableSongs("song3", "singer1", myPlaylist));
        // adding song from all available songs to myPlaylist using Track No
        System.out.println(album3.addSongToPlaylistFromAllAvailableSongs(4, myPlaylist));

        System.out.println();
        System.out.println();



        // Adding Song to myPlaylist from Album4
        // adding song to myPlaylist using song title and artist name
        System.out.println(album4.addSongToPlaylistFromAlbum("song1", "singer3", myPlaylist));
        // adding song to myPlaylist using trackNo and artist name
        System.out.println(album4.addSongToPlaylistFromAlbum(2, myPlaylist));
        // adding song from all available songs to myPlaylist using Title and Artist Name
        System.out.println(album4.addSongToPlaylistFromAllAvailableSongs("song3", "singer3", myPlaylist));
        // adding song from all available songs to myPlaylist using Track No
        System.out.println(album4.addSongToPlaylistFromAllAvailableSongs(4, myPlaylist));

        System.out.println();
        System.out.println();


        // TO play Playlist
        play(myPlaylist);

        System.out.println();
        System.out.println();



        // To print all available Albums
        System.out.println("All available " +allAvailableAlbums.size()+ " albums are:-");
        printAllAvailableAlbums();

        System.out.println();
        System.out.println();



        // To print all available Songs
        System.out.println("All available " +album1.getCount()+ " songs are:-");
        album1.printAllAvailableSongs();

    }




    // Function to Play the Song from Playlist
    public static void play(List<Song> playlist){
        if(playlist.size()==0){
            System.out.println("Playlist is Empty!");
            return;
        }

        ListIterator<Song> itr=playlist.listIterator();

        boolean isNext;  // to know out of, next or prev operations which was performed previously
        boolean isDeleted = false;  // to know whether in the previous operation we have deleted a song from the playlist or not

        // for First Song
        System.out.println("Currently Playing..");
        System.out.println(itr.next());  // Since there is Overridden Function in Song CLass. So, here instead of printing song
                                        // object's address, the title, duration and artist name of song object get printed
        isNext=true;

        System.out.println();

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter your choice from the menu");
        printMenu();
        while(true){
            System.out.println("Enter Your Choice");
            int choice= sc.nextInt();

            switch(choice){
                case 1:              // for playing next song
                    System.out.println("Now playing...");

                    if(!isNext) if(!isDeleted)itr.next();

                    if(itr.hasNext()) System.out.println(itr.next());
                    else System.out.println("You have already reached the end of playlist!");

                    isNext=true;
                    isDeleted=false;

                    break;
                case 2:        // for playing previous song
                    System.out.println("Now playing...");

                    if(isNext) if(!isDeleted)itr.previous();

                    if(itr.hasPrevious()) System.out.println(itr.previous());
                    else System.out.println("You have already on the First Song!");

                    isNext=false;
                    isDeleted=false;

                    break;
                case 3:          // for playing current song
                    System.out.println("Now playing...");

                    if(isNext){  // when current song is played by "itr.next()" operation . Then to play the
                                // current song again we have to move back
                        System.out.println(itr.previous());
                        isNext=false;
                    }
                    else{     // when current song is played by "itr.previous()" operation . Then to play the
                             // current song again we have to move next
                        System.out.println(itr.next());
                        isNext=true;
                    }

                    if(isDeleted) isDeleted=false;

                    break;
                case 4:         // for delete(or removing) current song from the playlist
                    itr.remove();
                    System.out.println("The current song has been deleted");
                    isDeleted=true;
                    break;
                case 5:         // for printing all song
                    printAllSongs(playlist);
                    break;
                case 6:
                    printMenu();        // for Menu
                    break;
                case 7:
                    System.out.println("Current size of your playlist is: " +playlist.size());
                    break;
                case 8:                 // for Exit
                    return;
            }
        }
    }


    // Function to print the all available choices in playlist
    static void printMenu(){
        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Play the current song again");
        System.out.println("4. Delete the current song");
        System.out.println("5. show all the available songs");
        System.out.println("6. show the menu again");
        System.out.println("7. Know the size of your playlist");
        System.out.println("8. Exit");
        return;
    }


    // Function to print all songs from an
    static void printAllSongs(List<Song> playlist){
        System.out.println("All " +playlist.size()+ " songs of your playlist are:-");
        for(Song s:playlist) System.out.println(s);
        return;
    }


    // Function to get All Available Albums
     static void printAllAvailableAlbums(){
         System.out.println("All available albums are:-");
        for(Album al:allAvailableAlbums){
//            System.out.print(al.getName() +" ");
//            System.out.println(al.getArtist());
//            System.out.println();

            System.out.println(al);    // Since there is an Overridden function in Album class that's why here Instead of
                                     // the address of the reference variable "al", the Name & Artist of the Album get Printed
        }
    }

}