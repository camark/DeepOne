package com.gm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ///System.out.println( "Hello World!" );

        VisitDAL visitDAL=new VisitDAL();
        final int visitCount = visitDAL.getVisitCount();
        //System.out.println(visitCount);
        visitDAL.insertDayRecord(visitCount);
    }


}
