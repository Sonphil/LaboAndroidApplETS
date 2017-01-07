package com.phil.laboandroidapplets;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ClubsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ClubsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClubsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ListView mListViewClubs;
    private ClubsDBAdapter clubsDBAdapter;

    public ClubsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClubsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClubsFragment newInstance(String param1, String param2) {
        ClubsFragment fragment = new ClubsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void setUpClubsList(View view) {
        mListViewClubs = (ListView) view.findViewById(R.id.liste_clubs);
        Context context = getActivity();
        clubsDBAdapter = new ClubsDBAdapter(context);
        if (clubsDBAdapter.getCount() == 0) {
            // Seed
            clubsDBAdapter.insertClub(new Club("ApplETS", "A-1304", "ic_applets", "https://clubapplets.ca/"));
            clubsDBAdapter.insertClub(new Club("Baja ÉTS", " A-1332", "ic_baja", "http://baja.etsmtl.ca/"));
            clubsDBAdapter.insertClub(new Club("Conjure", "A-1744", "ic_conjure", "http://conjure.etsmtl.ca/"));
            clubsDBAdapter.insertClub(new Club("Dronolab", "A-1760", "ic_dronolab", "http://dronolab.com/"));
            clubsDBAdapter.insertClub(new Club("Formule ETS", "A-1330", "ic_formuleets", "http://formuleets.ca/"));
            clubsDBAdapter.insertClub(new Club("LAN ETS", "B-0506", "ic_lanets", "https://lanets.ca/"));
            clubsDBAdapter.insertClub(new Club("Reflets", "B-3412", "ic_reflets", "http://clubreflets.com/"));
            clubsDBAdapter.insertClub(new Club("RockÉTS", "A-1764", "ic_rockets", "http://www.clubrockets.ca/"));
            clubsDBAdapter.insertClub(new Club("S.O.N.I.A.", "A-XXXX", "ic_sonia", "http://sonia.etsmtl.ca/?lang=fr"));
        }
        ArrayAdapter adapter = new ClubsAdapter(this, clubsDBAdapter.getAllClubsAsList());
        mListViewClubs.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clubs, container, false);
        setUpClubsList(view);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
