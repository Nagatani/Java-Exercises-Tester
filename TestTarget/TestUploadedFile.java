import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.hamcrest.core.Is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Nagatani
 */
public class TestUploadedFile extends JUnitSIOTestBase {

    Class target;

    @Test
    public void testMain() {
        Method target_method;
        try {
            target = Class.forName("Target");
            target_method = target.getMethod("main", String[].class);
            String[] params = null;
            target_method.invoke(null, (Object) params);
            // test
            assertThat(out.readLine(), Is.is("34"));
        } catch(ClassNotFoundException e) {
            // クラスが見つからない
        } catch(NoSuchMethodException e) {
            // メソッドが見つからない
        } catch(IllegalAccessException e) {
            // invokeできない
        } catch(InvocationTargetException e) {
        } catch(IllegalArgumentException e) {
        }
    }

    @Test
    public void これは絶対失敗するテスト() {
        Method target_method;
        try {
            target = Class.forName("Target");
            target_method = target.getMethod("main", String[].class);
            String[] params = null;
            target_method.invoke(null, (Object) params);
            // test
            assertThat(out.readLine(), Is.is("33"));
        } catch(ClassNotFoundException e) {
            // クラスが見つからない
        } catch(NoSuchMethodException e) {
            // メソッドが見つからない
        } catch(IllegalAccessException e) {
            // invokeできない
        } catch(InvocationTargetException e) {
        } catch(IllegalArgumentException e) {
        }
    }

    @Test
    public void これは成功するテスト() {
        Method target_method;
        try {
            target = Class.forName("Target");
            target_method = target.getMethod("main", String[].class);
            String[] params = null;
            target_method.invoke(null, (Object) params);
            // test
            assertThat(out.readLine(), Is.is("34"));
        } catch(ClassNotFoundException e) {
            // クラスが見つからない

        } catch(NoSuchMethodException e) {
            // メソッドが見つからない

        } catch(IllegalAccessException e) {
            // invokeできない
        } catch(InvocationTargetException e) {

        } catch(IllegalArgumentException e) {

        }

    }



}
