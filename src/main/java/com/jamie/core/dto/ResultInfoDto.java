package com.jamie.core.dto;

import java.io.Serializable;

public class ResultInfoDto implements Serializable {
	
	private static final long serialVersionUID = 5459375957735647151L;
	private boolean flag;  // 後端返回結果正常為true, 發生異常則返回false
	private Object data; // 後端返回結果數據物件
	private String message; // 發生異常的錯誤訊息
	private String token;
	
    public ResultInfoDto() {
    }
    
    public ResultInfoDto(boolean flag) {
        this.flag = flag;
    }

    public ResultInfoDto(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public ResultInfoDto(boolean flag, Object data, String message) {
        this.flag = flag;
        this.data = data;
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
