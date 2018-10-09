package com.gm;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VisitDALTest {
    @Test
    public void getVisitCount() throws Exception {
        VisitDAL visitDAL=new VisitDAL();

        final int visitCount = visitDAL.getVisitCount();
        Assert.assertTrue(visitCount >0);

        //Assert.assertTrue(visitDAL.insertDayRecord(visitCount)>0);
    }


}