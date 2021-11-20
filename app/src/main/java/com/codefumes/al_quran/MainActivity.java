package com.codefumes.al_quran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView list;
    SurahCustomAdapter adapter;
    String[] surahNames = QuranData.urduSurahNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.surahList);
        adapter = new SurahCustomAdapter(MainActivity.this,surahNames);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,SurahActivity.class);
                intent.putExtra("name",surahNames[position]);
                intent.putExtra("sidx",QuranData.getSurahStart(position) - 1);
                intent.putExtra("eidx",QuranData.getSurahStart(position+1));
                startActivity(intent);
            }
        });
    }
}