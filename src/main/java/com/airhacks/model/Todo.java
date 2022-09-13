package com.airhacks.model;

public class Todo {
    private int id;
    private String msg;
    private String createdAt;

    public Todo(int id, String msg, String createdAt) {
        this.id = id;
        this.msg = msg;
        this.createdAt = createdAt;
    }

    public Todo() {
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
