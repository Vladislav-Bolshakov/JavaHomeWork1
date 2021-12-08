package com.pb.bolshakov.hw11;

import java.io.*;
import java.util.*;

public class PhoneBook {

private  Scanner sc;
    HashMap hm=new HashMap();

    //увеличение
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

        System.out.println(date.toString());

        Contact newOne = new Contact (name, dateOfBirth, phone, address); // Считанные данные создают объект Contact
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
            System.out.println(date.toString());
            Contact newOne=new Contact(name1, dateOfBirth, phone, address);
            hm.put (name, newOne); // плюс новый
            System.out.println ("«Изменено успешно»");
        }else{
            System.out.println ("«Этот человек не существует»");
        }
    }


    // Распечатать все
    public void show(){
        System.out.println ("------ Показать все -----");
        Iterator iter = hm.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
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



	public void open() throws IOException{
		System.out.println ( "Read ...");
		DataInputStream in=new DataInputStream(new FileInputStream("files/contact.txt"));
		boolean flag=true;
		while(flag){
			try{
				String name=in.readUTF();
				String dateOfBirth=in.readUTF();
				String phone=in.readUTF();
				String address=in.readUTF();
                Date date = new Date();
                System.out.println(date.toString());
				Contact newOne = new Contact (name, dateOfBirth, phone, address);
				hm.put (name, newOne);
			}catch(EOFException e){
				flag=false;
			}
		}
		in.close();
	}
	public void save() throws IOException{
		System.out.println ( "Сохранить ...");
		DataOutputStream out=new DataOutputStream(new FileOutputStream("files/contact.txt"));
		Iterator iter = hm.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Contact val = (Contact) entry.getValue();
			out.writeUTF(val.getName());
			out.writeUTF(val.getDateOfBirth());
			out.writeUTF(val.getPhone());
			out.writeUTF(val.getAddress());
			out.writeUTF(val.getAddress());
            Date date = new Date();
            System.out.println(date.toString());
		}
		out.close();
		System.out.println ("«Сохранить успешно»");
	}


    // Сериализация для хранения и чтения

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
        Iterator iter = hm.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Contact val = (Contact) entry.getValue();
            out.writeObject(val);
        }
        out.close();
        System.out.println ( "Время сохранинения  :");
        Date date = new Date();

        // Вывод текущей даты и времени с использованием toString()
        System.out.println(date.toString());
        System.out.println ("«Сохранить успешно»");
    }
}
