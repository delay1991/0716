package co.micol.manager.board.vo;

import java.sql.Date;//시분초관리안됌 sql보다는 utl을 현업에서 더씀.

public class BoardVO {
private String boardid;
private String writer;
private String title;
private String subject;
private Date enterdate; 
private int hit;

public BoardVO() {
}

public String getBoardid() {
	return boardid;
}

public void setBoardid(String boardid) {
	this.boardid = boardid;
}

public String getWriter() {
	return writer;
}

public void setWriter(String writer) {
	this.writer = writer;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

public Date getEnterdate() {
	return enterdate;
}

public void setEnterdate(Date enterdate) {
	this.enterdate = enterdate;
}

public int getHit() {
	return hit;
}

public void setHit(int hit) {
	this.hit = hit;
}

public String toString() {
	System.out.print(" "+boardid+" : ");
	System.out.print(writer+" : ");
	System.out.print(title+" : ");
	System.out.print(enterdate+" : ");
	System.out.println(hit);
	return null;
}


}
