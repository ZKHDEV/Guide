package com.zkh.guide.common;

import java.awt.Color;
import java.io.File;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.ApplicationContext;

public class CommonUtils {

	public static String uuid(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
}
