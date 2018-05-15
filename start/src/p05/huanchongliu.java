package p05;

public class huanchongliu {
	public static void main(String[] args) {
		String str = "wo"; // 创建空字符串
		// 定义对字符串执行操作的起始时间
		long starTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) { // 利用for循环执行10000次操作
			str = str + i; // 循环追加字符串
		}
		long endTime = System.currentTimeMillis(); // 定义对字符串操作后的时间
		long time = endTime - starTime; // 计算对字符串执行操作的时间
		System.out.println("String循环1万次消耗时间：" + time); // 将执行的时间输出

		StringBuilder builder = new StringBuilder(""); // 创建字符串生成器
		starTime = System.currentTimeMillis(); // 定义操作执行前的时间
		for (int j = 0; j < 10000; j++) { // 利用for循环进行操作
			builder.append(j); // 循环追加字符
		}
		endTime = System.currentTimeMillis(); // 定义操作后的时间
		time = endTime - starTime; // 追加操作执行的时间
		System.out.println("StringBuilder循环1万次消耗时间：" + time); // 将操作时间输出

		StringBuilder builder2 = new StringBuilder(""); // 创建字符串生成器
		starTime = System.currentTimeMillis(); // 定义操作执行前的时间
		for (int j = 0; j < 50000; j++) { // 利用for循环进行操作
			builder2.append(j); // 循环追加字符
		}
		endTime = System.currentTimeMillis(); // 定义操作后的时间
		time = endTime - starTime; // 追加操作执行的时间
		System.out.println("StringBuilder循环5万次消耗时间：" + time); // 将操作时间输出
	}
}
