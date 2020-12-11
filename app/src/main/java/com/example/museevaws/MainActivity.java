package com.example.museevaws;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Context context;
    LayoutInflater layoutInflater;

    List<Adress> adresses = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddUsersInList();
        Init();
    }

    private void AddUsersInList() {

    }

    private void Init() {
        listView = findViewById(R.id.listView);
        context = this;
        layoutInflater = LayoutInflater.from(context);
        UserListAdapter userListAdapter = new UserListAdapter();
    }

    private class UserListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return adresses.size();
        }

        @Override
        public Adress getItem(int position) {
            return adresses.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View currentView, ViewGroup parent) {
            Adress currentAdress = getItem(position);
            currentView = layoutInflater.inflate(R.layout.item_otdel, parent, false);
            TextView adresView = currentView.findViewById(R.id.AdresTextView);
            TextView tipView = currentView.findViewById(R.id.TipTextView);
            TextView stateView = currentView.findViewById(R.id.StateTextView);
            TextView timeView = currentView.findViewById(R.id.TimeTextView);

            adresView.setText(currentAdress.getAdres());
            tipView.setText(currentAdress.getTip());
            stateView.setText(currentAdress.getState());
            timeView.setText(currentAdress.getTime());

            return null;
        }
    }
}