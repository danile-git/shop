package com.shop.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class FtpTest {
//	@Test
//	public void ftpClient() throws SocketException, IOException {
//		// 创建ftp对象
//		FTPClient ftp = new FTPClient();
//
//		//
//		ftp.connect("192.168.199.239", 21);
//		ftp.login("ftpuser", "123456");
//		FileInputStream inputStream = new FileInputStream(new File("E:\\安装包\\1.jpg"));
//		ftp.changeWorkingDirectory("/home/ftpuser/www/images");
//		ftp.setFileType(FTP.BINARY_FILE_TYPE);
//		// 第一个参数 存储的名字 ，第二个本地文件流
//		ftp.storeFile("h.jpg", inputStream);
//		inputStream.close();
//		ftp.logout();
//
//	}
}
