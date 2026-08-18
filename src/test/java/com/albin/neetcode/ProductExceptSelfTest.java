package com.albin.neetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductExceptSelfTest {

    @Test
    public void example1() {
        ProductExceptSelf s = new ProductExceptSelf();
        int[] res = s.productExceptSelf(new int[]{1,2,3,4});
        assertArrayEquals(new int[]{24,12,8,6}, res);
    }

    @Test
    public void zeroCases() {
        ProductExceptSelf s = new ProductExceptSelf();
        assertArrayEquals(new int[]{0,0}, s.productExceptSelf(new int[]{0,0}));
        assertArrayEquals(new int[]{2,0,0}, s.productExceptSelf(new int[]{0,1,2}));
    }
}
