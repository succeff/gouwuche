package bean;

/**
 * 类的描述：
 * 时间：  2017/8/9.15:15
 * 姓名：chenlong
 */

public class Four {

    /**
     * status : true
     * code : 1
     * message : 调用成功
     * data : {"user":{"mobile":"12315615615","password_plain":"31561156","password_hash":"$2y$13$prfvmRtp0ehXziqOz/5CEeSryVnJZRmyH8884LwFCywTGfJnCgS.q","access_token":"VXoD01dh7NgaakLjuFb4HY2cvucr-Cnd","avatar":"http://data.eleteam.com/uploads/public/user/default.jpg","status":1,"created_at":1502262834,"updated_at":1502262834,"created_by":null,"updated_by":null,"id":215},"app_cart_cookie_id":"cd5f127415a6f2eb06fb667c522874b5"}
     * share : {}
     */

    private boolean status;
    private int code;
    private String message;
    private DataBean data;
    private ShareBean share;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public ShareBean getShare() {
        return share;
    }

    public void setShare(ShareBean share) {
        this.share = share;
    }

    public static class DataBean {
        /**
         * user : {"mobile":"12315615615","password_plain":"31561156","password_hash":"$2y$13$prfvmRtp0ehXziqOz/5CEeSryVnJZRmyH8884LwFCywTGfJnCgS.q","access_token":"VXoD01dh7NgaakLjuFb4HY2cvucr-Cnd","avatar":"http://data.eleteam.com/uploads/public/user/default.jpg","status":1,"created_at":1502262834,"updated_at":1502262834,"created_by":null,"updated_by":null,"id":215}
         * app_cart_cookie_id : cd5f127415a6f2eb06fb667c522874b5
         */

        private UserBean user;
        private String app_cart_cookie_id;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getApp_cart_cookie_id() {
            return app_cart_cookie_id;
        }

        public void setApp_cart_cookie_id(String app_cart_cookie_id) {
            this.app_cart_cookie_id = app_cart_cookie_id;
        }

        public static class UserBean {
            /**
             * mobile : 12315615615
             * password_plain : 31561156
             * password_hash : $2y$13$prfvmRtp0ehXziqOz/5CEeSryVnJZRmyH8884LwFCywTGfJnCgS.q
             * access_token : VXoD01dh7NgaakLjuFb4HY2cvucr-Cnd
             * avatar : http://data.eleteam.com/uploads/public/user/default.jpg
             * status : 1
             * created_at : 1502262834
             * updated_at : 1502262834
             * created_by : null
             * updated_by : null
             * id : 215
             */

            private String mobile;
            private String password_plain;
            private String password_hash;
            private String access_token;
            private String avatar;
            private int status;
            private int created_at;
            private int updated_at;
            private Object created_by;
            private Object updated_by;
            private int id;

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getPassword_plain() {
                return password_plain;
            }

            public void setPassword_plain(String password_plain) {
                this.password_plain = password_plain;
            }

            public String getPassword_hash() {
                return password_hash;
            }

            public void setPassword_hash(String password_hash) {
                this.password_hash = password_hash;
            }

            public String getAccess_token() {
                return access_token;
            }

            public void setAccess_token(String access_token) {
                this.access_token = access_token;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public Object getCreated_by() {
                return created_by;
            }

            public void setCreated_by(Object created_by) {
                this.created_by = created_by;
            }

            public Object getUpdated_by() {
                return updated_by;
            }

            public void setUpdated_by(Object updated_by) {
                this.updated_by = updated_by;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }

    public static class ShareBean {
    }
}
