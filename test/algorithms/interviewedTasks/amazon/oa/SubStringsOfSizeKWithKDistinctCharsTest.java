package algorithms.interviewedTasks.amazon.oa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SubStringsOfSizeKWithKDistinctCharsTest {
    @Test
    public void KSubString1test1() {
        String input = "abcabc";
        int k = 3;
        List<String> exp = new ArrayList<>(Arrays.asList("abc", "bca", "cab"));
        SubStringsOfSizeKWithKDistinctChars ks = new SubStringsOfSizeKWithKDistinctChars();
        List<String> result = ks.kSubString1(input, k);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(exp.get(i), result.get(i));
        }
    }
    @Test
    public void KSubString1test2() {
        String input = "abacab";
        int k = 3;
        List<String> exp = new ArrayList<>(Arrays.asList("bac", "cab"));
        SubStringsOfSizeKWithKDistinctChars ks = new SubStringsOfSizeKWithKDistinctChars();
        List<String> result = ks.kSubString1(input, k);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(exp.get(i), result.get(i));
        }
    }
    @Test
    public void KSubString1test3() {
        String input = "awaglknagawunagwkwagl";
        int k = 4;
        List<String> exp = new ArrayList<>(Arrays.asList("wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun",
                "wuna", "unag", "nagw", "agwk", "kwag", "wagl"));
        SubStringsOfSizeKWithKDistinctChars ks = new SubStringsOfSizeKWithKDistinctChars();
        List<String> result = ks.kSubString1(input, k);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(exp.get(i), result.get(i));
        }
    }
    @Test
    public void KSubString2test1() {
        String input = "abcabc";
        int k = 3;
        List<String> exp = new ArrayList<>(Arrays.asList("abc", "bca", "cab"));
        SubStringsOfSizeKWithKDistinctChars ks = new SubStringsOfSizeKWithKDistinctChars();
        List<String> result = ks.kSubString2(input, k);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(exp.get(i), result.get(i));
        }
    }
    @Test
    public void KSubString2test2() {
        String input = "abacab";
        int k = 3;
        List<String> exp = new ArrayList<>(Arrays.asList("bac", "cab"));
        SubStringsOfSizeKWithKDistinctChars ks = new SubStringsOfSizeKWithKDistinctChars();
        List<String> result = ks.kSubString2(input, k);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(exp.get(i), result.get(i));
        }
    }
    @Test
    public void KSubString3test3() {
        String input = "awaglknagawunagwkwagl";
        int k = 4;
        List<String> exp = new ArrayList<>(Arrays.asList("wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun",
                "wuna", "unag", "nagw", "agwk", "kwag", "wagl"));
        SubStringsOfSizeKWithKDistinctChars ks = new SubStringsOfSizeKWithKDistinctChars();
        List<String> result = ks.kSubString2(input, k);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(exp.get(i), result.get(i));
        }
    }
}