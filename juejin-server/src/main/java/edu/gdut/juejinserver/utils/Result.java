package edu.gdut.juejinserver.utils;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result {

    private Boolean isSuccess;

    private Integer code;

    private String message;

    private Map<String, Object> data;

    /*构造方法私有化*/
    private Result() {
        data = new HashMap<>();
    }

    public static Result success() {
        Result result = new Result();
        result.isSuccess = true;
        result.code = ResultCode.SUCCESS;
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.isSuccess = false;
        result.code = ResultCode.ERROR;
        return result;
    }

    public Result message(String message) {
        this.message = message;
        return this;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

}
