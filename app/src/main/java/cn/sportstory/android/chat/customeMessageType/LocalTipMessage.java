package cn.sportstory.android.chat.customeMessageType;

import android.os.Parcel;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import io.rong.common.ParcelUtils;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;

/**
 * Created by aaron on 2017/4/30.
 */

public class LocalTipMessage extends MessageContent {

    private String content;
    private String extra;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public LocalTipMessage(Parcel in) {
        this.setContent(ParcelUtils.readFromParcel(in));
        this.setExtra(ParcelUtils.readFromParcel(in));
    }

    public static final Creator<LocalTipMessage> CREATOR = new Creator() {
        public LocalTipMessage createFromParcel(Parcel source) {
            return new LocalTipMessage(source);
        }

        public LocalTipMessage[] newArray(int size) {
            return new LocalTipMessage[size];
        }
    };
    @Override
    public byte[] encode() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("content", content);
            jsonObject.put("extra", extra);
        }catch (JSONException e){
            Log.e("JSONException", e.getMessage());
        }
        try {
            return jsonObject.toString().getBytes("UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        ParcelUtils.writeToParcel(dest, content);
        ParcelUtils.writeToParcel(dest, extra);
    }

}
