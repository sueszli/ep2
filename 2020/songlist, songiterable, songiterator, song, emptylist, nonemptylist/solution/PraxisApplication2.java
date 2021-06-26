// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisApplication2 {

    public static void main(String[] args) {

        Song s1 = new Song("Here comes the sun", 187);
        Song s2 = new Song("Is there anybody out there?", 182);
        Song s3 = new Song("Prodigal son", 372);
        Song s4 = new Song("Prodigal son", 171);
        Song s5 = new Song("The logical song", 250);
        Song s6 = new Song("Beat it", 258);

        SongList songlist = EmptyList.EMPTY;
        System.out.println(songlist); // no song

        System.out.println();

        songlist = songlist.add(s1);
        songlist = songlist.add(s2);
        songlist = songlist.add(s3);
        songlist = songlist.add(s4);
        songlist = songlist.add(s5);
        songlist = songlist.add(s6);
        songlist = songlist.add(s3);

        System.out.println(songlist);
        System.out.println();

        songlist = songlist.remove(new Song("Prodigal son", 372));

        for (Song s: songlist) {
            System.out.println(s);
        }

        System.out.println();

        songlist = songlist.remove(s1);
        songlist = songlist.remove(s2);
        songlist = songlist.remove(s3);
        songlist = songlist.remove(s4);
        songlist = songlist.remove(s5);
        songlist = songlist.remove(s6);

        System.out.println(songlist); // no song

        System.out.println();

        songlist = songlist.add(s1);
        songlist = songlist.add(s2);
        songlist = songlist.add(s3);

        SongList equalSonglist = EmptyList.EMPTY;
        equalSonglist = equalSonglist.add(s1);
        equalSonglist = equalSonglist.add(s2);
        equalSonglist = equalSonglist.add(s2);
        equalSonglist = equalSonglist.add(s3);

        System.out.println(songlist.equals(equalSonglist)); // true

        /*
        no song

        Here comes the sun, 187s
        Is there anybody out there?, 182s
        Prodigal son, 372s
        Prodigal son, 171s
        The logical song, 250s
        Beat it, 258s
        Prodigal son, 372s

        Here comes the sun, 187s
        Is there anybody out there?, 182s
        Prodigal son, 171s
        The logical song, 250s
        Beat it, 258s

        no song

        true
        */
    }
}
