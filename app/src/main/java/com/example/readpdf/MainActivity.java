package com.example.readpdf;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {




   public static  ListView listView;
    TabLayout tabLayout;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
     String[] pdfFiles = {"alogulajaliyeedau", "banichironthor", "debdas", "dosmohabidha", "gora", "hatchyee", "myjournery", "ooprothasithokhobita", "potherpachali", "premanksurrokthochai", "rechdead", "shrekanto", "themirakkelof moring"};












    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        tabLayout = findViewById(R.id.tabLayout);







        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//




        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("headerText", "হাত ছুঁয়ে-ছুঁয়ে দিয়েছি সব");
        hashMap.put("footerText", "কোয়েল তালুকদার");
        hashMap.put("imageUrl", "https://ds.rokomari.store/rokomari110/ProductNew20190903/260X372/Cokher_Bali-Rabindranath_Tagore-c0180-272240.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("headerText", "শ্রীকান্ত");
        hashMap.put("footerText", "শরৎচন্দ্র চট্টোপাধ্যায়");
        hashMap.put("imageUrl", "https://4.bp.blogspot.com/-alH-q8gl_Q4/WKia_SI9DPI/AAAAAAAAJQc/bkpKcG1M3Zo5rIR9zRc4SVH1XvcHw96IwCPcB/s640/Srikanta.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("headerText", "দেবদাস");
        hashMap.put("footerText", "শরৎচন্দ্র চট্টোপাধ্যায়");
        hashMap.put("imageUrl", "https://drishtibhongi.in/wp-content/uploads/2020/05/DEBDAS.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("headerText", "গোরা");
        hashMap.put("footerText", "রবীন্দ্রনাথ ঠাকুর");
        hashMap.put("imageUrl", "https://images.othoba.com/images/thumbs/0279227_-_400.jpeg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("headerText", "পথের পাঁচালী");
        hashMap.put("footerText", "বিভূতিভূষণ বন্দ্যোপাধ্যায়");
        hashMap.put("imageUrl", "https://fs.pbs.com.bd/DIR/Com/PBS/Product/Image/1806284.jpg");
        arrayList.add(hashMap);




        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//


        MyAdapter myAdapter = new MyAdapter(this, android.R.layout.simple_list_item_1, pdfFiles);
        listView.setAdapter(myAdapter);

        // Load fragment as needed
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabPosition = tab.getPosition();

                if (tabPosition == 0) {


                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout, new opponas());
                    fragmentTransaction.commit();

                    loadFragment(new opponas());
                    listView.setVisibility(View.VISIBLE);








                } else if (tabPosition == 1) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout, new golpo());
                    fragmentTransaction.commit();


                    loadFragment(new golpo());

                    listView.setVisibility(View.VISIBLE);  // Hide ListView when this tab is selected
                }

             else if (tabPosition == 2) {



                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout, new kobita());
                    fragmentTransaction.commit();


                loadFragment(new kobita());

                listView.setVisibility(View.VISIBLE);  // Hide ListView when this tab is selected
            }


                else if (tabPosition == 3) {


                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout, new natok());
                    fragmentTransaction.commit();


                    loadFragment(new natok());

                    listView.setVisibility(View.VISIBLE);


                }


                else if (tabPosition == 4) {



                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout, new cholochittro());
                    fragmentTransaction.commit();


                    loadFragment(new cholochittro());

                    listView.setVisibility(View.VISIBLE);


                }


                else if (tabPosition == 5) {


                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout, new golpo());
                    fragmentTransaction.commit();


                    loadFragment(new golpo());

                   listView.setVisibility(View.VISIBLE);


                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();







    }

    public class MyAdapter extends BaseAdapter {

        public MyAdapter(MainActivity mainActivity, int simpleListItem1, String[] pdfFiles)

        {




        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {



            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.item, parent, false);
            }




            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//


            LinearLayout itemLayout = convertView.findViewById(R.id.itemLayout);
            Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.button_click);
            itemLayout.setOnClickListener(v -> v.startAnimation(anim));

            LinearLayout itemLayout1 = convertView.findViewById(R.id.itemLayout);
            Animation anim1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.button_click);
            itemLayout.setOnClickListener(v -> v.startAnimation(anim));



            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//



            TextView headerTextView = convertView.findViewById(R.id.chokerbaliItem);
            TextView footerTextView = convertView.findViewById(R.id.chokerbaliRobindronathItem);
            ImageView imageView = convertView.findViewById(R.id.imageItem);



            HashMap<String, String> hashMap = arrayList.get(position);
            headerTextView.setText(hashMap.get("headerText"));
            footerTextView.setText(hashMap.get("footerText"));
            Picasso.get().load(hashMap.get("imageUrl"))
                    .centerCrop()
                    .resize(100, 100)
                    .into(imageView);




            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>////
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>////
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>////


            if (headerTextView.getText().toString().equals("চোখের বালি")) {
                itemLayout.setOnClickListener(v -> {
                    Intent intent = new Intent(MainActivity.this, PdfViewerActivity.class);
                    intent.putExtra("pdfFileName", "alogulajaliyeedau.pdf");
                    startActivity(intent);
                });

            }


            if (headerTextView.getText().toString().equals("শ্রীকান্ত")) {
                itemLayout.setOnClickListener(v -> {
                    Intent intent = new Intent(MainActivity.this, PdfViewerActivity.class);
                    intent.putExtra("pdfFileName", "shrekanto.pdf");
                    startActivity(intent);
                });

            }


            if (headerTextView.getText().toString().equals("দেবদাস")) {
                itemLayout.setOnClickListener(v -> {
                    Intent intent = new Intent(MainActivity.this, PdfViewerActivity.class);
                    intent.putExtra("pdfFileName", "debdas.pdf");
                    startActivity(intent);
                });

            }





            if (headerTextView.getText().toString().equals("গোরা")) {
                itemLayout.setOnClickListener(v -> {
                    Intent intent = new Intent(MainActivity.this, PdfViewerActivity.class);
                    intent.putExtra("pdfFileName", "gora.pdf");
                    startActivity(intent);
                });

            }




            if (headerTextView.getText().toString().equals("পথের পাঁচালী")) {
                itemLayout.setOnClickListener(v -> {
                    Intent intent = new Intent(MainActivity.this, PdfViewerActivity.class);
                    intent.putExtra("pdfFileName", "potherpachali.pdf");
                    startActivity(intent);
                });

            }









            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>////
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>////
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>////




            return convertView;
        }
    }
}
