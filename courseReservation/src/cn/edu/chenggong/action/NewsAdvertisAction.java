package cn.edu.chenggong.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.chenggong.biz.NewsAdvertisBiz;
import cn.edu.chenggong.po.NewsAdvertis;

@Controller
@RequestMapping("NewsAdvertisAction")
public class NewsAdvertisAction {
	@Resource
	private NewsAdvertisBiz newsBiz;

	public NewsAdvertisBiz getNewsBiz() {
		return newsBiz;
	}

	public void setNewsBiz(NewsAdvertisBiz newsBiz) {
		this.newsBiz = newsBiz;
	}

	@RequestMapping("/selectNewsAdvertis")
	public String selectNewsAdvertis(HttpSession session) {
		List<NewsAdvertis> listNews = new ArrayList<NewsAdvertis>();
		listNews = newsBiz.findNewsAdver();
		session.setAttribute("newsAdver", listNews);
		return "/displayNewsAdvertis.jsp";
	}
	
	/*
	 * 文件及新闻信息上传至Tomcat服务器
	 */
	@RequestMapping("/usersAdvertisPost")
	public String usersAdvertisPost(MultipartFile file,
			HttpServletRequest request, NewsAdvertis newsA)
			throws IllegalStateException, IOException {
		String path = request.getSession().getServletContext()
				.getRealPath("fileUpload");// tomcat下的文件路径
		String fileName = file.getOriginalFilename();
		File dir = new File(path, fileName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		file.transferTo(dir);
		String pathFile = "http://localhost:8080/courseReservation/fileUpload/"
				+ fileName;
		newsA.setAdvertisPath(pathFile);
		newsBiz.addNewsAdver(newsA);
		return "ok";
	}

	/*
	 * 文件下载
	 */
	@RequestMapping("/usersFiledown")
	public void filedown(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 模拟文件，myfile.txt为需要下载的文件
		String fileName = request.getSession().getServletContext()
				.getRealPath("fileupload")
				+ "/新建文本文档.html";
		// 获取输入流
		InputStream bis = new BufferedInputStream(new FileInputStream(new File(
				fileName)));
		// 假如以中文名下载的话
		String filename = "下载文件.txt";
		// 转码，免得文件名中文乱码
		filename = URLEncoder.encode(filename, "UTF-8");
		// 设置文件下载头
		response.addHeader("Content-Disposition", "attachment;filename="
				+ filename);
		// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
		response.setContentType("multipart/form-data");
		BufferedOutputStream out = new BufferedOutputStream(
				response.getOutputStream());
		int len = 0;
		while ((len = bis.read()) != -1) {
			out.write(len);
			out.flush();
		}
		out.close();
	}
}
