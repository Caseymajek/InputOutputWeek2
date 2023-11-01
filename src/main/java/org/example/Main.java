package org.example;

import org.example.utils.FileUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(FileUtil.readEmployeeCSV("src/main/resources/Employee_Sample_Data1.csv"));
        }
    }
