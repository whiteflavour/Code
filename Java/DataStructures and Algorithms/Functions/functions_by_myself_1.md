# Some Functions Written by Myself

## 1. 分治法求阶乘：

```java
/**
	* Use divide and conquer to calculate the factorial of n (n!)
	* <b>Note:</b> We use <i>BigInteger</i> to avoid overflow.
	* 
	* @param left first number to be multiplied (always be 1)
  * @param right last number to be multiplied (e.g. if we need
  *              to calculate n!, then <i>left</i> is 1 and
  *              <i>right</i> is n)
  * @return the result
	*/
public BigInteger partition(int left, int right) {
    if (left >= right) {
      return BigInteger.valueOf(left == right ? left : 1);
    }
    int mid = left + (right - left >> 1);
    if (left + 1 == right) {
      return BigInteger.valueOf((long) left * right);
    }
    BigInteger leftProduct = partition(left, mid);
    BigInteger rightProduct = partition(mid + 1, right);
    return leftProduct.multiply(rightProduct);
}
```

> 发现没什么屌用，仔细想想，时间复杂度还是O(n)，因为每个元素都被遍历了一次。经过仔细推敲，它跟快排、归并那些还是有本质区别，因为那俩是从`O(n²) -> O(nlogn) `。
