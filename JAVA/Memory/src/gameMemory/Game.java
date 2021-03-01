package gameMemory;


import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Game {
	public static void main(String[] args) throws MalformedURLException {
		  File file = new File("..\\Java\\Memory\\src\\gameMemory\\sound\\DongKiemEmCover-Vu-4580319_hq (online-audio-converter.com).wav");
	        URL url = null;
	        if (file.canRead()) {url = file.toURI().toURL();}
	        AudioClip clip = Applet.newAudioClip(url);
	        clip.play();
		memory_Home home = new memory_Home();
		home.setVisible(true);
	}
}
