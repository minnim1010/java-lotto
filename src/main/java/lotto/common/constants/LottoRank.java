package lotto.common.constants;

import java.util.Arrays;

public enum LottoRank {
    NO_RANK(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchingNumbersCount;
    private final boolean hasBonusBall;
    private final int prize;

    LottoRank(int matchingNumbersCount, boolean hasBonusBall, int prize) {
        this.matchingNumbersCount = matchingNumbersCount;
        this.hasBonusBall = hasBonusBall;
        this.prize = prize;
    }

    public int getMatchingNumbersCount() {
        return matchingNumbersCount;
    }

    public boolean hasBonusBall() {
        return hasBonusBall;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank from(int matchingNumbersCount, boolean hasBonusBall) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getMatchingNumbersCount() == matchingNumbersCount &&
                        rank.hasBonusBall() == hasBonusBall)
                .findFirst()
                .orElse(NO_RANK);
    }
}
