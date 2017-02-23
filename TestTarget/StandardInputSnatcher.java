import java.io.IOException;
import java.io.InputStream;

/**
 * 標準入力を置き換える
 * @author Nagatani
 */
public class StandardInputSnatcher extends InputStream {

    private final StringBuilder buffer = new StringBuilder();
    private final String linebreak = System.lineSeparator();

    /**
     * 文字列を入力する。改行は自動的に行う
     * @param str 入力文字列
     */
    public void inputln(String str) {
        buffer.append(str).append(linebreak);
    }

    @Override
    public int read() throws IOException {
        if (buffer.length() == 0) {
            return -1;
        }
        int result = buffer.charAt(0);
        buffer.deleteCharAt(0);
        return result;
    }
}
