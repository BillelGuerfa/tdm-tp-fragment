package dz.esi.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import dz.esi.model.Book;

/**
 * Created by Billel Guerfa on 07/03/2016.
 */

//TODO DetailActivity views here , use Bundle
public class DetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, null);
        Bundle bundle = getArguments();
        Book book = (Book) bundle.getSerializable("book");
        ImageView coverImage = (ImageView) view.findViewById(R.id.coverImage);
        TextView textSummary = (TextView) view.findViewById(R.id.summary);
        TextView textYear = (TextView) view.findViewById(R.id.yearText);
        TextView textTitle = (TextView) view.findViewById(R.id.textTitle);
        TextView textEditor = (TextView) view.findViewById(R.id.editorText);
        TextView textAuthor = (TextView) view.findViewById(R.id.textAuthor);
        coverImage.setImageResource(book.getCover());
        textSummary.setText(book.getSummary());
        textTitle.setText("Titre: "+book.getTitle());
        textYear.setText("Année d'édition: "+book.getYear());
        textEditor.setText("Editeur: "+book.getEditor());
        textAuthor.setText("Auteur(s): "+book.getAuthors().get(0));
        if(book.getAuthors().size()>1) {
            //textAuthorLabel.setText("Auteurs: ");
            for(int i=1;i<book.getAuthors().size();i++) {
                textAuthor.setText(textAuthor.getText()+", "+book.getAuthors().get(i));
            }
        }
        return view;
    }
}
