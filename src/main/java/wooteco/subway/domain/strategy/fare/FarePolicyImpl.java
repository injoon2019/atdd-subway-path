package wooteco.subway.domain.strategy.fare;

import java.util.List;
import wooteco.subway.domain.strategy.fare.distance.DistanceFareManager;
import wooteco.subway.domain.strategy.fare.distance.DistanceFareManagerFactory;
import wooteco.subway.domain.strategy.fare.distance.DistanceFareStrategy;
import wooteco.subway.domain.strategy.fare.discount.DiscountStrategy;
import wooteco.subway.domain.strategy.fare.discount.DiscountStrategyFactory;

public class FarePolicyImpl extends FarePolicy {

    @Override
    protected int calculateBasicFare(int distance) {
        DistanceFareManager distanceFareManager = DistanceFareManagerFactory.createDistanceFareManager();
        return distanceFareManager.calculateFare(distance);
    }

    @Override
    protected int calculateExtraFare(List<Integer> extraPrices) {
        return extraPrices.stream()
                .mapToInt(extraPrice -> extraPrice)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("가장 큰 값이 존재하지 않습니다"));
    }

    @Override
    protected int calculateDiscountFare(int price, int age) {
        DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(age);
        return discountStrategy.calculateDiscount(price);
    }
}
