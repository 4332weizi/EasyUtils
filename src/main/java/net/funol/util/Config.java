package net.funol.util;

/**
 * 配置类
 * <p>
 * 1. {@link #isAppReleased}应用是否已发布，默认为false。
 * <p>
 * 2. {@link #isDevLogDisplayOn}是否输出日志信息，默认应用发布时关闭。
 * <p>
 * 3. {@link #isDevToastDisplayOn}是否显示开发期临时Toast，默认应用发布时关闭。
 * 
 * @author 赵尉尉
 * 
 */
public class Config {

	/** 应用是否已发布 */
	public static boolean isAppReleased = false;
	/** 是否输出日志信息 */
	public static boolean isDevLogDisplayOn = !isAppReleased;
	/** 是否显示开发期临时Toast */
	public static boolean isDevToastDisplayOn = !isAppReleased;

}
