package com.arminzheng.infrastructure.exception;

/**
 * BizException
 *
 * @author zy
 * @version 2022/2/27
 */
public class BizException extends RuntimeException {

  private Integer code = 999;
  private String msg;

  public BizException(Integer code, String msg) {
    super(msg);
    this.code = code;
    this.msg = msg;
  }

  public BizException(String msg) {
    super(msg);
    this.msg = msg;
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

  @Override
  public String toString() {
    return "BizException{" + "code=" + code + ", msg='" + msg + '\'' + '}';
  }
}
