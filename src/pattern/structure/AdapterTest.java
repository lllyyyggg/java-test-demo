package pattern.structure;

import java.util.HashMap;
import java.util.Map;

public class AdapterTest {

    // 现在有两个软件，但是电脑只支持MediaPlayer这样的软件，不支持AdvancedMediaPlayer
    interface MediaPlayer {
        void play(String audioType, String fileName);
    }

    interface AdvancedMediaPlayer {
        void playMp4(String fileName);

        void playMp3(String fileName);
    }

    static class Mp4Player implements AdvancedMediaPlayer {
        @Override
        public void playMp4(String fileName) {
            System.out.println("Playing mp4 : " + fileName);
        }

        @Override
        public void playMp3(String fileName) {
        }
    }

    static class Mp3Player implements AdvancedMediaPlayer {
        @Override
        public void playMp4(String fileName) {
        }

        @Override
        public void playMp3(String fileName) {
            System.out.println("Playing mp3 : " + fileName);
        }
    }

    // 现在我想使用AdvancedMediaPlayer
    static class MediaPlayerAdapter implements MediaPlayer {
        private static final Map<String, AdvancedMediaPlayer> playerMap = new HashMap<>();

        static {
            playerMap.put("mp3", new Mp3Player());
            playerMap.put("mp4", new Mp4Player());
        }

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp3")) {
                playerMap.get("mp3").playMp3(fileName);
            } else if (audioType.equalsIgnoreCase("mp4")) {
                playerMap.get("mp4").playMp4(fileName);
            } else {
                throw new RuntimeException("不支持的文件类型");
            }
        }
    }

    static class Computer {
        private MediaPlayer mediaPlayer;
        public void install(MediaPlayer mediaPlayer) {
            this.mediaPlayer = mediaPlayer;
        }
        public void play(String audioType, String fileName) {
            this.mediaPlayer.play(audioType, fileName);
        }
    }

    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayerAdapter();
        Computer computer = new Computer();
        computer.install(mediaPlayer);
        computer.play("Mp4", "小森林.avi");
        computer.play("Mp3", "yourname.mp3");
        computer.play("Mp5", "yourname.mp3");
    }
}
