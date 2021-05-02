package com.jatin.contextmenudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;


/*

 STEPS TO CREATE CONTEXT MENU:
    1. Override method onCreateContextMenu
    2. Set Title and Add items to the menu
    3. Register your Context Menu with any View
    4. Add Event Handling to detect item selected

 */
public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);

        registerForContextMenu(layout);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose Background");
        menu.add("Yellow");
        menu.add("Green");
        menu.add("Cyan");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getTitle().toString()){
            case "Yellow":
                layout.setBackgroundColor(Color.YELLOW);
                return true;
            case "Green":
                layout.setBackgroundColor(Color.GREEN);
                return true;
            case "Cyan":
                layout.setBackgroundColor(Color.CYAN);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}