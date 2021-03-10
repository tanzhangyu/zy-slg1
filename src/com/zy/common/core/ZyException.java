package com.zy.common.core;

public class ZyException extends Exception {
	private static final long serialVersionUID = 1L;
	private Integer exceptionCode;

	private ZyException(String exceptionDesc) {
		// TODO 开启业务异常追踪
		super(exceptionDesc, null, false, true);
	}

	/**
	 * 业务异常(无跟踪堆栈 提高性能)
	 * 
	 * @param exceptionCode 业务码
	 * @param exceptionDesc 异常描述
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
