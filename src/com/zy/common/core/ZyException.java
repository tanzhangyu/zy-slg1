package com.zy.common.core;

public class ZyException extends Exception {
	private static final long serialVersionUID = 1L;
	private Integer exceptionCode;

	private ZyException(String exceptionDesc) {
		// TODO ����ҵ���쳣׷��
		super(exceptionDesc, null, false, true);
	}

	/**
	 * ҵ���쳣(�޸��ٶ�ջ �������)
	 * 
	 * @param exceptionCode ҵ����
	 * @param exceptionDesc �쳣����
	 */
	public ZyException(Integer exceptionCode, String exceptionDesc) {
		this(exceptionDesc);
		this.exceptionCode = exceptionCode;
	}

	public ZyException(Integer exceptionCode) {
		this("" + exceptionCode);
		this.exceptionCode = exceptionCode;
	}

	public Integer getExceptionCode() {
		return exceptionCode;
	}

}
