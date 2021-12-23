# Some Functions Written by Myself

## 1. 分治法求阶乘：

```java
public long partition(int left, int right) {
    if (left >= right) {
      return left == right ? left : 1;
    }
    int mid = left + (right - left >> 1);
    if (left + 1 == right) {
      return (long) left * right;
    }
    long leftProduct = partition(left, mid);
    long rightProduct = partition(mid + 1, right);
    return leftProduct * rightProduct;
}
```

