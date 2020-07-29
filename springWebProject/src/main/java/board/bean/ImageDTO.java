package board.bean;

import java.util.Date;

import lombok.Data;

@Data
public class ImageDTO {
	public int seq;
	public String imageId;
	public String imageName;
	public int imagePrice;
	public int imageQty;
	public String imageContent;
	public String image1;
	public Date logtime;
}
