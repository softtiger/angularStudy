package person.springcloud.domain;

public enum PayStatus {
        UNPAID(0,"未支付"),
        PAYED(1,"已支持") ;

        private Integer code;

    PayStatus(Integer code, String message) {
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

    private String message;
}
