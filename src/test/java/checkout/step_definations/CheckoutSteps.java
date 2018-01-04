package checkout.step_definations;

import checkout.implementation.Checkout;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class CheckoutSteps {

    private Checkout checkout = new Checkout();

    @Given("^the price of a \"([^\"]*)\" is (\\d+)c$")
    public void the_price_of_a_is_c(String ItemName, int ItemPrice) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        checkout.addItem(ItemName,ItemPrice);
    }

    @When("^I checkout (\\d+) \"([^\"]*)\"$")
    public void i_checkout(int itemCount, String itemName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        checkout.add(itemCount,itemName);
    }

    @Then("^the total price should be (\\d+)c$")
    public void the_total_price_should_be_c(int expectedPrice) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        int actualPrice = checkout.getTotalPrice();
        assertEquals(expectedPrice,actualPrice);
    }

    @Then("^the total price of \"([^\"]*)\" should be <BananaPriceTotal>c$")
    public void theTotalPriceOfShouldBeBananaPriceTotalC(String itemName,int expectedItemTotal) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        int actualItemTotal = checkout.getTotalItemPrice(itemName);
        assertEquals(expectedItemTotal,actualItemTotal);
    }

    @Then("^the total price of \"([^\"]*)\" should be (\\d+)c$")
    public void the_total_price_of_should_be_c(String itemName,int expectedItemTotal) throws Throwable {
        int actualItemTotal = checkout.getTotalItemPrice(itemName);
        assertEquals(expectedItemTotal,actualItemTotal);
    }
}
