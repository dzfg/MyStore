package com.iscc.store.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

	private SendEmail() {

	}

	// 第一个参数:收件人
	// 第二个参数:验证码的值
	public static void send(String toEmail, String code, int type) {
		
		/**
		 * 各种配置信息,写到properties集合
		 */
		Properties properties = new Properties();
		// 设置邮件的协议,这里设置的是SMTP协议,即是发送的协议
		properties.put("mail.transport.protocol", "SMTP");
		// 设置邮件的主机服务器
		properties.put("mail.smtp.host", "smtp.qq.com");
		// 设置邮件的端口号
		properties.put("mail.smtp.port", "465");
		// 设置邮件的认证
		properties.put("mail.smtp.auth", "true");
		// 开启debug模式,方便调试
		properties.put("mail.debug", "true");
		// 允许使用ssl
		properties.put("mail.smtp.ssl.enable", "true");

		/**
		 * 开启会话
		 */
		Session session = Session.getDefaultInstance(properties);

		try {
			/**
			 * 做出一封完整的邮件
			 */
			// 在这里更应该理解为,把message对象存入到session中
			Message message = new MimeMessage(session);
			// 设置邮件的主题
			message.setSubject("欢迎使用商城系统");
			// 设置邮件的发送日期
			message.setSentDate(new Date());
			// 设置发件人的地址,即从xxxx@qq.com地址中发送出邮件
			// 授权码:jkhqgwbgupyjbecg
			message.setFrom(new InternetAddress("695622366@qq.com"));
			// 设置收件人[收件人,抄送人,密送人]
			// TO:收件人
			// CC:抄送人
			// BCC:密送人
			message.setRecipient(RecipientType.TO, new InternetAddress(toEmail));

			// 设置邮件正文内容
			message.setText("您可以通过此邮件完成注册.");
			// 设置保存文件
			message.saveChanges();

			/**
			 * 添加附件
			 */
			// 添加出多功能处理模块
			// MimeMultipart(String subType): 这里的值有三种类型:
			// multipart/mixed：附件。
			// multipart/related：内嵌资源。
			// multipart/alternative：纯文本与超文本共存。
			MimeMultipart multipart = new MimeMultipart("related");

			// 为多功能模块构建内容: 文本, 图片 等等.
			MimeBodyPart content = new MimeBodyPart(); // 这是创建的文本部分

			/**
			 * 添加文本
			 */
			if (type == 1) {
				// "<a href=\"http://www.google.cn\">谷歌</a>"
				content.setContent("您的验证码如下:" + code + "<br/>(验证码在五分钟内有效,请抓紧时间注册哦)", "text/html;charset=utf-8");
			} else {
				content.setContent("您的激活链接如下:<br/>" + "<a href=\"http://"+GetIPv4.getInetAddress()+":8080/myStore/activateUserServlet2?code="
						+ code + "\">点我激活用户</a>", "text/html;charset=utf-8");
			}
			// 把文本和图片都加入到多功能模块
			multipart.addBodyPart(content);

			// 把多功能模块, 放入到邮件的主体
			message.setContent(multipart);

			// 设置保存邮件
			message.saveChanges();

			/**
			 * 发送邮件,获取到发送对象<br>
			 */
			Transport transport = session.getTransport("smtp");

			// 登录发送人的帐号和授权码
			transport.connect("695622366@qq.com", "jkhqgwbgupyjbecg");

			// 发送邮件
			// 第一个参数:要发送的邮件
			// 第二个参数:所有的接收者
			transport.sendMessage(message, message.getAllRecipients());

			/**
			 * 关闭传输对象
			 */
			transport.close();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
