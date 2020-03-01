package com.quaint.javabase.java8;

import com.quaint.javabase.java8.helper.Book;
import com.quaint.javabase.java8.helper.Box;

import java.util.Optional;

/**
 * @author quaint
 * @date 2020-01-16 11:30
 */
public class OptionalTest {

    public static void main(String[] args) {

        Optional<Object> empty = Optional.empty();
        // 下面 语句会报错
//        System.out.println(empty.get());
//        Optional<Object> o = Optional.of(null);
        Optional<Book> book = Optional.of(new Book());
        System.out.println(book);
        System.out.println(book.get().getColor());
        System.out.println(book.get().getPage());

        Optional<Object> emptyObject = Optional.ofNullable(null);
        // 报错
//        empty.get();
        Optional<Book> book1 = Optional.ofNullable(new Book());
        System.out.println(book1);
        System.out.println(book1.get().getColor());
        System.out.println(book1.get().getPage());

        Optional<Box> optionalBox = Optional.ofNullable(new Box());
        System.out.println(optionalBox.get());
        // 异常
//        System.out.println(optionalBox.get().getBook().getColor());
        System.out.println(optionalBox.filter(box->box.getBook()!=null).orElse(new Box()));

        System.out.println(optionalBox.map(Box::getBook));


        System.out.println("= = = = = = ");

        Box box = new Box();
        Book book2 = new Book();
        book2.setColor("red");
        box.setBook(book2);


        System.out.println(Optional.ofNullable(box)
                .flatMap(b -> Optional.ofNullable(b.getBook()))
                .map(Book::getColor)
                .orElse("unknow"));

    }

}
