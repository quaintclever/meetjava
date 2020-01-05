package com.quaint.sp.javabase.java8;

import com.quaint.sp.javabase.java8.helper.Book;
import com.quaint.sp.javabase.java8.helper.FunctionTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author quaint
 * @date 2020-01-05 19:26
 */
public class LambdaTest extends FunctionTest<Book> {

    public static void main(String[] args) {

        System.out.println("---------------------");
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello java");
            }
        };
        Runnable runnable = () -> System.out.println("hello java8 lambda");
        process(run);
        process(runnable);
        process(() -> System.out.println("hello lambda"));

        List<Book> books = Arrays.asList(new Book("red",100),
                                new Book("red",60),
                                new Book("green",101));

        List list = filterBook(books, book -> "red".equals(book.getColor()));
        System.out.println(list);

        System.out.println("---------------------");
        List list1 = filterBook(books, book -> book.getPage()>70);
        System.out.println(list1);

        System.out.println("---------------------");
        List list2 = filterBookBi(books, (color,pageNum) -> "red".equals(color) && pageNum>70);
        System.out.println(list2);

        System.out.println("---------------------");
        consumerSimple(books, System.out::println);
        consumerSimple("hello: ", books, (book,str) -> System.out.println(str+book));

        System.out.println("---------------------");
        List list3 = addPageFunction(books, book -> book.setPage(book.getPage() + 100));
        System.out.println(list3);
        Book blueBook = addBookFunction("blue", 1000, Book::new);
        System.out.println(blueBook);

        System.out.println("---------------------");
        Book springBook = createT(() -> new Book("spring", 1000));
        System.out.println(springBook);

        System.out.println("---------------------");
        // customize
        books.sort((a,b)->{
            if (a.getPage()>b.getPage()){
                return -1;
            } else if (a.getPage().equals(b.getPage())){
                return 0;
            }
            return 1;
        });
        System.out.println(books);
        // or
//        books.sort((a,b)->a.getPage().compareTo(b.getPage()));
        books.sort(Comparator.comparing(Book::getPage));
        System.out.println(books);

        System.out.println("---------------------");
        BiFunction<String, Integer, Character> biFunction = String::charAt;
        System.out.println(biFunction.apply("quaint", 2));
        String str = "clever";
        Function<Integer, Character> characterFunction = str::charAt;
        System.out.println(characterFunction.apply(1));

        System.out.println("---------------------");



    }


}
