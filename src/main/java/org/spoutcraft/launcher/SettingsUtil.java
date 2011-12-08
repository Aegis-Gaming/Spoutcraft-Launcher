package org.spoutcraft.launcher;

import java.io.File;

public class SettingsUtil {
	private static SettingsHandler settings = new SettingsHandler("defaults/technic.properties", new File(PlatformUtils.getWorkingDirectory(), "technic" + File.separator + "technic.properties"));
	
	static {
		settings.load();
	}
	
	public static boolean isLatestLWJGL() {
		return isProperty("latestLWJGL");
	}
	
	public static void setLatestLWJGL(boolean value) {
		setProperty("latestLWJGL", value);
	}
	
	public static boolean isWorldBackup() {
		return isProperty("worldbackup");
	}
	
	public static void setWorldBackup(boolean value) {
		setProperty("worldbackup", value);
	}
	
	public static int getLoginTries() {
		return isProperty("retryLogins", true) ? 3 : 1;
	}
	
	public static void setLoginTries(boolean value){
		setProperty("retryLogins", value);
	}
	
	public static boolean isRecommendedBuild() {
		return isProperty("recupdate", true);
	}
	
	public static void setRecommendedBuild(boolean value) {
		setProperty("recupdate", value);
	}
	
	public static int getSelectedBuild() {
		return getProperty("custombuild", -1);
	}
	
	public static void setSelectedBuild(int value) {
		setProperty("custombuild", value);
	}
	
	public static boolean isDevelopmentBuild() {
		return isProperty("devupdate");
	}
	
	public static void setDevelopmentBuild(boolean value) {
		setProperty("devupdate", value);
	}
	
	public static boolean isClipboardAccess() {
		return isProperty("clipboardaccess");
	}
	
	public static void setClipboardAccess(boolean value) {
		setProperty("clipboardaccess", value);
	}
	
	public static int getMemorySelection() {
		return getProperty("memory", 1);
	}
	
	public static void setMemorySelection(int value) {
		setProperty("memory", value);
	}
	
	private static void setProperty(String s, Object value) {
		if (settings.checkProperty(s)) {
			settings.changeProperty(s, value);
		}
		settings.put(s, value);
	}
	
	private static boolean isProperty(String s) {
		return isProperty(s, false);
	}
	
	private static boolean isProperty(String s, boolean def) {
		if (settings.checkProperty(s)) {
			return settings.getPropertyBoolean(s);
		}
		settings.put(s, def);
		return def;
	}
	
	private static int getProperty(String s, int def) {
		if (settings.checkProperty(s)) {
			return settings.getPropertyInteger(s);
		}
		settings.put(s, def);
		return def;
	}

}
