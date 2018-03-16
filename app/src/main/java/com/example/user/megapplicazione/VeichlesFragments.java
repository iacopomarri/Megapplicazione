
package com.example.user.megapplicazione;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class VeichlesFragments extends Fragment implements View.OnClickListener{

    //per apertura nuovi fragment
    FragmentTransaction fragmentTransaction;

    public VeichlesFragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView= inflater.inflate(R.layout.fragment_veichles, container, false);
        ImageButton addButton = (ImageButton)rootView.findViewById(R.id.addButton);

        addButton.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()){
            case R.id.addButton:
                fragment= new AddFragment();
                replaceFragment(fragment);
                break;
        }

    }

    //rimpiazza il fragment. Usato in onClick
    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.main_container, someFragment);
        transaction.replace(R.id.main_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}