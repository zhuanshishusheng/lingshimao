package com.example.administrator.lingshimao.bean;

/**
 * Created by Administrator on 2017/5/22 0022.
 */

public class RegisterBean {

    /**
     * response : register
     * userInfo : {"id":0,"password":"123","username":"fyc"}
     */

    private String response;
    private UserInfoBean userInfo;
    /**
     * error : 该用户名已经被注册过了
     * error_code : 1532
     */

    private String error;
    private String error_code;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
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

    public static class UserInfoBean {
        /**
         * id : 0
         * password : 123
         * username : fyc
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
