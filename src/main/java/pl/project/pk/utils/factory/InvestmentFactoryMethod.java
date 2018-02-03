package pl.project.pk.utils.factory;


import pl.project.pk.utils.investment.Forex;
import pl.project.pk.utils.investment.Fundusz;
import pl.project.pk.utils.investment.Lokata;

public class InvestmentFactoryMethod {

    public InvestmentFactoryMethod(){}

    public Lokata makeLokata(){
        return new Lokata();
    }

    public Fundusz makeFundusz(){
        return new Fundusz();
    }

    public Forex makeForex(){
        return new Forex();
    }

}
