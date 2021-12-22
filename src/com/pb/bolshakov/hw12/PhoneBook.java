package com.pb.bolshakov.hw12;

import javax.management.ObjectName;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {

private  Scanner sc;
    HashMap<String, Contact> hm= new HashMap<>();

    //добавить
    public void add(){
        sc = new Scanner(System.in);
        System.out.println ("------ Добавить телефонную книгу ------");
        System.out.println ( "Имя:");
        String name=sc.nextLine();
        System.out.println ( "Дата рождения:");
        String dateOfBirth=sc.nextLine();

        System.out.println ( "Телефон:");
        String phone=sc.nextLine();
        System.out.println("Адрес：");
        String address=sc.nextLine();

      System.out.println ( "Дата записи :");
        Date date = new Date();

        System.out.println(date);

        Contact newOne = new Contact(name, LocalDate.now(), phone, address); // Считанные данные создают объект Contact
        hm.put (name, newOne); // Добавить в HashMap
        System.out.println ("«Добавлено успешно»");
    }

    //Удалить
    public void del(){
        sc = new Scanner(System.in);
        System.out.println ("------ Удалить телефонную книгу ------");
        System.out.println ("«Пожалуйста, введите имя для удаления:»");
        String name=sc.nextLine();
        if (hm.containsKey (name)) {// Определить, есть ли этот человек
            System.out.println(hm.get(name).toString());
            System.out.println ("Вы уверены, что хотите удалить 1 (да) 0 (нет)");
            int flag=sc.nextInt();
            if(flag==1){
                hm.remove(name);
                System.out.println ("Удалино успешно");
            }else{
                System.out.println ( "Восстановить");
            }
        }else{
            System.out.println ("Этот человек не существует");
        }

    }


    // Изменить
    public void change(){
        sc = new Scanner(System.in);
        System.out.println ("------ Изменить телефонную книгу ------");
        System.out.println ("Пожалуйста, введите имя для изменения:");
        String name=sc.nextLine();
        if (hm.containsKey (name)) {// Определить, есть ли этот человек
            System.out.println(hm.get(name).toString());
            hm.remove (name); // Сначала удалите этого человека
            System.out.println ("«Пожалуйста, введите информацию заново»");
            System.out.println ( "Имя:");
            String name1=sc.nextLine();
            System.out.println ( "Дата рождения:");
            String dateOfBirth=sc.nextLine();

            System.out.println ( "Телефон:");
            String phone=sc.nextLine();
            System.out.println("Адрес：");
            String address = sc.nextLine();

            System.out.println ( "Дата редоктирования :");
            Date date = new Date();
            System.out.println(date);
            Contact newOne=new Contact(name1,  LocalDate.now(), phone, address);
            hm.put (name, newOne); // плюс новый
            System.out.println ("«Изменено успешно»");
        }else{
            System.out.println ("«Этот человек не существует»");
        }
    }


    // Распечатать все
    public void show(){
        System.out.println ("------ Показать все -----");
        for (Map.Entry<String, Contact> entry : hm.entrySet()) {
            System.out.println(entry.getValue().toString());
        }

    }


    // Поиск по имени
    public void search(){
        sc = new Scanner(System.in);
        System.out.println ("--- Поиск по имени ---");
        System.out.println ("Пожалуйста, введите имя для поиска:");
        String name=sc.nextLine();
        if(hm.containsKey(name)){
            System.out.println(hm.get(name).toString());
        }else{
            System.out.println ("Этот человек не существует");
        }
    }

    public void clear(){
        hm.clear();
    }

    //Читать
    public void open1() throws Exception{
        System.out.println ( "Read ...");
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("files/contact1.txt"));
        boolean flag=true;
        while(flag){
            try{
                Contact newOne=(Contact) in.readObject();
                hm.put (newOne.getName (), newOne); // Добавить в HashMap
            }catch(EOFException e){
                flag=false;
            }
        }
        in.close();

    }
    //Сохранить
    public void save1() throws Exception{
        System.out.println ( "Сохранить ...");
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("files/contact1.txt"));
        for (Map.Entry<String, Contact> entry : hm.entrySet()) {
            Contact val = entry.getValue();
            out.writeObject(val);
        }
        out.close();
        System.out.println ( "Время сохранинения  :");
        Date date = new Date();

        // Вывод текущей даты и времени
        System.out.println(date);
        System.out.println ("«Сохранино успешно»");
    }






}
