package com.compare.component;

import java.util.ArrayList;
import java.util.List;

//@Entity
public class CompareInfo {
	
	//@Id
	//@GeneratedValue
	private int contentId;
	private String formId;
	private String formTitle;
	private String versionNo;
	private List<Integer> paraSeq;
	private List<String> content;
	
	/**
	 * @return the contentId
	 */
	public int getContentId() {
		return contentId;
	}
	/**
	 * @param contentId the contentId to set
	 */
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	/**
	 * @return the cormId
	 */
	public String getFormId() {
		return formId;
	}
	/**
	 * @param cormId the cormId to set
	 */
	public void setFormId(String formId) {
		this.formId = formId;
	}
	/**
	 * @return the formTitle
	 */
	public String getFormTitle() {
		return formTitle;
	}
	/**
	 * @param formTitle the formTitle to set
	 */
	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}
	/**
	 * @return the versionNo
	 */
	public String getVersionNo() {
		return versionNo;
	}
	/**
	 * @param versionNo the versionNo to set
	 */
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	/**
	 * @return the paraSeq
	 */
	public List<Integer> getParaSeq() {
		
		if(paraSeq == null)
			return new ArrayList<Integer>();
		return paraSeq;
	}
	/**
	 * @param paraSeq the paraSeq to set
	 */
	public void setParaSeq(List<Integer> paraSeq) {
		this.paraSeq = paraSeq;
	}
	/**
	 * @return the content
	 */
	public List<String> getContent() {
		
		if(content == null)
			return new ArrayList<String>();
		
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(List<String> content) {
		this.content = content;
	}

}
