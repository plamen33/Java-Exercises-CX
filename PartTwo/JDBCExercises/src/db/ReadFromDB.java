package db;

import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ReadFromDB {
    public static void main(String[] args) throws SQLException {
        Connection dbConnection = null;
        Statement readStatement = null;
        PreparedStatement insertStatement = null;
        PreparedStatement updateStatement = null;
        ResultSet resultSet = null;

        try {
            Scanner scanner = new Scanner(System.in);

            boolean includeInsert = false;
            boolean includeUpdate = false;
            boolean printToFile = false;
            System.out.println("Do you want to initiate INSERT a row in the db table - yes/no ?");
            String includeInsertAnswer = scanner.nextLine().toLowerCase();
            System.out.println("Do you want to UPDATE a row in the db table - yes/no ?");
            String includeUpdateAnswer = scanner.nextLine().toLowerCase();
            System.out.println("Do you want to print the db table to a text file - yes/no ?");
            String printToFileAnswer = scanner.nextLine().toLowerCase();

            if(includeInsertAnswer.equals("yes")){ includeInsert = true;}
            if(includeUpdateAnswer.equals("yes")){ includeUpdate = true;}
            if(printToFileAnswer.equals("yes")){ printToFile = true;}

            // Get a connection to database
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcx", "root" , "");

            //  Create a statement for readStatement
            readStatement = dbConnection.createStatement();

            // insert statement
            if(includeInsert){
               insertStatement = dbConnection.prepareStatement("INSERT INTO `testcx`.`data` (`content`, `info`, `year`, `date`) VALUES (?, ?, ?, ?)");
               // do the insert
               insertInDB(insertStatement, scanner);
               insertStatement.execute();
            }

            // update statement
            if(includeUpdate){
                updateStatement = dbConnection.prepareStatement("UPDATE `testcx`.`data` SET `content`=?, `info`=?, `year`=?, `date`=? WHERE `id`=?");
                // do the update
                updateInDB(updateStatement, scanner);
                updateStatement.execute();
            }

            scanner.close();

            // Execute read SQL query
            resultSet = readStatement.executeQuery("select * from data");


            if(printToFile){
                // print to File the result set
                readFromDBToFile(resultSet);
            }
            else{
                // Display the result set in Console
                readFromDB(resultSet);
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if (resultSet != null) {
                resultSet.close();
            }

            if (readStatement != null) {
                readStatement.close();
            }
            if (insertStatement != null) {
                insertStatement.close();
            }
            if (updateStatement != null) {
                updateStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    private static void updateInDB(PreparedStatement updateStatement, Scanner scanner) throws SQLException {
        System.out.println("Updating a row in table: ");
        System.out.println("Enter the id of the row: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new content: ");
        String content = scanner.nextLine();
        System.out.print("Enter new info: ");
        String info = scanner.nextLine();
        System.out.print("Enter new year: ");
        int year = Integer.parseInt(scanner.nextLine());
        Timestamp newTime = Timestamp.valueOf(LocalDateTime.now());

        updateStatement.setString(1, content);
        updateStatement.setString(2, info);
        updateStatement.setInt(3, year);
        updateStatement.setTimestamp(4, newTime);
        updateStatement.setInt(5, id);

    }
    private static void insertInDB(PreparedStatement insertStatement, Scanner scanner) throws SQLException {
        System.out.println("Add a new row in table:");
        System.out.println("Enter content: ");
        String content = scanner.nextLine();
        System.out.print("Enter info: ");
        String info = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());
        Timestamp newTime = Timestamp.valueOf(LocalDateTime.now());
        insertStatement.setString(1, content);
        insertStatement.setString(2, info);
        insertStatement.setInt(3, year);
        insertStatement.setTimestamp(4, newTime);

    }
    private static void readFromDB(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String content = resultSet.getString("content");
            String info = resultSet.getString("info");
            int year = resultSet.getInt("year");
            Timestamp date = resultSet.getTimestamp("date");

            System.out.printf("%-3d| %-27s| %-27s| %-10d| %s\n", id, content, info, year, date);
        }
    }
    private static void readFromDBToFile(ResultSet resultSet) throws SQLException, IOException {
        FileOutputStream out = new FileOutputStream("D:\\Documents\\1 Programming\\Codix\\JDBC\\db_testcx.txt");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String ids = String.valueOf(id);
            String content = resultSet.getString("content");
            String info = resultSet.getString("info");
            int year = resultSet.getInt("year");
            String years = String.valueOf(year);
            Timestamp date = resultSet.getTimestamp("date");
            String dates = String.valueOf(date);

            String row = (ids + repeatChar(' ', 5-ids.length()) + content + repeatChar(' ', 27-content.length())+ info + repeatChar(' ', 27-info.length()) + years + repeatChar(' ', 7-years.length()) + dates +"\n");
            out.write(row.getBytes());

        }
        out.close();
    }
    private static String repeatChar(char charToRepeat, int count){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(charToRepeat);
        }
        return sb.toString();
    }
}
