package cn.edu.lingnan.util;

import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlHandler extends DefaultHandler{
	
	private StringBuffer sb = new StringBuffer();
	private HashMap<String,String> hm = new HashMap<String,String>();
	
	public void startElemnt (String uri, String localName, String qName, Attributes attributes)
		throws SAXException
	{
		sb.delete(0,sb.length());//1.清空可变字符串的内容
	}
	
	public void endElement (String uri, String localName, String qName)
		throws SAXException
	{
		hm.put(qName.toLowerCase(), sb.toString().trim());//3.把读到的内容写入一个存储介质
	}
	
	public void characters (char ch[], int start, int length)
		throws SAXException
	{
		sb.append(ch, start, length);//2.把读到的ch字符数组中的内容写入可变字符串
	}
	
	public HashMap<String,String> getHahMap(){
		return hm;
	}
}
