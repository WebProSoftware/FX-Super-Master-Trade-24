package pl.project.pk.utils.factory;

import org.junit.Assert;
import org.junit.Test;
import pl.project.pk.utils.investment.Forex;
import pl.project.pk.utils.investment.Fundusz;
import pl.project.pk.utils.investment.Lokata;

import static org.junit.Assert.*;


public class InvestmentFactoryMethodTest {
    @Test
    public void makeLokata() throws Exception {
        InvestmentFactoryMethod investmentFactoryMethod = new InvestmentFactoryMethod();
        Assert.assertEquals(investmentFactoryMethod.makeLokata().getClass(), new Lokata().getClass());
    }

    @Test
    public void makeFundusz() throws Exception {
        InvestmentFactoryMethod investmentFactoryMethod = new InvestmentFactoryMethod();
        Assert.assertEquals(investmentFactoryMethod.makeFundusz().getClass(), new Fundusz().getClass());
    }

    @Test
    public void makeForex() throws Exception {
        InvestmentFactoryMethod investmentFactoryMethod = new InvestmentFactoryMethod();
        Assert.assertEquals(investmentFactoryMethod.makeForex().getClass(), new Forex().getClass());
    }

}