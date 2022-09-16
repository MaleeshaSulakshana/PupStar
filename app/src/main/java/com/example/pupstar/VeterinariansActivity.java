package com.example.pupstar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VeterinariansActivity extends AppCompatActivity {

    private ChipGroup chipGroup;
    private EditText search;
    private ImageView btnBack;

    private ListView listView;
    private ArrayList<VetItem> arrayList = new ArrayList<>();
    private ArrayList<VetItem> arrayList2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinarians);

        chipGroup = (ChipGroup) this.findViewById(R.id.chipGroup);

        listView = (ListView) this.findViewById(R.id.listView);
        search = (EditText) this.findViewById(R.id.search);
        btnBack = (ImageView) this.findViewById(R.id.btnBack);

        showClinics();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                String selected = String.valueOf(arrayList.get(i).getId());

                Intent intent = new Intent(VeterinariansActivity.this, VetShopDetailsActivity.class);
                intent.putExtra("id", selected);
                startActivity(intent);

            }
        });

        chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup chipGroup, int i) {

                Chip chip = chipGroup.findViewById(i);
                if (chip != null) {
                    String selected = chip.getText().toString();

                    if (selected.equals("Clinics")) {
                        showClinics();
                    } else {
                        showShops();
                    }

                }
            }
        });

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String value = charSequence.toString().toLowerCase();

                arrayList.clear();
                listView.setAdapter(null);

                VetAdapter vetAdapter = new VetAdapter(VeterinariansActivity.this, R.layout.row_vet_item, arrayList);
                listView.setAdapter(vetAdapter);

                if (!value.equals("")) {
                    for (int l = 0; l < arrayList2.size(); l++) {
                        if (arrayList2.get(l).getTitle().toLowerCase().contains(value)) {
                            arrayList.add(arrayList2.get(l));
                        }
                    }
                } else {
                    for (int l = 0; l < arrayList2.size(); l++) {
                        arrayList.add(arrayList2.get(l));
                    }
                }

                vetAdapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void showClinics()
    {

        arrayList.clear();
        arrayList2.clear();
        listView.setAdapter(null);

        VetAdapter vetAdapter = new VetAdapter(VeterinariansActivity.this, R.layout.row_vet_item, arrayList);
        listView.setAdapter(vetAdapter);

        arrayList.add(new VetItem("1", "Funa Vet Clinic", "Veterinary clinics", "1.5Km", "75%", "25%", "https://goo.gl/maps/KjZxLVHiDX12YoYS9", "https://www.thesprucepets.com/thmb/vR6i92pOyYmL6FEH3yQXHtR4HAA=/941x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/names-for-german-shepherds-4797840-hero-ed34431ad20c42c6894b4a29765b4d68.jpg"));
        arrayList.add(new VetItem("2", "Pet Care", "Veterinary clinics", "2Km", "65%", "35%", "https://goo.gl/maps/DERVxZwdDYxAwyUe8", "https://i.pinimg.com/736x/13/44/a9/1344a98c1a7bd9788838922836d813c0.jpg"));

        arrayList2.add(new VetItem("1", "Funa Vet Clinic", "Veterinary clinics", "1.5Km", "75%", "25%", "https://goo.gl/maps/KjZxLVHiDX12YoYS9", "https://www.thesprucepets.com/thmb/vR6i92pOyYmL6FEH3yQXHtR4HAA=/941x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/names-for-german-shepherds-4797840-hero-ed34431ad20c42c6894b4a29765b4d68.jpg"));
        arrayList2.add(new VetItem("2", "Pet Care", "Veterinary clinics", "2Km", "65%", "35%", "https://goo.gl/maps/DERVxZwdDYxAwyUe8", "https://i.pinimg.com/736x/13/44/a9/1344a98c1a7bd9788838922836d813c0.jpg"));

        vetAdapter.notifyDataSetChanged();

    }

    private void showShops()
    {
        arrayList.clear();
        arrayList2.clear();
        listView.setAdapter(null);

        VetAdapter vetAdapter = new VetAdapter(VeterinariansActivity.this, R.layout.row_vet_item, arrayList);
        listView.setAdapter(vetAdapter);

        arrayList.add(new VetItem("1", "Funa Vet Clinic Shop", "Veterinary clinics", "1.5Km", "75%", "25%", "https://goo.gl/maps/KjZxLVHiDX12YoYS9", "https://www.thesprucepets.com/thmb/vR6i92pOyYmL6FEH3yQXHtR4HAA=/941x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/names-for-german-shepherds-4797840-hero-ed34431ad20c42c6894b4a29765b4d68.jpg"));
        arrayList.add(new VetItem("2", "Pet Care Shop", "Veterinary clinics", "2Km", "65%", "35%", "https://goo.gl/maps/DERVxZwdDYxAwyUe8", "https://i.pinimg.com/736x/13/44/a9/1344a98c1a7bd9788838922836d813c0.jpg"));

        arrayList2.add(new VetItem("1", "Funa Vet Clinic Shop", "Veterinary clinics", "1.5Km", "75%", "25%", "https://goo.gl/maps/KjZxLVHiDX12YoYS9", "https://www.thesprucepets.com/thmb/vR6i92pOyYmL6FEH3yQXHtR4HAA=/941x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/names-for-german-shepherds-4797840-hero-ed34431ad20c42c6894b4a29765b4d68.jpg"));
        arrayList2.add(new VetItem("2", "Pet Care Shop", "Veterinary clinics", "2Km", "65%", "35%", "https://goo.gl/maps/DERVxZwdDYxAwyUe8", "https://i.pinimg.com/736x/13/44/a9/1344a98c1a7bd9788838922836d813c0.jpg"));

        vetAdapter.notifyDataSetChanged();
    }

}

class VetItem {

    String id, title, type, distance, good, bad, mapUrl, image;

    public VetItem(String id, String title, String type, String distance, String good, String bad, String mapUrl, String image) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.distance = distance;
        this.good = good;
        this.bad = bad;
        this.mapUrl = mapUrl;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getDistance() {
        return distance;
    }

    public String getGood() {
        return good;
    }

    public String getBad() {
        return bad;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public String getImage() {
        return image;
    }
}

class VetAdapter extends ArrayAdapter<VetItem> {

    private Context mContext;
    private int mResource;

    public VetAdapter(@NonNull Context context, int resource, @NonNull ArrayList<VetItem> objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView type = (TextView) convertView.findViewById(R.id.type);
        TextView distance = (TextView) convertView.findViewById(R.id.distance);
        TextView good = (TextView) convertView.findViewById(R.id.good);
        TextView bad = (TextView) convertView.findViewById(R.id.bad);

        title.setText(getItem(position).getTitle());
        type.setText(getItem(position).getType());
        distance.setText(getItem(position).getDistance());
        good.setText(getItem(position).getGood());
        bad.setText(getItem(position).getBad());

        Uri imgUri = Uri.parse(getItem(position).getImage());
        Picasso.get().load(imgUri).into(image);

        return convertView;
    }

}