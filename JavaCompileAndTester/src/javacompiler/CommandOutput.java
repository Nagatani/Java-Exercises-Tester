package javacompiler;

import java.util.ArrayList;
import java.util.List;

/**
 * 処理結果
 */
public class CommandOutput {
    /**
     * 処理結果
     */
    private int exitValue;
    /**
     * 標準出力
     */
    private List<String> outputs;
    /**
     * エラー
     */
    private List<String> errors;

    public CommandOutput() {
         outputs = new ArrayList<>();
         errors = new ArrayList<>();
    }

    public CommandOutput(int exitValue, List<String> outputs, List<String> errors) {
        this.exitValue = exitValue;
        this.outputs = outputs;
        this.errors = errors;
    }

    /**
     * @return the exitValue
     */
    public int getExitValue() {
        return exitValue;
    }

    /**
     * @param exitValue the exitValue to set
     */
    public void setExitValue(int exitValue) {
        this.exitValue = exitValue;
    }

    /**
     * @return the outputs
     */
    public List<String> getOutputs() {
        return outputs;
    }

    /**
     * @param outputs the outputs to set
     */
    public void setOutputs(List<String> outputs) {
        this.outputs = outputs;
    }

    /**
     * @return the errors
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * @param errors the errors to set
     */
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
    
    
}
