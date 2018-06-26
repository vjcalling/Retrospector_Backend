package com.learning.retrospector.comment.api;

public class CommentConstants {

	public enum CommentError {
		
		COMMENT_NOT_FOUND("Comment Not Found"), DUPLICATE_COMMENT("Duplicate Comment"), INVALID_COMMENT("Invalid Comment");

		String value;
		CommentError(String value) { this.value = value; }
		
		public String toString(){
			return value;
		}
		
	}
}
