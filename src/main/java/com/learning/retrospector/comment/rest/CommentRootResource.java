package com.learning.retrospector.comment.rest;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.learning.retrospector.comment.api.Comment;
import com.learning.retrospector.comment.api.CommentConstants;
import com.learning.retrospector.comment.api.CommentException;
import com.learning.retrospector.comment.api.CommentInterface;
import com.learning.retrospector.comment.api.CommentNotFoundException;
import com.learning.retrospector.comment.api.DuplicateCommentException;
import com.learning.retrospector.comment.api.InvalidCommentException;
import com.learning.retrospector.comment.biz.RetroComment;
import com.learning.retrospector.util.Secured;

@Path("/comment")
public class CommentRootResource {

	private CommentInterface commentObj = new RetroComment();
	
	@POST
	@Path("/add")
	@Produces("application/json")
	public Response addComment(Comment newComment) throws URISyntaxException, InvalidCommentException, DuplicateCommentException, CommentException {
		System.out.println(newComment);
		Comment comment = commentObj.createComment(newComment);
		return Response.ok().entity(comment).build();
	}
	
	//@Secured
	@GET
    @Path("/")
	@Produces("application/json")
	public Response getAllComments() throws CommentException {
		List<Comment> comments = commentObj.getAllComments();
		GenericEntity<List<Comment>> list = new GenericEntity<List<Comment>>(comments) {};
		return Response.ok().entity(list).build();
	}
	
	@GET
    @Path("/{id}")
	@Produces("application/json")
	public Response getCommentById(@PathParam("id") String commentId) {
		Comment comment = null;
		try {
			comment = commentObj.getCommentById(commentId);
		} catch (CommentNotFoundException | CommentException e) {
			e.printStackTrace();
		}
		return Response.ok().entity(comment).build();
	}
	
	@PUT
	public Response updateComment(Comment updatedComment) {
		try {
			commentObj.updateComment(updatedComment);
		} catch (CommentNotFoundException | CommentException e) {
			//e.printStackTrace();
			return Response.status(Status.NOT_FOUND).entity(CommentConstants.CommentError.COMMENT_NOT_FOUND.toString()).build();
		}
		return Response.ok().entity(updatedComment).build();
	}
	
	@DELETE
    @Path("/{id}")
	public Response deleteCommentById(@PathParam("id") String commentId) {
		try {
			commentObj.deleteCommentById(commentId);
		} catch (CommentNotFoundException | CommentException e) {
			//e.printStackTrace();
			return Response.status(Status.NOT_FOUND).entity(CommentConstants.CommentError.COMMENT_NOT_FOUND.toString()).build();
		}
		return Response.ok().entity(commentId).build();
	}
	
}
