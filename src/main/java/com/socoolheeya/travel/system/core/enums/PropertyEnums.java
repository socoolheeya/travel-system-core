package com.socoolheeya.travel.system.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
public class PropertyEnums {

    @Getter
    @AllArgsConstructor
    public enum Star {
        STAR1("1STAR"),
        STAR2("2STAR"),
        STAR3("3STAR"),
        STAR4("4STAR"),
        STAR5("5STAR"),
        STAR6("6STAR"),
        STAR7("7STAR"),
        NONE(null);

        private final String code;

        @JsonCreator
        public Star from(String code) {
            return Arrays.stream(Star.values())
                    .filter(x -> x.code.equals(code))
                    .findFirst()
                    .orElse(null);
        }

    }

    @Getter
    @AllArgsConstructor
    public enum ImageType {
        MAIN, AMENITY, FACILITY, ROOM, EXTERIOR
    }

    /**
     * 숙소 정산 타입
     */
    @Getter
    @AllArgsConstructor
    public enum SettlementType {
        TRANSFER("CT101", "송금"),
        VCC("CT102", "가상카드"),
        CENTRAL_TRAVEL_CARD("CT103", "법인카드");

        private final String code;
        private final String description;
    }

    /**
     * 커미션 요금 타입
     */
    @Getter
    @AllArgsConstructor
    public enum CommissionPriceType {
        DEPOSIT_PRICE("CPT01", "예치금"),
        SELLING_PRICE_BEFORE_COMMISSION("CPT02", "판매가(수수료 전)"),
        SELLING_PRICE_AFTER_COMMISSION("CPT03", "판매가(수수료 후)"),
        ALL_PRICE("CPT04", "전체요금");

        private final String code;
        private final String description;

        @JsonCreator
        public static CommissionPriceType from(String code) {
            return Arrays.stream(CommissionPriceType.values())
                    .filter(x -> x.code.equals(code))
                    .findFirst()
                    .orElse(null);
        }
    }

    @Getter
    @AllArgsConstructor
    public enum  CommissionMode {
        ALL, WEEKDAY_WEEKEND
    }
}
