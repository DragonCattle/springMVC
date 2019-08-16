package com.itheima.springMVC.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * ����ת����
 * @author Administrator
 * S:source  Ҫת����Դ����
 * T:Ŀ�꣬Ҫת���ɵ���������
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
