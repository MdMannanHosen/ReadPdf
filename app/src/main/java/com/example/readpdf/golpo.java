package com.example.readpdf;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.content.Context;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class golpo extends Fragment {

    public static ListView listView;
    TabLayout tabLayout;

    static ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    String[] pdfFiles = {"alogulajaliyeedau", "banichironthor", "debdas", "dosmohabidha", "gora", "hatchyee", "myjournery", "ooprothasithokhobita", "potherpachali", "premanksurrokthochai", "rechdead", "shrekanto", "themirakkelof moring"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_golpo, container, false);
        listView = myView.findViewById(R.id.listView);

        // Add data to arrayList
        addDataToArrayList();

        // Set adapter
        MyAdapter adapter = new MyAdapter(getActivity(), R.layout.item, arrayList);
        listView.setAdapter(adapter);

        return myView;
    }

    private void addDataToArrayList() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("headerText", "golpo");
        hashMap.put("footerText", "মুনীর চৌধুরী");
        hashMap.put("imageUrl", "https://ds.rokomari.store/rokomari110/ProductNew20190903/260X372/Cokher_Bali-Rabindranath_Tagore-c0180-272240.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("headerText", "প্রেমাংশুর রক্ত চাই  ");
        hashMap.put("footerText", "নির্মলেন্দু গুণ");
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
    }

    public class MyAdapter extends BaseAdapter {
        private Context context;
        private int layoutResourceId;
        private ArrayList<HashMap<String, String>> data;

        public MyAdapter(Context context, int layoutResourceId, ArrayList<HashMap<String, String>> data) {
            this.context = context;
            this.layoutResourceId = layoutResourceId;
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(layoutResourceId, parent, false);

                holder = new ViewHolder();
                holder.itemLayout = convertView.findViewById(R.id.itemLayout);
                holder.headerTextView = convertView.findViewById(R.id.chokerbaliItem);
                holder.footerTextView = convertView.findViewById(R.id.chokerbaliRobindronathItem);
                holder.imageView = convertView.findViewById(R.id.imageItem);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            HashMap<String, String> hashMap = data.get(position);
            holder.headerTextView.setText(hashMap.get("headerText"));
            holder.footerTextView.setText(hashMap.get("footerText"));
            Picasso.get().load(hashMap.get("imageUrl"))
                    .centerCrop()
                    .resize(100, 100)
                    .into(holder.imageView);

            Animation anim = AnimationUtils.loadAnimation(context, R.anim.button_click);
            holder.itemLayout.setOnClickListener(v -> v.startAnimation(anim));

            holder.itemLayout.setOnClickListener(v -> {
                String headerText = hashMap.get("headerText");
                Intent intent = new Intent(context, PdfViewerActivity.class);
                switch (headerText) {
                    case "রক্তাক্ত প্রান্তর":
                        intent.putExtra("pdfFileName", "alogulajaliyeedau.pdf");
                        break;
                    case "প্রেমাংশুর রক্ত চাই":
                        intent.putExtra("pdfFileName", "premanksurrokthochai.pdf");
                        break;
                    case "দেবদাস":
                        intent.putExtra("pdfFileName", "debdas.pdf");
                        break;
                    case "গোরা":
                        intent.putExtra("pdfFileName", "gora.pdf");
                        break;
                    case "পথের পাঁচালী":
                        intent.putExtra("pdfFileName", "potherpachali.pdf");
                        break;
                    default:
                        return;
                }
                context.startActivity(intent);
            });

            return convertView;
        }

        private class ViewHolder {
            LinearLayout itemLayout;
            TextView headerTextView;
            TextView footerTextView;
            ImageView imageView;
        }
    }
}
