package com.codefumes.al_quran;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SurahActivity extends AppCompatActivity {

    ListView list;
    VerseCustomAdapter adapter;
    Intent intent;
    String[] verses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);
        intent = getIntent();

        int sidx = intent.getIntExtra("sidx",0);
        int eidx = intent.getIntExtra("eidx",0) - 1;
        verses = QuranData.GetData(sidx,eidx);

        String surah = intent.getStringExtra("name");
        TextView name = findViewById(R.id.surahName);
        name.setText(surah);

        list = findViewById(R.id.verseList);
        adapter = new VerseCustomAdapter(SurahActivity.this,verses);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, verses[i]);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void shareSurah(View v){
        String surahAll = String.join(" ", verses);
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, surahAll);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

}