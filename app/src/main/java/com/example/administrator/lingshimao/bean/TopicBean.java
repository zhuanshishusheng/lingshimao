package com.example.administrator.lingshimao.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/15 0015.
 */

public class TopicBean {
    /**
     * data : [{"describe":"【如水】黑西瓜子220g回味无穷（赏味期到12....","id":1,"imageurl":"/images/topic/topic_bangonglingzui_guazi.jpg","type":"办公零嘴"},{"describe":"【英国川宁】豪门伯爵红茶 红茶首创者","id":2,"imageurl":"/images/topic/topic_bangonglingzui_hongcha.jpg","type":"办公零嘴"},{"describe":"【美国Fisher】芬时乐美式蜂蜜烤花生","id":3,"imageurl":"/images/topic/topic_bangonglingzui_huasheng.jpg","type":"办公零嘴"},{"describe":"韩国火爆款美女石榴汁帅哥一卖买一箱","id":4,"imageurl":"/images/topic/topic_bangonglingzui_shiliuzhi.jpg","type":"办公零嘴"},{"describe":"【庄味夫】美国扁桃仁 完整果仁260g（赏味期到1..","id":5,"imageurl":"/images/topic/topic_bangonglingzui_taoren.jpg","type":"办公零嘴"}]
     * response : sort
     */

    private String response;
    private List<DataBean> data;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * describe : 【如水】黑西瓜子220g回味无穷（赏味期到12....
         * id : 1
         * imageurl : /images/topic/topic_bangonglingzui_guazi.jpg
         * type : 办公零嘴
         */
        private static final long serialVersionUID = -7060210544600464481L;
        private String describe;
        private int id;
        private String imageurl;

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getLove() {
            return love;
        }

        public void setLove(int love) {
            this.love = love;
        }

        public int getProceeds() {
            return proceeds;
        }

        public void setProceeds(int proceeds) {
            this.proceeds = proceeds;
        }

        public String getImageDetail() {
            return imageDetail;
        }

        public void setImageDetail(String imageDetail) {
            this.imageDetail = imageDetail;
        }

        private String type;
        private int price;

        private int love;
        private int proceeds;
        private String imageDetail;

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
