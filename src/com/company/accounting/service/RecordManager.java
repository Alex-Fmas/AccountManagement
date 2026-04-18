package com.company.accounting.service;

import com.company.accounting.entity.Record;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecordManager {
    private List<Record> records;           // 存储记录
    private int nextId;                     // 下一个生成ID

    public RecordManager() {
        records = new ArrayList<>();
        nextId = 1;     // 首个ID
    }
    /*
    * 添加记录
    * */
    public void addRecord(Record record) {
        record.setId(nextId);
        nextId++;
        records.add(record);
    }
    /*
    * 遍历
    * */
    public void listRecords() {
        if (records.isEmpty()) {
            System.out.println("暂无记录");
            return;
        }
        System.out.println("ID\t日期\t\t\t类型\t\t金额\t\t类别\t\t备注");
        for (Record record : records) {
            System.out.println(record);
        }
    }
    /*
    * 删除（ID）
    * */
    public boolean deleteRecord(int id) {
        Iterator<Record> iterator = records.iterator();
        while (iterator.hasNext()) {
            Record r = iterator.next();
            if(r.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    /*
    * 根据ID查找记录
    * */
    public Record findRecordById(int id) {
        for (Record record : records) {
            if (record.getId() == id) {
                return record;
            }
        }
        return null;
    }
    /*
    * 获取所有记录
    * */
    public List<Record> getAllRecords() {
        return records;
    }
    /*
    * 获取记录数量
    * */
    public int getRecordCount() {
        return records.size();
    }
}
