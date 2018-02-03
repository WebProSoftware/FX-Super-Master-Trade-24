package pl.project.pk.database.models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class ClientTest {
    @Test
    public void setFirstName() throws Exception {
        String firstName = "Patryk";

        Client client = new Client();
        client.setFirstName(firstName);

        Assert.assertEquals(firstName, client.getFirstName());

    }

    @Test
    public void setLastname() throws Exception {
        String lastName = "Przybek";

        Client client = new Client();
        client.setLastname(lastName);

        Assert.assertEquals(lastName, client.getLastname());
    }

}