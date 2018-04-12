 public static void findMajorityElement2(int[] arrays) {

        // 装载栈的元素
        int candidate = -1;

        // 栈的大小(长度)
        int count = 0;


        // 遍历给出的数组
        for (int i = 0; i < arrays.length; i++) {


            // 判断该栈为空，那么直接将元素入栈
            if (count == 0) {

                candidate = arrays[i];
                count++;

            } else if (candidate == arrays[i]) { // 该元素是否与栈的元素一致-->入栈(栈多一个元素)
                count++;
            } else {
                // 只要不一致-->出栈(栈少一个元素)
                count--;

            }
        }

        // 只要该数字出现次数大于数组长度的2/1，那么留下来的数字肯定在栈顶中
        System.out.println(candidate);

    }
