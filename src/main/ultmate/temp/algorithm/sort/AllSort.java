package temp.algorithm.sort;

public class AllSort {

  /***************************插入排序****************************/
  public void insertSort(int[] data) {
    for (int i = 0; i < data.length; i++) {
      int temp = data[i];
      int j;
      for (j = i - 1; j >= 0 && data[j] > temp; j--) {
        data[j + 1] = data[j];
      }
      data[j + 1] = temp;
    }
  }

  /***************************希尔排序****************************/
  public void shellSort(int[] data) {
    for (int step = data.length / 2; step > 0; step /= 2) {
      for (int i = 0; i < data.length; i += step) {
        int temp = data[i];
        int j;
        for (j = i - step; j >= 0 && data[j] > temp; j -= step) {
          data[j + step] = data[j];
        }
        data[j + step] = temp;
      }
    }
  }

  /***************************快速排序****************************/
  public void quickSort(int[] data, int low, int high) {
    while (low < high) {
      int posi = quickSortCore(data, low, high);
      quickSort(data, low, posi - 1);
      quickSort(data, posi + 1, high);
    }
  }

  /**
   * 快排核心算法，填坑法
   *
   * @param data 原始数组
   * @param low 低指针
   * @param high 高指针
   */
  public int quickSortCore(int[] data, int low, int high) {
    int temp = data[low];
    while (low < high) {
      while (low < high && data[high] >= temp) {
        high--;
      }
      data[low] = data[high];

      while (low < high && data[low] <= temp) {
        low++;
      }
      data[high] = data[low];
    }
    data[low] = temp;
    return low;
  }

  /***************************堆排序****************************/
  public int leftChild(int i) {
    return 2 * i + 1;
  }

  /**
   * 堆排核心算法
   *
   * @param data 原始数组
   * @param i 非叶子节点位置
   * @param n 数据长度
   */
  public void heapSortCore(int[] data, int i, int n) {
    int child;
    int tmp;
    for (tmp = data[i]; leftChild(i) < n; i = child) {
      child = leftChild(i);
      if (child < n - 1 && data[child] < data[child + 1]) {
        child = child + 1;
      }
      if (tmp < data[child]) {
        data[i] = data[child];
      } else {
        break;
      }
    }
    //在这里交换，减少了交换次数
    data[i] = tmp;
  }

  public void heapSort(int[] data) {
    for (int i = data.length / 2 - 1; i >= 0; i--) {
      heapSortCore(data, i, data.length);
    }

    int length = data.length;
    while (length > 0) {
      int tmp = data[length - 1];
      data[length - 1] = data[0];
      data[0] = tmp;
      length--;
      heapSortCore(data, 0, length);
    }
  }

  /***************************归并排序****************************/
  private void mergeData(int[] data, int[] tempArray, int left, int mid, int right) {
    int posi = left;
    int leftPosi = left;
    int rightPosi = mid + 1;
    while (leftPosi <= mid && rightPosi <= right) {
      if (data[leftPosi] < data[rightPosi]) {
        tempArray[posi++] = data[leftPosi++];
      } else {
        tempArray[posi++] = data[rightPosi++];
      }
    }

    if (leftPosi > mid) {
      while (rightPosi <= right) {
        tempArray[posi++] = data[rightPosi++];
      }
    } else {
      while (leftPosi <= mid) {
        tempArray[posi++] = data[leftPosi++];
      }
    }

    while (left <= right) {
      data[left] = tempArray[left++];
    }

  }

  public void mergeSortCore(int[] data, int[] tempArray, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSortCore(data, tempArray, left, mid);
      mergeSortCore(data, tempArray, mid + 1, right);
      mergeData(data, tempArray, left, mid, right);
    }
  }

  public void mergeSort(int[] data) {

    int[] temp = new int[data.length];
    mergeSortCore(data, temp, 0, data.length - 1);
  }

}





