package com.man1s.algorithm.tcp.test;


import com.man1s.algorithm.tcp.utils.FtpTool;

public class TestFtp {
	private static final  String IP = "172.23.4.148";
	private static final  Integer PORT = 21;
	private static final  String NAME = "ftp_test";
	private static final  String PASS = "1123";


	public static void main(String[] args) {
		FtpTool ftpTool = new FtpTool();
		ftpTool.getFilesName(IP,PORT,NAME,PASS,"/home/ftp_test");
}


}
