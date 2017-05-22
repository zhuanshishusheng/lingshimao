package com.example.administrator.lingshimao.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/23 0023.
 */

public class OrderBean {
    /**
     * orderList : [{"order_id":"891083","price":29,"status":"待付款","time":"1495468891206","userid":10001}]
     * response : orderList
     */

    private String response;
    private List<OrderListBean> orderList;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public static class OrderListBean {
        /**
         * order_id : 891083
         * price : 29
         * status : 待付款
         * time : 1495468891206
         * userid : 10001
         */

        private String order_id;
        private int price;
        private String status;
        private String time;
        private int userid;

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }
    }
}
