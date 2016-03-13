package dz.esi.activities;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dz.esi.adapter.CutomAdapter;
import dz.esi.model.Book;

public class MainActivity extends AppCompatActivity {
    CutomAdapter cutomAdapter;
    ListView listView;
    //TODO get the ListView and set adapter at the fragment class
    //TODO handle only the itemClick event listener here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        //TODO copy to fragment class

        //TODO : let this here
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDetail((Book) listView.getAdapter().getItem(position));
            }
        });

        // implémenter le filtre
        //TODO : let this here
        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                cutomAdapter = (CutomAdapter) listView.getAdapter();
                cutomAdapter.getFilter().filter(newText);
                return false;
            }
        });

    }
    public boolean isTwoPane() {
        View view = findViewById(R.id.frameLayout);
        return (view != null);
    }

    public void showDetail(Book book) {
        if (isTwoPane()) {
            DetailFragment detailFragment = new DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("book",book);
            detailFragment.setArguments(bundle);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout,detailFragment);
            ft.commit();

        }
        else {
            Intent intent = new Intent(this,DetailActivity.class);
            intent.putExtra("book",book);
            startActivity(intent);
        }

    }
    // insérer des livres
    //TODO: Copy to fragment class

}
