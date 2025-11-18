package com.example.TodoApi;

public class Response{
	private Long id=null;
	private Boolean completed=null;
	private String title=null;
	private Long userId=null;
	private String message=null;


	public Response(Long id, Boolean completed, String title, Long userId){
		this.id=id;
		this.completed=completed;
		this.title=title;
		this.userId=userId;
	}

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return id;
	}

	public void setCompleted(Boolean completed){
		this.completed = completed;
	}

	public Boolean isCompleted(){
		return completed;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUserId(Long userId){
		this.userId = userId;
	}

	public Long getUserId(){
		return userId;
	}


	@Override
 	public String toString(){
		return 
			"Response{" + 
			"id = '" + id + '\'' + 
			",completed = '" + completed + '\'' + 
			",title = '" + title + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}
}
