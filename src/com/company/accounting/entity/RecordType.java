package com.company.accounting.entity;

public enum RecordType {
    INCOME("收入"),
    EXPENSE("支出");

    private final String text;

    RecordType (String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static RecordType fromText(String text) {
        for(RecordType type : values()) {
            if (type.text.equals(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("无效的收支类型" + text);
    }
}
