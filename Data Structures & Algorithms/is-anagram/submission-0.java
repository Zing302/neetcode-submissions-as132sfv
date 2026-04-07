class Solution {
    public boolean isAnagram(String s, String t) {
        char[] fir=s.toCharArray();
        char[] sec=t.toCharArray();
        Arrays.sort(fir);
        Arrays.sort(sec);
        return Arrays.equals(fir,sec);
    }
}
