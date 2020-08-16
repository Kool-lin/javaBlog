package com.blog.service.impl;

import com.blog.dao.BloggerDao;
import com.blog.entity.Blogger;
import com.blog.service.BloggerService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {
	@Resource
	private BloggerDao bloggerDao;

	public Blogger find() {
		return this.bloggerDao.find();
	}

	public Blogger getByUserName(String userName) {
		return this.bloggerDao.getByUserName(userName);
	}

	public Integer update(Blogger blogger) {
		return this.bloggerDao.update(blogger);
	}
}
