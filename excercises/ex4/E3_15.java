package ap.excercises.ex4;

public class E3_15 {
    public static void main(String[] args) {
        Letter letter = new Letter("Mary", "John");
        letter.addLine("I am sorry we must part.");
        letter.addLine("I wish you all the best.");

        System.out.println(letter.getText());
    }
}
//the class
public class Letter {
    private String sender;
    private String recipient;
    private String body;

    public Letter(String from, String to) {
        sender = from; 
        recipient = to;
        body = "";
    }

    public void addLine(String line) {
        body = body.concat(line).concat("\n");
    }

    public String getText() {
        String letterText = "";
        letterText = letterText.concat("Dear ").concat(recipient).concat(":\n\n");
        letterText = letterText.concat(body).concat("\n");
        letterText = letterText.concat("Sincerely,\n\n");
        letterText = letterText.concat(sender);
        return letterText;
    }
}
