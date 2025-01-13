package paf.lecture.paf_24l.repository;

public class QueryBooks {
    public static final String CREATE_BOOK = "insert into books (title, quantity) values (?, ?);";

    public static final String ALL_BOOKS = "select * from books;";

    public static final String GET_BOOK_BY_ID = "select * from books where id = ?;";

    public static final String UPDATE_BOOK = "update books set title = ?, quantity = ? where id = ?;";
}
