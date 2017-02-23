package javacompiler;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Nagatani
 */
public class JavaCompiler {

    // 提出されたJavaファイルの保存先（JUnitのテストプログラムも同じ所に入れておく必要がある。）
    public static final String JAVA_FILES_DIR = "/Users/Nagatani/github/Java-Exercises-Tester/TestTarget/";

    public static final String LIB_FILES_OPTIONS = ".:hamcrest-core-1.3.jar:junit-4.12.jar";

    /**
     * @param args the command line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // テスト対象のJavaファイルをコンパイル
        showOutput(exec("javac", "Target.java"));

        // テストプログラムをコンパイル
        showOutput(exec("javac", "-cp", LIB_FILES_OPTIONS, "TestUploadedFile.java"));

        // テスト実行
        CommandOutput ret = exec("java", "-cp", LIB_FILES_OPTIONS, "org.junit.runner.JUnitCore", "TestUploadedFile");
        showOutput(ret);
    }

    public static CommandOutput exec(String... args) throws IOException, InterruptedException {

        ProcessBuilder pb = new ProcessBuilder(args);
        System.out.println(pb.command().toString());
        // カレントディレクトリを指定
        File dir = new File(JAVA_FILES_DIR);
        pb.directory(dir);
        // プロセス開始
        Process process = pb.start();
        // 出力メッセージ受信スレッド
        ProcessInputStreamThread messages = new ProcessInputStreamThread(process.getInputStream());
        ProcessInputStreamThread errors = new ProcessInputStreamThread(process.getErrorStream());
        messages.start();
        errors.start();
        // 処理完了待ち
        process.waitFor();
        // メッセージ受信スレッド終了待ち
        messages.join();
        errors.join();
        // 戻り値作成
        CommandOutput ret = new CommandOutput(
                process.exitValue(),
                messages.getMessage(),
                errors.getMessage());

        return ret;
    }

    private static void showOutput(CommandOutput ret) {

        System.out.println("処理結果:" + ret.getExitValue());
        if (!ret.getOutputs().isEmpty()) {
            System.out.println("Message:" + (ret.getOutputs().size()));
            int row = 1;
            for (String s : ret.getOutputs()) {
                System.out.printf("%2s :", row++);
                System.out.println(s);
            }
        }
        if (!ret.getErrors().isEmpty()) {
            System.out.println("Error:" + (ret.getErrors().size()));
            for (String s : ret.getErrors()) {
                System.out.println(s);
            }
        }
    }

}
