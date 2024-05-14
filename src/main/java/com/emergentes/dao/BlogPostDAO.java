package com.emergentes.dao;

import com.emergentes.modelo.BlogPost;
import java.util.List;

public interface BlogPostDAO {
    public void insert(BlogPost blogpost) throws Exception;
    public void update(BlogPost blogpost) throws Exception;
    public void delete(int id) throws Exception;
    public BlogPost getById(int id) throws Exception;
    public List<BlogPost> getAll() throws Exception;
}
