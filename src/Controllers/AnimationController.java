package Controllers;

public class AnimationController {

    private String lastLine = "";

    public void print(String line) {
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

    public void animate(String line) {
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
}
