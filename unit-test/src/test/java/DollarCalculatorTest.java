import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class DollarCalculatorTest {
    @Mock
    public MarketApi marketApi;

    @BeforeEach
    public void init() {
        Mockito.lenient().when(marketApi.connect()).thenReturn(200);
    }

    @Test
    public void dollarTest() {
        MarketApi marketApi = new MarketApi();
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();
        Calculator calculator = new Calculator(dollarCalculator);


        Assertions.assertEquals(2200, calculator.sum(10, 10));
    }

    @Test
    public void mockDollarTest() {
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();
        Calculator calculator = new Calculator(dollarCalculator);


        Assertions.assertEquals(4000, calculator.sum(10, 10));
    }

}