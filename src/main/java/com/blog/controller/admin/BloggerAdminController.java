 package com.blog.controller.admin;

 import com.blog.entity.Blogger;
/*   4:    */ import com.blog.service.BloggerService;
/*   5:    */ import com.blog.util.CryptographyUtil;
/*   6:    */ import com.blog.util.DateUtil;
/*   7:    */ import com.blog.util.ResponseUtil;
/*   8:    */ import java.io.File;
/*   9:    */ import javax.annotation.Resource;
/*  10:    */ import javax.servlet.ServletContext;
/*  11:    */ import javax.servlet.http.HttpServletRequest;
/*  12:    */ import javax.servlet.http.HttpServletResponse;
/*  13:    */ import net.sf.json.JSONObject;
/*  14:    */ import org.apache.shiro.SecurityUtils;
/*  15:    */ import org.apache.shiro.subject.Subject;
/*  16:    */ import org.springframework.stereotype.Controller;
/*  17:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  18:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  19:    */ import org.springframework.web.multipart.MultipartFile;
 
 @Controller
 @RequestMapping({"/admin/blogger"})
 public class BloggerAdminController
 {
 @Resource
  private BloggerService bloggerService;
  
  @RequestMapping({"/save"})
   public String save(@RequestParam("imageFile") MultipartFile imageFile, Blogger blogger, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
    if (!imageFile.isEmpty())
    {
     String filePath = request.getServletContext().getRealPath("/");
     String imageName = DateUtil.getCurrentDateStr() + "." + imageFile.getOriginalFilename().split("\\.")[1];
      imageFile.transferTo(new File(filePath + "static/userImages/" + imageName));
       blogger.setImageName(imageName);
     }
     int resultTotal = this.bloggerService.update(blogger).intValue();
   StringBuffer result = new StringBuffer();
   if (resultTotal > 0) {
       result.append("<script language='javascript'>alert('修改成功！');</script>");
     } else {
      result.append("<script language='javascript'>alert('修改失败！');</script>");
     }
    ResponseUtil.write(response, result);
     return null;
  }
 
   @RequestMapping({"/find"})
   public String find(HttpServletResponse response)
     throws Exception
   {
    Blogger blogger = this.bloggerService.find();
    JSONObject jsonObject = JSONObject.fromObject(blogger);
    ResponseUtil.write(response, jsonObject);
     return null;
   }
   
   @RequestMapping({"/modifyPassword"})
  public String modifyPassword(String newPassword, HttpServletResponse response)
     throws Exception
  {
   Blogger blogger = new Blogger();
     blogger.setPassword(CryptographyUtil.md5(newPassword, "darryl"));
    int resultTotal = this.bloggerService.update(blogger).intValue();
    JSONObject result = new JSONObject();
     if (resultTotal > 0) {
       result.put("success", Boolean.valueOf(true));
     } else {
       result.put("success", Boolean.valueOf(false));
    }
     ResponseUtil.write(response, result);
     return null;
   }
   
   @RequestMapping({"/logout"})
   public String logout()
     throws Exception
   {
     SecurityUtils.getSubject().logout();
    return "redirect:/login.jsp";
 }
 }
