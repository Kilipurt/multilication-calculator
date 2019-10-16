import com.BigIntegerMultiplication;
import com.MyMultiplication;
import org.junit.Assert;
import org.junit.Test;

public class Tests {

    private MyMultiplication myMultiplication = new MyMultiplication();
    private BigIntegerMultiplication bigIntegerMultiplication = new BigIntegerMultiplication();

    @Test
    public void algorithmsResultsShouldBeEqual() throws Exception {
        String firstFactor = "12345678901234567890";
        String secondFactor = "11111111111111111111";

        String actual = myMultiplication.multiply(firstFactor, secondFactor);
        String expected = bigIntegerMultiplication.multiply(firstFactor, secondFactor);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionShouldBeThrownByMyMultiplicationWhenSecondFactorIsWrong() throws Exception {
        String firstFactor = "12345678901234567890";
        String secondFactor = "qf";

        myMultiplication.multiply(firstFactor, secondFactor);
    }

    @Test(expected = Exception.class)
    public void exceptionShouldBeThrownByMyMultiplicationWhenFirstFactorIsWrong() throws Exception {
        String firstFactor = "wqf";
        String secondFactor = "11111111111111111111";

        myMultiplication.multiply(firstFactor, secondFactor);
    }

    @Test(expected = Exception.class)
    public void exceptionShouldBeThrownByBigIntegerMultiplicationWhenSecondFactorIsWrong() throws Exception {
        String firstFactor = "12345678901234567890";
        String secondFactor = "qf";

        bigIntegerMultiplication.multiply(firstFactor, secondFactor);
    }

    @Test(expected = Exception.class)
    public void exceptionShouldBeThrownByBigIntegerMultiplicationWhenFirstFactorIsWrong() throws Exception {
        String firstFactor = "wqf";
        String secondFactor = "11111111111111111111";

        bigIntegerMultiplication.multiply(firstFactor, secondFactor);
    }
}
