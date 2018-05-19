package common;
/**
 * 这个类用来封装http的相关参数信息
 * @author song
 *
 */
public class HttpContext {
	//状态码
	public static final int CODE_OK=200;//就绪
	public static final int CODE_NOTFOUND=404;//资源不存在
	public static final int CODE_ERROR=500;//服务器错误
	//状态码的描述信息
	public static final String DESC_OK="OK";
	public static final String DESC_NOTFOUND="NOTFOUND";
	public static final String DESC_ERROR="ERROR";
}
