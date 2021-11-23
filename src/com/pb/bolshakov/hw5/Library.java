package com.pb.bolshakov.hw5;


public class Library {
    public Library() {
    }

    public static void main(String[] args) {
        Reader reader1 = new Reader("Петров В.В.", 1, "SMT", "23.11.2000", "+0887854321");
        Reader reader2 = new Reader("Печкин В.И.", 2, "SMT", "16.09.1999", "+0997123479");
        Reader reader3 = new Reader("Карманов К.А.", 3, "SMT", "06.07.2002", "+055957435");
        Reader[] readers = new Reader[]{reader1, reader2, reader3};
        Book book1 = new Book("Приключения ", "Иванов И. И.", "2000г.");
        Book book2 = new Book(" Словарь", "Сидоров А. В.", "1980г.");
        Book book3 = new Book("Энциклопедия", "Гусев К. В.", "2010 г.");
        Book[] books = new Book[]{book1, book2, book3};
        printReaders(readers);
        printBooks(books);
        reader1.takeBook(3);
        reader1.takeBook(new String[]{" Приключения, Словарь, Энциклопедия"});
        reader1.takeBook(new Book[]{book1, book2, book3});
        reader1.returnBook(3);
        reader1.returnBook(new String[]{"Приключения, Словарь, Энциклопедия"});
        reader1.returnBook(new Book[]{book1, book2, book3});
    }

    private static void printBooks(Book[] books) {
        System.out.println("Список книг:");
        Book[] var1 = books;
        int var2 = books.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Book book = var1[var3];
            System.out.println(book.getInfo());
        }

        System.out.println();
    }

    private static void printReaders(Reader[] readers) {
        System.out.println("Список читателей:");
        Reader[] var1 = readers;
        int var2 = readers.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Reader reader = var1[var3];
            System.out.println(reader.getInfo());
        }

        System.out.println();
    }
}
