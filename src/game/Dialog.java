package game;

public class Dialog {
    private String output;
    private String buttonText1;
    private String buttonText2;

    public Dialog(String output, String buttonText1, String buttonText2) {
        this.output = output;
        this.buttonText1 = buttonText1;
        this.buttonText2 = buttonText2;
    }

    public String getOutput() { return output; }
    public String getButtonText1() { return buttonText1; }
    public String getButtonText2() { return buttonText2; }
}
