package com.project.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.PostView;

@Repository
@Transactional
public class PostViewDao {

	private SessionFactory sessfact;
	
	public PostViewDao() { }
	
	@Autowired
	public PostViewDao(SessionFactory sessfact) {
		super();
		this.sessfact = sessfact;
	}
	
	public List<PostView> findAll() {
		return sessfact.getCurrentSession().createNativeQuery("select * from social.post_view order by social.post_view.id desc", PostView.class).list();
	}
	
	public List<PostView> findByUserId(int userid) {
		Query<PostView> q = sessfact.getCurrentSession().createNativeQuery("select * from social.post_view where post_userid =?1 order by social.post_view.id desc", PostView.class);
		q.setParameter(1, userid);
		return q.getResultList();
	}
	/*No CRUD methods. This is a view not a table!!
	  If you want to update post or user do it w// PostDao or UserDao**/
}
