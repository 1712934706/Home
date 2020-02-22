package temp.algorithm.query;

public class AllQuery {

  /***************************二分查找*****************************/
  public int binarySearch(int[] data, int target) {
    int left = 0;
    int right = data.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (data[mid] == target) {
        return mid;
      } else if (data[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

}