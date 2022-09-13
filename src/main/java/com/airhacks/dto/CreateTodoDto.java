package com.airhacks.dto;

import java.time.LocalDateTime;

public class CreateTodoDto {
    private int id;
    private String msg;

    public CreateTodoDto(int id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }
}
