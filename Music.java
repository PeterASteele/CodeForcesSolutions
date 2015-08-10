import java.util.ArrayList;
import java.util.Scanner;

/*
 * A. Music
time limit per test2 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
Little Lesha loves listening to music via his smartphone. But the smartphone doesn't have much memory, so Lesha listens to his favorite songs in a well-known social network InTalk.

Unfortunately, internet is not that fast in the city of Ekaterinozavodsk and the song takes a lot of time to download. But Lesha is quite impatient. The song's duration is T seconds. Lesha downloads the first S seconds of the song and plays it. When the playback reaches the point that has not yet been downloaded, Lesha immediately plays the song from the start (the loaded part of the song stays in his phone, and the download is continued from the same place), and it happens until the song is downloaded completely and Lesha listens to it to the end. For q seconds of real time the Internet allows you to download q - 1 seconds of the track.

Tell Lesha, for how many times he will start the song, including the very first start.

Input
The single line contains three integers T, S, q (2 ≤ q ≤ 10^4, 1 ≤ S < T ≤ 10^5).

Output
Print a single integer — the number of times the song will be restarted.
 */
public class Music {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double duration = input.nextInt();
		double secTillStart = input.nextInt();
		double speed = input.nextInt(); //download speed is (speed-1)/speed
		int started = 0;
		double compute = -1;
		double durationTrack = 0;
		while(durationTrack < duration){
			compute = ((durationTrack == 0)?secTillStart:durationTrack)*speed;
			durationTrack = compute;
			started++;
			
		}
		System.out.println(started);
	}
}