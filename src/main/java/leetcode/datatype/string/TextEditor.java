package main.java.leetcode.datatype.string;

public class TextEditor {
    StringBuilder content = new StringBuilder();
    int cursorPosition = 0;

    public TextEditor() {

    }

    public void addText(String text) {
        content.insert(cursorPosition, text);
        cursorPosition += text.length();
    }

    public int deleteText(int k) {
        if (cursorPosition - k < 0)
            k = cursorPosition;
        content.delete(cursorPosition - k, cursorPosition);
        cursorPosition = cursorPosition - k;
        return k;
    }

    public String cursorLeft(int k) {
        cursorPosition = Math.max(0, cursorPosition - k);
        int t = Math.max(0, cursorPosition - 10);
        return content.substring(t, cursorPosition);
    }

    public String cursorRight(int k) {
        cursorPosition = Math.min(content.length(), cursorPosition + k);
        int t = Math.max(0, cursorPosition - 10);
        return content.substring(t, cursorPosition);
    }

    // TODO : ideal solution
}
