package com.pinternals.nulladapter;

import com.sap.aii.af.lib.trace.Category;

public class XIConst {
	public static String version = "0.1", spec_version = "1.0";
	public static String vendor = "pinternals.com";
	
	public static String ADAPTER_TYPE = "Null";
	public static String ADAPTER_NS = "urn:pinternals-adapters";
	public static String ADAPTER_DESC = "Proof-of-concept";
	public static String JNDI_NAME =  "deployedAdapters/%/shareable/%".replaceAll("%", ADAPTER_TYPE);

	private static Category lcRoot = Category.getCategory(Category.getRoot(), "Applications/ExchangeInfrastructure/Adapter/" + ADAPTER_TYPE);
	public static final Category lcConfig = Category.getCategory(lcRoot, "Configuration");
	public static final Category lcServer = Category.getCategory(lcRoot, "Server");
	public static final Category lcConnect = Category.getCategory(lcRoot, "Connection");
	public static final Category lcAF = Category.getCategory(lcServer, "Adapter Framework");

	protected static String rbName = XIConst.class.getPackage().getName() + ".rb_pimon";
}
