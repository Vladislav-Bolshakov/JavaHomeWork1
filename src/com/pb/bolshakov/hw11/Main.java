package com.pb.bolshakov.hw11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception  {
        PhoneBook con =new PhoneBook();

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

