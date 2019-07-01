package cn.edu.lingnan.util;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlValidator {
	
	public static boolean validator(String xmlPath, String xsdPath){
		boolean flag = false;
		String base = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//		System.out.println("------"+base);
		xmlPath = base + xmlPath;
		xsdPath = base + xsdPath;
//		System.out.println(xmlPath);
//		System.out.println(xsdPath);
		try {
			SchemaFactory sf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");//1.创建一个模式工厂
			File f = new File(xsdPath);
			Schema s = sf.newSchema(f);//2。通过模式工厂创建一个模式
			Validator v = s.newValidator();//3.通过这个模式创建一个验证器 
			Source source = new StreamSource(xmlPath);
			v.validate(source);//4.验证
			flag = true;
		} catch (SAXException e) {
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("XML文件验证失败！");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static void main(String[] args) {
		String xmlPath = "database.conf.xml";
		String xsdPath = "database.conf.xsd";
		System.out.println(XmlValidator.validator(xmlPath, xsdPath));
	}

}
