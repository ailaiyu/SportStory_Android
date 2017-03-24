package cn.sportstory.sportstory;

import android.net.Uri;
import android.os.Bundle;

import cn.sportstory.sportstory.activity.ActivityFragment;
import cn.sportstory.sportstory.chat.ChatFragment;
import cn.sportstory.sportstory.focus.FocusFragment;
import cn.sportstory.sportstory.me.MeFragment;
import cn.sportstory.sportstory.nearby.NearbyFragment;

public class MainActivity extends BaseActivity implements NearbyFragment.OnFragmentInteractionListener,
        ChatFragment.OnFragmentInteractionListener, FocusFragment.OnFragmentInteractionListener,
        ActivityFragment.OnFragmentInteractionListener, MeFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}