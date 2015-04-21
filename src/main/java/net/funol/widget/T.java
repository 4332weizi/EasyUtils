package net.funol.widget;

import net.funol.util.Config;
import android.content.Context;
import android.widget.Toast;

/**
 * 在应用开发期打印日志信息，应用发布时将display改为false可避免在发布的应用中显示Toast。
 * <p>
 * 
 * <b>注：</b>推荐使用{@link net.funol.util.Config}
 * 中配置<b>isDevLogDisplayOn<b>为false禁用Log输出。
 * 
 * @see android.widget.Toast
 * @author 赵尉尉
 */
public class T extends Toast {

	/**
	 * 是否显示Toast，true时打印日志信息
	 */
	private static boolean display = Config.isDevToastDisplayOn;

	public T(Context context) {
		super(context);
	}

	/**
	 * 显示Toast
	 * 
	 * @param context
	 *            上下文
	 * @param msg
	 *            Toast内容
	 */
	public static void show(Context context, String msg) {
		if (display)
			makeText(context, msg, LENGTH_LONG).show();
	}

}
