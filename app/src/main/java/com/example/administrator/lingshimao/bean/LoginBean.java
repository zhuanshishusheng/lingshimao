package com.example.administrator.lingshimao.bean;

/**
 * Created by Administrator on 2017/5/15 0015.
 */

public class LoginBean {

    /**
     * data : {"id":10001,"password":"123456","username":"zp"}
     * response : login
     */

    private DataBean data;
    private String response;
    /**
     * error : 请求参数错误或缺失
     * error_code : 1534
     */

    private String error;
    private String error_code;

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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public static class DataBean {
        /**
         * id : 10001
         * password : 123456
         * username : zp
         */

        private int id;
        private String password;
        private String username;

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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
