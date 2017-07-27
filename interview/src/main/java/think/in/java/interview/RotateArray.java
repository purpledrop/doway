package think.in.java.interview;

/**
 * Created by yang on 2017/7/24. Rotate Array in Java For example, with n = 7 and k = 3, the array
 * [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. How many different ways do you know to solve this
 * problem?
 */
public class RotateArray {

  public static void main(String[] args) {
    RotateArray rotateArray = new RotateArray();
    int[] array = {1, 2, 3, 4, 5, 6, 7};
    System.out.println("排序前数组：");
    rotateArray.systemArray(array);
    int k = 10;
    System.out.println("调用s1_rotate排序后数组：");
    rotateArray.s1_rotate(array, 3);
    rotateArray.systemArray(array);

    array = new int[]{1, 2, 3, 4, 5, 6, 7};
    System.out.println("调用s2_rotate排序后数组：");
    rotateArray.s2_rotate(array, 3);
    rotateArray.systemArray(array);

    array = new int[]{1, 2, 3, 4, 5, 6, 7};
    System.out.println("调用s3_rotate排序后数组：");
    rotateArray.s3_rotate(array, 3);
    rotateArray.systemArray(array);

  }

  /**
   * 输出数组内容
   */
  public void systemArray(int[] array) {
    String result = "";
    for (int i = 0; i < array.length; i++) {
      String str = String.valueOf(array[i]);
      if (i == 0) {
        result = "array[" + str;
      } else if (i != array.length - 1) {
        result += "," + str;
      } else {
        result += "," + str + "]";
      }
    }
    System.out.println(result);
  }

  /**
   * Solution 1 - Intermediate Array
   * System.arraycopy
   * Space is O(n) and time is O(n)
   */
  public void s1_rotate(int[] nums, int k) {
    if (k > nums.length) {
      k = k % nums.length;
    }

    int[] result = new int[nums.length];
    for (int i = 0; i < k; i++) {
      result[i] = nums[nums.length - k + i];
    }
    int j = 0;
    for (int i = k; i < nums.length; i++) {
      result[i] = nums[j];
      j++;
    }
    System.arraycopy(result, 0, nums, 0, nums.length);
  }

  /**
   * Solution 2 - Bubble Rotate
   * the time is O(n*k).
   */
  public void s2_rotate(int[] arr, int order) {
    if (arr == null || arr.length < 0) {
      throw new IllegalArgumentException("Illegal argument!");
    }
    for (int i = 0; i < order; i++) {
      for (int j = arr.length - 1; j > 0; j--) {
        int temp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = temp;
      }
    }

  }

  /**
   * Solution 3 - Reversal
   */
  public void s3_rotate(int[] array, int order) {
    if (array == null || array.length == 0 || order < 0) {
      throw new IllegalArgumentException("Illegal argument!");
    }
    if (order > array.length) {
      order = order % array.length;
    }

    int a = array.length - order;
    reverse(array, 0, a - 1);
    reverse(array, a, array.length - 1);
    reverse(array, 0, array.length - 1);


  }

  public void reverse(int[] array, int left, int right) {
    if (array == null || array.length == 1) {
      return;
    }
    while (left < right) {
      int temp = array[left];
      array[left] = array[right];
      array[right] = temp;
      left++;
      right--;
    }
  }

}
