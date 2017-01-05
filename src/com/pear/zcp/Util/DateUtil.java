package com.pear.zcp.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public final class DateUtil {
	
	public static String DEFAULT_DATE_SPLITE = "-";
	
	public static String DEFAULT_DATE_FROMAT = "yyyy-MM-dd";
	
	public static String DEFAULT_DATE_FROMAT_YYYYMM = "yyyy-MM";
	
	
	public static Date firstTimeForDate(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND,0);
		return c.getTime();
	}
	public static Date lastTimeForDate(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND,999);
		return c.getTime();
	}
	
	public static Date firstTimeForMonth(String date){
		if(date == null || StringUtils.isBlank(date)){
			throw new  IllegalArgumentException("input param is null or ''");
		}
		String[] values = date.split(DEFAULT_DATE_SPLITE);
		
		if(values == null || values.length != 2){
			throw new  IllegalArgumentException("input param must be yyyy-MM");
		}
		int year = Integer.parseInt(values[0]);
		int month = Integer.parseInt(values[1]);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND,0);
		return c.getTime();
	}
	
	public static Date lastTimeForMonth(String date){
		if(date == null || StringUtils.isBlank(date)){
			throw new  IllegalArgumentException("input param is null or ''");
		}
		String[] values = date.split(DEFAULT_DATE_SPLITE);
		
		if(values == null || values.length != 2){
			throw new  IllegalArgumentException("input param must be yyyy-MM");
		}
		int year = Integer.parseInt(values[0]);
		int month = Integer.parseInt(values[1]);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND,0);
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DATE, -1);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND,999);
		return c.getTime();
	}
	
	public static Date firstTimeForDate(String date){
		if(date == null || StringUtils.isBlank(date)){
			throw new  IllegalArgumentException("input param is null or ''");
		}
		String[] values = date.split(DEFAULT_DATE_SPLITE);
		
		if(values == null || values.length != 3){
			throw new  IllegalArgumentException("input param must be yyyy-MM");
		}
		int year = Integer.parseInt(values[0]);
		int month = Integer.parseInt(values[1]);
		int day = Integer.parseInt(values[2]);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.DAY_OF_MONTH, day);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND,0);
		return c.getTime();
	}
	
	public static Date lastTimeForDate(String date){
		if(date == null || StringUtils.isBlank(date)){
			throw new  IllegalArgumentException("input param is null or ''");
		}
		String[] values = date.split(DEFAULT_DATE_SPLITE);
		if(values == null || values.length != 3){
			throw new  IllegalArgumentException("input param must be yyyy-MM");
		}
		int year = Integer.parseInt(values[0]);
		int month = Integer.parseInt(values[1]);
		int day = Integer.parseInt(values[2]);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.DAY_OF_MONTH, day);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND,999);
		return c.getTime();
	}
	
	/**
     *获取当前时间
     * @return  当前完整时间
     */
    public final static Date getCurrentTime(){
        return new Date();
    }
    
    public static String getDate(Long date, boolean isEndDate){
		Date dateOld = new Date(date);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dateOldStr = sdf.format(dateOld);
		try {
			dateOld = sdf.parse(dateOldStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		if(isEndDate){
			Calendar c = Calendar.getInstance();
			c.setTime(dateOld);
			c.add(Calendar.DATE, 1);
			dateOld = c.getTime();
		}
		String rsult = sdf.format(dateOld);
		return rsult;
}
    
    public static Date getDateByLongDate(Long date){
		return new Date(date);
    	
    }
	
	public static void main(String[] args){
		//Date d = new Date();
		//Date begin = DateUtil.firstTimeForMonth("2016-01");
		//Date end = DateUtil.lastTimeForMonth("2016-01");
		
//		System.out.println(getDate(Long.valueOf("1483631999000").longValue(), false));
	}
}
