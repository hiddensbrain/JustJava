package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int coffeePrice = 5;
    String customerName = "Paul";
    String drinkOfTheDay = "latte";
    double backPressedTime = 0;
    Toast backToast;
    boolean hasWhippedCream;
    boolean hasCinnamon;
    boolean hasChocolate;
    String toppings = "Toppings: ";
    String whippedCream;
    String cinnamon;
    String chocolate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //next method stretches the application to fill whole phone screen
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    //This method is called when "+" button is clicked.
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    //This method is called when "-" button is clicked.
    public void decrement(View view) {
        if (quantity == 0) {
            Toast.makeText(this, "Can't be below 0", Toast.LENGTH_SHORT).show();
        } else {
            quantity--;
        }
        displayQuantity(quantity);
    }


    //This method is called when "order" button is clicked.

    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = findViewById(R.id.checkBoxCream);
        CheckBox cinnamonCheckBox = findViewById(R.id.checkBoxCinnamon);
        CheckBox chocolateCheckBox = findViewById(R.id.checkBoxChocolate);
        hasWhippedCream = whippedCreamCheckBox.isChecked();
        hasCinnamon = cinnamonCheckBox.isChecked();
        hasChocolate = chocolateCheckBox.isChecked();
        creamCounter(hasWhippedCream);
        chocoCounter(hasChocolate);
        cinnCounter(hasCinnamon);
        toppings =  whippedCream  + chocolate  + cinnamon;
        createOrderSummary(quantity, coffeePrice, customerName);
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

    //counting cream, returning String
    public void creamCounter(boolean cream) {
        if (cream) {
            whippedCream = "\n" + "+ Whipped Cream";
        } else {
            whippedCream = "";
        }
    }

    //counting choco, returning String
    public void chocoCounter(boolean choco) {
        if (choco) {
            chocolate = "\n" + "+ Chocolate";
        } else {
            chocolate = "";
        }
    }

    //counting cinnamon, returning String
    public void cinnCounter(boolean cinn) {
        if (cinn) {
            cinnamon = "\n" + "+ Cinnamon";
        } else {
            cinnamon = "";
        }
    }

    /**
     * Calculates the price of the order based on the current quantity and one cup cost
     * <p>
     * Than if quantity os 0 or button Reset active - display empty text
     * and else - method displays given texts in both price_text_view and order_text_view fields
     */

    private void createOrderSummary(int quantity, int coffeePrice, String customerName) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        TextView orderTextView = findViewById(R.id.price_text_primary);
        int price = quantity * coffeePrice;


//        if (hasWhippedCream) {
//            toppings = "Toppings: Whipped Cream";
//        } else {
//            toppings = "Toppings: None";
//        }
        if (quantity == 0) {
            priceTextView.setText("");
            orderTextView.setText("");
        } else {
            String summary = "Name: " + customerName + "\n" + "Quantity of coffees: " + quantity  + toppings + "\n" + "\n" + "Total, $: " + price + "\n" + "\n" + "Thank you!";
            orderTextView.setText("Your Order:");
            priceTextView.setText(summary);
        }


    }

    //system button "back" start
    //Exiting app by popup and second click
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "For Exit, Push one more time", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
    //system button "back" end

}



