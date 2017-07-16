package cn.sportstory.android.profile.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.sportstory.android.R;
import cn.sportstory.android.settings.view.SettingsActivity;
import cn.sportstory.android.timeline.view.TimelineContentList;

import static cn.sportstory.android.profile.view.FollowersListActivity.FRAGMENT_TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ViewGroup head;
    private ViewGroup content;

    private ProfileAlbumFragment albumFragment;
    private ProfileSportsFragment sportsFragment;
    private TimelineContentList timelineFragment;
    private FragmentTransaction fragmentTransaction;

    private ImageView setting;
    private OnFragmentInteractionListener mListener;
    private static final int FRAGMENT_TIMELINE = 0, FRAGMENT_DATA = 1, FRAGMENT_ALBUM = 2;

    private TextView mTvFollowersNumber, mTvFollowingNumber;
    private LinearLayout mLlFollowingNumber, mLlFollowersNumber;

    private FrameLayout mFlContent;
    private LinearLayout mLlTimeline, mLlData, mLlAlbum;
    public MeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MeFragment newInstance(String param1, String param2) {
        MeFragment fragment = new MeFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        setting = (ImageView)view.findViewById(R.id.setting);
        head = (ViewGroup)view.findViewById(R.id.profile_head);
        content = (ViewGroup)view.findViewById(R.id.profile_content);
        head.findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EditProfileActivity.class));
            }
        });
        initView();
        return view;

    }


    private void initView(){
        mTvFollowersNumber = (TextView)head.findViewById(R.id.tv_profile_followers_number);
        mTvFollowingNumber = (TextView)head.findViewById(R.id.tv_profile_following_number);
        mLlFollowingNumber = (LinearLayout) head.findViewById(R.id.ll_profile_following_number);
        mLlFollowersNumber = (LinearLayout)head.findViewById(R.id.ll_profile_followers_number);

        mFlContent = (FrameLayout)content.findViewById(R.id.fl_profile_content);
        mLlTimeline = (LinearLayout)content.findViewById(R.id.ll_profile_content_timeline);
        mLlData = (LinearLayout)content.findViewById(R.id.ll_profile_content_data);
        mLlAlbum = (LinearLayout)content.findViewById(R.id.ll_profile_content_album);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SettingsActivity.class));
            }
        });

        mLlFollowersNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt(FRAGMENT_TAG, FollowersListActivity.FOLLOWERS_LIST);
                intent.putExtras(bundle);
                intent.setClass(getActivity(), FollowersListActivity.class);
                startActivity(intent);

            }
        });

        mLlFollowingNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt(FRAGMENT_TAG, FollowersListActivity.FOLLOWING_LIST);
                intent.putExtras(bundle);
                intent.setClass(getActivity(), FollowersListActivity.class);
                startActivity(intent);


            }
        });


        mLlAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(FRAGMENT_ALBUM);
            }
        });

        mLlData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(FRAGMENT_DATA);

            }
        });

        mLlTimeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(FRAGMENT_TIMELINE);
            }
        });
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
        /*
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        */
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

    private void changeFragment(int tag){
        if (getActivity() == null || getActivity().isFinishing())
            return;
        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        hideFragment();
        switch (tag){
            case FRAGMENT_ALBUM:
                if (albumFragment == null)
                {
                    albumFragment = new ProfileAlbumFragment();
                    fragmentTransaction.add(R.id.fl_profile_content, albumFragment).commit();
                }else
                {
                    fragmentTransaction.show(albumFragment).commit();
                }
                break;
            case FRAGMENT_DATA:
                if (sportsFragment == null)
                {
                    sportsFragment = new ProfileSportsFragment();
                    fragmentTransaction.add(R.id.fl_profile_content, sportsFragment).commit();
                }else
                {
                    fragmentTransaction.show(sportsFragment).commit();
                }
                break;
            case FRAGMENT_TIMELINE:
                if (timelineFragment == null)
                {
                    timelineFragment = new TimelineContentList();
                    fragmentTransaction.add(R.id.fl_profile_content, timelineFragment).commit();
                }else
                {
                    fragmentTransaction.show(timelineFragment).commit();
                }
                break;
        }
    }

    private void hideFragment(){
        if (timelineFragment != null)
            fragmentTransaction.hide(timelineFragment);
        if (albumFragment != null)
            fragmentTransaction.hide(albumFragment);
        if (sportsFragment != null)
            fragmentTransaction.hide(sportsFragment);
    }

}
