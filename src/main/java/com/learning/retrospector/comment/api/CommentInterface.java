package com.learning.retrospector.comment.api;

import java.util.List;

public interface CommentInterface {

	//Create
		public Comment createComment(Comment comment) throws InvalidCommentException, DuplicateCommentException, CommentException;
		
		//Read
		public List<Comment> getAllComments() throws CommentException;
		public Comment getCommentById(String commentId) throws CommentNotFoundException, CommentException;
		public List<Comment> getCommentsByUserId(String userId) throws CommentNotFoundException, CommentException;
		public List<Comment> getCommentsByUserIdForSprint(String userId, int sprintNumber) throws CommentNotFoundException, CommentException;
		public List<Comment> getCommentsByScrumForSprint(String scrum, int sprintNumber) throws CommentNotFoundException, CommentException;
		
		//Update
		public void updateComment(Comment comment) throws CommentNotFoundException, CommentException;
		
		//Delete
		public void deleteComment(Comment comment) throws InvalidCommentException, DuplicateCommentException, CommentException;
		public void deleteCommentById(String id) throws InvalidCommentException, DuplicateCommentException, CommentException;

}
