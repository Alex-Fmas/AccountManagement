package com.company.accounting.app;

import com.company.accounting.entity.Record;
import com.company.accounting.service.RecordManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class MainApp {

    // ===== 核心对象 =====

    private static RecordManager manager = new RecordManager();

    private static Scanner scanner = new Scanner(System.in);


    // ===== 程序入口 =====

    public static void main(String[] args) {

        while (true) {

            showMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除换行

            switch (choice) {

                case 1:
                    addRecord("收入");
                    break;

                case 2:
                    addRecord("支出");
                    break;

                case 3:
                    manager.listRecords();
                    break;

                case 4:
                    deleteRecord();
                    break;

                case 0:
                    System.out.println("系统退出");
                    return;

                default:
                    System.out.println("无效选择，请重新输入");
            }

        }

    }


    // ===== 显示菜单 =====

    private static void showMenu() {

        System.out.println();
        System.out.println("====== 企业记账系统 ======");
        System.out.println("1. 添加收入");
        System.out.println("2. 添加支出");
        System.out.println("3. 查看所有记录");
        System.out.println("4. 删除记录");
        System.out.println("0. 退出系统");
        System.out.print("请选择：");

    }


    // ===== 添加记录 =====

    private static void addRecord(String type) {

        System.out.println("请输入金额：");

        String amountStr = scanner.nextLine();

        BigDecimal amount =
                new BigDecimal(amountStr); // 必须用字符串

        System.out.println("请输入类别：");

        String category = scanner.nextLine();

        System.out.println("请输入备注：");

        String note = scanner.nextLine();

        // 获取当前日期
        LocalDate date = LocalDate.now();

        // 创建记录（id自动生成）
        Record record =
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

    private static void deleteRecord() {

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