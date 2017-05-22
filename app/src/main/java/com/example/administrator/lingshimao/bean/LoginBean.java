package com.example.administrator.lingshimao.bean;

/**
 * Created by Administrator on 2017/5/15 0015.
 */

public class LoginBean {
    /**
     * data : {"defaultAddress":"1","id":10001,"password":"123456","phone":"15538302070","username":"zp"}
     * response : login
     */

    private DataBean data;
    private String response;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    private String error;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public static class DataBean {
        /**
         * defaultAddress : 1
         * id : 10001
         * password : 123456
         * phone : 15538302070
         * username : zp
         */

        private String defaultAddress;
        private int id;
        private String password;
        private String phone;
        private String username;

        public String getDefaultAddress() {
            return defaultAddress;
        }

        public void setDefaultAddress(String defaultAddress) {
            this.defaultAddress = defaultAddress;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    /**
     * data : {"id":10001,"password":"123456","username":"zp"}
     * response : login
     */


    /**
     * error : 请求参数错误或缺失
     * error_code : 1534
     */


}
