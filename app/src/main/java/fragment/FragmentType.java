package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypc.notification.R;

/**
 * Created by MyPC on 11/09/2017.
 */

public class FragmentType extends Fragment {
    TextView tvType;
    Bundle bundle;
    String Data;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_type , null);
        tvType = view.findViewById(R.id.tvType);
        bundle = new Bundle();
        bundle = getArguments();
        Data = bundle.getString("Data");

        tvType.setText(Data);

        return view;
    }
}
