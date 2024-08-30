package db;

import model.MyList;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static DBConnection instance;
    private List<MyList> connection;
    private DBConnection(){
        connection=new ArrayList<>();
    }
    public List<MyList> getConnection(){
        return connection;
    }
    public static DBConnection getInstance() {
        return null==instance?instance=new DBConnection():instance;
    }
}
