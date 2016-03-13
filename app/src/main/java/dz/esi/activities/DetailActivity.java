package dz.esi.activities;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import dz.esi.model.Book;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        DetailFragment detailFragment = new DetailFragment();
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("book",intent.getSerializableExtra("book"));

        //TODO : Set the bundle properties with Intent properties then replace the layout
        //TODO : delete views and put them at  fragment level
        /*Intent intent = getIntent();
        Book book = (Book) intent.getSerializableExtra("book");
        */
        detailFragment.setArguments(bundle);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, detailFragment);
        ft.commit();
    }
}
