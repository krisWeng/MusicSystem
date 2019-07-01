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
			SchemaFactory sf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");//1.����һ��ģʽ����
			File f = new File(xsdPath);
			Schema s = sf.newSchema(f);//2��ͨ��ģʽ��������һ��ģʽ
			Validator v = s.newValidator();//3.ͨ�����ģʽ����һ����֤�� 
			Source source = new StreamSource(xmlPath);
			v.validate(source);//4.��֤
			flag = true;
		} catch (SAXException e) {
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("XML�ļ���֤ʧ�ܣ�");
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
