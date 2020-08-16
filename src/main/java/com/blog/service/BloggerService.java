package com.blog.service;

import com.blog.entity.Blogger;

public abstract interface BloggerService
{
  public abstract Blogger find();
  
  public abstract Blogger getByUserName(String paramString);
  
  public abstract Integer update(Blogger paramBlogger);
}
