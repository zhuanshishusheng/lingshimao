package com.example.administrator.lingshimao.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/17 0017.
 */

public class CarBean {
    /**
     * data : [{"describe":"【英国川宁】豪门伯爵红茶 红茶首创者","id":2,"imageDetail":"/images/topic/topic_bangonglingzui_hongchada.jpg","imageurl":"/images/topic/topic_bangonglingzui_hongcha.jpg","love":120,"price":29,"proceeds":343,"type":"办公零嘴"}]
     * response : carlist
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

    public static class DataBean {
        /**
         * describe : 【英国川宁】豪门伯爵红茶 红茶首创者
         * id : 2
         * imageDetail : /images/topic/topic_bangonglingzui_hongchada.jpg
         * imageurl : /images/topic/topic_bangonglingzui_hongcha.jpg
         * love : 120
         * price : 29
         * proceeds : 343
         * type : 办公零嘴
         */

        private String describe;
        private int id;
        private String imageDetail;
        private String imageurl;
        private int love;
        private int price;
        private int proceeds;
        private String type;

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

        public String getImageDetail() {
            return imageDetail;
        }

        public void setImageDetail(String imageDetail) {
            this.imageDetail = imageDetail;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }

        public int getLove() {
            return love;
        }

        public void setLove(int love) {
            this.love = love;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getProceeds() {
            return proceeds;
        }

        public void setProceeds(int proceeds) {
            this.proceeds = proceeds;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
