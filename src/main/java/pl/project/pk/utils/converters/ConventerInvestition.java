package pl.project.pk.utils.converters;


import pl.project.pk.database.models.Investment;
import pl.project.pk.mapper.InvestmentMapper;

public class ConventerInvestition {

    public static InvestmentMapper converToInvestmentMapper(Investment investment){
        InvestmentMapper investmentMapper = new InvestmentMapper();
        investmentMapper.setId(investment.getId());
        investmentMapper.setAmount(Long.toString(investment.getAmount()));
        investmentMapper.setCategory(investment.getCategory());
        investmentMapper.setClientMapper( ConventerClient.convertToClientMapper(investment.getClient()) );

        return investmentMapper;
    }

}
