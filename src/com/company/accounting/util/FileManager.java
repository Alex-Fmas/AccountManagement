package com.company.accounting.util;

import com.company.accounting.entity.Record;
import com.company.accounting.entity.RecordType;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "data/records.txt";

    public static void saveToFile(List<Record> records) {
        try {
            File file = new File(FILE_NAME);
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
        } catch (Exception e) {  e.printStackTrace(); }

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        ){
            for(Record record : records) {
                String line = record.toFileString();
                writer.write(line);
                writer.newLine();
            }
        } catch (java.io.FileNotFoundException e) {
            System.err.println("写入文件失败：文件不存在 - " + e.getMessage());
        } catch (java.io.IOException e) {
            System.err.println("写入文件失败：IO错误 - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("保存失败" + e.getMessage());
        }
    }

    public static List<Record> loadFromFile() {
        List<Record> records = new ArrayList<>();

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return records;
        }

        try (
                BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

        ){
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] parts = line.split(",");

                if (parts.length < 6){
                    System.err.printf("第%d行格式错误，字段数量不足6个，跳过该行%n", lineNumber);
                    continue;
                }

                try {
                    int id = Integer.parseInt(parts[0]);
                    LocalDate date = LocalDate.parse(parts[1]);
                    RecordType type = RecordType.valueOf(parts[2]);
                    BigDecimal amount = new BigDecimal(parts[3]);
                    String category = parts[4];
                    String note = parts[5];

                    Record record = new Record(
                            id,
                            date,
                            type,
                            amount,
                            category,
                            note
                    );

                    records.add(record);
                }  catch (NumberFormatException e) {
                    System.err.printf("第 %d 行数字格式错误：%s，跳过该行%n", lineNumber, e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.printf("第 %d 行枚举类型解析错误：%s，跳过该行%n", lineNumber, e.getMessage());
                } catch (Exception e) {
                    System.err.printf("第 %d 行解析失败：%s，跳过该行%n", lineNumber, e.getMessage());
                }
            }
        } catch (java.io.FileNotFoundException e) {
            System.err.println("读取文件失败：文件不存在 - " + e.getMessage());
        } catch (java.io.IOException e) {
            System.err.println("读取文件失败：IO错误 - " + e.getMessage());
        } catch (Exception e) {
            System.err.printf("读取文件失败：未知错误 - " + e.getMessage());
        }
        return records;
    }

}
