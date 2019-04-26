package com.demo.sharding.po;

import org.springframework.stereotype.Component;

@Component
public class TestDemo {
    private Long id;
    private String name;
    private String content;
    private String ch;
    private float f;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    @Override
    public String toString() {
        return "TestDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", ch='" + ch + '\'' +
                ", f=" + f +
                '}';
    }
}
