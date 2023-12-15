package dev.damola.fullstacktest;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record UserInfoDto(
        @NotEmpty
        String name,

        @NotEmpty
        List<Integer> selectedSectors,

        Boolean agreeToTerms
) {
}
