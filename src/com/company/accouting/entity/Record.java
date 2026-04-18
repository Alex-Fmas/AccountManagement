package com.company.accouting.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Record {
    private int id;                     // id
    private LocalDate date;             // 日期
    private String type;                // 类型
    private BigDecimal amount;          // 金额
    private String category;            // 分类
    private String note;                // 备注

    /*
    * 构造方法
    * */
    public Record() {
    }

    public Record(int id, LocalDate date, String type, BigDecimal amount, String category, String note) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.note = note;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getnote() {
        return note;
    }

    public void setnote(String note) {
        this.note = note;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {

        return id + "\t"
                + date + "\t"
                + type + "\t"
                + amount + "\t"
                + category + "\t"
                + note;
    }

    /*
    * 保存到文件
    * */
    public String toFileString() {

        return id + ","
                + date + ","
                + type + ","
                + amount + ","
                + category + ","
                + note;
    }
}
