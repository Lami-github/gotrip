package pwdquiz;

import java.util.ArrayList;
import java.util.List;

public class PwdquizDataBean {
	
	private int pquiz_num;
	private String quiz;
	private List<PwdquizDataBean> pwdquizList;

	
	
	public PwdquizDataBean() {
		this(new ArrayList<PwdquizDataBean>(),0,"질문을 선택해주십시요");
	}
	public PwdquizDataBean(List<PwdquizDataBean> pwdquizList, int pquiz_num, String quiz ) {
		this.pwdquizList= pwdquizList;
		this.pquiz_num=pquiz_num;
		this.quiz=quiz;
	}
	public int getPquiz_num() {
		return pquiz_num;
	}
	public void setPquiz_num(int pquiz_num) {
		this.pquiz_num = pquiz_num;
	}
	public String getQuiz() {
		return quiz;
	}
	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}
	public List<PwdquizDataBean> getPwdquizList() {
		return pwdquizList;
	}
	public void setPwdquizList(List<PwdquizDataBean> pwdquizList) {
		this.pwdquizList = pwdquizList;
	}
	

}
