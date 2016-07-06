package parser;

public class InputFormatter {
    private String data;

    public InputFormatter(String data) {
        this.data = data;
    }

    public String[] format() {
        return data.trim().replaceAll(" +", " ").split(" ");
    }
}
