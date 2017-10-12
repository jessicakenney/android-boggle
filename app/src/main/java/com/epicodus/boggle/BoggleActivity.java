package com.epicodus.boggle;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import static com.epicodus.boggle.R.id.parent;

public class BoggleActivity extends AppCompatActivity {
    GridView gridView;
    LetterAdapter letterAdapter;
    TextView testTextView;
    String[] letters = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boggle);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/caviardreams.ttf");
        gridView = (GridView) findViewById(R.id.baseGridView);

        letterAdapter = new LetterAdapter(this,letters,typeface);
        gridView.setAdapter(letterAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedItem = letterAdapter.getItem(position).toString();
                Toast.makeText(BoggleActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
                //testTextView.setText(selectedItem);
            }
        });
    }



}
