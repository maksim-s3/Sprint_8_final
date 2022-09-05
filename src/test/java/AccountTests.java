import com.github.javafaker.Faker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTests {
    Faker faker = new Faker();

    @Test
    public void canBePrintNameTest() {
        Account account = new Account(faker.name().firstName() + " " + faker.name().lastName());
        boolean expected = true;
        boolean actual = account.checkNameToEmboss();
        assertEquals("", expected, actual);
    }

    @Test
    public void notCanBePrintShortNameTest() {
        Account account = new Account(faker.name().firstName().substring(0, 1) + " " + faker.name().lastName().substring(0, 1));
        boolean expected = false;
        boolean actual = account.checkNameToEmboss();
        assertEquals("", expected, actual);
    }

    @Test
    public void notCanBePrintLongNameTest() {
        StringBuilder name = new StringBuilder(faker.name().firstName() + " " + faker.name().lastName());
        while (name.length() < 20) {
            name.append("a");
        }
        Account account = new Account(name.toString());
        boolean expected = false;
        boolean actual = account.checkNameToEmboss();
        assertEquals("", expected, actual);
    }

    @Test
    public void notCanBePrintNameStartsWhitespace() {
        Account account = new Account(" " + faker.name().firstName() + " " + faker.name().lastName());
        boolean expected = false;
        boolean actual = account.checkNameToEmboss();
        assertEquals("", expected, actual);
    }

    @Test
    public void notCanBePrintNameEndsWhitespace() {
        Account account = new Account(faker.name().firstName() + " " + faker.name().lastName() + " ");
        boolean expected = false;
        boolean actual = account.checkNameToEmboss();
        assertEquals("", expected, actual);
    }
}
