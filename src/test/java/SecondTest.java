import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest{

    @Test
    public void MyntraTest() throws Exception {
        Reporter.log(String.format("Myntra Test Started %s",Thread.currentThread().getId()),true);
        getDriver().navigate().to("https://www.myntra.com/");
        Assert.assertEquals(getDriver().getTitle(), "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra");
        Reporter.log(String.format("Myntra Test Ended %s",Thread.currentThread().getId()),true);
    }

    @Test
    public void ThoughtWorksTest() throws Exception {
        Reporter.log(String.format("ThoughtWorks Test Started %s",Thread.currentThread().getId()),true);
        getDriver().navigate().to("https://www.thoughtworks.com/");
        //Assert.assertEquals(getDriver().getTitle(), "Thoughtworks: A global technology consultancy | Thoughtworks");
        Reporter.log(String.format("ThoughtWorks Test Ended %s",Thread.currentThread().getId()),true);
    }
}