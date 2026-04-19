package com.company.accounting.ui;

import com.company.accounting.entity.Record;
import com.company.accounting.entity.RecordType;
import com.company.accounting.service.RecordManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class RecordMenu {
    private RecordManager manager;
    private Scanner scanner;

    public RecordMenu(RecordManager manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = scanner;
    }

    // ===== 添加记录 =====

    public void addRecord(RecordType type) {

        System.out.println("请输入金额：");

        String amountStr = scanner.nextLine();

        BigDecimal amount =
                new BigDecimal(amountStr); // 必须用字符串

        System.out.println("请输入分类：");

        String category = scanner.nextLine();

        System.out.println("请输入备注：");

        String note = scanner.nextLine();

        // 获取当前日期
        LocalDate date = LocalDate.now();

        // 创建记录（id自动生成）
        com.company.accounting.entity.Record record =
                new Record(
                        date,
                        type,
                        amount,
                        category,
                        note
                );

        // 添加记录
        manager.addRecord(record);

        System.out.println("添加成功！");

    }


    // ===== 删除记录 =====

    public void deleteRecord() {

        System.out.println("请输入要删除的ID：");

        int id = scanner.nextInt();

        scanner.nextLine();

        boolean result =
                manager.deleteRecord(id);

        if (result) {

            System.out.println("删除成功");

        } else {

            System.out.println("未找到该ID");

        }

    }
}
