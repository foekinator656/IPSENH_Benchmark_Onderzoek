package Controllers;

import java.util.concurrent.atomic.AtomicBoolean;

public class AnimationController {

    private String lastLine = "";

    private void print(String line) {
        if (lastLine.length() > line.length()) {
            String temp = "";
            for (int i = 0; i < lastLine.length(); i++) {
                temp += " ";
            }
            if (temp.length() > 1)
                System.out.print("\r" + temp);
        }
        System.out.print("\r" + line);
        lastLine = line;
    }

    private byte anim;

    private void animate(String line) {
        switch (anim) {
            case 1:
                print("Thanks, working now. " + line);
                break;
            case 2:
                print("Thanks, working now.. " + line);
                break;
            case 3:
                print("Thanks, working now... " + line);
                break;
            default:
                anim = 0;
                print("Thanks, working now. " + line);
        }
        anim++;
    }

    public Thread run(AtomicBoolean isSortingRunning) {
        return new Thread(() -> {
            int i = 1;
            while (isSortingRunning.get()) {
                animate(i + " Seconds busy.");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        });
    }
}
