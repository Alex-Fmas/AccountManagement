package com.company.accounting.tool;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;
/*
*               ==== 仅为生成初始数据使用 ====
* */
public class GenerateTestData {
    public static void main(String[] args) throws IOException {
        String[] types = {"INCOME", "EXPENSE"};
        String[] categories = {"工资", "餐饮", "交通", "购物", "娱乐", "医疗", "日用品", "数码", "服饰", "红包", "奖金", "兼职"};
        String[] notes = {"日常开销", "朋友聚餐", "上班通勤", "网购", "看电影", "感冒买药", "生活用品", "电子设备", "换季衣服", "长辈红包", "项目奖励", "周末兼职"};

        Random random = new Random();
        LocalDate startDate = LocalDate.of(2026, 1, 1);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/records.txt"))) {
            for (int i = 1; i <= 1000; i++) {
                LocalDate date = startDate.plusDays(random.nextInt(110)); // 2026-01-01 到 2026-04-20
                String type = types[random.nextInt(2)];
                BigDecimal amount = new BigDecimal(random.nextDouble() * 5000 + 1).setScale(2, BigDecimal.ROUND_HALF_UP);
                String category = categories[random.nextInt(categories.length)];
                String note = notes[random.nextInt(notes.length)];

                String line = String.format("%d,%s,%s,%s,%s,%s", i, date, type, amount, category, note);
                writer.write(line);
                writer.newLine();
            }
            System.out.println("已生成1000条测试数据到 records.txt");
        }
    }
}