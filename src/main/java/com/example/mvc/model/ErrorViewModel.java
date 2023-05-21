package com.example.mvc.model;

public class ErrorViewModel {
    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public boolean isShowRequestId() {
        return requestId != null && !requestId.isEmpty();
    }
}
