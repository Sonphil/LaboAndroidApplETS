package com.phil.laboandroidapplets;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by TSPhi on 2017-01-06.
 */

public class ClubsAdapter extends ArrayAdapter<Club> {

    private ClubsFragment mFragment;

    public ClubsAdapter(ClubsFragment fragment, List<Club> clubs) {
        super(fragment.getActivity(), 0, clubs);
        mFragment = fragment;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Club club = getItem(position);
        final Context context = getContext();

        // On vérifie si une vue existante a été réutilisée. Autrement, on la génère.
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.list_clubs_item, parent, false);
        }

        TextView textViewNomClub = (TextView) convertView.findViewById(R.id.nomClub);
        textViewNomClub.setText(club.getNom());

        TextView textViewLocalClub = (TextView) convertView.findViewById(R.id.localClub);
        textViewLocalClub.setText(club.getLocal());

        ImageView imageViewIconClub = (ImageView) convertView.findViewById(R.id.iconeClub);

        int idDrawable = context.getResources().getIdentifier(club.getIcone(), "drawable",
                context.getPackageName());
        imageViewIconClub.setImageResource(idDrawable);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragment.onButtonPressed(Uri.parse(club.getSitweb()));
            }
        });

        return convertView;
    }
}
