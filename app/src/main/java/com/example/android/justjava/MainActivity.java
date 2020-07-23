package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int coffeePrice = 5;
    String name = "Paul Kardash";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */


    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        quantity--;
        display(quantity);
    }

    public void submitOrder(View view) {
        String cost = createOrderSummary(quantity, coffeePrice, name);
        displayMessage(cost);
        displayOrder("Your Order");
    }

    public void reset(View view) {
        quantity = 0;
        display(quantity);
        displayOrder("");
        displayMessage("");
    }

    /**
     * This method displays the given quantity value on the screen.
     */

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private void displayOrder(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_primary);
        priceTextView.setText(message);
    }


    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */

    private String createOrderSummary(int quantity, int onePrice, String name) {
        int price = quantity * onePrice;
        String summary = "Name: " + name + "\n" + "Quantity: " + quantity + "\n" + "Total, $: " + price + "\n" + "Thank you!";
        return summary;
    }
}
