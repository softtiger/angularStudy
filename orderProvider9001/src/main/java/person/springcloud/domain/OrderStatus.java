package person.springcloud.domain;

public enum OrderStatus {
        NEW(0,"新订单"),
        FINISHED(1,"完成"),
        CANCEL(2,"取消");

        private Integer code;
        private String message;

    OrderStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}