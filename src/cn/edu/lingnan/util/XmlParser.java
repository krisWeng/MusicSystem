package cn.edu.lingnan.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XmlParser {
	
	public static HashMap<String,String> parser(String xmlPath){
		String base = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		xmlPath = base + xmlPath;
		HashMap<String,String> hm = new HashMap<String,String>();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			File file = new File(xmlPath);
			XmlHandler xh = new XmlHandler();
			saxParser.parse(file, xh);
			hm = xh.getHahMap();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hm;
	}

	public static void main(String[] args) {
		String xmlPath = "database.conf.xml";
		XmlParser.parser(xmlPath);
		System.out.println();

	}

}
