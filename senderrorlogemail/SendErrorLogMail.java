package com.senderrorlogemail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.app.Activity;
import android.os.Environment;

/**
 * @ClassName: SendErrorLogMail
 * @Description: start send
 * @author guochaolang
 * @Time: 2016-3-7 下午5:22:25
 */
public class SendErrorLogMail {

	Activity act;

	public SendErrorLogMail(Activity activity) {
		act = activity;
	}
	
	/**
	 * @Title: SendErrorLog
	 * @Description: 获取错误日志并发送到邮箱
	 * @return: void
	 * @author guochaolang
	 * @Time: 2016-3-7 下午4:13:21
	 */
	public void SendErrorLog() {

		String path;
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) { // 优先保存到SD卡中
			path = Environment.getExternalStorageDirectory().getAbsolutePath()
					+ File.separator
					+ LogcatHelper.getInstance(act).errorlogfolder; // 放置日志文件的文件夹
		} else { // 如果SD卡不存在，就保存到本应用的目录下
			path = act.getFilesDir().getAbsolutePath() + File.separator
					+ LogcatHelper.getInstance(act).errorlogfolder; // 放置日志文件的文件夹
		}
		// File file = new File(path+"Cat-2016-03-04.log");
		File file = new File(path, "Cat-" + MyDate.getFileName() + ".log");
		FileInputStream fis;
		String res = "";
		try {
			fis = new FileInputStream(file);
			int length = fis.available();
			byte[] buffer = new byte[length];
			fis.read(buffer);
			//res = EncodingUtils.getString(buffer, "UTF-8");
			res =new String(buffer, "UTF-8");
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 将得到的log文件发送到邮箱
		final MailSenderInfo mailInfo = new MailSenderInfo();
		// mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerHost("smtp.sina.cn");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("18270721134@sina.cn"); // 你的邮箱地址

		mailInfo.setPassword("********");// 您的邮箱密码
		mailInfo.setFromAddress("18270721134@sina.cn");
		mailInfo.setToAddress("2544902337@qq.com");
		mailInfo.setSubject("log");
		mailInfo.setContent(res);
		// mailInfo.setAttachFileNames(file_name);

		// 这个类主要来发送邮件
		final SimpleMailSender sms = new SimpleMailSender();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				sms.sendTextMail(mailInfo);// 发送文体格式
				// sms.sendHtmlMail(mailInfo);//发送html格式
			}
		}).start();
	}
}
