package com.study.xyl._08_preventRepeat.T;

public class GenericResponse<T> {
    private T data;

    private int code = 200;

    private String message="success";

    public GenericResponse(T data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public GenericResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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

    public static <T> GenericResponse<T> success(T data) {
        return new GenericResponse<>(data);
    }

}
