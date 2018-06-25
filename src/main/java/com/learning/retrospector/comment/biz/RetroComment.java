package com.learning.retrospector.comment.biz;

import java.util.List;
import java.util.UUID;

import org.mongodb.morphia.Datastore;

import com.learning.retrospector.comment.api.Comment;
import com.learning.retrospector.comment.api.CommentException;
import com.learning.retrospector.comment.api.CommentInterface;
import com.learning.retrospector.comment.api.CommentNotFoundException;
import com.learning.retrospector.comment.api.DuplicateCommentException;
import com.learning.retrospector.comment.api.InvalidCommentException;
import com.learning.retrospector.comment.data.CommentDAO;
import com.learning.retrospector.comment.data.MorphiaCommentDAO;
import com.learning.retrospector.util.DatabaseHandler;

public class RetroComment implements CommentInterface{

	Datastore datastore = DatabaseHandler.getMongoDatastore();
	private CommentDAO dao = new MorphiaCommentDAO(Comment.class,datastore);

	
	@Override
	public Comment createComment(Comment comment)
			throws InvalidCommentException, DuplicateCommentException, CommentException {
		comment.setCommentId(UUID.randomUUID().toString());
		Comment createdComment = dao.createComment(comment);
		return createdComment;
	}

	@Override
	public List<Comment> getAllComments() throws CommentException {
		return dao.getAllComments();
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
