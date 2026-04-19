package com.company.accounting.ui;

import com.company.accounting.entity.RecordType;
import com.company.accounting.service.RecordManager;

import java.math.BigDecimal;
import java.util.Scanner;

public class MainMenu {
    private RecordManager manager = new RecordManager();
    private Scanner scanner = new Scanner(System.in);

    private RecordMenu recordMenu = new RecordMenu(manager, scanner);
    private SearchMenu searchMenu = new SearchMenu(manager, scanner);

    public void start() {

        boolean running = true;

        while (running) {

            showMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除换行

            switch (choice) {
                case 1 -> recordMenu.addRecord(RecordType.INCOME);      // 添加收入
                case 2 -> recordMenu.addRecord(RecordType.EXPENSE);     // 添加支出
                case 3 -> manager.printRecords();                       // 查看所有记录
                case 4 -> recordMenu.deleteRecord();                    // 删除记录
                case 5 -> showStatistics();                             // 查看统计报表
                case 6 -> searchMenu.showSearchMenu();                  // 查询记录
                case 0 -> {                                             // 退出
                    System.out.println("系统退出");
                    running = false; // 注意：这里的 return 依然有效，用于退出方法
                }
                default -> System.out.println("无效选择，请重新输入");
            }

        }
    }

    private void showMenu() {

        System.out.println();
        System.out.println("====== 企业记账系统 ======");

        System.out.println("1. 添加收入");
        System.out.println("2. 添加支出");
        System.out.println("3. 查看所有记录");
        System.out.println("4. 删除记录");
        System.out.println("5. 查看统计报表");
        System.out.println("6. 查询记录");
        System.out.println("0. 退出系统");

        System.out.print("请选择：");

    }

    // ==== 统计报表 ====
    private void showStatistics() {

        BigDecimal income =
                manager.getTotalIncome();

        BigDecimal expense =
                manager.getTotalExpense();

        BigDecimal balance =
                manager.getBalance();

        System.out.println();
        System.out.println("====== 统计报表 ======");

        System.out.println("总收入：" + income);

        System.out.println("总支出：" + expense);

        System.out.println("当前余额：" + balance);

    }

}
