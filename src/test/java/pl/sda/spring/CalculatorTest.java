package pl.sda.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.spring.exception.DivisionByZeroException;
import pl.sda.spring.operation.OperationType;
import pl.sda.spring.operation.PowerOperation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CalculatorTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void shouldReturnFiveForGivenArgumentsOnAdditionOperation() {
        //given
        double arg1 = 2.0;
        double arg2 = 3.0;

        //when
        double actual = calculator.calculate(OperationType.ADDITION, arg1, arg2);

        //then
        Assert.assertEquals(5.0, actual, 0.00000001);
    }

    @Test
    public void shouldReturnTwoForGivenArgumentsOnSubtractionOperation() {
        //given
        double arg1 = 5.0;
        double arg2 = 3.0;

        //when
        double actual = calculator.calculate(OperationType.SUBTRACTION, arg1, arg2);

        //then
        Assert.assertEquals(2.0, actual, 0.00000001);
    }

    @Test
    public void shouldReturnEightForGivenArgumentsOnMultiplicationOperation() {
        //given
        double arg1 = 4.0;
        double arg2 = 2.0;

        //when
        double actual = calculator.calculate(OperationType.MULTIPLICATION, arg1, arg2);

        //then
        Assert.assertEquals(8.0, actual, 0.00000001);
    }

    @Test
    public void shouldReturnTwoForGivenArgumentsOnDivisionOperation() {
        //given
        double arg1 = 4.0;
        double arg2 = 2.0;

        //when
        double actual = calculator.calculate(OperationType.DIVISION, arg1, arg2);

        //then
        Assert.assertEquals(2.0, actual, 0.00000001);
    }

    @Test(expected = DivisionByZeroException.class)
    public void shouldReturnExceptionForGivenArgumentsOnDivisionOperation() {
        //given
        double arg1 = 10.0;
        double arg2 = 0.0;
        double actual = calculator.calculate(OperationType.DIVISION, arg1, arg2);

        //when


    }

    @Test
    public void shouldReturnTwoForGivenArgumentsOnPercentageOperation() {
        //given
        double arg1 = 10.0;
        double arg2 = 20.0;

        //when
        double actual = calculator.calculate(OperationType.PERCENTAGE, arg1, arg2);

        //then
        Assert.assertEquals(2.0, actual, 0.00000001);
    }

    @Test
    public void shouldReturnNineForGivenArgumentsOnPowerOperation() {
        //given
        double arg1 = 4.0;
        double arg2 = 2.0;

        //when
        double actual = calculator.calculate(OperationType.POWER, arg1, arg2);

        //then
        Assert.assertEquals(16.0, actual, 0.00000001);
    }
}
