public class FindMostFrequentVowelandConsonant 
{
    public int maxFreqSum(String s) 
    {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int maxVowel = 0, maxConsonant = 0;
        for (int i = 0; i < 26; i++) {
            char c = (char)(i + 'a');
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                if (freq[i] > maxVowel) maxVowel = freq[i];
            } else {
                if (freq[i] > maxConsonant) maxConsonant = freq[i];
            }
        }

        return maxVowel + maxConsonant;
    }

    public static void main(String[] args) 
    {
        FindMostFrequentVowelandConsonant obj = new FindMostFrequentVowelandConsonant();
        String s = "successes";
        System.out.println(obj.maxFreqSum(s)); 
    }
}
