package pl.project.pk.utils.investment;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class InvestmentBaseTest {
    private static List<InvestmentBase> inwestycje = new ArrayList<InvestmentBase>();

    @Test
    public void nazwaInwestycji() throws Exception {
        /* iterator w testach */

        inwestycje.add(new Lokata());
        inwestycje.add(new Fundusz());
        inwestycje.add(new Forex());

        inwestycje.add(new Lokata());
        inwestycje.add(new Fundusz());
        inwestycje.add(new Forex());

        Iterator<InvestmentBase> it = inwestycje.iterator();
        while(it.hasNext()) Assert.assertNotNull(it.next().nazwaInwestycji());

    }

}