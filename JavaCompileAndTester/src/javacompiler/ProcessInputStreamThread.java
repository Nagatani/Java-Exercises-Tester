package javacompiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * InputStreamスレッド
 */
public class ProcessInputStreamThread extends Thread {

    private InputStream in;
    private String charset;
    private List<String> message;

    private ProcessInputStreamThread() {
        this.message = new ArrayList<>();
        this.charset = "UTF-8";
    }

    /**
     * InputStreamを指定して初期化
     *
     * @param in
     */
    public ProcessInputStreamThread(InputStream in) {
        this();
        this.in = in;
    }

    /**
     * InputStreamと文字コードを指定して初期化
     *
     * @param in
     * @param charset
     */
    public ProcessInputStreamThread(InputStream in, String charset) {
        this();
        this.in = in;
        this.charset = charset;
    }

    @Override
    public void run() {
        BufferedReader b;
        try {
            b = new BufferedReader(new InputStreamReader(in, charset));
            while (true) {
                String line = b.readLine();
                if (line == null) {
                    break;
                }
                this.getMessage().add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * @return the in
     */
    public InputStream getIn() {
        return this.in;
    }

    /**
     * @param in the in to set
     */
    public void setIn(InputStream in) {
        this.in = in;
    }

    /**
     * @return the charset
     */
    public String getCharset() {
        return this.charset;
    }

    /**
     * @param charset the charset to set
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * @return the message
     */
    public List<String> getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(List<String> message) {
        this.message = message;
    }

}
