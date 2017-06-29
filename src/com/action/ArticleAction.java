package com.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import com.bean.MyArticle;
import com.bean.MyArticleContent;
import com.service.IArticleService;
import com.util.ImageMethod;

public class ArticleAction {

	private IArticleService articleService;// 文章类业务

	private List<MyArticle> articleList;// 文章列表

	private MyArticle article;// 单个文章

	private MyArticleContent articleContent;// 单个文章具体内容

	private int articleType;// 文章类别

	public int getArticleType() {
		return articleType;
	}

	public void setArticleType(int articleType) {
		this.articleType = articleType;
	}

	public List<MyArticle> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<MyArticle> articleList) {
		this.articleList = articleList;
	}

	public MyArticle getArticle() {
		return article;
	}

	public void setArticle(MyArticle article) {
		this.article = article;
	}

	public MyArticleContent getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(MyArticleContent articleContent) {
		this.articleContent = articleContent;
	}

	public IArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}

	/**
	 * 删除文章
	 * @return
	 */
	public String deleteArticle() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		articleType = Integer.parseInt(request.getParameter("articleType"));
		articleService.deleteArticle(articleId);
		articleList = articleService.getByType(articleType);

		return "articleEditList";
	}

	/**
	 * 编辑文章（标题，引言等内容）
	 * @return
	 */
	public String gotoArticleEditList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		articleType = Integer.parseInt(request.getParameter("articleType"));
		articleList = articleService.getByType(articleType);
		return "articleEditList";
	}

	/**
	 * 用户跳转到文章列表
	 * @return
	 */
	public String gotoArticleUserList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		articleType = Integer.parseInt(request.getParameter("articleType"));
		articleList = articleService.getByType(articleType);
		return "articleUserList";
	}

	/**
	 * 用户跳转到文章具体内容页面
	 */
	public String gotoArticleUserContent() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		MyArticleContent article = articleService
				.getArticleContentByArticleId(articleId);
		request.getSession().setAttribute("article", article);
		return "articleUserContent";
	}

	
	
	/***
	 * 管理员跳转到添加文章页面
	 * @return
	 */
	public String gotoAddArticle() {
		article=new MyArticle();//清空缓存
		articleContent=new MyArticleContent();//清空缓存
		return "articleAddOrEdit";
	}

	
	/***
	 * 管理员跳转到编辑文章页面
	 * @return
	 */
	public String gotoEditArticle() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		article = articleService.getArticleByArticleId(articleId);
		return "articleAddOrEdit";
	}

	
	/**
	 * 根据类型获取文章列表
	 * @return
	 */
	public String getArticleByType() {
		HttpServletRequest request = ServletActionContext.getRequest();
		articleType = Integer.parseInt(request.getParameter("articleType"));
		List<MyArticle> articles = articleService.getByType(articleType);
		return "articleList";
	}

	/**
	 * 保存文章并跳转到文章内容页
	 * @return
	 */
	public String DoSaveArticle() {
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(request.getParameter("articleId"));
		int articleId = Integer
				.parseInt(request.getParameter("articleId") .isEmpty() ? "-100"
						: request.getParameter("articleId"));
		int articleType = Integer.parseInt(request.getParameter("articleType"));
		String articleTitle = request.getParameter("articleTitle");
		//String articleTitleImageUrl = request.getParameter("articleTitleImageUrl");
		String writerName = request.getParameter("writerName");
		String articleLeadText = request.getParameter("articleLeadText");
		String articleTitleImageUrl = request.getParameter("articleTitleImageUrl");
		String createDate = request.getParameter("createDate").isEmpty()?"2017-01-01 00:00:00":request.getParameter("createDate");
		
		System.out.println(createDate);
		article= new MyArticle(articleId, writerName, articleType,
				articleTitle, articleTitleImageUrl, articleLeadText,
				Timestamp.valueOf(createDate), new Timestamp(
						System.currentTimeMillis()), 0);
		if (articleId == -100) {
			int articleId2=articleService.addArticle(article);
		} else {
			articleService.updateArticle(article);
			articleContent = articleService
					.getArticleContentByArticleId(articleId);
			articleContent.setMyArticle(article);
		}
		return "articleContentAddOrEdit";
	}

	
	
	/**
	 * 保存文章正文内容
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String DoSaveArticleContent() throws UnsupportedEncodingException {
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId = Integer
				.parseInt(request.getParameter("articleId") == null ? "-100"
						: request.getParameter("articleId"));
		
		String articleContentBuff = request.getParameter("articleContent");
		String articleContent=new String(articleContentBuff.getBytes("ISO-8859-1"), "UTF-8"); //中文解码
		
		MyArticleContent articleContent2= new MyArticleContent();
		articleContent2.setArticleContent(articleContent);
		MyArticle articleBuff=articleService.getArticleByArticleId(articleId);
		articleContent2.setMyArticle(articleBuff);
		
		if (articleId == -100) {
			System.out.println("前台传递了非法文章id，函数为DoSaveArticleContent");
		} else {
			articleService.updateArticleContent(articleContent2);
		}
		return "articleManage";
	}
	
	/**
	 * 压缩并上传文章图片方法
	 * @throws IOException
	 * @throws ServletException
	 */
	public void UploadImage() throws IOException, ServletException {
		
		HttpServletRequest request = ServletActionContext.getRequest();//请求request对象
		request.setCharacterEncoding("UTF-8");
		HttpServletResponse response = ServletActionContext.getResponse();//response对象返回数据给前台
		response.setContentType("application/json; charset=utf-8");
		String base64Img=request.getParameter("img").toString();
		base64Img=base64Img.replace("data:image/jpeg;base64,", "");//去除base64中无用的文件头
		String realSavePath=request.getSession().getServletContext().getRealPath("/WeixinPages/uploadImg/articleImage/");//保存图片的绝对路径
		String imgName=ImageMethod.Base64SaveAsImage(base64Img, realSavePath);//保存图片到系统应用文件夹中
		
		
		Map<String, String> map = new HashMap<String, String>();
		String showPath=request.getContextPath() +"/WeixinPages/uploadImg/articleImage/";
		//System.out.println(showPath+imgName);
		if(imgName==null){
			map.put("done", "-1");
			map.put("imgSrc", showPath+"nofound.jpg");
			map.put("msg", "图片上传失败了!");
		}else{
			map.put("done", "0");
			map.put("imgSrc", showPath+imgName);//显示图片的完整相对路径
			map.put("msg", "图片上传成功!");
			System.out.println("用户上传图片至："+showPath+imgName);
		}
		
        JSONObject jsonObject = JSONObject.fromObject(map);
        response.getWriter().write(jsonObject.toString()); 

	}

	
	/**
	 * 压缩并上传文章图标
	 * @throws IOException
	 * @throws ServletException
	 */
	public void UploadIcon() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();//请求request对象
		request.setCharacterEncoding("UTF-8");
		HttpServletResponse response = ServletActionContext.getResponse(); //response对象返回数据给前台
		response.setContentType("application/json; charset=utf-8");
		String base64Img=request.getParameter("img").toString();
		base64Img=base64Img.replace("data:image/jpeg;base64,", "");//去除base64中无用的文件头
		String realSavePath=request.getSession().getServletContext().getRealPath("/WeixinPages/uploadImg/articleIcon/");//保存图片的绝对路径
		String imgName=ImageMethod.Base64SaveAsImage(base64Img, realSavePath);//保存图片到系统应用文件夹中
		
		
		Map<String, String> map = new HashMap<String, String>();
		String showPath=request.getContextPath() +"/WeixinPages/uploadImg/articleIcon/";
		//System.out.println(showPath+imgName);
		if(imgName==null){
			map.put("done", "-1");
			map.put("imgSrc", showPath+"nofound.jpg");
			map.put("msg", "图标上传失败了!");
		}else{
			map.put("done", "0");
			map.put("imgSrc", showPath+imgName);//显示图片的完整相对路径
			map.put("msg", "图标上传成功!");
			System.out.println("用户上传图标至："+showPath+imgName);
		}
		
        JSONObject jsonObject = JSONObject.fromObject(map);
        response.getWriter().write(jsonObject.toString()); 
		
	}
	
	
	
	
}
