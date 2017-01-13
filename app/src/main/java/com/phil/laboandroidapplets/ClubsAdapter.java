package com.phil.laboandroidapplets;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by TSPhi on 2017-01-06.
 */

public class ClubsAdapter extends ArrayAdapter<Club> {

    private ClubsFragment mFragment;
    private ViewHolderItem viewHolderItem;

    public ClubsAdapter(ClubsFragment fragment, List<Club> clubs) {
        super(fragment.getActivity(), 0, clubs);
        mFragment = fragment;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Club club = getItem(position);
        final Context context = getContext();

        /*
        La méthode getView essaie d'obtenir une vue (convertView) recyclée. Cependant, si celle-ci
        est nulle, cela signifie qu'aucune vue recyclée est disponible. Il faut donc générer une
        nouvelle. En d'autres mots, on vérifie si une vue existante a été réutilisée  Autrement, on
        en génère une nouvelle.
         */
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.list_clubs_item, parent, false);
        }

        viewHolderItem = (ViewHolderItem) convertView.getTag();
        if (viewHolderItem == null) {
            viewHolderItem = new ViewHolderItem();
            viewHolderItem.textViewNomClub = (TextView) convertView.findViewById(R.id.nomClub);
            viewHolderItem.textViewLocalClub = (TextView) convertView.findViewById(R.id.localClub);
            viewHolderItem.imageViewIconClub = (ImageView) convertView.findViewById(R.id.iconeClub);
        }

        viewHolderItem.textViewNomClub.setText(club.getNom());

        viewHolderItem.textViewLocalClub.setText(club.getLocal());

        int idDrawable = context.getResources().getIdentifier(club.getIcone(), "drawable",
                context.getPackageName());
        viewHolderItem.imageViewIconClub.setImageResource(idDrawable);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragment.onButtonPressed(Uri.parse(club.getSitweb()));
            }
        });

        return convertView;
    }

    /**
     * Classe servant à retenir les références vers les sous-vues de la vue (item) de la liste et
     * éviter d'avoir à les rechercher de nouveau. Un ViewHolder est donc, associé à chaque vue de
     * la liste et il stocké en tant que propriété de cette vue dans l'attribut tag.
     */
    private class ViewHolderItem {
        public TextView textViewNomClub;
        public TextView textViewLocalClub;
        public ImageView imageViewIconClub;
    }
}
