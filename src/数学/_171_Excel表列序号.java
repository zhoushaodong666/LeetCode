package 数学;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/excel-sheet-column-number/
 * @Date 2020/10/21 14:32
 */
public class _171_Excel表列序号 {
    /**
     * 进制加法：
     * 我们用每个字符减去'A'+1,得出每个字符的值num=chs[i]-'A'
     * 因为是26个大写字母一轮,所以是26进制
     * 公式 sum=sum*26+num
     */
    public int titleToNumber(String s) {
        int len = s.length();
        if (s == null || len == 0) return 0;

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            sum = sum * 26 + num;
        }
        return sum;
    }
}
