package com.example.Blog.dao;

import com.example.Blog.entity.Blog;
import com.example.Blog.entity.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DbManager {

    private static Connection connection;
    private static final String GET_USER_BY_EMAIL = "select * from users where email = ?";
    private static final String DELETE_BLOG_BY_ID = "delete from blogs where id = ?";
    private static final String EDIT_BLOG = "select  title ,content  from blogs where id = ?";
    private static final String EDIT_BLOG2 = "update blogs set title = ? , content = ? , date = ? where id = ?";
    private static final String UPDATE_USER = "update users set full_name = ? where  email = ?";
    private static final String UPDATE_USER_PASSWORD = "update users set password = ? where  email = ?";
    private static final String ADD_USER = "insert into users (email , full_name, password) VALUES (?,?,?)";
    private static final String ADD_BLOG = "insert into blogs (title, content, author,date) values  (?,?,?,?)";
    private static final String GET_ALL_BLOG = "select b.id, title, content, author, date ,u.full_name ,email from blogs b  join users u on u.id = b.author";
    private static final String URL = "jdbc:sqlite:C:\\Users\\HeniTay\\Desktop\\Blog\\identifier.sqlite";


    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(URL);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Boolean updateBlog(String title , String content , LocalDate date , Long id ) throws SQLException {

        int row = 0;
        PreparedStatement statement = connection.prepareStatement(EDIT_BLOG2);
        statement.setString(1, title);
        statement.setString(2, content);
        statement.setDate(3,Date.valueOf(date));
        statement.setLong(4,id);

        row = statement.executeUpdate();

        return row > 0;
    }

    public static Blog edit(Long id)throws SQLException {
        Blog blog = null;

        PreparedStatement statement = connection.prepareStatement(EDIT_BLOG);
        statement.setLong(1, id);
        ResultSet set = statement.executeQuery();
        System.out.println("Success");

        if (set.next()) {
            blog = new Blog(
                    id,
                    set.getString(1),
                    set.getString(2));
        }
        set.close();
        statement.close();

        return blog;
    }

    public static void delete(Long id )throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DELETE_BLOG_BY_ID);
        statement.setLong(1, id);

        statement.executeUpdate();

        System.out.println("Success");

        statement.close();
    }


    public static void updateUser(String fullName,String email) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(UPDATE_USER);
        statement.setString(1, fullName);
        statement.setString(2, email);

        statement.executeUpdate();

        statement.close();



    }
    public static void updateUserPassword(String password,String email) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(UPDATE_USER_PASSWORD);
        statement.setString(1, password);
        statement.setString(2, email);

        statement.executeUpdate();

        statement.close();


    }


    public static void addBlog(String title, String content, Long author, LocalDate date) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(ADD_BLOG);
        statement.setString(1, title);
        statement.setString(2, content);
        statement.setLong(3, author);
        statement.setDate(4, Date.valueOf(date));
        statement.executeUpdate();
        statement.close();
        System.out.println("Success");
    }


    public static void addUser(String email, String full_name, String password) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(ADD_USER);
        statement.setString(1, email);
        statement.setString(2, full_name);
        statement.setString(3, password);
        statement.executeUpdate();

        statement.close();

        System.out.println("Success");

    }

    public static ArrayList<Blog> getALLBlog() throws SQLException {
        ArrayList<Blog> ss = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(GET_ALL_BLOG);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            ss.add(
                    new Blog(set.getLong("id"),
                            set.getString("title"),
                            set.getString("content"),
                            new User(set.getLong("author"),
                                    set.getString("email"),
                                    set.getString("full_name"),
                                    null),
                            set.getDate("date")

                    ));
        }
        set.close();
        statement.close();

        return ss;

    }


    public static User getUserByEmail(String email) throws SQLException {
        User user = null;

        PreparedStatement statement = connection.prepareStatement(GET_USER_BY_EMAIL);
        statement.setString(1, email);
        ResultSet set = statement.executeQuery();

        if (set.next()) {
            user = new User(
                    set.getLong(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4));
        }
        set.close();
        statement.close();


        return user;


    }
}
