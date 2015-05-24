package com.tony.threadpoolexecutor;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestBase64 {

	public static final Log logger = LogFactory.getLog(TestBase64.class);
	
	public static byte[] getUTF8Bytes(String arg) throws Exception{
		logger.debug("getUTF8Bytes");
		return arg.getBytes("UTF-8");
	}
	public static byte[] getGBKBytes(String arg) throws Exception{
		logger.debug("getGBKBytes");
		return arg.getBytes("GB2312");
	}
	
	public static void main(String[] args)throws Exception{
		/*String x = "dfdfdfsafdaf erer sdfaiere dfd";*/
		String x = "我是中国人";
		String j = new sun.misc.BASE64Encoder().encode(TestBase64.getGBKBytes(x));
		String k = new sun.misc.BASE64Encoder().encode(TestBase64.getUTF8Bytes(x));
		/*System.out.println(j.equals(k));
		System.out.println(TestBase64.getGBKBytes(x).length);
		System.out.println(TestBase64.getUTF8Bytes(x).length);*/
	}
}
