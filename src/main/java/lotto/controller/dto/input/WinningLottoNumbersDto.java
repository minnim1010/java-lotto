package lotto.controller.dto.input;

import java.util.List;
import lotto.common.constants.LottoRule;
import lotto.util.Parser;
import lotto.util.Validator;

public record WinningLottoNumbersDto(String winningLottoNumbers) {
    private static final String DELIMITER = ",";
    private static final int WINNING_LOTTO_NUMBERS_MIN_LENGTH = 1;
    private static final int WINNING_LOTTO_NUMBERS_MAX_LENGTH =
            String.valueOf(LottoRule.LOTTO_NUMBER_MAX.value).length() * LottoRule.LOTTO_NUMBER_SIZE.value +
                    LottoRule.LOTTO_NUMBER_SIZE.value * DELIMITER.length();

    public WinningLottoNumbersDto {
        Validator.validateLength(winningLottoNumbers, WINNING_LOTTO_NUMBERS_MIN_LENGTH,
                WINNING_LOTTO_NUMBERS_MAX_LENGTH);
        Validator.validateHasText(winningLottoNumbers);
    }

    public List<Integer> toIntegerList() {
        List<String> list = Parser.toList(winningLottoNumbers);
        return list.stream()
                .map(e -> {
                    Validator.validateNumeric(e);
                    return Parser.toInt(e);
                })
                .toList();
    }
}
