package com.emergentes.dao;

import com.emergentes.modelo.BlogPost;
import com.emergentes.utiles.ConexionDB;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlogPostDAOimpl extends ConexionDB implements BlogPostDAO{
    
    @Override
    public void insert(BlogPost blogpost) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT into blogpost (fecha, titulo, contenido) values (?,?,?)");
            ps.setDate(1, (Date) blogpost.getFecha());
            ps.setString(2, blogpost.getTitulo());
            ps.setString(3, blogpost.getContenido());
            ps.executeUpdate();            
        } catch (Exception e){
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update(BlogPost blogpost) throws Exception {
        try{
            PreparedStatement ps = this.conn.prepareStatement("UPDATE blogpost set fecha=?, titulo=?, contenido=? where id=?");
            ps.setDate(1, (Date) blogpost.getFecha());
            ps.setString(2, blogpost.getTitulo());
            ps.setString(3, blogpost.getContenido());
            ps.setInt(4, blogpost.getId());
            ps.executeUpdate();
        } catch(Exception e){
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM blogpost WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e){
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public BlogPost getById(int id) throws Exception {
        BlogPost bp = new BlogPost();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM blogpost WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                bp.setId(rs.getInt("id"));
                bp.setTitulo(rs.getString("titulo"));
                bp.setContenido(rs.getString("contenido"));
            }
        } catch (Exception e){
            throw e;
        } finally {
            this.desconectar();
        }
        return bp;
    }

    @Override
    public List<BlogPost> getAll() throws Exception {
        List<BlogPost> lista = null;
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM blogpost");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<BlogPost>();
            while (rs.next()){
                BlogPost bp = new BlogPost();
                bp.setId(rs.getInt("id"));
                bp.setTitulo(rs.getString("titulo"));
                bp.setContenido(rs.getString("contenido"));
                lista.add(bp);
            }
            rs.close();
            ps.close();
        } catch (Exception e){
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
