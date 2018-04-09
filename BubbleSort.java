//外层循环是排序的趟数
    for (int i = 0; i < arrays.length -1 ; i++) {

        //每比较一趟就重新初始化为0
        isChange = 0;

        //内层循环是当前趟数需要比较的次数
        for (int j = 0; j < arrays.length - i - 1; j++) {

            //前一位与后一位与前一位比较，如果前一位比后一位要大，那么交换
            if (arrays[j] > arrays[j + 1]) {
                temp = arrays[j];
                arrays[j] = arrays[j + 1];
                arrays[j + 1] = temp;


                //如果进到这里面了，说明发生置换了
                isChange = 1;

            }
        }
        //如果比较完一趟没有发生置换，那么说明已经排好序了，不需要再执行下去了
        if (isChange == 0) {
            break;
        }

    }
    System.out.println(arrays);
	