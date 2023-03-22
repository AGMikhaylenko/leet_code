package medium.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-authentication-manager/
 * Runtime 49.54% Memory 33.3%
 */
public class DesignAuthenticationManager {

    final int timeToLive;
    final Map<String, Integer> tokens;
    List<String> expiredTokens = new ArrayList<>();

    public DesignAuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokens = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        Integer time = tokens.get(tokenId);
        if (time != null && time > currentTime) {
            tokens.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        expiredTokens.clear();
        int c = 0;

        for (Map.Entry<String, Integer> token : tokens.entrySet()) {
            if (token.getValue() <= currentTime) {
                expiredTokens.add(token.getKey());
            } else {
                c++;
            }
        }

        for (String t : expiredTokens) {
            tokens.remove(t);
        }

        return c;
    }
}
