package game;

public class Trivia {
    private String output;
    private String buttonText1;
    private String buttonText2;
    private String buttonText3;
    private int answer;

    public Trivia(String output, String buttonText1, String buttonText2, String buttonText3, int answer) {
        this.output = output;
        this.buttonText1 = buttonText1;
        this.buttonText2 = buttonText2;
        this.buttonText3 = buttonText3;
        this.answer = answer;
    }

    public String getOutput() { return output; }
    public String getButtonText1() { return buttonText1; }
    public String getButtonText2() { return buttonText2; }
    public String getButtonText3() { return buttonText3; }
    public int getAnswer() { return answer; }
}
