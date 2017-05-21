package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/5/21.
 */

public class UserSearchBean extends CommonBean {
    private int searchType;
    private String keyword;
    private String start;
    private String num;
    private QueryUserBean[] users;

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
