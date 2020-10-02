package com.example.customlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String mName [] = {"Thám tử lừng danh conan","Doraemon","DragonBall","Naruto","Pokemon","Tom and Jerry"};
    String mTG [] = {
            "Tác giả Aoyama Gōshō", "Tác giả Fujiko Fujio","Tác giả Toriyama Akira","Tác giả Kishimoto Masashi",
            "Tác giả Tajiri Satoshi, Sugimori Ken ", "Tác giả Gene Deitch"};
    int images[] = {R.drawable.conan, R.drawable.doremon, R.drawable.dragonball, R.drawable.naruto, R.drawable.pokemon, R.drawable.tomjerry};
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        MyApdapter apdapter = new MyApdapter(this, mName, mTG,images );
        listView.setAdapter(apdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Conan", Toast.LENGTH_SHORT).show();
                }
                if (position == 1){
                    Toast.makeText(MainActivity.this, "Doraemon", Toast.LENGTH_SHORT).show();
                }
                if (position == 2){
                    Toast.makeText(MainActivity.this, "Dragon Ball", Toast.LENGTH_SHORT).show();
                }
                if (position == 3){
                    Toast.makeText(MainActivity.this, "Naruto", Toast.LENGTH_SHORT).show();
                }
                if (position == 4){
                    Toast.makeText(MainActivity.this, "Pokemon", Toast.LENGTH_SHORT).show();
                }
                if (position == 5){
                    Toast.makeText(MainActivity.this, "Tom and Jerry", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    class  MyApdapter extends ArrayAdapter<String> {
        Context context;
        String mName[];
        String mTG[];
        int mimages[];

        MyApdapter (Context c, String name[], String tg[], int imgs[]){
            super(c,R.layout.row_listview,R.id.title, name);
            this.context = c;
            this.mName = name;
            this.mTG=tg;
            this.mimages = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row_listview = layoutInflater.inflate(R.layout.row_listview, parent, false);
            ImageView images = row_listview.findViewById(R.id.image);
            TextView title = row_listview.findViewById(R.id.title);
            TextView author = row_listview.findViewById(R.id.author);

            images.setImageResource(mimages[position]);
            title.setText(mName[position]);
            author.setText(mTG[position]);
            return row_listview;
        }
    }
}