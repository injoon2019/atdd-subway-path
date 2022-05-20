package wooteco.subway.domain.strategy.path;

import wooteco.subway.domain.Path;
import wooteco.subway.domain.Sections;
import wooteco.subway.domain.Station;

public interface PathFindStrategy {

    Path findPath(Station source, Station target, Sections sections);
}
