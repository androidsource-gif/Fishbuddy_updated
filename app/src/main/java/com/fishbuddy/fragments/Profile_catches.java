package com.fishbuddy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fishbuddy.R;
import com.fishbuddy.customadapter.CustomRecyclerview;
import com.fishbuddy.sidemenu.SideMenu;
import com.fishbuddy.storedobjects.StoredObjects;

public class Profile_catches extends Fragment {
    RecyclerView profile_catches_recyclerview;
    CustomRecyclerview customRecyclerview;
  //  TextView title_txt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.profile_see_all_catches,null,false );
        StoredObjects.page_type="home";
        StoredObjects.back_type="profile_catches";
        SideMenu.updatemenu(StoredObjects.page_type);
        initilization(v);
        return v;
    }

    private void initilization(View v) {
        profile_catches_recyclerview = (RecyclerView) v.findViewById( R.id.profile_catches_recyclerview );
        customRecyclerview = new CustomRecyclerview(getActivity());

       // title_txt = (TextView)v.findViewById( R.id. title_txt);
       // title_txt.setText( "Catches" );

       /* ImageView backbtn_img = (ImageView)v.findViewById( R.id.backbtn_img );
        backbtn_img.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               fragmentcallinglay( new Profile() );

            }
        } );*/

        StoredObjects.hashmaplist(8);
          customRecyclerview.Assigndatatorecyleviewhashmap(profile_catches_recyclerview, StoredObjects.dummy_list,"profile_catches", StoredObjects.Gridview, 2, StoredObjects.ver_orientation, R.layout.profile_see_all_catches_listitems);


    }

    public void fragmentcallinglay(Fragment fragment) {

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace( R.id.frame_container, fragment ).commit();

    }

}
