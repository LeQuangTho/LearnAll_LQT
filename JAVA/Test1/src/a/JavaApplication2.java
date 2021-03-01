package a;
 
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
 
public class JavaApplication2 {
 
    public static void main(String[] args) throws MalformedURLException {
        File file = new File("F:\\JAVA\\Test1\\src\\a\\DongKiemEmCover-Vu-4580319_hq (online-audio-converter.com).wav");
        URL url = null;
        if (file.canRead()) {url = file.toURI().toURL();}
        System.out.println(url);
        AudioClip clip = Applet.newAudioClip(url);
        clip.play();
        clip.loop();
    }
}
//beep3.wav was available from: http://www.pacdv.com/sounds/interface_sound_effects/beep-3.wav
