package com.learning.retrospector.comment.rest;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.learning.retrospector.comment.api.Comment;
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
	
	@Secured
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
}
