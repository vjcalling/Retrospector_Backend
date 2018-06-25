package com.learning.retrospector.comment.data;

import java.util.List;

import com.learning.retrospector.comment.api.Comment;
import com.learning.retrospector.comment.api.CommentException;
import com.learning.retrospector.comment.api.CommentNotFoundException;
import com.learning.retrospector.comment.api.DuplicateCommentException;
import com.learning.retrospector.comment.api.InvalidCommentException;

public interface CommentDAO {

	//Create
	public Comment createComment(Comment comment) throws InvalidCommentException, DuplicateCommentException, CommentException;

	//Read
	public List<Comment> getAllComments() throws CommentException;
	public Comment getCommentById(String commentId) throws CommentNotFoundException, CommentException;
	public List<Comment> getCommentsByUserId(String userId) throws CommentNotFoundException, CommentException;
	public List<Comment> getCommentsByUserIdForSprint(String userId, int sprintNumber) throws CommentNotFoundException, CommentException;
	public List<Comment> getCommentsByScrumForSprint(String scrum, int sprintNumber) throws CommentNotFoundException, CommentException;

	//Update
	public void updateComment(Comment comment) throws InvalidCommentException, DuplicateCommentException, CommentException;

	//Delete
	public void deleteComment(Comment comment) throws InvalidCommentException, DuplicateCommentException, CommentException;
	public void deleteCommentById(String id) throws InvalidCommentException, DuplicateCommentException, CommentException;

}
