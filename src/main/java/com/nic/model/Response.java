package com.nic.model;

public class Response {
    private int status;
    private String message;
    private Object data;
    private boolean isSuccess;

    public void setStatus(int _statusCode) {
        this.status = _statusCode;
    }

    public void setMessage(String _message) {
        this.message = _message;
    }

    public void setData(Object _data) {
        this.data = _data;
    }

    public void setIsSuccess(boolean _isSuccess) {
        this.isSuccess = _isSuccess;
    }

    public int getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getData() {
        return this.data;
    }

    public boolean getIsSuccess() {
        return this.isSuccess;
    }
}
