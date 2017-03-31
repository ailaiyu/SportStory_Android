package cn.sportstory.sportstory.chat.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import cn.sportstory.sportstory.R;
import cn.sportstory.sportstory.chat.bean.ChatItemBean;
import cn.sportstory.sportstory.constants.TestConstants;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChatFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerView;
    private ChatRecyclerAdapter adapter;
    private  LinearLayoutManager layoutManager;
    private Button mBtnUpdate;
    private ArrayList<ChatItemBean> chats = new ArrayList<ChatItemBean>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    public ChatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
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
        View view =  inflater.inflate(R.layout.fragment_chat, container, false);
        mBtnUpdate = (Button)view.findViewById(R.id.btn_update);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycle_chat);
        recyclerView.setLayoutManager(layoutManager);
        fillTestData();
        adapter = new ChatRecyclerAdapter(chats, getContext());
        recyclerView.setAdapter(adapter);
        mBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testUpdateData();
            }
        });
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

    private static final int MSG_WHAT_CHAT_UPDATE = 1;

    /**
     *更新列表
     */
    private void updateChats(){

        //为了防止数据量过大，比对算法耗时，将算法放入新线程执行
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<ChatItemBean> oldChats = adapter.getChats();
                DiffUtil.DiffResult result = DiffUtil.calculateDiff(new ChatListCallback(oldChats, chats));
                Message message = updateChatsHandler.obtainMessage(MSG_WHAT_CHAT_UPDATE);
                message.obj = result;
                message.sendToTarget();
            }
        }).start();

    }

    private Handler updateChatsHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_WHAT_CHAT_UPDATE:
                    DiffUtil.DiffResult result = (DiffUtil.DiffResult)msg.obj;
                    result.dispatchUpdatesTo(adapter);
                    adapter.setChats(chats);
            }
        }
    };

    private void fillTestData(){
        int name = 0;
        for (int i = 0; i < 3000; i ++)
        {
            ChatItemBean bean = new ChatItemBean();
            bean.setAvatarPath(TestConstants.TEST_AVATAR_PATH);
            if (i%4 ==0)
                bean.setAvatarPath(TestConstants.TEST_AVATAR_PATH4);
            else if(i%3 == 0)
                bean.setAvatarPath(TestConstants.TEST_AVATAR_PATH3);
            else if (i % 2 == 0)
                bean.setAvatarPath(TestConstants.TEST_AVATAR_PATH5);
            bean.setUserId("" + i);
            bean.setNickname("用户名" + name ++ );
            bean.setMsg("测试测试测试测试测试测试测试测试test测试哈hahahahhahahaha哈哈哈哈哈哈哈去消息" + name);
            bean.setTime("12:12");
            chats.add(bean);
        }
    }

    int k = 0;
    private void testUpdateData(){
        k++;
        for (int kk =0; kk < chats.size(); kk ++) {
            chats.get(kk).setMsg("第" + k +"次修改之后的数据");
            chats.get(kk).setAvatarPath(TestConstants.TEST_AVATAR_PATH6);
            kk++;
        }
        updateChats();
    }
}
