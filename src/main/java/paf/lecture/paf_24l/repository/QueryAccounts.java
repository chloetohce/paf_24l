package paf.lecture.paf_24l.repository;

public class QueryAccounts {
    public static final String CREATE_ACCOUNT = """
            insert into accounts (name, isActive, balance)
                values(?, ?, ?);
            """;
    
    public static final String SELECT_ALL = "select * from accounts";

    public static final String SELECT_ACCOUNT = "select * from accounts where id=?";

    public static final String DELETE_ACCOUNT = "update accounts set isActive = false where id = ?";

    public static final String UPDATE_ACCOUNT = "update accounts set balance = ? where id = ?";
    
    public static final String CHECK_EXISTING_ACCOUNT = "select count(*) as count from accounts where id = ?";
}
