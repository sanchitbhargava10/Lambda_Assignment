package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class IphoneTest extends BaseTest {

    @Test
    public void addIphoneToCart() {

        setup();

        page.navigate("https://www.amazon.com");

        page.locator("#twotabsearchtextbox")
                .fill("iPhone");

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
                "iPhone Price : " + price);

        productPage.locator("#add-to-cart-button")
                .click();

        tearDown();
    }
}
