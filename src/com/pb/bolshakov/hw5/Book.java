package com.pb.bolshakov.hw5;

public class Book {
    private String name;
    private String author;
    private String year;

    public Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public Book() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear() {
        this.year = this.year;
    }

    public String getInfo() {
        return "[ Название: " + this.name + ",  Автор:" + this.author + ", Год выпуска:" + this.year + "]";
    }
}
