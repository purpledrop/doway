package think.in.java.interview;

/**
 * Created by yang on 2017/7/24.
 * Rotate Array in Java
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. How many different ways do you know to solve this problem?
 */
public class RotateArray {

  public static void main(String[] args) {
    RotateArray rotateArray = new RotateArray();
    int[] array={1,2,3,4,5,6,7};
    rotateArray.systemArray(array);
    int k=3;
    rotateArray.s1_rotate(array,3);
    rotateArray.systemArray(array);
  }

  /**
   * 输出数组内容
   * @param array
   */
  public void systemArray(int[] array){
    String result = "";
    for(int i=0;i<array.length;i++){
      String str=String.valueOf(array[i]);
      if(i==0){
        result="array["+str;
      }else if(i!=array.length-1){
        result+=","+str;
      }else {
        result+=","+str+"]";
      }
    }
    System.out.println(result);
  }
  /**
   * Solution 1 - Intermediate Array
   */
  public void s1_rotate(int[] nums,int k){
    if(k>nums.length){
      k=k%nums.length;
    }

    int[] result=new int[nums.length];
    for(int i=0;i<k;i++){
      result[i]=nums[nums.length-k+i];
    }
    int j=0;
    for(int i=k;i<nums.length;i++){
      result[i]=nums[j];
      j++;
    }
    System.arraycopy(result,0,nums,0,nums.length);
  }

}
