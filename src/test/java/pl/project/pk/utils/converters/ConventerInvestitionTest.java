package pl.project.pk.utils.converters;

import org.junit.Assert;
import org.junit.Test;
import pl.project.pk.database.models.Client;
import pl.project.pk.database.models.Investment;
import pl.project.pk.mapper.InvestmentMapper;

public class ConventerInvestitionTest {
    @Test
    public void converToInvestmentMapper() throws Exception {

        Client client = new Client();
        client.setId(1);
        client.setFirstName("Test");
        client.setLastname("Test 2");
        client.setPhone("32131231");
        client.setSalary("20000");

        Investment investment = new Investment();
        investment.setId(1);
        investment.setCategory("Forex");
        investment.setClient(client);
        investment.setAmount((long) 2000);

        InvestmentMapper investmentMapperTest = new InvestmentMapper();
        investmentMapperTest.setId(1);
        investmentMapperTest.setCategory("Forex");
        investmentMapperTest.setClientMapper(ConventerClient.convertToClientMapper(client));
        investmentMapperTest.setAmount("2000");

        InvestmentMapper investmentMapper = ConventerInvestition.converToInvestmentMapper(investment);

        Assert.assertEquals(investmentMapper.getId(), investmentMapperTest.getId());

    }

}