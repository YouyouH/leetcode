##**矩阵问题**

###技巧
1. 遍历到矩阵的某一个元素时，如果需要遍历周围的元素，可以用一个数组保存周边位置
的变化向量，一次性通过一个双重遍历来遍历完周边的值。
   ````
                int[] neighbors = {0, 1, -1};
   
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            // 相邻位置的坐标
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);
                        }
                    }
                }
   ````