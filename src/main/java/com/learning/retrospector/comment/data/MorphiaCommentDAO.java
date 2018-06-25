package com.learning.retrospector.comment.data;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.dao.BasicDAO;

import com.learning.retrospector.comment.api.Comment;
import com.learning.retrospector.comment.api.CommentException;
import com.learning.retrospector.comment.api.CommentNotFoundException;
import com.learning.retrospector.comment.api.DuplicateCommentException;
import com.learning.retrospector.comment.api.InvalidCommentException;

public class MorphiaCommentDAO extends BasicDAO<Comment, String> implements CommentDAO  {

	public MorphiaCommentDAO(Class entityClass, Datastore ds) {
		super(entityClass, ds);	
	}
	
	@Override
	public Comment createComment(Comment comment)
			throws InvalidCommentException, DuplicateCommentException, CommentException {
		Key<Comment> key = save(comment);
		if(key == null)
			throw new CommentException();
		return comment;
	}

	@Override
	public List<Comment> getAllComments() throws CommentException {
		List<Comment> comments = createQuery().asList();
		return comments;
	}

	@Override
	public Comment getCommentById(String commentId) throws CommentNotFoundException, CommentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getCommentsByUserId(String userId) throws CommentNotFoundException, CommentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getCommentsByUserIdForSprint(String userId, int sprintNumber)
			throws CommentNotFoundException, CommentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getCommentsByScrumForSprint(String scrum, int sprintNumber)
			throws CommentNotFoundException, CommentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateComment(Comment comment)
			throws InvalidCommentException, DuplicateCommentException, CommentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteComment(Comment comment)
			throws InvalidCommentException, DuplicateCommentException, CommentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCommentById(String id)
			throws InvalidCommentException, DuplicateCommentException, CommentException {
		// TODO Auto-generated method stub
		
	}

}
