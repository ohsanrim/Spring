package board.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BoardDTO {
	public int seq;
	public String id;
	public String name;
	public String email;
	public String subject;
	public String content;
	public int ref;
	public int lev;
	public int step;
	public int pseq;
	public int reply;
	public int hit;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
	public Date logtime;
}
