package leetcodesolutions;

import java.util.HashMap;
import java.util.Map;

class NO488 {
    private int idxOf(char c) {
        switch (c) {
            case 'R': return 0;
            case 'Y': return 1;
            case 'B': return 2;
            case 'G': return 3;
            case 'W': return 4;
        }
        return -1;
    }

    private static final String colors = "RYBGW";
    private static final int MAX_STEPS = 6; // 最多6步，超过则无解

    Map<String, Integer> mem;

    public int findMinStep(String board, String hand) {
        int[] handCount = new int[5];
        mem = new HashMap<>();
        for(int i=0; i<hand.length(); i++){
            handCount[idxOf(hand.charAt(i))]++;
        }

        int ans = dfs(board, handCount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int dfs(String board, int[] handCount){
        board = shrink(board);
        if(board.isEmpty())
            return 0;
        
        // 剪枝：如果手牌为空，无法继续
        boolean hasHand = false;
        for(int count : handCount) {
            if(count > 0) {
                hasHand = true;
                break;
            }
        }
        if(!hasHand) return Integer.MAX_VALUE;
        
        int ans = Integer.MAX_VALUE;
        int n = board.length();
        
        // 优化缓存键：使用更紧凑的表示
        String key = generateKey(board, handCount);
        if (mem.containsKey(key)) return mem.get(key);
        
        // 剪枝：如果当前步数已经超过最大可能步数，直接返回
        int currentSteps = getCurrentSteps(handCount);
        if(currentSteps >= MAX_STEPS) {
            mem.put(key, Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }
        
        for(int i=0;i <= n; i++){
            // 剪枝：避免在相同位置插入相同颜色的球
            if(i > 0 && i < n && board.charAt(i) == board.charAt(i-1)){
                continue;
            }

            for(int j=0; j<5; j++){
                if(handCount[j] == 0) continue;
                char ch = colors.charAt(j);
                
                // 改进的promising函数
                if(!promising(board, i, ch)) continue;

                String newBoard = board.substring(0, i) + ch + board.substring(i);
                newBoard = shrink(newBoard);
                
                handCount[j]--;
                int minNum = dfs(newBoard, handCount);
                handCount[j]++;

                if (minNum != Integer.MAX_VALUE) {
                    ans = Math.min(ans, 1 + minNum);
                }
            }
        }
        mem.put(key, ans);
        return ans;
    }

    // 改进的promising函数：更智能的剪枝策略
    private boolean promising(String board, int pos, char ch) {
        // 情况1：跟左边同色
        if (pos > 0 && board.charAt(pos - 1) == ch) return true;
        // 情况2：跟右边同色
        if (pos < board.length() && board.charAt(pos) == ch) return true;
        // 情况3：左==右，且都等于 ch（可以桥接成三个）
        if (pos > 0 && pos < board.length()
                && board.charAt(pos - 1) == board.charAt(pos)
                && board.charAt(pos) == ch) {
            return true;
        }
        // 情况4：插入后可能形成更长的连续序列（通过后续操作）
        // 检查插入后是否能通过连锁反应消除更多球
        return canFormChain(board, pos, ch);
    }
    
    // 检查插入后是否能形成连锁反应
    private boolean canFormChain(String board, int pos, char ch) {
        // 模拟插入后的情况
        String newBoard = board.substring(0, pos) + ch + board.substring(pos);
        String shrunk = shrink(newBoard);
        
        // 如果插入后能消除更多球，则值得尝试
        return shrunk.length() < board.length();
    }
    
    // 计算当前已使用的步数
    private int getCurrentSteps(int[] handCount) {
        int totalHand = 0;
        for(int count : handCount) {
            totalHand += count;
        }
        return 5 - totalHand; // 假设初始手牌为5个
    }
    
    // 优化缓存键生成：使用更紧凑的表示
    private String generateKey(String board, int[] handCount) {
        StringBuilder sb = new StringBuilder();
        sb.append(board);
        sb.append("#");
        for(int i = 0; i < handCount.length; i++) {
            if(handCount[i] > 0) {
                sb.append(colors.charAt(i));
                sb.append(handCount[i]);
            }
        }
        return sb.toString();
    }

    // 优化的shrink函数：减少不必要的字符串操作
    private String shrink(String s) {
        if (s.length() < 3) return s;
        
        boolean changed = true;
        while (changed) {
            changed = false;
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < s.length(); ) {
                int j = i + 1;
                // 找到连续相同字符的结束位置
                while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                    j++;
                }
                
                if (j - i >= 3) {
                    // 这一段会消除，跳过
                    changed = true;
                } else {
                    // 这一段保留
                    sb.append(s, i, j);
                }
                i = j;
            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        NO488 no488 = new NO488();
        System.out.println(no488.findMinStep("RRWWRRBBRR", "WB") + " Steps");

    }

}