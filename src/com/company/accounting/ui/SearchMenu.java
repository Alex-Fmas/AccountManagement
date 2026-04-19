package com.company.accounting.ui;

import com.company.accounting.entity.Record;
import com.company.accounting.entity.RecordType;
import com.company.accounting.service.RecordManager;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class SearchMenu {
    private RecordManager manager;
    private Scanner scanner;

    public SearchMenu(RecordManager manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = scanner;
    }

    // ==== 查询 =====
    public void showSearchMenu() {

        System.out.println();
        System.out.println("====== 查询菜单 ======");

        System.out.println("1. 按日期查询");
        System.out.println("2. 按分类查询");
        System.out.println("3. 按类型查询（收入，支出）");

        System.out.print("请选择：");

        int choice = scanner.nextInt();

        scanner.nextLine();

        switch (choice) {

            case 1 -> searchByDate();

            case 2 -> searchByCategory();

            case 3 -> searchByType();

            default -> System.out.println("无效选择");
        }

    }

    private void searchByDate() {
        LocalDate data = null;

        while (true) {
            System.out.println("请输入日期（例如 2026-04-19）：");
            String dateStr = scanner.nextLine().trim();

            if (dateStr.isEmpty()) {
                System.out.println("输出不能为空，请重新输入！");
            }

            try {
                data = LocalDate.parse(dateStr);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("日期格式不正确，请输入yyyy-MM-dd");
            }
        }

        try{
            List<com.company.accounting.entity.Record> list = manager.searchByDate(data);
            manager.printRecords(list);
        } catch (Exception e) {
            System.out.println("查询失败");
        }

    }
    private void searchByCategory() {

        System.out.println("请输入分类：");

        String category =
                scanner.nextLine();

        List<com.company.accounting.entity.Record> result =
                manager.searchByCategory(category);

        manager.printRecords(result);

    }
    private void searchByType() {

        System.out.println("请选择类型：");
        System.out.println(RecordType.INCOME.getText());
        System.out.println(RecordType.EXPENSE.getText());

        RecordType type = null;
        boolean running = true;

        while (running) {
            try{
                String input = scanner.nextLine().trim();
                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1 -> {
                        type = RecordType.INCOME;
                        running = false;
                    }
                    case 2 -> {
                        type = RecordType.EXPENSE;
                        running = false;
                    }
                    default -> System.out.println("无效选择");
                }
            } catch (NumberFormatException e) {
                System.out.println("请输入数字");
            }
        }

        try {
            List<Record> result = manager.searchByType(type);
            manager.printRecords(result);
        } catch (Exception e) {
            System.out.println("查询失败" + e.getMessage());
        }
    }
}
