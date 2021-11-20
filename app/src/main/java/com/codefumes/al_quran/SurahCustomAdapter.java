package com.codefumes.al_quran;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SurahCustomAdapter extends ArrayAdapter {
    private final Activity context;
    String[] surahList;

    public SurahCustomAdapter(Activity context,String[] data) {
        super(context,R.layout.card_info,data);
        this.context = context;
        this.surahList = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View singleCard = inflater.inflate(R.layout.card_info,null,true);
        TextView info = singleCard.findViewById(R.id.info);
        TextView ayatCount = singleCard.findViewById(R.id.ayat);
        ayatCount.setText("Verses "+Integer.toString(QuranData.getSurahVerses(position)));
        info.setText(surahList[position]);
        return singleCard;
    }
}
