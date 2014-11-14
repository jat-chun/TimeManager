package com.example.timemanager.utils;

import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

import com.example.timemanager.bean.UpdateBean;

public class XmlParseUtils {

	/**
	 * ����XML
	 * @param inputStream
	 * @return
	 */
	public static UpdateBean getUpdateInfo(InputStream inputStream) {
		//�õ�����������ʼ�����õ��¼����ͣ�������ƶ����ݾͷŽ�bean����
		XmlPullParser parser = Xml.newPullParser();
		UpdateBean bean = new UpdateBean();
		try {
			parser.setInput(inputStream, "UTF-8");
			int type = parser.getEventType();
			//û���������ͼ������
			while(type!=XmlPullParser.END_DOCUMENT){
				switch (type) {
				case XmlPullParser.START_TAG:
					if("version".equals(parser.getName())){
						bean.setVersion(parser.nextText());
						System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+bean.getVersion());
					}else if("description".equals(parser.getName())){
						bean.setDescription(parser.nextText());
					}else if("apkurl".equals(parser.getName())){
						bean.setApkurl(parser.nextText());
					}
					break;
				}
				type = parser.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
}
