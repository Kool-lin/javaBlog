package com.blog.dao;

import com.blog.entity.Blogger;

public abstract interface BloggerDao
{
  public abstract Blogger find();  //查找
  
  public abstract Blogger getByUserName(String paramString);   //获取
  
  public abstract Integer update(Blogger paramBlogger);			//修改
}

