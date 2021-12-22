package com.pb.bolshakov.hw12;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws Exception {
        PhoneBook con = new PhoneBook();
        List<Contact> contact = Arrays.asList(

                new Contact("Alexs", LocalDate.of(2000, 2, 4), "380500000", "Dnipro"),
                new Contact("Rika", LocalDate.of(2010, 4, 3), "38050411000", "Kiev"),
                new Contact("Julia", LocalDate.of(1990, 3, 2), "3805033300", "Ternovka"));
        System.out.println("Список телефонной книги");

        contact.stream()
                .collect(Collectors.groupingBy(Contact:: getDateOfBirth))
                .entrySet()
                .forEach(System.out::println);
        System.out.println("----------------------------------------");

        List<String> listToSort = new ArrayList<>();
        Set<String> uniqueValues = new HashSet<>();
        for (Contact contact2 : contact) {
            String name = contact2.getName();
            if (uniqueValues.add(name)) {
                listToSort.add(name);
            }
        }

        for (String name : listToSort) {
            System.out.println(name);
        }

        System.out.println("----------------------------------------");


        int flag = 0; // Круговой выход
        while(flag==0){
            System.out.println ("--- Система управления телефонной книгой --- ");
            System.out.println ("1. Добавить \t" +
                    " 2. Удалить \t 3. " +
                    "Изменить \t 4. Показать все " +
                    "\t 5. Запрос по имени \t 6." +
                    " Читать и отобразить \t 7." +
                    " Сохранить телефонную книгу " +
                    "\t 8. Очистить \t " +
                    "0. Выход ");

            System.out.println ("Пожалуйста, выберите операцию");
            Scanner sc1 = new Scanner(System.in);
            switch (sc1.nextInt()) {
                case 1:
                    con.add();
                    break;
                case 2:
                    con.del();
                    break;
                case 3:
                    con.change();
                    break;
                case 4:
                    con.show();
                    break;
                case 5:
                    con.search();
                    break;
                case 6:
                    con.open1();con.show();
                    break;
                case 7:
                    con.save1();
                    break;
                case 8:
                    con.clear();
                    break;
                case 0:
                    flag=1;
                    break;
                default:
                    break;
            }
        }

    }




}
