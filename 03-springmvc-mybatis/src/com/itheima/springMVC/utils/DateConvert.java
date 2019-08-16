package com.itheima.springMVC.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 日期转换期
 * @author Administrator
 * S:source  要转换的源类型
 * T:目标，要转换成的数据类型
 *
 */
public class DateConvert implements Converter<String, Date>{

	public Date convert(String source) {
		
		Date result=null;
		
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			result=sdf.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
