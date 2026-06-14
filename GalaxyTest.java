package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class GalaxyTest extends BaseTest {

    @Test
    public void addGalaxyToCart() {

        setup();

        page.navigate("https://www.amazon.com");

        page.locator("#twotabsearchtextbox")
                .fill("Samsung Galaxy");

        page.keyboard().press("Enter");

        page.locator("div[data-component-type='s-search-result']")
                .first()
                .click();

        Page productPage = page.context()
                .waitForPage(() -> {});

        String price = productPage
                .locator(".a-price-whole")
                .first()
                .textContent();

        System.out.println(
                "Galaxy Price : " + price);

        productPage.locator("#add-to-cart-button")
                .click();

        tearDown();
    }
}
