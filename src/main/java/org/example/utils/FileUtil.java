package org.example.utils;

import org.example.entities.Employee;
import org.example.enums.Ethnic;
import org.example.enums.Gender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<Employee> readEmployeeCSV(String fileName){
        List<Employee> listOfEmployees = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
          String lines;
//          int counter = 0;
            boolean isFirstLine = true;
          while((lines=reader.readLine())!=null){
              String[] rows = lines.split(",");
              if(!isFirstLine){
                  Employee employee = new Employee();
                  employee.setEmployeeId(rows[0]);
                  employee.setFullName(rows[1]);
                  employee.setJobTitle(rows[2]);
                  employee.setDepartment(rows[3]);
                  employee.setBusinessUnit(rows[4]);
                  employee.setGender(Gender.valueOf(rows[5]));
                  employee.setEthnicity(Ethnic.valueOf(rows[6]));
                  employee.setAge(Integer.parseInt(rows[7]));
                  String[] date = rows[8].split("/");
                  StringBuilder stringBuilder = new StringBuilder();
                  String day = date[0].length()==1?"0"+date[0]:date[0];
                  String month = date[1].length()==1?"0"+date[1]:date[1];
                  stringBuilder.append(day+"/");
                  stringBuilder.append(month+"/");
                  stringBuilder.append(date[2]);
                  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
                  LocalDate dateTime = LocalDate.parse(stringBuilder+" 00:00", formatter);
                  employee.setHireDate(dateTime);
                  listOfEmployees.add(employee);
              }
              isFirstLine = false;
//              counter++;
          }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfEmployees;
    }
}
