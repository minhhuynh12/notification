package fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mypc.notification.FragmentInteraction;
import com.example.mypc.notification.R;

import extras.Enumes;



public class FragmentDownload extends BaseFragment {
    Button btnDownload;
    FragmentInteraction mInteraction;
    EditText editDownload;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_download , null);
        editDownload = view.findViewById(R.id.editDownload);


        btnDownload = (Button) view.findViewById(R.id.btnDownload);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Data" , editDownload.getText().toString());
                hideKeyboardIfNeed(getContext());
                mInteraction.openFragmnet(Enumes.FragmentType.FRAGMENT_TYPE, bundle , Enumes.Direction.RIGHT_IN);
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
