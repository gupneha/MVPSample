package app.mvp.sample;

import org.junit.Test;

import app.mvp.sample.util.Validate;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void empty_validator_false() throws Exception {
        assertEquals(false, Validate.isEmpty("abc"));
    }

    @Test
    public void empty_validator_true() throws Exception {
        assertEquals(true, Validate.isEmpty(""));
    }

    @Test
    public void email_validator() throws Exception {
        assertEquals(true, Validate.validEmail("abcd@gmail.com"));
    }

    @Test
    public void password_validator() throws Exception {
        assertEquals(true, Validate.validPassword("123456"));
    }
}