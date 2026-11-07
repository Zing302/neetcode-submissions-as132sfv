class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char task:tasks){
            freq[task-'A']++;
        }
        Arrays.sort(freq);
        int ides = (freq[25]-1)*n;
        int maxFreq = freq[25];
        for(int i=24;i>=0;i--){
            if(freq[i] == 0){
                break;
            }
            if(maxFreq == freq[i]){
                ides -= maxFreq-1;
            }else{
                ides -= freq[i];
            }
        }
        return Math.max(0,ides) + tasks.length;
    }
}
