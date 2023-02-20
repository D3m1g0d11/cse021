package roommates;

import java.util.Scanner;

public class Preference {
	public int quietTime;
	public int music; 
	public int reading;
	public int chatting;
	
	// in main: Preference p = new Preference(0,10,10,10,9); 
	public Preference(int qTime, int musicPref, int readingPref, int chattingPref ) {
		if(qTime > 10) {
			this.quietTime = 10;
		}else if(qTime < 0) {
			this.quietTime = 0;
		}else {
			this.quietTime = qTime;
		}
		if(musicPref > 10) {
			this.music = 10;
		}else if(musicPref < 0) {
			this.music = 0;
		}else {
			this.music = musicPref;
		}if(readingPref > 10) {
			this.reading = 10;
		}else if(readingPref > 10) {
			this.reading = 0;
		}else {
			this.reading = readingPref;
		}
		if(chattingPref > 10) {
			this.chatting = 10;
		}else if(chattingPref < 0) {
			this.chatting = 0;
		}else {
			this.chatting = chattingPref;
		}
	}
	
	public int getQuietTime() { // Accessor
		return this.quietTime;
	}
	
	public int getMusic() { // Accessor
		return this.music;
	}
	public int getReading() { // Accessor
		return this.reading;
	}
	public int getChatting() { // Accessor
		return this.chatting;
	}
	
	
	public int compare(Preference pf) {
		
		int readDiff;
		int musicDiff;
		int quietDiff;
		int talkDiff;
		int prefDiff;
		
		readDiff = Math.abs(this.reading - pf.reading);
		musicDiff = Math.abs(this.music - pf.music);
		quietDiff = Math.abs(this.quietTime - pf.quietTime);
		talkDiff = Math.abs(this.chatting - pf.chatting);
		
		prefDiff = readDiff+musicDiff+quietDiff+talkDiff;
		
		return prefDiff;
	}
	}
