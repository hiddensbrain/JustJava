package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int coffeePrice = 5;
    String name = "Paul";
    String drinkOfTheDay = "latte";
    String drinksOrdered = "Nothing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //This method is called when "+" button is clicked.
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    //This method is called when "-" button is clicked.
    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);
    }


    //This method is called when "order" button is clicked.

    public void submitOrder(View view) {
        createOrderSummary(quantity, coffeePrice, name);
    }

    //This method is called when "reset" button is clicked.
    public void reset(View view) {
        quantity = 0;
        displayQuantity(quantity);
        createOrderSummary(0, 0, "");
    }


    //This method displays the given quantity value on the screen.


    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * Calculates the price of the order based on the current quantity and one cup cost
     * <p>
     * Than if quantity os 0 or button Reset active - display empty text
     * and else - method displays given texts in both price_text_view and order_text_view fields
     */

    private void createOrderSummary(int quantity, int onePrice, String name) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        TextView orderTextView = findViewById(R.id.price_text_primary);
        int price = quantity * onePrice;
        if (quantity == 0) {
            priceTextView.setText("");
            orderTextView.setText("");
        } else {
            String summary = "Name: " + name + "\n" + "Quantity: " + quantity + "\n" + "Total, $: " + price + "\n" + "Thank you!";
            orderTextView.setText("Your Order:");
            priceTextView.setText(summary);
        }

    }
}
