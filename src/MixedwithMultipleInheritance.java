abstract class Device {
    String brand = "Samsung";

    abstract void turnOn();

    void showBrand() {
        System.out.println("Brand: " + brand);
    }
}

interface Camera {
    int MAX_ZOOM = 10;

    void takePhoto();

    default void cameraInfo() {
        System.out.println("Camera is ready");
    }
}

interface MusicPlayer {
    String TYPE = "Digital";

    void playMusic();

    default void musicInfo() {
        System.out.println("Music player is ready");
    }
}

class Smartphone extends Device implements Camera, MusicPlayer {

    @Override
    void turnOn() {
        System.out.println("Smartphone is turned ON");
    }

    @Override
    public void takePhoto() {
        System.out.println("Taking photo...");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing music...");
    }
}

public class MixedwithMultipleInheritance {

    public static void main(String[] args) {

        Smartphone s = new Smartphone();

        s.turnOn();
        s.showBrand();
        s.takePhoto();
        s.playMusic();
        s.cameraInfo();
        s.musicInfo();

        System.out.println("Maximum Zoom: " + Camera.MAX_ZOOM);
        System.out.println("Music Type: " + MusicPlayer.TYPE);
    }
}