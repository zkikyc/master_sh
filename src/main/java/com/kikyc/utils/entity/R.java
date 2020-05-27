package com.kikyc.utils.entity;


/**
 * 返回结果类
 *
 * @param <T> 类型
 */

public class R<T> {

    private Integer code;
    private String msg;
    private T data;

    public R(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 请求成功  状态码 200
     *
     * @param msg 返回信息
     * @param <T> 类型
     * @return ResultVO
     */
    public static <T> R getSuccess(String msg) {
        return new R(200, msg);
    }

    /**
     * 请求成功  状态码 200
     *
     * @param msg  返回信息
     * @param data 返回对象
     * @param <T>  类型
     * @return R
     */
    public static <T> R getSuccess(String msg, T data) {
        return new R(200, msg, data);
    }

    /**
     * 请求失败   状态码 500
     *
     * @param msg 返回信息
     * @param <T> 类型
     * @return R
     */
    public static <T> R getFailed(String msg) {
        return new R(500, msg);
    }

    /**
     * 请求失败  状态 500
     *
     * @param msg  返回信息
     * @param data 返回数据
     * @param <T>  类型
     * @return R
     */
    public static <T> R getFailed(String msg, T data) {
        return new R(500, msg, data);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
