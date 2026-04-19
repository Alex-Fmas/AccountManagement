package com.company.accounting.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Record {
    private int id;                     // id
    private LocalDate date;             // 日期
    private RecordType type;            // 类型
    private BigDecimal amount;          // 金额
    private String category;            // 分类
    private String note;                // 备注

    /*
    * 构造方法
    * */
    public Record() {
    }

    public Record(LocalDate date, RecordType type, BigDecimal amount, String category, String note) {
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

    public RecordType getType() {
        return type;
    }

    public void setType(RecordType type) {
        this.type = type;
    }

    @Override
    public String toString() {

        return id + "\t"
                + date + "\t"
                + type.getText() + "\t\t"
                + amount + "\t"
                + category + "\t\t"
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
