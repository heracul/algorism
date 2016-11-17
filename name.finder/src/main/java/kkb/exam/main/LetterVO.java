package kkb.exam.main;

public class LetterVO {

	public LetterVO prev;
	public String value;
	public LetterVO next;
	
	public LetterVO getPrev() {
		return prev;
	}
	public void setPrev(LetterVO prev) {
		this.prev = prev;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public LetterVO getNext() {
		return next;
	}
	public void setNext(LetterVO next) {
		this.next = next;
	}
}
