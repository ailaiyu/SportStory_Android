package cn.sportstory.android.profile.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

import cn.sportstory.android.R;
import cn.sportstory.android.profile.bean.Album;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileAlbumFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileAlbumFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileAlbumFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private RecyclerView mRecyclerView;
    private ArrayList<Album> albumData;
    private AlbumAdapter albumAdapter;

    public ProfileAlbumFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileAlbumFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileAlbumFragment newInstance(String param1, String param2) {
        ProfileAlbumFragment fragment = new ProfileAlbumFragment();
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
        View view =  inflater.inflate(R.layout.fragment_profile_album, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_album);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        initData();

        initAdapter();
        return view;
    }

    private void initAdapter() {
        albumAdapter = new AlbumAdapter(R.layout.album_item,albumData);
        albumAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT); //开启动画效果
        albumAdapter.isFirstOnly(false);   //动画默认执行一次，可对其修改
        mRecyclerView.setAdapter(albumAdapter);
    }

    private void initData() {
        albumData = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Album item = new Album();
            item.setAlbumName("相册"+i);
            albumData.add(item);
        }
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
        /*3
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
}
