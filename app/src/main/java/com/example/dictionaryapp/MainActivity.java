package com.example.dictionaryapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shashank.sony.fancytoastlib.FancyToast;

import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CardsAdapter adapter;
    ArrayList<String> List;

    Word word;

    Button searchButton;
    EditText searchEditText;
    ImageView headerImage;
    ImageView logoImage;

    String URL = "https://lingua-robot.p.rapidapi.com/language/v1/entries/en/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    if (searchEditText.getText().toString().isEmpty()) {
                        FancyToast.makeText(MainActivity.this, "Input word", 0, FancyToast.CONFUSING, false).show();
                    } else {
                        word = JsonUtils.getWordInfoFromJson(URL, searchEditText.getText().toString());
                        if (word.getWord() == null) {
                            FancyToast.makeText(MainActivity.this, "No results", 0, FancyToast.ERROR, false).show();
                        } else makeCards(word);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void makeCards(Word word) {
        List = word.getDefinitions();
        adapter = new CardsAdapter(List);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchButton = findViewById(R.id.searchBtn);
        searchEditText = findViewById(R.id.searchTxt);
        headerImage = findViewById(R.id.headerImage);
        logoImage = findViewById(R.id.logo);
        int imageResource = getResources().getIdentifier("headerlogo", "drawable", getPackageName());
        logoImage.setImageResource(imageResource);
    }
}



