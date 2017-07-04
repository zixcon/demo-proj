package com.learning.demo.common;

import com.google.common.base.Strings;
import com.learning.demo.common.util.BigDecimalUtil;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.math.BigDecimal;
import java.text.MessageFormat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        LocalDate start=new LocalDate(2012, 12,15);
        LocalDate end=new LocalDate(2012, 12, 15);
        int days = Days.daysBetween(start, end).getDays();

        System.out.println( "Hello World!" + days);


        String name1 = "s";
        String name2 = "ssdfasdfasfadsfasdfasadfdsfsdafasdfasdfasdfasfdasdf";
        String name3 = "sdfsadfa";
        String name4 = "       ";
        boolean bname1 = Strings.isNullOrEmpty(name1)|| (name1.length()>=2 && name1.length()<=16 );
        boolean bname2 = Strings.isNullOrEmpty(name2)|| (name2.length()>=2 && name2.length()<=16 );
        boolean bname3 = Strings.isNullOrEmpty(name3)|| (name3.length()>=2 && name3.length()<=16 );
        boolean bname4 = Strings.isNullOrEmpty(name4)|| (name4.length()>=2 && name4.length()<=16 );

//		boolean bamount1 = AmountUtil.isLess8PointLess2Number(new BigDecimal("999999999.99"));
//		boolean bamount2 = AmountUtil.isLess8PointLess2Number(new BigDecimal("99999999.99"));
//		boolean bamount3 = AmountUtil.isLess8PointLess2Number(new BigDecimal("99999999.999"));
//		boolean bamount4 = AmountUtil.isLess8PointLess2Number(new BigDecimal("99999999.9"));
//		boolean bamount5 = AmountUtil.isLess8PointLess2Number(new BigDecimal("9999999"));

//        boolean bamount1 = BigDecimalUtil.isZero(new BigDecimal("00.00"));
//        boolean bamount2 = BigDecimalUtil.isZero(new BigDecimal("0.0"));
//        boolean bamount3 = BigDecimalUtil.isZero(new BigDecimal("0.000"));
//        boolean bamount4 = BigDecimalUtil.isZero(new BigDecimal("0"));
//        boolean bamount5 = BigDecimalUtil.isZero(new BigDecimal("0000"));

        boolean bamount1 = BigDecimalUtil.isNegative(new BigDecimal("-00.00"));
        boolean bamount2 = BigDecimalUtil.isNegative(new BigDecimal("-10.0"));
        boolean bamount3 = BigDecimalUtil.isNegative(new BigDecimal("10.000"));
        boolean bamount4 = BigDecimalUtil.isNegative(new BigDecimal("0"));
        boolean bamount5 = BigDecimalUtil.isNegative(new BigDecimal("-0.001"));

        System.out.println( "bname1= " + bname1);
        System.out.println( "bname1= " + bname2);
        System.out.println( "bname1= " + bname3);
        System.out.println( "bname1= " + bname4);

        System.out.println( "bamount1= " + bamount1);
        System.out.println( "bamount2= " + bamount2);
        System.out.println( "bamount3= " + bamount3);
        System.out.println( "bamount4= " + bamount4);
        System.out.println( "bamount5= " + bamount5);

        String temp = "dfasdf{0}sdfasdf{1}sdf";
        String ss = MessageFormat.format(temp,1,2);
        System.out.println(ss);
    }
}
