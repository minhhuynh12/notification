package com.example.mypc.notification;

import android.os.Bundle;

import extras.Enumes;

/**
 * Created by MyPC on 11/09/2017.
 */

public interface FragmentInteraction  {
    void openFragmnet(Enumes.FragmentType fragmentType , Bundle bundle , Enumes.Direction direction);


}
