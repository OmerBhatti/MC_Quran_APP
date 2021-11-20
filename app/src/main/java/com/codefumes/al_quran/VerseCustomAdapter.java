package com.codefumes.al_quran;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class VerseCustomAdapter extends ArrayAdapter {
    private final Activity context;
    String[] Verses;

    public VerseCustomAdapter(Activity context, String[] data) {
        super(context,R.layout.single_verse_layout,data);
        this.context = context;
        this.Verses = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View singleVerse = inflater.inflate(R.layout.single_verse_layout,null,true);
        TextView verse = singleVerse.findViewById(R.id.verse);
        verse.setText(Verses[position]);
        return singleVerse;
    }
}
