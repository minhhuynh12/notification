package fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mypc.notification.FragmentInteraction;
import com.example.mypc.notification.R;

import extras.Enumes;

/**
 * Created by MyPC on 11/09/2017.
 */

public class FragmentHot extends Fragment {
    Button btnHot, btnTodo;
    FragmentInteraction mInteraction;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot_comic , null );
        btnTodo = view.findViewById(R.id.btnTodo);
        btnHot = view.findViewById(R.id.btnHot);
        btnHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInteraction.openFragmnet(Enumes.FragmentType.FRAGMENT_ACTICLE, null , Enumes.Direction.RIGHT_IN);
            }
        });
        btnTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInteraction.openFragmnet(Enumes.FragmentType.FRAGMENT_TODO, null , Enumes.Direction.RIGHT_IN);
            }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mInteraction = (FragmentInteraction) context;
    }
}
