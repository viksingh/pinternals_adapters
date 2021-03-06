package com.pinternals.mailclientadapter;

import javax.resource.spi.ConnectionRequestInfo;

public class CCIConnectionRequestInfo implements ConnectionRequestInfo {
	private static final XITrace TRACE = new XITrace(CCIConnectionRequestInfo.class.getName());
	private String userName;
	private String password;
	private String channelId;

	public String getUserName() {
		return this.userName;
	}

	public String getPassword() {
		return this.password;
	}

	public String getChannelId() {
		return this.channelId;
	}

	public CCIConnectionRequestInfo(String userName, String password, String channelId) {
		String SIGNATURE = "CciConnectionRequestInfo(String userName, String password, String channelId)";
		TRACE.entering(SIGNATURE, new Object[] { userName, password, channelId });
		this.userName = userName;
		this.password = password;
		this.channelId = channelId;
		TRACE.exiting(SIGNATURE);
	}

	public boolean equals(Object obj) {
		String SIGNATURE = "equals(Object obj)";
		TRACE.entering(SIGNATURE, new Object[] { obj });
		boolean equal = false;
		if ((obj instanceof CCIConnectionRequestInfo)) {
			CCIConnectionRequestInfo other = (CCIConnectionRequestInfo) obj;
			equal = (isEqual(this.userName, other.userName))
					&& (isEqual(this.password, other.password))
					&& (isEqual(this.channelId, other.channelId));
		}
		TRACE.exiting(SIGNATURE);
		return equal;
	}

	private boolean isEqual(Object o1, Object o2) {
		if (o1 == null) {
			return o2 == null;
		}
		return o1.equals(o2);
	}

	public int hashCode() {
		String SIGNATURE = "hashCode()";
		TRACE.entering(SIGNATURE);
		String result = "" + this.userName + this.password + this.channelId;
		TRACE.exiting(SIGNATURE);
		return result.hashCode();
	}
}
